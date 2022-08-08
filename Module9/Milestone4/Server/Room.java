package Module9.Milestone4.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

//Milesonte 4 imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Module8.Milestone3.Common.Constants;

public class Room implements AutoCloseable {
	private String name;
	private List<ServerThread> clients = Collections.synchronizedList(new ArrayList<ServerThread>());
	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";
	private final static String FLIP = "flip";
	private final static String ROLL = "roll";
	private final static String MUTE = "mute";
	private final static String UNMUTE = "unmute";
	private final static String EXPORT = "export";

	private static Logger logger = Logger.getLogger(Room.class.getName());

	public HashMap<String, ArrayList<String>> muteCheck = new HashMap<String, ArrayList<String>>();

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		logger.log(Level.INFO, String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	public boolean isRunning() {
		return isRunning;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			sendConnectionStatus(client, true);
			sendRoomJoined(client);
			sendUserListToClient(client);
		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			// sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
			close();
		}
	}

	/***
	 * Helper function to process messages to trigger different functionality.
	 * 
	 * @param message The original message being sent
	 * @param client  The sender of the message (since they'll be the ones
	 *                triggering the actions)
	 */

	public boolean isMuted(ServerThread Client, String clientName) {
		clientName = clientName.trim().toLowerCase();
		ArrayList<String> mu = muteCheck.get(Client.getClientName().trim().toLowerCase());
		return mu.contains(clientName);
	}
	public void mute(ServerThread Client, String name) {
		name = name.trim().toLowerCase();
		if (!isMuted(Client, name)) {
			ArrayList<String> mu = muteCheck.get(Client.getClientName().trim().toLowerCase());
			mu.add(name);
			muteCheck.put(Client.getClientName().trim().toLowerCase(), mu);
			
		}
	}
	
	public void unmute(ServerThread Client, String name) {
		name = name.trim().toLowerCase();
		if (isMuted(Client, name)) {
			ArrayList<String> mu = muteCheck.get(Client.getClientName().trim().toLowerCase());
			mu.remove(name);
			muteCheck.put(Client.getClientName().trim().toLowerCase(), mu);
		}
	}

	public void muteExport(ServerThread Client) {
		try {
			File muteExp = new File(Client.getClientName().trim().toLowerCase() + ".txt");
			if (muteExp.createNewFile()) {
				System.out.println("File created: " + muteExp.getName());
			}

		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}

		// now the actual writing into the mutelist.txt file

		try {
			FileWriter fw = new FileWriter(Client.getClientName().trim().toLowerCase() + ".txt");
			ArrayList<String> m = muteCheck.get(Client.getClientName());
			for (int i = 0; i < m.size(); i++) {
				fw.append(m.get(i) + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Error creating filewriter");
		}
	}

	private boolean processCommands(String message, ServerThread client) {
		boolean wasCommand = false;
		try {
			if (message.startsWith(COMMAND_TRIGGER)) {
				String[] comm = message.split(COMMAND_TRIGGER);
				String part1 = comm[1];
				String[] comm2 = part1.split(" ");
				String command = comm2[0];
				String roomName;
				wasCommand = true;
				switch (command) {
					case CREATE_ROOM:
						roomName = comm2[1];
						Room.createRoom(roomName, client);
						break;
					case JOIN_ROOM:
						roomName = comm2[1];
						Room.joinRoom(roomName, client);
						break;
					case FLIP:
						flipcoin(client);
						break;
					case ROLL:
						int rol = Integer.valueOf(comm2[1]);
						roll(client, rol);
						break;
					case EXPORT:
						client.createExport();
						client.exportChat();
						break;
					case MUTE:
						String mUser = comm2[1];
						mute(client, mUser);
						ArrayList<String> m = new ArrayList<String>();
						m.add(mUser);
						muteExport(client);
						sendPrivateMessage(client, m, client.getClientName() + " has muted you");
						break;
					case UNMUTE:
						String umUser = comm2[1];
						unmute(client, umUser);
						ArrayList<String> n = new ArrayList<String>();
						n.add(umUser);
						muteExport(client);
						sendPrivateMessage(client, n, client.getClientName() + " has unmuted you");
						break;
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					default:
						wasCommand = false;
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasCommand;
	}

	protected static void getRooms(String query, ServerThread client) {
		String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
		client.sendRoomsList(rooms, null);
	}

	protected static void createRoom(String roomName, ServerThread client) {
		if (Server.INSTANCE.createNewRoom(roomName)) {
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
			client.sendRoomsList(null, String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!Server.INSTANCE.joinRoom(roomName, client)) {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
			client.sendRoomsList(null, String.format("Room %s doesn't exist", roomName));
		}
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
		client.disconnect();
		room.removeClient(client);
	}
	// end command helper methods

	/***
	 * Takes a sender and a message and broadcasts the message to all clients in
	 * this room. Client is mostly passed for command purposes but we can also use
	 * it to extract other client info.
	 * 
	 * @param sender  The client sending the message
	 * @param message The message to broadcast inside the room
	 */
	protected synchronized void sendMessage(ServerThread sender, String message) {
		if (!isRunning) {
			return;
		}
		info("Sending message to " + clients.size() + " clients");
		if (sender != null && processCommands(message, sender) || privatemessage(message, sender)) {
			// it was a command or was a private message don't broadcast
			return;
		}
		message = formatMessage(message);
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				if (!isMuted(client, sender.getClientName())) {
					boolean messageSent = client.sendMessage(from, message);
					client.addChatHistory(client, message);
					if (!messageSent) {
						handleDisconnect(iter, client);
					}
				}
			}
		}
	}

	// Command helper methods
	//
	//
	//
	// Milestone2 feature implementation
	protected synchronized void flipcoin(ServerThread sender) {
		Random random = new Random();
		int coins = random.nextInt(4);
		String m;
		if (coins % 2 == 0) {
			m = "-r The Coin is Heads r-";
		} else {
			m = "-r The Coin is tails r-";
		}
		sendMessage(sender, m);
	}

	protected synchronized void roll(ServerThread sender, int number) {
		Random random = new Random();
		int num = random.nextInt(number);
		String m = "-r Your number is " + num + "r-";
		String newresult = formatMessage(m);
		sendMessage(sender, newresult);
	}

	private boolean privatemessage(String message, ServerThread client) {
		boolean wasPrivate = false;
		String m = message;
		try {
			if (m.indexOf("@") > -1) {
				String arr[] = m.split("@");
				String clientName = arr[1];
				clientName = clientName.trim().toLowerCase();
				List<String> clientss = new ArrayList<String>();
				clientss.add(clientName);
				wasPrivate = true;
				sendPrivateMessage(client, clientss, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasPrivate;
	}

	protected void sendPrivateMessage(ServerThread sender, List<String> listMessage, String message) {
		Iterator<ServerThread> iterator = clients.iterator();
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
		while (iterator.hasNext()) {
			ServerThread client = iterator.next();
			if (listMessage.contains(client.getClientName().toLowerCase())) {
				if (!isMuted(client, sender.getClientName())) {
					boolean messageSent = client.sendMessage(from, message);
					if (!messageSent) {
						iterator.remove();
					}
					break;
				}
			}
		}
	}

	protected synchronized String formatMessage(String message) {
		String newmessage = message;
		if (newmessage.indexOf("##") > -1) {
			String[] s1 = newmessage.split("##");
			String m = "";
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith(" ") || s1[i].endsWith(" ")) {
					m += s1[i];
				} else {
					m += "<b>" + s1[i] + "</b>";
				}
				System.out.println(s1[i]);
			}
			newmessage = m;
		}
		if (newmessage.indexOf("\\") > -1) {
			String[] s1 = newmessage.split("\\@");
			String m = "";
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith(" ") || s1[i].endsWith(" ")) {
					m += s1[i];
				} else {
					m += "<i>" + s1[i] + "</i>";
				}
				System.out.println(s1[i]);
			}
			newmessage = m;
		}
		if (newmessage.indexOf("__") > -1) {
			String[] s1 = newmessage.split("__");
			String m = "";
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith(" ") || s1[i].endsWith(" ")) {
					m += s1[i];
				} else {
					m += "<u>" + s1[i] + "</u>";
				}
				System.out.println(s1[i]);
			}
			newmessage = m;
		}
		// color for red
		if (newmessage.indexOf("-r") > -1) {
			String[] s1 = newmessage.split("\\-");
			String m = "";
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith("r") || s1[i].endsWith("r")) {
					m += "<font color =\"red\">" + s1[i].substring(2, s1[i].length() - 2) + "</font>";
				} else {
					m += s1[i];
				}
				System.out.println(s1[i]);
			}
			newmessage = m;
		}
		if (newmessage.indexOf("-y") > -1) {
			String[] s1 = newmessage.split("\\-");
			String m = "";
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].startsWith("y") || s1[i].endsWith("y")) {
					m += "<font color =\"yellow\">" + s1[i].substring(2, s1[i].length() - 2) + "</font>";
				} else {
					m += s1[i];
				}
				System.out.println(s1[i]);
			}
			newmessage = m;
		}
		if (newmessage.indexOf("-p") > -1) {
			String[] s3 = newmessage.split("\\-");
			String me = "";
			for (int i = 0; i < s3.length; i++) {
				if (s3[i].startsWith("p") || s3[i].endsWith("p")) {
					me += "<font color =\"purple\">" + s3[i].substring(2, s3[i].length() - 2) + "</font>";
				} else {
					me += s3[i];
				}
				System.out.println(s3[i]);
			}
			newmessage = me;
		}
		return newmessage;
	}

	protected synchronized void sendUserListToClient(ServerThread receiver) {
		logger.log(Level.INFO, String.format("Room[%s] Syncing client list of %s to %s", getName(), clients.size(),
				receiver.getClientName()));
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread clientInRoom = iter.next();
				if (clientInRoom.getClientId() != receiver.getClientId()) {
					boolean messageSent = receiver.sendExistingClient(clientInRoom.getClientId(),
							clientInRoom.getClientName());
					// receiver somehow disconnected mid iteration
					if (!messageSent) {
						handleDisconnect(null, receiver);
						break;
					}
				}
			}
		}
	}

	protected synchronized void sendRoomJoined(ServerThread receiver) {
		boolean messageSent = receiver.sendRoomName(getName());
		if (!messageSent) {
			handleDisconnect(null, receiver);
		}
	}

	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
		// converted to a backwards loop to help avoid concurrent list modification
		// due to the recursive sendConnectionStatus()
		// this should only be needed in this particular method due to the recusion
		if (clients == null) {
			return;
		}
		synchronized (clients) {
			for (int i = clients.size() - 1; i >= 0; i--) {
				ServerThread client = clients.get(i);
				boolean messageSent = client.sendConnectionStatus(sender.getClientId(), sender.getClientName(),
						isConnected);
				if (!messageSent) {
					clients.remove(i);
					info("Removed client " + client.getClientName());
					checkClients();
					sendConnectionStatus(client, false);
				}
			}
		}
	}

	private synchronized void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
		if (iter != null) {
			iter.remove();
		}
		info("Removed client " + client.getClientName());
		checkClients();
		sendConnectionStatus(client, false);
		// sendMessage(null, client.getClientName() + " disconnected");
	}

	public void close() {
		Server.INSTANCE.removeRoom(this);
		isRunning = false;
		clients = null;
	}
}
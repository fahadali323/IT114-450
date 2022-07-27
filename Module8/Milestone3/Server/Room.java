package Module8.Milestone3.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import Module8.Milestone3.Common.Constants;

//Milesonte 2 imports

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
	private static Logger logger = Logger.getLogger(Room.class.getName());

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
						boolean coinflip = flipcoin();
						sendMessage(client, coinflip ? "heads" : "tails");
						break;
					case ROLL:
						int roll = roll();
						sendMessage(client, client.getClientName() + " rolled " + roll);
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

	// Command helper methods
	// Milestone2 feature implementation
	private boolean flipcoin() {
		Random Flip = new Random();
		return Flip.nextBoolean();
	}

	private int roll() {
		Random roll = new Random();
		return roll.nextInt(150);
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
		if (sender != null && processCommands(message, sender)) {
			// it was a command, don't broadcast
			return;
		}
		message = formatMessage(message);
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				boolean messageSent = client.sendMessage(from, message);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
		}
	}

	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_PURPLE = "\u001B[35m";

	protected synchronized String formatMessage(String message) {
		String newmessage = message;
		if (newmessage.indexOf("@@") > -1) {
			String[] s1 = newmessage.split("@@");
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
			String[] s1 = newmessage.split("\\$\\$");
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
			String[] s1 = newmessage.split("\\*\\*");
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
					m += TEXT_RED + s1[i].substring(2, s1[i].length() - 2) + TEXT_RESET;
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
					m += TEXT_YELLOW + s1[i].substring(2, s1[i].length() - 2) + TEXT_RESET;
				} else {
					m += s1[i];
				}
				System.out.println(s1[i]);
			}
			newmessage = m;
		}
		return newmessage;
	}
	// private String formatMessage(String message) {
	// return TEXT_BLACK + message + TEXT_RESET;
	// }
	// String p[] = message.split("\\*");
	// String newmessage[] = new String[p.length];
	// for (int i = 0; i < newmessage.length; i++) {
	// if (p[i].startsWith(" ") || p[i].endsWith(" ")) {
	// newmessage[i] = p[i];
	// } else {
	// char symbol = p[i].charAt(0);
	// switch (symbol) {
	// case ('U'):
	// String underline = String.join("\u0332",message.split("",-1));
	// newmessage[i] = (underline);
	// break;
	// case ('O'):
	// String bold = (TEXT_BOLD + p[i]);
	// newmessage[i] = (bold);
	// break;
	// case ('I'):
	// String italics = (TEXT_ITALICS+ p[i]);
	// newmessage[i] = (italics);
	// break;
	// case ('Y'):
	// String y = TEXT_YELLOW + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (y);
	// break;
	// case ('R'):
	// String r = TEXT_RED + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (r);
	// break;
	// case ('b'):
	// String b = TEXT_BLACK + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (b);
	// break;
	// case ('G'):
	// String g = TEXT_GREEN + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (g);
	// break;
	// case ('B'):
	// String bl = TEXT_BLUE + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (bl);
	// break;
	// case ('P'):
	// String P = TEXT_PURPLE + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (P);
	// break;
	// case ('C'):
	// String c = TEXT_CYAN + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (c);
	// break;
	// case ('W'):
	// String w = TEXT_WHITE + p[i].substring(0, p[i].length() - 1) + TEXT_RESET;
	// newmessage[i] = (w);
	// break;
	// }
	// }
	// }
	// return TEXT_BLACK + message + TEXT_RESET;
	// // }

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
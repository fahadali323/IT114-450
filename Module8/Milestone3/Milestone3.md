<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Fahad Ali(fa376)</td></tr>
<tr><td> <em>Generated: </em> 7/31/2022 10:55:00 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone3/grade/fa376" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182054032-f68ff552-551d-47d1-861c-a07332885995.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Host/port<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182054054-5796babb-bb3b-4754-a812-bf8f1a81126e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>username<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p>We use a gethost() and getport() to get the host number and the<br>port number inside the connection panel. Then to display onto the console we<br>used a csPanel.getHost() which outputs the hostname, inputPanel.getUsername() to display a panel for<br>the user to type their name and csPanel.getPort() to display the port panel.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182054565-0c8f488f-a5d0-4ab0-b613-f4f2da5b1d25.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show a list of user in the room<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182054633-48e7fadc-6d9a-498b-8612-223628451c0e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the chat message area with chat history<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182054926-4b69ecc7-03ee-4c8e-852c-b59e4b8ac04a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show a snippet for the code that lets the enter key send<br>the message<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182054993-b2c86caa-f12c-44db-8293-7b5367f18755.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show a snippet for the code that lets the enter key send<br>the message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182055273-b7589981-7c23-4203-8ed7-d70b1194f331.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show /flip  &amp;&amp;&amp;  Show /roll (Their output should appear in<br>a different text format)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182055336-4d497e38-3292-4e73-acf3-153b3332f39c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show the server-side code for /flip generation<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182055398-c3357b5c-f5e3-40ed-afad-fdcba98010df.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the server-side code for the /roll generation<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182060217-cb0a4c6a-d4b8-44a5-adae-f09006f36b7c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Case for flip and roll <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <p>So when a user types /flip, the message gets processed inside the processcommands<br>function which returns a boolean value of whether a message is a command<br>or not. In this case /flip is a command, then inside the processcommands,<br>we call the flipcoin function which takes in a parameter of client. Inside<br>the flipcoin function, we use a random to generate a random number upto<br>4. If the coin remainder is equal to 0, we output to the<br>screen that it was a heads, otherwise if the remainder is is something<br>else we output to the screen that the coin is tails. Similarly, when<br>a user types /roll 30, we use that to go into the roll<br>case inside the processcommand function. Then we call the roll function which takes<br>in client and rol the integer value typed by the user as parameters<br>for the roll function. Inside the roll function the I use a random<br>generator to generate a number from 0 to the number the user inputed<br>into the console when they typed /roll x (x is the # uesr<br>types). Then we append this new generated number into a message that gets<br>formated using the formateMessage() functions which changes the format of the message of<br>the result.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056121-c5697d15-76a0-4cad-aee0-1174bbc5e1bc.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot of bold, italics, color and underline <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056208-68f17945-6ee4-47b3-8963-d00339940de1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot showing combinations of effects together working<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>If the user wants to bold a message they type in ##message which<br>would make the word message bold. I used a format function which checks<br>for the different text style the user wants for their message. So inside<br>this function I check for whether or not a message starts with a<br>certain symbol much like ## for bold or __ for underline or&nbsp; \<br>for italics. Then I split the message with the starting values of ##<br>for bold. Then for each character in the message that the user typed<br>after ## will get appended and based on what they they typed before<br>will get a specific text style. In this case, a bold message will<br>be printed to the console by using&nbsp;&nbsp;<span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space:<br>pre; color: rgb(0, 16, 128);">m</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;"> +=<br></span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(163, 21, 21);">&quot;&lt;b&gt;&quot;</span><span style="font-family:<br>Consolas, &quot;Courier New&quot;, monospace; white-space: pre;"> + </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace;<br>white-space: pre; color: rgb(0, 16, 128);">s1</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">[</span>&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(0, 16, 128);&quot;&gt;i</span><span style="font-family: Consolas,<br>&quot;Courier New&quot;, monospace; white-space: pre;">] + </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space:<br>pre; color: rgb(163, 21, 21);">&quot;&lt;/b&gt;&quot;</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">;</span><span style="font-family:<br>Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">; where all characters will get added by<br>applying the bold text style. </span><br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056312-f4121116-8592-4f9d-8d0c-580c89a51e8f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshots showing a demo of whisper commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056809-f9980a7d-4fc4-4db2-bdc8-bd2ec925f4d4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of privatemessage function<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056854-2450441a-766b-412d-9fb2-da3494ea0eed.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot  sendPrivateMessage Function<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056975-514bdd8e-13c3-4341-bfe6-d91174e9ba85.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>How private message gets send <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>I created a function called privatemessage() which returns a boolean value based on<br>whether or not a function has a @ symbol at the end of<br>the message before the username.&nbsp;<div>This function takes in the parameter (string message and<br>ServerThread client). if the message has an index of @, then we split<br>the message where the @ symbol is and add the rest of the<br>message inside an arraylist. Each character that is written as the username will<br>be trimmed and lowercased and then added to list called clientss. And we<br>set a boolean value of wasPrivate to true. And call a function sendPrivateMessage()<br>that takes in client, clientss, and message as parameter. Client is the user<br>who typed the message. clientss is the targetted user, and message is the<br>message that the sender wants to send. So inside the&nbsp; sendPrivateMessage(), we use<br>an iterator to check whether or not the the targeted user is inside<br>the arraylist then we send the message to the targetted user. Otherwise, we<br>remove the iterator. One thing to note is that inside the sendMessage() we<br>used<span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">&nbsp; &nbsp;</span><span style="font-family: Consolas, &quot;Courier New&quot;,<br>monospace; white-space: pre; color: rgb(175, 0, 219);">if</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space:<br>pre;"> (</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(0, 16, 128);">sender</span>&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;&quot;&gt; != </span><span style="font-family: Consolas, &quot;Courier New&quot;,<br>monospace; white-space: pre; color: rgb(0, 0, 255);">null</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space:<br>pre;"> &amp;&amp; </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(121, 94,<br>38);">processCommands</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">(</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace;<br>white-space: pre; color: rgb(0, 16, 128);">message</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">,<br></span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(0, 16, 128);">sender</span><span style="font-family:<br>Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">) || </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace;<br>white-space: pre; color: rgb(121, 94, 38);">privatemessage</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">(</span>&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(0, 16, 128);&quot;&gt;message</span><span style="font-family: Consolas,<br>&quot;Courier New&quot;, monospace; white-space: pre;">, </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;<br>color: rgb(0, 16, 128);">sender</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">)) {</span></div><div style="font-family:<br>Consolas, &quot;Courier New&quot;, monospace; line-height: 19px; white-space: pre;"><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><span style="color: #008000;">// it was a command or was a private message don&#39;t<br>broadcast</span></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span style="color: #af00db;">return</span>;</div><div>&nbsp; &nbsp; &nbsp; &nbsp; }<br>which basically checks if a message was a command of private message so<br>we don&#39;t broadcast the message to all users inside the same room. </div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056691-a4de48b9-a797-41d3-9b65-a2d09e668054.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Capture any output from mute<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182056748-9a4a2f5f-9f04-45b2-a13d-25d105b503a4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>unmute commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182059736-0a5585df-57ac-43d6-8fa5-4f418306c9e6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Mute/Unmute case screenshot<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182059827-0cd877ee-c101-4b4f-867d-f43404a61ce2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>priveatemessage function called inside each Case<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182059930-2876bb6d-a2ca-4deb-81a0-7055a091a495.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot function for mute/unmute function<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/182060062-a37b7b55-da48-4685-9633-7b4d4e0115f9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of Sendmessage function<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>We use case by case function to check if a message is a<br>command /mute or /unmute. If it is then we go into the case<br>mute where muteduser is the client comm2[1]. We use client.mute(muteduser) and call the&nbsp;&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(121, 94, 38);&quot;&gt;sendPrivateMessage</span><span style="font-family: Consolas,<br>&quot;Courier New&quot;, monospace; white-space: pre;">(</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color:<br>rgb(0, 16, 128);">client</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">, </span><span style="font-family: Consolas,<br>&quot;Courier New&quot;, monospace; white-space: pre; color: rgb(175, 0, 219);">new</span><span style="font-family: Consolas, &quot;Courier New&quot;,<br>monospace; white-space: pre;"> </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(121,<br>94, 38);">ArrayList</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">&lt;</span><span style="font-family: Consolas, &quot;Courier New&quot;,<br>monospace; white-space: pre; color: rgb(38, 127, 153);">String</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space:<br>pre;">&gt;(), </span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(0, 16, 128);">message</span>&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;&quot;&gt;).Inside the serverthread.java we used boolean function<br>called isMuted which checks if a user is muted or not. We use<br>a void  mute function which adds a the targeted user inside </span><div>&lt;font<br>face=&quot;Consolas, Courier New, monospace&quot;&gt;<span style="white-space: pre;">a string list. And similarly, we also use<br>a void unmuted function to remove a user from the string list of<br>muted users. To decide whether or not to send a  message to<br>the targetted user, we check by</span></font></div><div><font face="Consolas, Courier New, monospace"><span style="white-space: pre;">using </span></font>&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(175, 0, 219);&quot;&gt;if</span><span style="font-family: Consolas,<br>&quot;Courier New&quot;, monospace; white-space: pre;">(!</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color:<br>rgb(0, 16, 128);">client</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">.</span><span style="font-family: Consolas, &quot;Courier<br>New&quot;, monospace; white-space: pre; color: rgb(121, 94, 38);">isMuted</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace;<br>white-space: pre;">(</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre; color: rgb(0, 16, 128);">sender</span>&lt;span<br>style=&quot;font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;&quot;&gt;.</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space:<br>pre; color: rgb(121, 94, 38);">getClientName</span><span style="font-family: Consolas, &quot;Courier New&quot;, monospace; white-space: pre;">())){</span></div><div style="font-family:<br>Consolas, &quot;Courier New&quot;, monospace; line-height: 19px; white-space: pre;"><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; <span style="color: #267f99;">boolean</span> <span style="color: #001080;">messageSent</span> = <span style="color:<br>#001080;">client</span>.<span style="color: #795e26;">sendMessage</span>(<span style="color: #001080;">from</span>, <span style="color: #001080;">message</span>);</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; <span style="color: #af00db;">if</span> (!<span style="color: #001080;">messageSent</span>) {</div><div>&nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span style="color: #795e26;">handleDisconnect</span>(<span style="color:<br>#001080;">iter</span>, <span style="color: #001080;">client</span>);</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br>}</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; } which checks if a<br>client is not muted, then we send them the message. If they are<br>muted then we don&#39;t send them any messages. </div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone3/grade/fa376" target="_blank">Grading</a></td></tr></table>
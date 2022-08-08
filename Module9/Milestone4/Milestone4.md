<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Fahad Ali(fa376)</td></tr>
<tr><td> <em>Generated: </em> 8/8/2022 1:22:39 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone4/grade/fa376" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183461773-917b7911-73e7-4bd1-9617-7f503e9f3381.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client can export chat history of their current session (client-side)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183461905-c0087870-d17b-416f-b82f-e4dba04ee3e1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>UI <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183461963-9b04f8d5-27ef-4e02-9947-aa1a9b4aab9c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add screenshot of exported data<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I used a command called /export which calls two functions called createExport() and<br>exportchat(). Then inside serverthread.java I used a private string list array that stores<br>all the messages a user types into the console. i also used AddchatHistory()<br>function which handles the functionality of adding messages typed by a user and<br>storing it the list array. CreateExport() function will create a new file called<br>export.txt if the file already exits, it deletes the old one and then<br>creates a new one. Finally exportChat() function role is to write into the<br>export.txt all the&nbsp; messages that were previously recorded by the AddChatHistory() function inside<br>the chatHist array list.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183463692-ef9bcfae-31a1-40e3-aa09-74cdd9378132.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot of how the mute list is stored<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183463963-a3546b1e-e76e-4efe-b2a1-b02a20222634.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>How mute export is handled <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183464394-862e9ce6-73db-4fce-890c-c0e32561c582.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot of the code saving/loading mute list<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>When the user types in the command /mute it calls for the muteexport()<br>function which creates a file called .txt file for the user that called<br>the function preceding .txt. Mute export will use a new File() object to<br>create a new file. If the file is created it will print out<br>that the file was created followed by what the name of the file<br>is. If it is not created it throws an error. After that I<br>created another try function that adds the value of the user who is<br>being muted by the one calling the /mute command. I again use FileWriter<br>to write into the the file that was previously created the name of<br>the user who is being muted. If the filewriter can&#39;t write into the<br>file, it will throw an error.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183466225-770fe3aa-c93a-4811-b8fd-d4401b8bf9d2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot showing the related chat messages<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183466001-0363f2eb-1b4f-40b9-a83e-0ed93d1ad552.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot of the related code snippets<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183467133-19377d66-6a74-4609-9cc7-dc3eebe87ba3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> code snippet 2<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>When the /mute or the /unmute command is processed it calls a function<br>mute() or unmute() with parameters client and mUser being passed. The mute function<br>then trims and lowercases the name. If the name is not already muted,<br>it will create an arraylist called mu and add the clientname into a<br>muteCheck hashmap. This is similar process with the /unmute with the exception of<br>the client is already muted, then you check to see if the name<br>is in the mu list. If it is you remove the name from<br>the mu list. In addition, when either command is called a private message<br>gets send to the user that is being muted stating that a username<br>has muted you. Or if a user types /unmute, a private message is<br>send to the muted user that username so and so has unmuted you.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183466225-770fe3aa-c93a-4811-b8fd-d4401b8bf9d2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>could not figure it out <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/183466225-770fe3aa-c93a-4811-b8fd-d4401b8bf9d2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>could not figure it out <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>For the last feature, I was thinking about adding a function inside userListpanel<br>where I add the names of clients inside this function and updating constantly<br>after a new user types in message. if the most recent message is<br>send then we change the color of the message by highlighting it with<br>a color. In addition, we create another loop that stores the previous colored<br>messages and highlights it as the name list gets updated with a new<br>clientname that send a message. We would then unhighlight the old message and<br>highlight the new message. Similarly to gray out the client who is muted,<br>I would add a function called graybackground() that finds the correct rgb color<br>for gray color inside clientUtils. This graybackground() function then gets called inside the<br>UserListPanel.java where when the /mute or /unmute commands get processed then I would<br>use an if loop to check if it was processed. If it was<br>processed then i would called the graybackground() function to change the background color<br>of the user that gets muted or unmuted. Mutted would gray out the<br>background of the user and unmuted would clear the background color of the<br>unmuted user.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone4/grade/fa376" target="_blank">Grading</a></td></tr></table>
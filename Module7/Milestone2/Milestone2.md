<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Fahad Ali(fa376)</td></tr>
<tr><td> <em>Generated: </em> 7/20/2022 7:40:49 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone-2/grade/fa376" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Server will have the functionality to switch users between “Rooms” </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of lobby</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179881740-b0a1e072-2438-4d8e-895b-768a736b1b04.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>| Show that the users are in the lobby<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179881871-dec93fe5-cc5e-4028-b143-df951b689c2a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show some multi-user communication<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Screenshots of different room</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179881934-7db5cd34-4ed0-4bf3-b239-24cf6bb748fe.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the process of creating a new room<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179882034-dccb3f05-6cbf-467c-a8aa-c915cde00326.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show that the user is now in a new room<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179882087-d8919e66-1dd3-44fa-b772-431b15576870.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show that there&#39;s no cross-room communication<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179882245-819897ca-f5f9-40fe-9159-c5da123ca53b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Add a screenshot of your Payload code<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179882309-512773ca-c61d-41a9-a9e8-0cf86838e658.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show the code for /flip and  Show the code for /roll<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179882591-aaaffad7-2f4a-4850-a8e8-1732a9811b66.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the code for the mentioned commands<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179882624-471c2fd2-9b9f-43e5-bf1f-806bacc4144b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the code for the mentioned commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>So when the user type is /flip the code will output either heads<br>of tails. So I create two separate functions<div>called&nbsp;<span style="font-family: Consolas, &quot;Courier New&quot;, monospace;<br>white-space: pre; color: rgb(121, 94, 38);">flipcoin</span><font face="Consolas, Courier New, monospace"><span style="white-space: pre;">() and<br>roll(). In the flipcoin(), I initialized and object of random and </span></font></div><div><font face="Consolas,<br>Courier New, monospace"><span style="white-space: pre;">passed into a Boolean value. Then inside the commands<br>process function the code will output </span></font></div><div><font face="Consolas, Courier New, monospace"><span style="white-space: pre;">heads<br>of tails based on the Boolean value that the random generated. Similarly, roll()<br>function </span></font></div><div><font face="Consolas, Courier New, monospace"><span style="white-space: pre;">will get a random number from<br>1 to 150 and then prints to the console that a certain user<br>rolled a</span></font></div><div><font face="Consolas, Courier New, monospace"><span style="white-space: pre;">and the value was such and<br>such.</span></font></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179885003-029015d9-9570-4ff3-b8c5-c7e5b261cad8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how bold is processed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179885068-97528d4f-f6e2-47e9-abfd-7cfafa50a3c6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how italics is processed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179885125-cfda9c59-23e7-4548-85c9-e7ce756a4301.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how color is processed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/179885213-4039c5f7-31da-4f5e-a774-983ba3b1705f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how underline is processed<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/180100267-0d921889-4f84-4aee-a52a-97eee68e86f1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how bold is displayed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/180100300-54b6ed09-e531-48b1-93ca-29697e34dd78.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> show how italics is displayed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/180100350-20ae8d83-1dee-474a-8d62-ef2942a06bef.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how underline is displayed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/180100490-00b006f5-06e4-4946-805a-fec043b7a760.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show how color is displayed<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/180100659-0e2f3a18-ca91-4062-a367-dfd8193502bd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Show a mix of all options together<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>I used a formatemessage() function where the message gets split where a word<br>starts with \*. Then each character in the word gets appended into an<br>array where it either gets bolded, italics, color or underlined. To decide when<br>each format happens, I used a switch case where based on the letter<br>they inputted after the \* will decided whether something gets bolded and so<br>on.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/fahadali323/IT114-450/pull/17">https://github.com/fahadali323/IT114-450/pull/17</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone-2/grade/fa376" target="_blank">Grading</a></td></tr></table>
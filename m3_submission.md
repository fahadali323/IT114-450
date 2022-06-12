<table><tr><td> <em>Assignment: </em> IT114 - Number Guesser</td></tr>
<tr><td> <em>Student: </em> Fahad Ali(fa376)</td></tr>
<tr><td> <em>Generated: </em> 6/11/2022 8:09:53 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-number-guesser/grade/fa376" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create the below branch name</li><li>Implement the NumberGuess4 example from the lesson/slides</li><li>Add/commit the files as-is from the lesson material</li><li>Pick 2 of the following options to implement</li><ol><li>Display higher or lower as a hint after a wrong guess</li><li>Implement anti-data tampering of the save file data (reject edits)</li><li>Add a difficulty selector that adjusts the max strikes per level</li><li>Display a cold, warm, hot indicator based on how close to the correct value the guess is (example, 10 numbers away is cold, 5 numbers away is warm, 2 numbers away is hot; adjust these per your preference)</li><li>Add a hint command that can be used once per level and only after 2 strikes have been used that reduces the range around the correct number (i.e., number is 5 and range is initially 1-15, new range could be 3-8 as a hint)</li><li>Implement separate save files based on a "What's your name?" prompt at the start of the game</li></ol><li>Fill in the below deliverables</li><li>Create an m3_submission.md file and fill in the markdown from this tool when you're done</li><li>Git add/commit/push your changes to the HW branch</li><li>Create a pull request to main</li><li>Complete the pull request</li><li>Grab the link to the m3_submission.md from the main branch and submit that direct link to github</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Implementation 1 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/173208530-3e23082c-8be8-4f26-a282-daebd6b83bcc.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot of higher/lower code <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/173208565-71a8c77d-568b-4ab7-b1a5-678b61787c0f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>higher/lower output <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>I implement the higher/lower where if the user inputs the wrong number, during<br>runtime the code will display to the screen telling the user if the<br>random picked number is higher or lower depending on what they guessed. As<br>you can notice in the code, I basically used an if loop and<br>and a Boolean statement to compare the guess and the number. If the<br>user guessed number is lower, the code displays to the screen that the<br>random picked number is higher than their guessed number and vise versa for<br>a higher guessed number. In the output screenshot you can see that the<br>random number is 6, when I typed in 7 the prompt tells me<br>to lower my guesser. When I lowered my guess to 5, the prompt<br>tells me to increase my number. (Note: that the random number is only<br>displayed for screenshot)<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Implementation 2 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/173208733-ba2da277-a34f-45e6-8b70-7677bf619439.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot of adjusting max strikes per level code <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/173208789-ec62e98d-caf3-409b-baf3-8062f926ccb9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>adjusting maxstrikes per level output <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/106360996/173208883-787ee216-49b5-4954-af8b-834576c11ef6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>level 3 strike error output <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>For the second option, I used the adjusting maxstrikes per level. To do<br>this i used in if and else loop where I basically compare if<br>the level reaches 3, I will decrease the maxstrikes from 5 to 4.<br>Then when the level reaches 5, i decrease the maxstrike to 3. And<br>lastly I change the maxstrike from 3 to 2. In the screenshot, I<br>output to the screen the random number to reach the levels faster. When<br>level 3 is reached, the prompt outputs to the screen thath the maxstrikes<br>has been decreased and it outputs the strike counter. I do this for<br>the next levels 5 and 6. In the second output screenshot I show<br>for level 3 that the maxstrikes have indeed been decreased to 4. In<br>the screenshot when the users inputs 4 wrong numbers, the level decreases from<br>3 to 2.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a link to the related pull request of this hw</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/fahadali323/IT114-450/pull/6">https://github.com/fahadali323/IT114-450/pull/6</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Discuss anything you learned during this lesson/hw or any struggles you had</td></tr>
<tr><td> <em>Response:</em> <p>At first I was struggling with the levels and implementing the higher/lower code.<br>I was confused on where to write the code in the baseline file.<br>After thoroughly going over the code again and getting a better picture of<br>what each part of the code was doing, I was able to implement<br>the code.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-number-guesser/grade/fa376" target="_blank">Grading</a></td></tr></table>
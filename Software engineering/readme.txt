File: readme.txt
Author: Group <Patroclus>

To launch level builder, run the file LaunchBuilder.java under src/builder.builder
To launch the game, run the file Kabasuji.java under src/model

Please run our game in windows.

For the Kabasuji game, we have two levels, the first level(puzzle level) is unlocked and the second level(lightning level) 
is locked until you get at least one star on the first level. To rotate or flip, select the piece by clicking it , then 
press the button to flip or rotate. All other features are the same except that the piece on board can not move out side 
the board at this point. When you meet the achievement, there will be stars on top right corner. In Lightning level, when 
the time is up, the game will end and go back to level selection panel.

For the level builder,  Click New Level button to create a new level. For the piece creator on bottom left corner, user can 
create a piece by pressing 6 square. The piece can be successfully added into the piece container by pressing the "+" 
button if the piece is valid. In the piece container, you can delete the piece you created. You should select level type on 
the top right corner. If puzzlelevel is selected, you then input allowed move AND PRESS ENTER key to validate. If you select 
Lightning level, similarly input time allowed and Enter. If you select Release level(you have to select square on board first)
, select color first, then pick the number and place it on the board. For creating the board, press the squares and then 
click on hint button and click on the board to create hint(hint as to be 6 squares). Then click on the "+" button to create
the board until it is valid. Then you can test the level by pressing the Test button. After every element is added, click 
on Create Level button to and then click on Save&Exit to finish creating the level. Undo, redo, restart button can work 
perfectly. Then, when you open the game, the builded level will appear.   


Our test case have covered about 40%. 
Part of test case can only run on mac, we will fix it later.
 

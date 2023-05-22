# TicTacToe

### How to build and test (from Terminal):

1. Make sure that you have Apache Ant installed. Run each ant command in the tictactoe folder, which contains the `build.xml` build file.

2. Run `ant document` to generate the javadoc (a hypertext description) for all of the java classes. Generated hypertext description will be in the `jdoc` folder. Open the `index.html` file. 

3. Run `ant compile` to compile all of the java classes. Compiled classes will be in the `bin` folder.

4. Run `ant test` to run all unit tests.

### How to run (from Terminal):

1. After building the project (i.e., running `ant`), run the following command in the tictactoe folder to play against a human player:
   `java -cp bin RowGameApp HUMAN_VS_HUMAN`
   
   Run the following command in the tictactoe folder to play against a computer player:
   `java -cp bin RowGameApp HUMAN_VS_COMPUTER`

### How to clean up (from Terminal):

1. Run `ant clean` to clean the project (i.e., delete all generated files).

Supported features:

* Player 2 can now be either another human player or a computer player. See Step 4 above.

* Undo functionality - If the game has not just started or finished, the users are allowed to undo their previous moves. The user should click on the Undo button to undo the immediately previous move.

# TicTacToe

This version of TicTacToe has been rewritten to conform to the MVC design pattern, as well as a greater degree of readability, encapsulation, and modularity. Instructions for running the code, application, and test suite remain identical as to when project was cloned (i.e. below commands work).

### How to build and test (from Terminal):

1. Make sure that you have Apache Ant installed. Run each ant command in the tictactoe folder, which contains the `build.xml` build file.

2. Run `ant document` to generate the javadoc (a hypertext description) for all of the java classes. Generated hypertext description will be in the `jdoc` folder. Open the `index.html` file.

3. Run `ant compile` to compile all of the java classes. Compiled classes will be in the `bin` folder.

4. Run `ant test` to run all unit tests.

### How to run (from Terminal):

1. After building the project (i.e., running `ant`), run the following command in the tictactoe folder:
   `java -cp bin RowGameApp`

### How to clean up (from Terminal):

1. Run `ant clean` to clean the project (i.e., delete all generated files).

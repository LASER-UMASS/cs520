#BinarySearch

A Java-based implementation of binary search to be used in the CS520 course.

### How to build and run (from Terminal):

1. Make sure that you have Apache Ant installed. Run each ant command in the basic-stats folder, which contains the `build.xml` build file.

2. Run `ant document` to generate the javadoc (a hypertext description) for all of the java classes. Generated hypertext description will be in the `jdoc` folder. Open the `index.html` file. 

3. Run `ant lint` to perform linting of the java classes. Linting results will be printed out to the terminal.

4. Run `ant compile` to compile all of the java classes. Compiled classes will be in the `bin` folder.

5. Run `ant clean` to clean the project (i.e., delete all generated files).

### How to run (from Terminal):

1. After building the project (i.e., running `ant`), run the following command in the binarysearch folder:
   `java -cp bin BinarySearch <ARR> <X>`

   where <ARR> specifies the int array elements and <X> specifies the int value to be searched for

   Example: `java -cp bin BinarySearch 8 6 4 2 6` // Returns 2
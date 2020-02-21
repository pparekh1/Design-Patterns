# CSX42: Assignment 3
## Name: Pranjal Kamlesh Parekh

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<delete.txt> -Darg2=<output1.txt> -Darg3=<output2.txt> -Darg4=<output3.txt> -Darg5=<Logger-Value> 

Example:

The last argument is the Logger value. 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=3



-----------------------------------------------------------------------
## Description:
Data Structures:
1. HashSet: as it avoids duplicates so used to maintain buid and courses.
2. ArrayList:used to store the list of all courses.
3. Binary Search Tree-Each Node Consists of key(Buid) and Courses for storing the information of the students.
Time Complexity of Insert and search is O(n) in worst case.
Also to print the output i have chosen Inorder fashion to print the tree.

Citations:
1. For Binary search tree insert and search functions i have taken help from https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
and have modified the code as per the requirements.
2. To write to a file i have taken help from https://howtodoinjava.com/java/io/java-write-to-file/#BufferedWritter
3.Observer pattern: https://howtodoinjava.com/design-patterns/behavioral/observer-design-pattern/

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 10-JULY-2019



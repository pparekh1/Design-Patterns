# CSX42: Assignment 4
## Name: Pranjal Kamlesh Parekh

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in multiThreadedHS/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile multiThreadedHS/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile multiThreadedHS/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 

ant -buildfile multiThreadedHS/src/build.xml run -Dargs="3 input1.txt input2.txt input3.txt output.txt <Logger-Value>" (For N=3 takes 3 input)
ant -buildfile multiThreadedHS/src/build.xml run -Dargs="2 input1.txt input2.txt  output.txt <Logger-Value>" 		   (For N=2 takes 2 input)
ant -buildfile multiThreadedHS/src/build.xml run -Dargs="1 input1.txt output.txt <Logger-Value>" 					   (For N=1 takes 1 input)
<Logger-Value> will have 0,1,2,3,4,5


Example for N=3 and Logger-Value=3:
The last argument is the Logger value. 
ant -buildfile multiThreadedHS/src/build.xml run -Dargs="3 input1.txt input2.txt input3.txt output.txt 3" 



-----------------------------------------------------------------------
## Description:

1. I have validated the input contents that is it will only accept 5 digit number.
2. I have updated build.xml so that it will take arguments with regard to value of N.

Data Structures:

1. I am using an Array data structure to store contents from n input files when n threads are spawned.N-Threads are created and contents from n-input files are added to the respective array and is being sorted using Merge sort.Is is easy to implement and it helps to store multiple items of the same type together.

2. ArrayList:I have used this data structure to combine all the sorted elements from a sorted array when threads are spawned and added to list and pass it to results file.It grows itself when needed that is it is re-sizable.

3. For the Shared data structure i have used an array as it is easy to implement and helps to store multiple items of the same type together.

Use of Sorting:
I have used Merge sort to sort the data in the data structure for each threads spawned and used Merge sort on shared Data Structure.
I have used mergesort as its worst ,best and average case time complexity is O(nlogn).It starts with smaller subbfiles and finishes with larger files.

Citations:
1. For merge sort I have taken code from https://www.baeldung.com/java-merge-sort
2. To write to a file I have taken help from https://howtodoinjava.com/java/io/java-write-to-file/#BufferedWritter


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

Date: -- 22-JULY-2019



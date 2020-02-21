# CSX42: Assignment 5
## Name: Pranjal Kamlesh Parekh

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=<userInputs.txt> -Darg1=<techA.txt> -Darg2=<techB.txt> -Darg3=<techC.txt> -Darg4=<syn.txt> -Darg5=<output.txt> -Darg6=<Logger-Value> 
	Logger-Value=0,1,2,3,4



Example:

The last argument is the Logger value. 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInputs.txt -Darg1=techA.txt -Darg2=techB.txt -Darg3=techC.txt -Darg4=syn.txt -Darg5=output.txt -Darg6=3 



-----------------------------------------------------------------------
## Description:

Project Description:
dSeaGate Portable Drive vendor wants to provide an online trouble shooter for customers.dSeaGate implemented visitor pattern to implment three type oF Search Algorithm that is exact search ,Naive Stemming search and Semantic search.
There are total 5 files submitted which are as follows:
1. userInputs.txt which has total 27 entries. 8 entries works with "Exact match", 8 with "one-word match", and 8 with "semantic match." 3 matches none.
2. techA.txt which has some sentences and will match will userInputs for "Exact Match" and write to output.txt from techA.txt.
3. techB.txt which has some sentences and will match will userInputs for "Naive Stemming matxh" and write to output.txt from techB.txt.
3. techC.txt which has some sentences and will match will userInputs for "Semantic Match" and write to output.txt from techC.txt.
4. syn.txt which is a synonym file and will map with userInputs and return the respective key or value of matched userInputs and again will map with techC.txt to perform Semantic Match.
5. output.txt has all the matched sentences from techA,techB,techC.

Data Structures used:
1. ArrayList:It has been used to store all the contents from userInput.txt,techA.txt,techB.txt,techC.txt.It contains string representing the sentence.
2. HashMap: Hashmap data structure has been used to store key-value pairs of synonyms which will be taken from syn.txt.

Visitor Pattern Implementation:

1. In the Driver class, algo is the object of type Visitor interface i.e VisitorI.

2. When this object algo passed to the d.accept(algo) where d is the object of the type dSeaGate interface for the concrete class Exact, similarly we have d1 and d2 for Naive stemming and Semantic respectively wherein all three classes override the accept() method which accepts argument of type Visitor Interface.

3. The flow goes as follows : it first goes into the dSeaGateI interface where it gets the declaration of the accept() method which takes the argument of VisitorI type and understands which visit() method is to be visited then goes to the VisitorI interface where it finds the the declaration of the visit() method of the specifies argument type.

4. Similarly , the flow goes for Naive and Semantic match.

Citations:

1. To understand the visitor pattern I have used this site to create the initial structure of my assignment https://sourcemaking.com/design_patterns/visitor/java/1

2. To get the keys by values in hashmap I have taken help from https://thispointer.com/java-how-to-get-keys-by-a-value-in-hashmap-search-by-value-in-map/ and have modified according to my code.

3. To find the last word of a sentence i have looked at this site https://stackoverflow.com/questions/4672806/java-simplest-way-to-get-last-word-in-a-string

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

Date: -- 05-AUGUST-2019



package myArrayList.driver;

import java.util.*;
import java.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.*;
import MyArrayList.util.MyArrayList;
import java.lang.NullPointerException;
//import myArrayList.util.FileProcessor;
import java.io.FileNotFoundException;
import myArrayList.util.MyArrayListTest;

import MyArrayList.util.Results;




/**
 * @author Pranjal Parekh
 *
 */
public class Driver {
	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		
		if (args.length != 2) //|| args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				//|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) 
		{

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
		System.out.println("Hello World! Lets get started with the assignment");
		
		MyArrayList my = new MyArrayList();
        
        
            Results res = new Results();
            MyArrayListTest t = new MyArrayListTest();
            t.testMe(my,res);
            // t.resizeTest(my,res);
            // t.sizeTest(my,res);
            // t.insertNegative(my,res);
            // t.indexTest(my,res);
            // t.removeTest(my,res);
            // t.sumTest(my,res);
            // t.compactFunction(my,res);

            // t.insertDuplicate(my,res);
            // t.notPresentIndex(my,res);
            // t.sumAfterRemoval(my,res);






                int A = my.sum();     
     
        res.storeNewResult("The sum of all the values in the array list is:"+A);
        
        
        res.writeToFile(args[1]);



	}
}

	


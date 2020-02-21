package multiThreadedHS.util;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.io.File;
import java.util.Scanner;
import multiThreadedHS.driver.Driver;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;


public class FileProcessor
 { 
 	private String str;

 	 private Scanner src;
 	 List<Integer> list=new ArrayList<Integer>();


 /**
  * @param inputfile
  * this method opens the input file
  * @return nothing 
  */
public void openFile(String Input)
{
	try {
		src=new Scanner(new File(Input));
	}
	
	catch (Exception e){
		System.out.println("Error");
	}
}
/**
 * @param nothing
 * This method is used to read from the file.
 * The file content to be read is also validated that is it accepts only a five digit number
 * The contents read from the file in the form of String is converted into list
 * The above list is converted into array and returned
 * @return array
 */
public Integer[] readFile()
{ 
	str="";
	while(src.hasNext()){
		str=src.next();
		int a=Integer.parseInt(str);
		if(a<10000 || a>99999)
			System.out.println("Invalid format.");

		else
		list.add(new Integer(str));
		}
	Integer[] arr = new Integer[list.size()];
	for(int i = 0;i < arr.length;i++)
  		arr[i] = list.get(i);

	return arr;
 
}

 /**
  * @param nothing
  * It closes the file opened
  * @return nothing
  */
 public void closeFile(){
	src.close();
}

}








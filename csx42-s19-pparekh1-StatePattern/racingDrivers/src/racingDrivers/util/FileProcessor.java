package racingDrivers.util;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.BufferedReader;
import java.nio.file.Paths;
import java.io.File;
import java.util.Scanner;


public class FileProcessor
 { 
 	private String str;

 	 private Scanner src;

    //FileReader F=null;
// BufferedReader br=null;

public void openFile(String Input)
{
	//String Input = filename;
	try {

		//File temp = new File(Input);
		src=new Scanner(new File(Input));
		
	}
		// F= new FileReader(Input);
		// br=new BufferedReader(F);
	
	
	catch (Exception e){
		System.out.println("Error");
		// System.exit(1);

	}
}

public String readFile()
{
	try{
		if(src.hasNextLine())
			str=src.nextLine();
		else 
			return null;
		}
	catch(Exception e){
		System.out.println("Error");
	}
		// String a = src.next();
		// String b = src.next();
		// String c = src.next();
		// String d = src.next();
		//System.out.println(str);
		
	
	return str;

 // public String readLine()
}

public void closeFile(){
src.close();
}
// {

// 	String content = null;
// 		// try {
// 			content = br.readLine();
// 		// }
// 		// catch(Exception e) { 
// 		// System.out.println("Error while reading file");
// 		// System.exit(1);
// 		//  }
		

// 		return content;
// 	}
			


}








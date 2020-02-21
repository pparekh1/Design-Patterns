package studentCoursesBackup.util;
import  studentCoursesBackup.driver.Driver;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class FileProcessor {
	
	private String str;
	private Scanner src;
 	 Set<String> set= new LinkedHashSet<>();



    /**
	 *@param inputfile to be opened
	 *This method is used to open the file and also reads the file inside.
	 * @return array of inputs in a file
	 */
	public Set<String> openFile(String Input)
	{
		 MyLogger.writeMessage("Input file opened",DebugLevel.INPUT);
		try {
			src=new Scanner(new File(Input));
			String s = "";
            	while (s != null)
            	{
                	s = readFile();
                	if (s == null) break;
                	set.add(s.trim());
            	}
		}

	
	
		catch (Exception e){
			System.out.println("Error FileProcessor openFile");
		// System.exit(1);

		}
		return set;
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
		System.out.println("Error FileProcessor readFile");
	}
	
		
	
	return str;

}
}


package troubleShootSearch.driver;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.pattern.dSeaGateI;
import troubleShootSearch.util.Misc;
import troubleShootSearch.util.Results;
import troubleShootSearch.pattern.SearchAlgoVisitorI;
import troubleShootSearch.pattern.Exact;
import troubleShootSearch.pattern.Naive;
import troubleShootSearch.pattern.Semantic;
import troubleShootSearch.pattern.VisitorI;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.util.Misc;
/**
 * @author Pranjal Parekh
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 7) //|| args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				//|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) 
		{

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		int debugValue=Integer.parseInt(args[6]);
		MyLogger.setDebugValue(debugValue);

		/*Defining arraylist and hashmap*/
		ArrayList<String> userInputs= new ArrayList<String>();
		ArrayList<String> techA= new ArrayList<String>();
		ArrayList<String> techB= new ArrayList<String>();
		ArrayList<String> techC= new ArrayList<String>();
		HashMap<String, String> hm1= new HashMap<String, String>(); 

		/* creating required objects*/
		MyLogger.writeMessage("Object created for User Input File",DebugLevel.OBJECT);
		FileProcessor fp=new FileProcessor();
		MyLogger.writeMessage("Object created for Technical A File",DebugLevel.OBJECT);
		FileProcessor fp1=new FileProcessor();
		MyLogger.writeMessage("Object created for Synonyms Input File",DebugLevel.OBJECT);
		FileProcessor fp2=new FileProcessor();
		MyLogger.writeMessage("Object created for Technical B File",DebugLevel.OBJECT);
		FileProcessor fp3=new FileProcessor();
		MyLogger.writeMessage("Object created for Technical C File",DebugLevel.OBJECT);
		FileProcessor fp4=new FileProcessor();
		MyLogger.writeMessage("Object created for Results",DebugLevel.OBJECT);
		Results res=new Results();
		MyLogger.writeMessage("Object created for Misc",DebugLevel.OBJECT);
		Misc m=new Misc();

		/*Opening userinput file and adding it to list*/
		MyLogger.writeMessage("File User Inputs Opened",DebugLevel.FILE_O);
		fp.openFile(args[0]);
		String input1;
		while((input1 =fp.readFile()) != null){
			userInputs.add(input1);
		}

		/*Opening techA file and adding it to list*/
		MyLogger.writeMessage("File Technical A Opened",DebugLevel.FILE_O);
		fp1.openFile(args[1]);
		String input2;
		while((input2 =fp1.readFile()) != null){
		 	techA.add(input2);
		}
		
		/*Opening techB file and adding it to list*/
		MyLogger.writeMessage("File Technical B Opened",DebugLevel.FILE_O);
		fp3.openFile(args[2]);
		String input3;
		while((input3 =fp3.readFile()) != null){
			techB.add(input3);
		}

		/*Opening techC file and adding it to list*/
		MyLogger.writeMessage("File Technical C Opened",DebugLevel.FILE_O);
		fp4.openFile(args[3]);
		String input4;
		while((input4 =fp4.readFile()) != null){
			techC.add(input4);
		}

		/*Opening synonyms file and reading it from misc adding it to hashmap*/
		MyLogger.writeMessage("File Synonyms Opened",DebugLevel.FILE_O);
		fp2.openFile(args[4]);
		hm1=m.readIntoMap(fp2);
		//System.out.println("Hashmap:"+hm1);

		
		VisitorI algo=new SearchAlgoVisitorI(userInputs,techA,techB,techC,hm1,res);
		MyLogger.writeMessage("Object created for Exact",DebugLevel.OBJECT);
		dSeaGateI d=new Exact();
		d.accept(algo);

		MyLogger.writeMessage("Object created for Naive Stemming",DebugLevel.OBJECT);
		dSeaGateI d1=new Naive();
		d1.accept(algo);

		MyLogger.writeMessage("Object created for Semantic",DebugLevel.OBJECT);
		dSeaGateI d2=new Semantic();
		d2.accept(algo);

		res.writeToFile(args[5]);
		if(debugValue==0){
			MyLogger.writeMessage("Nothing to print",DebugLevel.NO_OUTPUT);
		}
		else
			res.writeToStdout();

		//System.out.println("Hello World! Lets get started with the assignment");

	}
}

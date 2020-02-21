package racingDrivers.driver;
import racingDrivers.driverStates.raceContext;
import racingDrivers.util.FileProcessor;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;


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
		 if (args.length != 3) //|| args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
		// 		|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) 
		 {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
		System.out.println("Hello World! Lets get started with the assignment");
		

		MyLogger.setDebugValue (Integer.parseInt(args[2]));
		FileProcessor fp = new FileProcessor();
		fp.openFile(args[0]);
		
		raceContext rc=new raceContext();
		Results res = new Results();
		MyLogger.writeMessage ("Object created Here"  ,
                                     DebugLevel.OBJECT ) ;
		rc.readToArray(fp,res);
		
		
		res.writeToFile(args[1]);
		MyLogger.writeMessage ("Files realeased Here"  ,
                                     DebugLevel.RELEASE ) ;
		

		 // List<Double> str = new ArrayList<>();
		 // //str = fp.openFile(args[0]);
		 // String num= fp.readFile();
		 // String num2 = fp.readFile();


		 // int temp =Integer.parseInt(num);
		 // Double[] myArray = new Double[temp];
		 // String[] s=num2.split(" ");
		 // for(int i=0;i<temp;i++)
		 // {
		 // 	//System.out.println(s[i]);

		 // 	myArray[i]=Double.parseDouble(s[i]);
		 // 	System.out.println(myArray[i]);
		 // }
		  //System.out.println(num2);

		//for (Double temp : str)
  //       {
  //           Double[] splited = temp.split(" ");
  //           str.add(fp.readFile());
  //           System.out.println(str);

	}
}


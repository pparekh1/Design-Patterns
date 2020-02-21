package racingDrivers.driverStates;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import racingDrivers.util.FileProcessor;
import racingDrivers.util.Results;

 


public class raceContext
{
	static public int temp;
	List<Double> str = new ArrayList<>();
	DriverContext dc=new DriverContext();
	
		/** @param Object fp is passed from driver.java and res object
		 *  This method is used to read input from file to an array
		 * it reads one line and converts to double.
		 * @return nothing
		 */
		 public void readToArray(FileProcessor fp, Results res){

		 	 String num= fp.readFile();
		 	 temp =Integer.parseInt(num);

		 String num2;
		 double[] myArray = new double[temp];

		 for(int i=0;i<temp;i++)
		 	myArray[i]=0.0;

		 while((num2 = fp.readFile()) !=null)
		 {
		 
		// String num2 = fp.readFile();


		
		 
		 String[] s=num2.split(" ");
		 for(int i=0;i<temp;i++)
		 {
		 	/*System.out.println(s[i]);*/

		 	myArray[i]=myArray[i]+Double.parseDouble(s[i]);
		 	//System.out.println(myArray[i]);
		 }
		 //System.out.println("Hiiii");
		 dc.rank(myArray,res);

		}
		 //System.out.println(myArray);
		 }
 }
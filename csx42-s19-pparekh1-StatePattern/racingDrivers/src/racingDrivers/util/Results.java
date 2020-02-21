
package racingDrivers.util;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;
import racingDrivers.util.StdoutDisplayInterface;
import racingDrivers.util.FileDisplayInterface;
import racingDrivers.driverStates.raceContext;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	private List<String> r = new Vector<String>();
	raceContext r1 = new raceContext();
	String result = "";

	/**
	 *@param file to which output has to be generated
	 * Citation:Took help from internet https://howtodoinjava.com/java/io/java-write-to-file/#BufferedWritter
	 *This method is used to generate the output file
	 * @return nothing
	 */
	public void writeToFile(String fileName) {
		int value= r1.temp;
		
		int any=0;
		try {
			BufferedWriter w = new BufferedWriter( new FileWriter( fileName));
		
		for(String str : r ){
				

				w.write( str );
				w.write(" ");
				any++;

				if(any== r1.temp){
					w.write("\r\n");
					any=0;
				}

			
		}
			
			w.close();	
		} catch (Exception e) {
			System.out.println("Exception.");
			System.exit(1);
		}		 
	}	
	
	/**
	 *@param takes a string
	 *this method is used to print in console 
	 *@return nothing
	 */

	public void writeToStdout(String s) {
	
		System.out.println(s);
	}
	

	
	public void storeNewResult(String result){
		r.add(result);
		writeToStdout(result);
	}
	
}


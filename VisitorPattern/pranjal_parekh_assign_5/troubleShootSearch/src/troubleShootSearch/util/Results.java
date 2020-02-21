
package troubleShootSearch.util;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;
import troubleShootSearch.util.StdoutDisplayInterface;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
//import troubleShootSearch.driverStates.raceContext;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	private List<String> r = new Vector<String>();

	String result = "";

	/**
	 *@param file to which output has to be generated
	 * Citation:Took help from internet https://howtodoinjava.com/java/io/java-write-to-file/#BufferedWritter
	 *This method is used to generate the output file
	 * @return nothing
	 */
	public void writeToFile(String fileName) {
		
		
		try {
			BufferedWriter w = new BufferedWriter( new FileWriter(fileName));
		
		for(String str : r ){
				w.write( str );
				w.write("\r\n");
		}
			MyLogger.writeMessage("Output File Closed",DebugLevel.FILE_O);
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
	public void writeToStdout() {
	
		for(String str : r ){
				System.out.println( str );
				
		}
	}
	

	
	public void storeNewResult(List<String> result){
		r.addAll(result);
		
		//writeToStdout(result);
	}
	
}


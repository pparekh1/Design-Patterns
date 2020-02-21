package studentCoursesBackup.util;




import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;



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
			BufferedWriter w = new BufferedWriter( new FileWriter( fileName));
			 MyLogger.writeMessage("output file created",DebugLevel.OUTPUT);
			

		
		for(String str : r ){
				

				w.write( str );
				w.write("\r\n");
				

			
		}
			
			w.close();
			 MyLogger.writeMessage("Output file closed",DebugLevel.RELEASE);	
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
	

	/**
	 *@param takes new result string
	 *this method is used to set the results
	 *@return nothing
	 */
	public void storeNewResult(String result){
		r.add(result);

		//writeToStdout(result);
	}
	
}


	


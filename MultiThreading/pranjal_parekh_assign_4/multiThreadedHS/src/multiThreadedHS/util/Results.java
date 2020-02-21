package multiThreadedHS.util;


import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;
import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.StdoutDisplayInterface;
import multiThreadedHS.util.FileDisplayInterface;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.MergeSort;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;



public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private String input;
	
	private List<String> r = new Vector<String>();
	ArrayList<Integer> ar = new ArrayList<Integer>();

	
	String result = "";
	

	/**
	 * @param file to which output has to be generated
	 * Citation:Took help from internet https://howtodoinjava.com/java/io/java-write-to-file/#BufferedWritter
	 * This method is used to generate the output file.It copies the content from a list to an array and 
	 * Performs Merge sort and sorted elements are written in the file.
	 * @return nothing
	 */
	public void writeToFile(String fileName) {
		MergeSort ms=new MergeSort();
		MyLogger.writeMessage("Merge Sort objects Created",DebugLevel.OBJECT);
		Integer[] val=ar.toArray(new Integer[ar.size()]);
		ms.mergeSort(val,val.length);
		 for(int i=0;i<val.length;i++){

			System.out.println(val[i]);
		 }

		try {
			BufferedWriter w = new BufferedWriter( new FileWriter( fileName));
			 MyLogger.writeMessage("output file created",DebugLevel.OUTPUT);
				for(int i=0;i<val.length;i++){
					r.add(String.valueOf(val[i]));
					
				}
				for(String str:r){
					w.write(str);
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
	 * @param input , object of fileprocessor
	 * This method reads contents of file from files and adds to an array
	 * @return array
	 */
	public Integer[] readToAnArray(String input,FileProcessor fp) throws IOException{
		Integer[] array = fp.readFile();
		//System.out.println("Results array:"+ Arrays.toString(array));
		return array;
	}

	/**
	 *@param element from thread worker 
	 *This method adds the element to the arr list.
	 *@return nothing
	 */
	public void storeElements(Integer ele){
		//System.out.println("element value"+ele);
		ar.add(ele);
		}
	
   /**
	*@param nothing
	*This method is written to check total elements in arr list.
	*@return nothing
	*/
	public void printArr() {
	 	//System.out.println("Inside printArr");
	 	//for(int i=0;i<ar.size();i++)
			//System.out.println(ar.get(i));
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


	


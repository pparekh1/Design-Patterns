package multiThreadedHS.threads;
import multiThreadedHS.driver.Driver;
import multiThreadedHS.util.FileProcessor;
import java.util.Arrays;
import java.util.ArrayList;
import multiThreadedHS.util.MergeSort;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;


public class ThreadWorker extends Thread{

	public String input;
	public String output;
	private Results res1;

	/**
	 * @param input which is the name of the input file and the res1 object of Results class
	 * Constructor of TheardWorker Class
	 */
	public ThreadWorker(String input,Results res1){
	 MyLogger.writeMessage("Constructor for ThreadWorker Class",DebugLevel.CONSTRUCTOR);
	 this.input=input;
	 this.res1=res1;

	}

	MergeSort ms=new MergeSort();
	FileProcessor fp=new FileProcessor();

	/**
	 * @param nothing
	 * this method starts the thread process.
	 * Here it takes inputs from store readToArray method of Results and stores it into an array.
	 * Then it sorts tje inputs of that thread and store that into a Sorted array and then passes to 
	 * storeElement method in results.
	 * @return nothing
	 */
	@Override	
	public void run(){
		
		try{
			fp.openFile(input);
			MyLogger.writeMessage("File Opened here",DebugLevel.INPUT);

			Integer[] duplicate=res1.readToAnArray(input,fp);
		
			for(int i=0;i<duplicate.length;i++)
		 	System.out.println(" input file: "+duplicate[i]);
		
			Integer[] sorted=ms.mergeSort(duplicate,duplicate.length);
			for(int i=0;i<sorted.length;i++)
				{
		   		//System.out.println("Sorted: "+sorted[i]);
		   		res1.storeElements(sorted[i]);
				}

		}
	catch(Exception e)
	{
		System.out.println("Error");
}

		}

}





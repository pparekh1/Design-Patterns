package multiThreadedHS.driver;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;


/**
 * @author Pranjal Parekh
 *
 */
public class Driver {
	public static void main(String[] args) {

        MyLogger.writeMessage("File processor objects Created",DebugLevel.OBJECT);
		FileProcessor fp=new FileProcessor();
		MyLogger.writeMessage("Results objects Created",DebugLevel.OBJECT);
		Results res=new Results();
        
    try {
        int firstArg = Integer.parseInt(args[0]);
        //System.out.println(args[0]);
        // int debugValue = Integer.parseInt(args[firstArg+2]);
        // MyLogger.setDebugValue(debugValue);
   
       if(firstArg<1 || firstArg>3){
    
     	System.out.println("Invalid entry.Enter between 1 to 3");
     }
    	if(firstArg==1)
    		 {
                if(args.length!=4){
                        System.out.println("Incorrect no of arguments");
                        System.exit(0);
                }


				//System.out.println(firstArg+ " Threads started");    		 	
				ThreadWorker tw=new ThreadWorker(args[1],res);
                int debugValue = Integer.parseInt(args[3]);
                MyLogger.setDebugValue(debugValue);
    		 	MyLogger.writeMessage("Theadworker objects Created",DebugLevel.OBJECT);
               
    		 	 MyLogger.writeMessage("Thread 1 Started",DebugLevel.THREAD);
    			tw.start();
    			try{
    				tw.join();
    			}
    			catch(Exception e)
    			{System.out.println("Error");
    		}
            res.writeToFile(args[2]);
 				   			
    		 }
    		 else if(firstArg==2){
                if(args.length!=5){
                        System.out.println("Incorrect no of arguments");
                        System.exit(0);
                }
    		 	//System.out.println("Thread "+firstArg+ " started");
                int debugValue = Integer.parseInt(args[4]);
                MyLogger.setDebugValue(debugValue);
    		 	ThreadWorker tw=new ThreadWorker(args[1],res);
    			MyLogger.writeMessage("Theadworker objects Created",DebugLevel.OBJECT);
    		 	ThreadWorker tw1=new ThreadWorker(args[2],res);
    		 	MyLogger.writeMessage("Theadworker objects Created",DebugLevel.OBJECT);
                MyLogger.writeMessage("Thread 1 started",DebugLevel.THREAD);
                tw.start();
                 MyLogger.writeMessage("Thread 2 Started",DebugLevel.THREAD);
    		 	tw1.start();
    		 	try{tw.join();

    		 	tw1.join();}
    			catch(Exception e){System.out.println("Error");}
                res.writeToFile(args[3]);

    		 }
    		 else if(firstArg==3){
                if(args.length!=6){
                        System.out.println("Incorrect no of arguments");
                        System.exit(0);
                }
    		 	System.out.println("Thread "+firstArg+ " started");
                int debugValue = Integer.parseInt(args[5]);
                MyLogger.setDebugValue(debugValue);
    		 	ThreadWorker tw=new ThreadWorker(args[1],res);
                MyLogger.writeMessage("Theadworker objects Created",DebugLevel.OBJECT);
    		 	ThreadWorker tw1=new ThreadWorker(args[2],res);
                MyLogger.writeMessage("Theadworker objects Created",DebugLevel.OBJECT);
    		 	ThreadWorker tw2=new ThreadWorker(args[3],res);
                MyLogger.writeMessage("Theadworker objects Created",DebugLevel.OBJECT);
                 MyLogger.writeMessage("Thread 1 Started",DebugLevel.THREAD);
    		 	tw.start();
                 MyLogger.writeMessage("Thread 2 Started",DebugLevel.THREAD);
    		 	tw1.start();
                 MyLogger.writeMessage("Thread 3 Started",DebugLevel.THREAD);
    		 	tw2.start();
    		 	
    		 	try{tw.join();
    		 	tw1.join();
    		 	tw2.join();}
    			catch(Exception e){System.out.println("Error");}
                res.writeToFile(args[4]);

    		 }

    		 }

     catch (NumberFormatException e) {
        System.err.println("Argument" + args[0] + " must be an integer.");
        System.exit(1);
    }
    System.out.println("Hello World! Lets get started with the assignment");

	}
}


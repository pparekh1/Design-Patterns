
package studentCoursesBackup.driver;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.TreeBuilder; 
import studentCoursesBackup.myTree.Node;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import studentCoursesBackup.myTree.Operation;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;


    
/**
 * @author Pranjal Parekh
 * B number:B00751906
 * Student courses Backup System 
 */
    
    public class Driver {
	
	public static void main(String[] args) {
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */

	    // FIXME: update this if statement for this assignment
	    if (args.length != 6) //|| args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
		    {
		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);
	    } // end of if
	    
	    System.out.println("Hello World! Lets get started with the assignment");

	    /*object Creation*/
	    MyLogger.setDebugValue (Integer.parseInt(args[5]));
	    MyLogger.writeMessage("Object Created here",DebugLevel.OBJECT);
	    Node Node_orig=new Node();
		FileProcessor fp = new FileProcessor();
	    FileProcessor fpd=new FileProcessor();
	    TreeBuilder tb=new TreeBuilder();
	    TreeBuilder tb1=new TreeBuilder();
	    TreeBuilder tb2=new TreeBuilder();
	    Results res=new Results();
	    Results res1=new Results();
	    Results res2=new Results();

	    /*creating Hashset*/
	     Set<String> set = new LinkedHashSet<>();
	     Set<String> setd = new LinkedHashSet<>();
	    
	    /*Initialization*/
	    Node backup_Node_1 = null;
	    Node backup_Node_2 = null;
	    int key;

	   /*opening the files and adding it to array*/
		 set=fp.openFile(args[0]);
		 setd=fpd.openFile(args[1]);
		

		for(String str:set)
		{
		  if(str!=null)
		  {
		   try{
		 String arr[]=str.split(":");
		 key = Integer.parseInt(arr[0]); 
		 String course=arr[1];
		 Node_orig = tb.search(key, 0);
		 backup_Node_1=tb1.search(key, 1);
		 backup_Node_2=tb2.search(key,2);
		 if (Node_orig == null)
                    {
                    	
                    	Node_orig=new Node(key,course);
     					backup_Node_1 = (Node)Node_orig.clone();
                        
                         backup_Node_2 = (Node)Node_orig.clone();
                        
                        tb.insert(Node_orig, 0);
                        tb1.insert(backup_Node_1, 1);
                        tb2.insert(backup_Node_2, 2);
                    }
                    else{
                    
                    	tb.notifyAll(key,course,Operation.I,0);
                    	tb1.notifyAll(key,course,Operation.I,1);
                    	tb2.notifyAll(key,course,Operation.I,2);
                    }

                    	
                }
                catch(Exception e)
                {
                	System.err.println("Error driver");
                    }
			}
		}

		//tb.inorder();
		System.out.println("Deletion started");
		
		

for(String str2:setd)
		{
		  if(str2!=null)
		  {
		   try{
		 String arr[]=str2.split(":");
		 key = Integer.parseInt(arr[0]); 
		 String course=arr[1];
		 Node_orig = tb.search(key, 0);
		 backup_Node_1=tb1.search(key, 1);
		 backup_Node_2=tb2.search(key,2);
		 tb.notifyAll(key,course,Operation.U,0);
         tb1.notifyAll(key,course,Operation.U,1);
         tb2.notifyAll(key,course,Operation.U,2);
		}
		catch(Exception e)
		{
			System.out.println("Delete catch");
		}


}
}
/*Printing the trees*/
tb.printNodes(0,res);
tb1.printNodes(1,res1);
tb2.printNodes(2,res2);


/*generating 3 output files*/
res.writeToFile(args[2]);
res1.writeToFile(args[3]);
res2.writeToFile(args[4]);


	}  // end public static void main
 }  // end public class Driver

package racingDrivers.driverStates;
import racingDrivers.driverStates.raceContext;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;



/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 



public class DriverContext implements DriverContextI
{
  Context context=new Context();
  Calculative cal=new Calculative();
  Confident con=new Confident();
  Reckless reck=new Reckless();

   

 

  /**
   *@param initial array of distance covered and res object
   * This method is sorting the array in descending order.I have used bubble sort.
   * also checked the condition if two or mor dirvers are in same position
   * to get the position of drivers and checking the condition 
   * to determine the state
   *@return nothing 
   */


	public void rank(double[] a, Results res)
  {
		double b[]=new double[a.length];
		int var;
	
	
		for(int p=0;p<a.length;p++){
		
			b[p]=a[p];
				//System.out.println(b[p]);
      }
		 
	/* used bubble sort*/
		for(int i=0;i<b.length;i++)
    {
      for(int j=0;j<b.length-i-1;j++)
      {
        if(b[j]<b[j+1])
        {
          double temp=b[j];
          b[j]=b[j+1];
          b[j+1]=temp;
        }
      }
		
  }
  
  for(int i=0;i<b.length;i++)
  {

    //System.out.println("Sorted in descending:"+b[i]);
    //System.out.println(b[i]);
  }

	 


  for(int i=0;i<a.length;i++)
  {
  	int flag=0;

  	for(int j=0;j<a.length;j++)
  	{
      //System.out.println(a[i]);
      //System.out.println(a[j]);
  		if (((a[i])==(a[j])) && (i!=j))
      {
        
  			flag=1;
      }
  	}

  	var = getPos(b,a[i]);
  //	System.out.println(flag);
  	if(flag==1){
  		
      reck.doAction(context,res);
      //System.out.println(context.getState().toString());

  	}
  	else{
  	if(var < ( 0.3 * (a.length) ) ){

      con.doAction(context,res);
      //System.out.println(context.getState().toString());
      //System.out.println("Confident");
    }
  	
  		
  	
  	else if(var >= Math.round( 0.7 * a.length) ){
  		//System.out.println("Reckless");
      reck.doAction(context,res);
      //System.out.println(context.getState().toString());

    }
  		  	
  
  else if( var < Math.round( 0.7 * a.length ) && var >= Math.round( 0.3 * a.length ) ){
  	//System.out.println("Calculative");
    cal.doAction(context,res);
      //System.out.println(context.getState().toString());
  }
  
  }
  flag=0;
}
}

 
 /**
  *@param takes a sorted array and element to get the position
  *iterates over the sorted array to and if found return the index+1
  *@return returns the index+1 to get the rank if found else returns -1
  */ 
	
 public int getPos(double[] b,double ele)
 {
 	//int flag=1;
 	for(int i=0;i<b.length;i++)
 	{
 		
 		
 		if(ele==b[i])
 			return i+1;
 	}
 	return -1;
 	
}


 	 



}







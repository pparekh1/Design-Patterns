package racingDrivers.driverStates;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;



/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 

public class Context {
   private DriverStatesI driverstate;
   


  public Context(){
     MyLogger.writeMessage ("Constructor Here"  ,
                                     DebugLevel.CONSTRUCTOR ) ;
      driverstate = null;
   }

  /**
   *@param driverstate od type DriverStateI
   * this will set the state of driver
   *@return nothing
   */
   

   public void setState(DriverStatesI driverstate){
      this.driverstate = driverstate;		
   }

   public DriverStatesI getState(){
      return driverstate;
   }
}
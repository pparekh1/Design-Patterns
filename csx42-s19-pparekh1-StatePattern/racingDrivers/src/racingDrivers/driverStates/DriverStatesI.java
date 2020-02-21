package racingDrivers.driverStates;
import racingDrivers.util.Results;
  
/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 

public interface DriverStatesI{

	Results res=new Results();
	public void doAction(Context context,Results res);
}
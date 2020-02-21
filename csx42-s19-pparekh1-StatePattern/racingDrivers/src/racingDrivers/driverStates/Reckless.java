
package racingDrivers.driverStates;
import racingDrivers.util.Results;

/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 

public class Reckless implements DriverStatesI{
	
	/**
	 *@param takes object context and res 
	 *this method generates Recklessin output file
	 *@return nothing
	 */


	public void doAction(Context context,Results res){
		//System.out.println("Driver is in reckless state");
		res.storeNewResult("Reckless");
		context.setState(this);
	}
	public String toString(){
		return "Reckless State";
	}
}


package racingDrivers.driverStates;
import racingDrivers.util.Results;

/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 

public class Confident implements DriverStatesI{
	
	/**
	 *@param takes object context and res 
	 *this method generates Confident in output file
	 *@return nothing
	 */


	public void doAction(Context context,Results res){
		//System.out.println("Driver is in confident state");
		res.storeNewResult("Confident");

		context.setState(this);
	}
	public String toString(){
		return "Confident State";
	}
}

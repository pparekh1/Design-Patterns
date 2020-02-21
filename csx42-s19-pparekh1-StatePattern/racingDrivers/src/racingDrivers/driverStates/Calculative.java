
package racingDrivers.driverStates;
import racingDrivers.util.Results;


/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 

 
public class Calculative implements DriverStatesI{

	
	/**
	 *@param takes object context and res 
	 *this method generates Calculative in output file
	 *@return nothing
	 */


	
	public void doAction(Context context,Results res){
		//System.out.println("Driver is in calculative state");
		res.storeNewResult("Calculative");

		context.setState(this);
	}
	public String toString(){
		return "Calculative State";
	}
}
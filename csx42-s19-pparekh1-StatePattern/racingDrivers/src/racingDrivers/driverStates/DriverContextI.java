package racingDrivers.driverStates;
import racingDrivers.util.Results;
public interface DriverContextI{

/**
 *Citation: taken help from https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * and followed the names and compared accordingly
 */ 
    Results res=new Results();
    public void rank(double[] a,Results res);

   
}


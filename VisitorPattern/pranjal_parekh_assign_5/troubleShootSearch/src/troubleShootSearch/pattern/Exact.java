package troubleShootSearch.pattern;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import troubleShootSearch.util.FileProcessor;


public class Exact implements dSeaGateI{
	
	/**
	 *Its a concrete class
	 *accept() method in this class is calling visit()
	 *method of visitor and passing itself as argument.
	 */
	public void accept(VisitorI visitor){
			visitor.visit(this);
	}

	
	
}
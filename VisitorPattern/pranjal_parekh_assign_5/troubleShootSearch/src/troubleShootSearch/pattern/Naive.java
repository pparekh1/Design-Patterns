package troubleShootSearch.pattern;

public class Naive implements dSeaGateI{

	/**
	 *Its a concrete class
	 *accept() method in this class is calling visit()
	 *method of visitor and passing itself as argument.
	 */
	public void accept(VisitorI visitor){
			visitor.visit(this);
	}
}
package troubleShootSearch.pattern;



/**
 *we have visit() method for all the items in Visitor interface
 *that will be implemented by concrete visitor class that is searchAlgoVisitorI
 */
  public interface VisitorI{

	public void visit(Exact ex);
	public void visit(Naive n);
	public void visit(Semantic sem);
	

}
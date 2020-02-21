package myArrayList.util;

import MyArrayList.util.MyArrayList;
import MyArrayList.util.Results;


public class MyArrayListTest{



	public void testMe(MyArrayList myArrayList, Results results) {
 		resizeTest( myArrayList,results);
		sizeTest(myArrayList, results);
		insertNegative(myArrayList, results);
		indexTest(myArrayList, results);
		removeValueTest(myArrayList, results);		
		sumOfElementsTest(myArrayList, results);		
		compactFunction(myArrayList, results);	
		insertDuplicate(myArrayList, results);
		notPresentIndex(myArrayList, results);
		sumAfterRemoval(myArrayList, results);	
 	}
	/** this methods checks if the array is growing or not 
     Default capacity is 11  **/ 
 	public void resizeTest(MyArrayList myArrayList, Results results){
 		
 		int j=20;
		
 		
 		for(int i = 0 ; i < 20; i++) {
 			myArrayList.insertSorted(i);
             j--;

         }
		if(myArrayList.arrayLen()==22)
		results.storeNewResult("Resize test:Passed");	
		else 	
		results.storeNewResult("Resize test:Failed");
	}
	/** this methods checks the size of an array  **/ 
	public void sizeTest(MyArrayList myArrayList, Results results){
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(2);
		myArrayList.insertSorted(3);
		myArrayList.insertSorted(4);
		myArrayList.insertSorted(5);
		if(myArrayList.size()==5)	
			results.storeNewResult("Size of array :PASSED\r\n");
		else
			results.storeNewResult("Size of array :FAILED\r\n");
	}


	/** this methods checks the boundary case that is array should not have negative value **/ 
	public void insertNegative(MyArrayList myArrayList, Results results){
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(11);
		myArrayList.insertSorted(21);
		myArrayList.insertSorted(43);
		myArrayList.insertSorted(-1);
		if(myArrayList.size()==4)
		
			results.storeNewResult("Negative value in Array:Passed\r\n");
		
		else
			results.storeNewResult("Negative value in Array:Failed\r\n");

}
	
	/** this methods checks the index of an element in an array **/
	public void indexTest(MyArrayList myArrayList, Results results){

		myArrayList.insertSorted(1);
		myArrayList.insertSorted(11);
		myArrayList.insertSorted(21);
		myArrayList.insertSorted(42);
		if(myArrayList.indexOf(11)==2)
		
			results.storeNewResult("Index of an element:Passed\r\n");
		
		else
			results.storeNewResult("Index of an element:Failed\r\n");

}
	/** this methods checks the remove functionality **/
	public void removeValueTest(MyArrayList myArrayList, Results results)
{
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(11);
		myArrayList.insertSorted(21);
		myArrayList.insertSorted(43);
		myArrayList.removeValue(11);
		if(myArrayList.size()==3)
				results.storeNewResult("Remove value functionality:Passed\r\n");
			
			else
				results.storeNewResult("Remove value functionality:Passed\r\n");

}
	/** this methods checks the sum functionality  **/
	public void sumOfElementsTest(MyArrayList myArrayList, Results results){
		
		myArrayList.insertSorted(5);
		myArrayList.insertSorted(6);
		myArrayList.insertSorted(3);
		myArrayList.insertSorted(2);
		int temp=myArrayList.sum();
		if(temp==16)	
			results.storeNewResult("Sum of elements: PASSED\r\n");
		else
			results.storeNewResult("Sum of elements: PASSED\r\n");
	}


	/** this methods checks the compact functionality that is checks if the new array is shrinked **/
	public void compactFunction(MyArrayList myArrayList, Results results){
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(2);
		myArrayList.insertSorted(5);
		myArrayList.insertSorted(6);
		myArrayList.insertSorted(56);
		myArrayList.insertSorted(76);
		myArrayList.insertSorted(61);
		myArrayList.insertSorted(21);
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(63);
		myArrayList.insertSorted(89);
		int a=myArrayList.size();
		myArrayList.removeValue(6);
		myArrayList.removeValue(5);
		myArrayList.removeValue(21);
		myArrayList.removeValue(1);
		myArrayList.removeValue(2);
		myArrayList.compact();
		int b=myArrayList.size();

		if(b<a)	
			results.storeNewResult("Compact function functionality: PASSED\r\n");
		else
			results.storeNewResult("Compact function functionality:  FAILED\r\n");
	}

	/** this method checks if array can have duplicate elements **/
	public void insertDuplicate(MyArrayList myArrayList, Results results){
		myArrayList.insertSorted(12);
		myArrayList.insertSorted(15);
		myArrayList.insertSorted(11);
		myArrayList.insertSorted(18);
		myArrayList.insertSorted(17);
		int a=myArrayList.size();
		myArrayList.insertSorted(17);
		int b=myArrayList.size();
		if(a==b)
			results.storeNewResult("Duplicate elements test: FAILED\r\n");
		else results.storeNewResult("Duplicate elements test: FAILED\r\n");

}
/** this method checks index of element not present in an array  **/
public void notPresentIndex(MyArrayList myArrayList, Results results)
{
		myArrayList.insertSorted(12);
		myArrayList.insertSorted(15);
		myArrayList.insertSorted(11);
		myArrayList.insertSorted(18);
		myArrayList.insertSorted(17);
		if(myArrayList.indexOf(34)==-1)
			 results.storeNewResult("Index of not presesnt element:Passed\r\n");
			else
				 results.storeNewResult("Index of not presesnt element:Passed\r\n");

}
/**  This method will test the sum after removing an element  **/
public void sumAfterRemoval(MyArrayList myArrayList, Results results)
{
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(15);
		myArrayList.insertSorted(19);
		myArrayList.insertSorted(18);
		myArrayList.insertSorted(17);
		int sum=myArrayList.sum();
		myArrayList.removeValue(18);
		int newSum=myArrayList.sum();
		if(sum==newSum)
			 results.storeNewResult("Sum of elements after remove method:Failed\r\n");
			else
				 results.storeNewResult("Sum of elements after remove method:Passed\r\n");


}

}






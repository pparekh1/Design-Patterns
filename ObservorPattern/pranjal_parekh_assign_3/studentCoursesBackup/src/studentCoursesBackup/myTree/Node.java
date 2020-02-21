package studentCoursesBackup.myTree;
import studentCoursesBackup.util.TreeBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;


public class Node implements Cloneable {
    
	public int key; 
  public String course;              
	private List<String> valueList=new ArrayList();  
	public Node leftChild;
	public Node rightChild;


    
    public Node(){
       MyLogger.writeMessage("Empty Constructor called",DebugLevel.CONSTRUCTOR);

    }
    public Node(Node node, int mode){
      MyLogger.writeMessage("Parameterized Constructor called",DebugLevel.CONSTRUCTOR);
      if (mode == 1) {
        this.key = node.getBno();
         this.course=node.getCourse();
         this.valueList.add(this.course);
         this.leftChild = getLeft();
         this.rightChild = getRight();
      } else {
        this.key = node.key;
        this.course = node.getCourse();
        this.valueList = node.valueList;
        this.leftChild = null;
        this.rightChild = null;
      }

    }

   

    public Node(int key,String course){  
     MyLogger.writeMessage("Parameterized Constructor called with key and course",DebugLevel.CONSTRUCTOR);  
         this.key = key;
         this.course=course;
         this.valueList.add(course);
         this.leftChild = null;
         this.rightChild = null;
    }

   public void setBno(int key){
    this.key=key;
   } 

    public void setCourses(List<String> valueList){
    this.valueList=valueList;
   } 
    

    /**
    *getter for bno
    *@param nothing
    *@return key
    **/
    public int getBno(){
        return key;
   }

   /**
    *getter for course
    *@param nothing
    *@return course
    **/
   public String getCourse(){
        return course;
   }


   /**
    *getter for list of courses
    *@param nothing
    *@return valuelist
    **/
   public List<String> getCoursesL(){
    return valueList;
   }

 


  /**
   *gets the left child of the node
   *@return the left child
   **/
    public Node getLeft(){
        return leftChild;
   }

  /**
   *gets the right child of the node
   *@return the right child
   **/
   public Node getRight(){
        return rightChild;
   }

   /**
    *setter for left child
    *@param leftChild the node to be added
    **/
   public void setLeft(Node leftChild){
    this.leftChild=leftChild;
   } 

 /**
  *setter for right child
  *@param rightChild the node to be added
  **/
   public void setRight(Node rightChild){
    this.rightChild=rightChild;
   } 

   
   public Object clone() throws CloneNotSupportedException{
        Node temp = new Node(this, 0);

        return temp;

   }


    

   /**
    *@param takes course to be updated and enum operation
    *this method is used to update the course idf present and checks for duplicates
    *@return nothing
    **/
 
   public void update(String course,Operation op)
    {
        int mode = 0;
        if (op == Operation.I)                                    
        {
          for (int i = 0; i < valueList.size(); i++) {
            if (valueList.get(i).contains(course))
                mode = 1;
        }
        if (mode == 0)
          valueList.add(course); 
      }
        else if (op == Operation.U)
        {
            for (int i = 0; i < valueList.size(); i++) {
                if (valueList.get(i).contains(course))                               
                  mode = 1;
                  }
            if (mode == 1)
              valueList.remove(course); 
        }
    }

   
}



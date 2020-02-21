package studentCoursesBackup.util;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import studentCoursesBackup.myTree.Operation;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class TreeBuilder{

	Node root;
  Node backup_Node_1, backup_Node_2;
    

public TreeBuilder(){
      
       backup_Node_1 = null;
       backup_Node_2 = null;
       root=null;
    }   

    
  /**
   *@param takes new node and a mode value 
   *this method is used to insert in a node for 3 trees and uses 
   *insertHelper() to add the value in BST format.
   *Citation:https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
   *@return nothing
   */

   public void insert(Node insertingNode, int mode) {
    
     
    switch (mode) {
    case 0:root=this.insertHelper(root,insertingNode, mode);
         break;
    case 1:backup_Node_1=this.insertHelper(backup_Node_1,insertingNode, mode);
         break;
    case 2:backup_Node_2=this.insertHelper(backup_Node_2,insertingNode, mode);
         break;
        }
        
    }
 
  /**
   *@param takes a root ,new node and and mode value
   *this method is used to insert the incoming value in the left or in the right
   *Citation:https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
   *@return root.right if value is greater than root
   *@return root.left if value is greater than root
   *@return root if tree is null
   */                             
    public Node insertHelper(Node root , Node insertingNode,int mode)
     {
     	
     	
     	int newKey= insertingNode.getBno();
     	
        if(root == null) {
            root = new Node(insertingNode, 1);
            return root;
        }
        if (newKey > root.getBno()) 
       
           
        	root.setRight(this.insertHelper(root.getRight(),insertingNode, mode));
    

        else if (newKey < root.getBno())
        root.setLeft(this.insertHelper(root.getLeft(),insertingNode, mode));
    

        return root;
    }



  /**
   *@param takes a key that is a bnumber and mode value.
   *this method checks if the key is present 
   *Citation:https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
   *@return root if key matches the root
   *@return searches left subtree and returns value if matches
   *@return searches left subtree and returns value if matches
   */  
    
    public Node search(int key, int mode) {
    	
      Node temp = null;
      if (mode == 0) {
        temp = root;
               if(root!=null)
        while(temp!=null)
        {
          if(temp.getBno()==key){
            return temp;
          }else if(temp.getBno()>key) {
            temp=temp.getLeft();
          }else if(temp.getBno()<key) {
            temp=temp.getRight();
          }
        }
      }
      else if (mode == 1) {
        temp = backup_Node_1;
               if(backup_Node_1!=null)
        while(temp!=null)
        {
          if(temp.getBno()==key){
            return temp;
          }else if(temp.getBno()>key) {
            temp=temp.getLeft();
          }else if(temp.getBno()<key) {
            temp=temp.getRight();
          }
        }
      }
      else {
        temp = backup_Node_2;
                       if(backup_Node_2!=null)
        while(temp!=null)
        {
          if(temp.getBno()==key){
            return temp;
          }else if(temp.getBno()>key) {
            temp=temp.getLeft();
          }else if(temp.getBno()<key) {
            temp=temp.getRight();
          }
        }
      }
      

       	return null;
    }
    

  /**
   *@param takes a mode value
   *this method calls printNodes() with parameter root,backup_node1,backup_node2
   *@return nothing
   */
     public void printNodes(int mode, Results r) {
      if(mode==0) {
        if(root == null) 
            return;
         else 
           printNodes(root,r);
        
     }
       if(mode==1) {
        if(backup_Node_1 == null) 
            return;
         else 
             printNodes(backup_Node_1,r);
        
     }
       if(mode==2) {
        if(backup_Node_2 == null) 
            return;
         else 
            printNodes(backup_Node_2,r);
        }
    }

   

  /**
   *@param takes a root node
   *this method is used to print in inorder fashion.
   *@return nothing
   */
    private void printNodes(Node iteratingNode, Results r) {
        if(iteratingNode == null) {
            return;
        }
        printNodes(iteratingNode.leftChild,r);
        System.out.println(iteratingNode.getBno()+":"+ iteratingNode.getCoursesL());
        r.storeNewResult(iteratingNode.getBno()+":"+ iteratingNode.getCoursesL());
        printNodes(iteratingNode.rightChild,r);
    }

  /**
   *@param takes a key which is a bnumber,course ,enum operation,mode value
   *this method updated the course to respective bnumber if already present.
   *@return nothing
   */
	public void notifyAll(int key,String course,Operation t, int mode){
		Node SearchNode = search(key, mode);
		SearchNode.update(course,t);
		
	}

}


        
	
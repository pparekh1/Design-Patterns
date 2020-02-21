package MyArrayList.util;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.NullPointerException;
import myArrayList.util.FileProcessor;
import java.io.FileNotFoundException;
import java.util.*;
import java.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.*;

public class MyArrayList {

    private Integer myArray[];
    private static final int default_capacity = 11;
    int index;
    int noOfValues;
    Queue<Integer> orderQueue;
    double loadFactor;
    int sumOfValues = 0;

    public MyArrayList() {


        myArray = new Integer[default_capacity];
        index = 0;
        orderQueue = new LinkedList<>();
        noOfValues = 0;


    }
     public int arrayLen(){
        return myArray.length;
    }

    public void readLine(String f) throws FileNotFoundException
    {   
        File file = new File(f);
        try{
        
        Scanner src = new Scanner(file);

        while(src.hasNext()) 
        {
             if(noOfValues == myArray.length) {
            resizeArray();
        }
        int value=src.nextInt();
        if(value>=0 && value<=10000 ){
         System.out.println(value);
        myArray[index]=value;
        // System.out.println(myArray[1]);
        index++;
        noOfValues++;
        sumOfValues=sumOfValues+value;
        orderQueue.add(value);
        }
    
   
    
     
       src.useDelimiter("\\z");

    }
}
     catch (Exception e)
    {
        System.out.println("Invalid");
    }
}

/*  resize array initial capacity is 11*/
    private void resizeArray() {

        int newSize = 2*myArray.length;
        Integer newArray[] = new Integer[newSize];
       

        for(int i = 0 ; i < myArray.length ; i++) {
            newArray[i] = myArray[i];
        }

        myArray = newArray;

    }

    private void resizeArray(int newSize) {


        Integer newArray[] = new Integer[newSize];
       

        for(int i = 0 ; i < newArray.length ; i++) {
            newArray[i] = myArray[i];
        }

        myArray = newArray;


    }

    public void insertSorted(int newValue) {
         if(newValue >=0 && newValue<=10000){

         if(noOfValues == myArray.length) {
            resizeArray();
        }
        index = noOfValues;
        orderQueue.add(newValue);
        myArray[index] = newValue;

        noOfValues++;
        sumOfValues += newValue;
        index++;

        //System.out.println("no of values: " + noOfValues);

        Arrays.sort(myArray, 0 , noOfValues);

}



    }

    public void printInsertionOrder() {

        Iterator queueIterator = orderQueue.iterator();
        System.out.println();
        System.out.println("Insertion order for array:");
        while(queueIterator.hasNext()) {
            System.out.print(queueIterator.next() +" ");
        }


    }

    public void removeValue(Integer value) {

        for(int k = 0 ; k < myArray.length ; k++) {

            if(myArray[k] == value) {

                myArray[k] = null;
                noOfValues--;
                sumOfValues = sumOfValues - value;
            }

        }

        int j;
        Integer temp;
        for(int i = 0 ; i < noOfValues ; i++) {
            if(myArray[i] == null) {
                j = i;
                while(myArray[j] == null && j < myArray.length) {
                    j++;
                }



                temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;


            }
        }

        // loadFactor = (double) noOfValues / myArray.length;
        // System.out.println("Load Factor: " + loadFactor);
        // if(loadFactor < 1.0) {
        //     System.out.println("calling compact");
        //     compact();
        // }

        //Arrays.sort(myArray);
    }


    public void compact() {

        resizeArray(noOfValues);
        //resizeArray(myArray.length / 2);
    }


    public int indexOf(int value) {
       // int i=-1;
        
        for(int i = 0 ; i < noOfValues ; i++) {

            if(myArray[i] == value) {
               
                return i;
                
            }

        }

        return -1;

    }

    public int size() {
        return noOfValues;
        
    }

    public int sum() {
        return sumOfValues;
    }

  


    
    // @Override
    public void toString1() {
        //System.out.println();
        for (int i = 0 ; i < myArray.length ; i++) {

            System.out.println(" Index:  "+i+"   Value:  "+myArray[i]);

        }
    }

}

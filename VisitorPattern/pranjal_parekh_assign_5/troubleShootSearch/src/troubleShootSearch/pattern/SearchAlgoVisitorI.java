package troubleShootSearch.pattern;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

import troubleShootSearch.util.FileProcessor;



/**
 *we have implemented searchInterfaceI and every item(Exact,Naive,Semantic)
 * will have its logic to give the required search result.
 */ 
public class SearchAlgoVisitorI implements VisitorI {

  
  public ArrayList<String> userInputs= new ArrayList<String>();
  public ArrayList<String> techA= new ArrayList<String>();
  public ArrayList<String> techB= new ArrayList<String>();
  public ArrayList<String> techC= new ArrayList<String>();
  public List<String> match=new ArrayList<String>();
  public List<String> matchn=new ArrayList<String>();
  public List<String> matchs=new ArrayList<String>();
  public List<String> naive=new ArrayList<String>();
  public List<String> seml=new ArrayList<String>();
  public List<String> semhm=new ArrayList<String>();
  public Results res;
  private HashMap<String, String> hm1 = new HashMap<String, String>(); 
  
  /**
   *@param Arraylist of userinputs,technicalA,technicalB,technicalC,hashmap of Synonyms and Results object
   *Its a constructor and initialize the contents to use in this class
   */
  public SearchAlgoVisitorI(ArrayList<String> input,ArrayList<String> inputT,ArrayList<String> inputT2,ArrayList<String> inputT3,HashMap<String, String> hm1,Results res)
   {
         MyLogger.writeMessage("Constructor of SearchAlgoVisitorI class created",DebugLevel.CONSTRUCTOR);
         this.userInputs=input;
         this.techA=inputT;
         this.techB=inputT2;
         this.techC=inputT3;
         this.hm1=hm1;
         this.res=res;

  }
     

  /**
   *@param ex of class Exact
   *This method will have logic of Exact search.
   *It will run through two loops that is userinputs and technical 
   *and will add technical sentence into a list if the userinput is found
   *@return nothing
   */
   @Override
   public void visit(Exact ex) 
   {
    // System.out.println("*******Algo for Exact Match.**************");
    // System.out.println("Contents of Technical file: "+techA);
    // System.out.println("Contents of userInputs: "+userInputs);
    //  System.out.println("Matched :"+match);

    for(int i=0;i<userInputs.size();i++)
    {

      for(int j=0;j<techA.size();j++)
      {
        if(techA.get(j).contains(userInputs.get(i))){
          match.add(techA.get(j));
        }
      }
    }
    //System.out.println("Matched :"+match);
    MyLogger.writeMessage("Exact Search",DebugLevel.MATCH);
    res.storeNewResult(match);
    //res.writeToStdout(match);
  }
   

  /**
   *@param ns of Type Naive
   *This method will have logic of Naive search.
   *It will run through two loops that is userinputs and technical and will take only first word of userinputs 
   *and will add technical sentence into a list if the first word is substring in a technical sentence.
   *@return nothing
   */
   @Override
   public void visit(Naive ns) {
     // // System.out.println("***************Algo for Naive Stemming Match.***************88");
     //  System.out.println("Contents of Technical file: "+techB);
     //  System.out.println("Contents of userinputs"+userInputs);
      //int mode=0;
      String[] items=new String[userInputs.size()];
      for(int i=0;i<userInputs.size();i++){
        items[i]=userInputs.get(i);
      }
        
            List<String> num=firstWord(items);
           // System.out.println(num);

       for(int i=0;i<num.size();i++)
   {    
      for(int j=0;j<techB.size();j++)
      {
        int mode=0;
          String divide[]=techB.get(j).split(" ");
          for(String d:divide){
            if(num.get(i).compareTo(d)==0)
          mode=1;
        }
        
         if(techB.get(j).contains(num.get(i)) && mode==0){
          //System.out.println(technicaln.get(j)); 

            matchn.add(techB.get(j));
         }

      }
 
   }
     //System.out.println("Matched : " +matchn);   
      MyLogger.writeMessage("Naive Stemming Search",DebugLevel.MATCH);
      res.storeNewResult(matchn);
     //res.writeToStdout(matchn);

   }

   /**
    *@param array of string items
    *This method find the first word and adds to a list.
    *@return list naive
    */
   public List<String> firstWord(String[] items)
    {
      String first=null;
      for(String s : items) {
            String[] s2 = s.split(" ");
             first=s2[0];
             naive.add(first);
             //System.out.println(first);
           }
           return naive;
         }

   
  /**
   *@param sem of Type Semantic
   *This method will have logic of Semantic search.
   *This method takes three files into use.It will take the last word of userinputs and will match into Synonyms file
   * if the word is present either in the key or value will return its corresponding value or key.
   *That value or key will be searched in technical file and perform Exact Search.
   *@return nothing
   */
   @Override
   public void visit(Semantic sem) {
      // System.out.println("*******************************Algo for Semantic Match.*********************************************8");
      // System.out.println("Contents of Technical file: "+techC);;
      // System.out.println("contents of hashmap"+hm1);
      String[] items1=new String[userInputs.size()];
      for(int i=0;i<userInputs.size();i++){
        items1[i]=userInputs.get(i);
        //System.out.println("Items elements:"+items);
      }
      List<String> nums=lastWord(items1);
     // System.out.println("last words"+nums);
      //System.out.println(hm1.entrySet());
      
      for(String a:seml){
        if(hm1.keySet().contains(a)){ 
          semhm.add(hm1.get(a));

         } 
          else if(hm1.values().contains(a)){
              getKeyFromValue(a);
          }
       
      }
       //System.out.println("all key value matches:"+semhm);

       for(int i=0;i<semhm.size();i++)
   {
      for(int j=0;j<techC.size();j++)
      { 
         if(techC.get(j).contains(semhm.get(i)))
            matchs.add(techC.get(j));
      }

   }
     //System.out.println("Matched : " +matchs); 
         MyLogger.writeMessage("Semantic Search",DebugLevel.MATCH);

     res.storeNewResult(matchs);
     //res.writeToStdout(matchs);
  

 }


  /**
   *@param string a
   *this method is used to get the key of corresponding value
   *citation:https://thispointer.com/java-how-to-get-keys-by-a-value-in-hashmap-search-by-value-in-map/
   *@return list semhm
   */
  public List<String> getKeyFromValue(String a)
  {
   for (Map.Entry<String,String> entry : hm1.entrySet()) {
    if(entry.getValue().equals(a)){
      semhm.add(entry.getKey());
    }
   }
   return semhm;
  }
  

  /**
   *@param array of string
   *This method find the last word and adds to a list.
   *Citation: https://stackoverflow.com/questions/4672806/java-simplest-way-to-get-last-word-in-a-string
   *@return list seml
   */
  public List<String> lastWord(String[] items1){
    String last=null;
    for(String s : items1) {
            String[] s2 = s.split(" ");
             last=s2[s2.length-1];
             seml.add(last);
             //System.out.println(first);

      }
      return seml;
    }   


}
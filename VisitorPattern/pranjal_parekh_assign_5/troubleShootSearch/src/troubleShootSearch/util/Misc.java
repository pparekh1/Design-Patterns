package troubleShootSearch.util;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;


public class Misc{

	private List<String> al = new ArrayList<String>();
	private HashMap<String, String> hm = new HashMap<String, String>(); 


	/**
	 *@param Fileprocessor object fp
	 *this method reads the files and adds the content to the list
	 *@return list al
	 */
	public List<String> readIntoList(FileProcessor fp){
		String num;

		
		while((num=fp.readFile()) != null){
			al.add(num);
		
		}
		for(int i=0;i<al.size();i++)
		System.out.println(al.get(i));

	return al;

	}


	/**
	 *@param Fileprocessor object fp
	 *this method reads the synonyms file and adds the content to the hashmap which store as key and value
	 *@return hashmap hm
	 */
	public HashMap<String, String> readIntoMap(FileProcessor fp){
		String num1;

		while((num1=fp.readFile()) != null){

			String kv[] = num1.split(":");
			hm.put(kv[0],kv[1]);

		 }

	return hm;


	 }
}

package job;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Problem4 {

	public static List<Integer> findSubsequence(List<Integer> arr) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		List<Integer> dups = new ArrayList<Integer>();
		for (Integer integer : arr) {
			if(map.containsKey(integer)) {
				map.put(integer, map.get(integer)+1);
			}else {
				map.put(integer, 1);
			}
		}
		for (java.util.Map.Entry<Integer, Integer> eachEntry : map.entrySet()) {
			if(eachEntry.getValue() > 1) {
				for (int i = 0; i < eachEntry.getValue()-1; i++) {
					dups.add(eachEntry.getKey());
				}
			}
		}
		int i = 0;
		for (Integer key : arr) {		
			if(i < dups.size() && dups.get(i).equals(key)) {
				i+= 1;
			}
		}
		
		if(dups.size() == i) {
			return dups;
		}else {
			dups.clear();
			dups.add(-1);
			return dups; 
		}
		
		
		
		
	}

	public static void main(String[] args) {
		//Integer[] data = {5,3,2,2,1,1};
		List<Integer> lst = readDataFromFile();
		List<Integer> findSubsequence = findSubsequence(lst);
		System.out.println(findSubsequence);
	}
	
	public static List<Integer> readDataFromFile() {
		List<Integer> lst = new ArrayList<>();

	    try {
	      File myObj = new File("input.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	       // System.out.println(data);
	        lst.add(Integer.parseInt(data));
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    
	    return lst;
	  }
	
}

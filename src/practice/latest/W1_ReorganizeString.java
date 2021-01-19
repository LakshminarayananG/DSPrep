package practice.latest;

import java.util.HashMap;
import java.util.PriorityQueue;

import org.junit.Test;

public class W1_ReorganizeString {

	
	/*
	 * Given a string S, check if the letters can be rearranged so that two
	 * characters that are adjacent to each other are not the same.
	 * 
	 * If possible, output any possible result. If not possible, return the empty
	 * string.
	 * 
	 * Example 1:
	 * 
	 * Input: S = "aab" Output: "aba" Example 2:
	 * 
	 * Input: S = "aaab" Output: "" Note:
	 * 
	 * S will consist of lowercase letters and have length in range [1, 500].
	 */
	
	
	@Test
	public void eg1() {
		String S="vvvolll";
		System.out.println(reorganizeString(S));
	}
	
	
	
	private String reorganizeString(String S) {
        if(S==null || S.length()==0) return "";
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c: S.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb= new StringBuilder();
        PriorityQueue<Character> maxHeap= new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        
        maxHeap.addAll(map.keySet());
        while(maxHeap.size()>1){
            char curr1= maxHeap.remove();
            char curr2= maxHeap.remove();
            sb.append(curr1);
            sb.append(curr2);
            map.put(curr1, map.get(curr1)-1);
            map.put(curr2, map.get(curr2)-1);
            if(map.get(curr1)>0) maxHeap.add(curr1); 
            if(map.get(curr2)>0) maxHeap.add(curr2); 
        }
        if(!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if(map.get(last)>1) return "";
            sb.append(last);
        }
        return sb.toString();
    }
	
	
	
}

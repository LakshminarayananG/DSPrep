package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashTechnique {

	@Test
	public void eg1() {
		int[] arr= {1,2,2,1,2};
		int k=3;
		hashTech(arr,k);
	}
	
	private void hashTech(int[] arr, int k) {
		
		//System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0,2)));
		Map<Integer, Integer> map=new HashMap<>();
		map.put(0, -1);
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			int diff=sum-k;
			if(map.containsKey(diff))
				System.out.println("{"+(map.get(diff)+1)+","+i+"}");
			
			map.put(sum, i);
		}
	}
}

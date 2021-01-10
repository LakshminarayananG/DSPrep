package practice.old;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SubArrayOfDesiredSum {
	
	@Test
	public void eg1() {
		int[] input= {1,2,4,5,3,8,10,1,5};
		int desiredsum=16;
		System.out.println(desiredsumSubArr(input, desiredsum));
	}
	
	
	@Test
	public void eg2() {
		int[] input= {1,2,4,5,3,8,10,1,5};
		int desiredsum=16;
		System.out.println(subArraySum(input, desiredsum));
	}
	
	private Map<Integer, Integer> desiredsumSubArr(int[] input, int desiredsum) {
		Map<Integer,Integer> subArray=new HashMap<>();
		for(int i=0;i<input.length;i++) {
			int targetsum=input[i];			
			for(int j=i+1;j<input.length;j++) {
				targetsum+=input[j];				
				if(targetsum==desiredsum) {
					subArray.put(i, j);
					break;
				}
				else if(targetsum>desiredsum) {
					break;
				}
			}
		}
		
		return subArray;
	}
	
	
	private Map<Integer,Integer> subArraySum(int[] array,int requiredSum)
	{ 
		int startIndex=0;int windowSum=0;
		Map<Integer,Integer> subArrays=new HashMap<>();
		for(int i=0;i<array.length;i++) {
			windowSum=windowSum+array[i];
			
			if(windowSum==requiredSum) {
				subArrays.put(startIndex, i);
			}
			
			while(windowSum>requiredSum) {
				windowSum=windowSum-array[startIndex];
				startIndex++;
			}
			
			if(windowSum==requiredSum) {
				subArrays.put(startIndex, i);
			}
		}
		return subArrays;

	}

}

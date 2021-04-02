package practice.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MinimumSwaps {

	
	@Test
	public void eg1() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(3,4,1,2));
		System.out.println(swaps(list));
		
		
		
	}
	
	@Test
	public void eg2() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(3,1,2));
		System.out.println(swaps(list));
		
		
	}
	
	
	private int minimumSwaps(List<Integer> arr) {
        int i =0;
        int count=0;
        int temp;
        int  n = arr.size();
        while(i<n){
            if(arr.get(i) != i+1){
                temp = arr.get(i);
                arr.set(i, arr.get(temp-1));
                arr.set(temp-1, temp);
                count++;
            }
            else{
                i++;
            }
        }
        return count;
    }
	
	
	
	private int swaps(List<Integer> list) {
		int left=0,right=list.size()-1,count=0;
		while(left<=right) {
			if(list.get(left)<list.get(right)) {
				int temp=list.get(left);
				list.set(left, list.get(right));
				list.set(right, temp);
				count++;
				left++;
				right--;
			}
			else if(list.get(left)>list.get(right))	left++;
			else right--;
			
		}
		return count;
	}
	
}

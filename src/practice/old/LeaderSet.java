package practice.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LeaderSet {
	
	@Test
	public void eg1() {
	int[] input= {3,4,2,7,1,2,4,5};	
		System.out.println(Arrays.toString(leader(input)));
	}
	
	
	@Test
	public void eg2() {
	int[] input= {4,9,3,5,6,5,2};	
		System.out.println(Arrays.toString(leader(input)));
	}
	
	

	@Test
	public void eg3() {
	int[] input= {2,1};	
		System.out.println(Arrays.toString(leader(input)));
	}
	
	
	@Test
	public void eg4() {
	int[] input= {4,9,3,5,6,5,2};	
		printLeaders(input,input.length);
	}
	
	
	//Brute force Approach 
	//Complexity --> O[N^2]
	private Object[] leader(int[] input) {
		List<Integer> lead= new ArrayList<Integer>();
		boolean flag=false;
		
		for(int i=0;i<input.length-1;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i]>input[j]) {
					flag=true;
				}
				else 
				{
					flag=false;
					break;
				}
			}
			if(flag==true) {
				lead.add(input[i]);
			}
		}
		lead.add(input[input.length-1]);
		
		return lead.toArray();
	}
	
	
	
	
	//Other Alternate Approach -- Traverse from right side
	private void printLeaders(int input[], int size) 
    { 
        int max_from_right =  input[size-1]; 
        System.out.print(max_from_right + " "); 
       
        for (int i = size-2; i >= 0; i--) 
        { 
            if (max_from_right <= input[i]) 
            {            
            max_from_right = input[i]; 
            System.out.print(max_from_right + " "); 
            } 
        }     
    } 

}

package job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {


    public static List<Integer> moveOddNumber(List<Integer> numbers) {
		List<Integer> oddNumbers  = new ArrayList<Integer>();
		List<Integer> evenNumbers =  new ArrayList<Integer>();
		
    	for (int i = 0; i < numbers.size(); i++) {
			if(numbers.get(i)%2 == 1) {
				oddNumbers.add(numbers.get(i));
			}else {
				evenNumbers.add(numbers.get(i));
			}
		}
	    	evenNumbers.addAll(oddNumbers);    	
		return evenNumbers;
    }


	public static void main(String[] args) {
		Integer[] data = {1,1,0,2,4};
		
		System.out.println(moveOddNumber(Arrays.asList(data)));
	}


}

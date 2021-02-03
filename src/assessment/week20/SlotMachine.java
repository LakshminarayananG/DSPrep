package assessment.week20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SlotMachine {
	
	/*
	 * A slot machine has multiple wheels that are spun n times. In each spin, each
	 * wheel may have multiple stops from 1 to 9 and shows one random number on the
	 * machine's dashboard.
	 * 
	 * 
	 * Given the number of spins n, determine the minimum number of stops on each
	 * wheel to produce the numbers displayed on the dashboard for each spin. Then,
	 * calculate the total stops.
	 * 
	 * 
	 * n=4 spins[] = [ '712', '246', '365', '312' ] the spins on a slot machine with
	 *  3  wheels are recorded as an array, history: 7 1 2 2 4 6 3 6 5 3 1 2
	 * 
	 * One wheel needs to have at least  7  stops to produce the numbers displayed
	 * on the dashboard for  spin. Since  is the highest value in any row, remove
	 * the highest value from each of the rows:   1 2 2 4 3 5 1 2
	 * 
	 * Now the highest value is 5 , so another wheel must have  stops to produce the
	 * numbers displayed on the dashboard for 3 spin. Using the same logic, the
	 * final wheel needs 3  stops. Total stops are 7 + 5 + 3 = 15
	 */
	
	
	@Test
	public void eg1() {
		String[] input= {"712","246","365","312"};
		List<String> history = new ArrayList<>(Arrays.asList(input));
		System.out.println(slotWheels(history));
	}
	
	@Test
	public void eg2() {
		String[] input= {"137","364","115","724"};
		List<String> history = new ArrayList<>(Arrays.asList(input));
		System.out.println(slotWheels(history));
	}
	
	public static int slotWheels(List<String> history) {
	    // Write your code here
	    List<char[]> characterlist = new ArrayList<>();
	    
	    for(int i=0;i<history.size();i++){
	        String temp = history.get(i);
	        char[] charr= temp.toCharArray();
	        Arrays.sort(charr);
	        characterlist.add(charr);
	    }
	    
	    int maxvalue=0, index=characterlist.get(0).length-1;
	    while(index>=0){
	        int currmax=0;
	        for(char[] temp: characterlist){
	            currmax=Math.max(currmax, Integer.valueOf(""+temp[index]));
	        }
	        maxvalue+=currmax;
	        index--;
	    }
	    return maxvalue;
	    }

}

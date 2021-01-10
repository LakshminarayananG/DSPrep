package assessment.week2;

import java.util.Arrays;

import org.junit.Test;

/*
 Given arrival and departure time of all trains that reach a railway station, 
 the task is to find the min number of platforms required for the railway station so that no trains wait
 
 Arrival[]={9:00,9:40,9:50,11:00,15:00,18:00}
 Departure[]={9:10,12:00,11:20,11:30,19:00,20:00}
*/

public class P4_MinPlatforms {

	@Test
	public void example1() {
		int[] arrival= {900,940,950,1100,1500,1800};
		int[] departure={910,1200,1120,1130,1900,2000};
		minPlatforms(arrival, departure);
	}
	
	@Test
	public void example2() {
		int[] arrival= {900,940,1110};
		int[] departure={910,1100,1120};
		minPlatforms(arrival, departure);
	}
	
	@Test
	public void example3() {
		int[] arrival= {900,940,950,1100,1500,1800,1810,1900,1915,1920};
		int[] departure={910,1200,1120,1130,1900,2000,1840,1930,1950,2000};
		minPlatforms(arrival, departure);
	}
	
	@Test
	public void example4() {
		int[] arrival= {200, 210, 300, 320, 350, 500};
		int[] departure={230, 340, 320, 430, 400, 520};
		minPlatforms(arrival, departure);
	}
	
	private void minPlatforms(int[] arrival, int[] departure) {
	    Arrays.sort(arrival);
	    Arrays.sort(departure);
	    //System.out.println(Arrays.toString(arrival));
	    //System.out.println(Arrays.toString(departure));
	    int platform=Integer.MIN_VALUE;
	    int count=1;
	    int i=1,j=0;
	    
	    while(i<arrival.length) {
	    	if(arrival[i]>departure[j]) {
	    		j++;
	    		count--;
	    	}
	    	else if(arrival[i]<=departure[j]) {
	    		i++;
	    		count++;
	    	}
	    	platform=Math.max(platform, count);
	    }
	    
	    System.out.println(platform);
	    
	}
}

package assessment.week20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AladdinAndCarpet {
	
	/*
	 * 	
	 * Q4: Aladdin wants to travel around the world and will choose a circular path
	 * to fly on his magical carpet. The carpet needs enough magic to take him from
	 * one place to another. He knows that after traveling some distance, he can
	 * find a magic source that will enable the carpet to travel a further distance.
	 * 
	 * There are  n  magical sources along the circular path numbered from  0 to n-1
	 * 
	 * . Initially, the carpet has no magic and Aladdin can use a portal to jump to
	 * any magical source and start his journey. The carpet consumes units of magic
	 * equal to the units of distance travelled. He needs to choose a point to start
	 * his journey that will allow him to complete his journey. Determine the lowest
	 * index of the starting points from which Aladdin can start his journey and
	 * visit all of the places in the circular path in order. If there is no
	 * solution, return -1.
	 * 
	 * For example, there are n = 4 sources of magic along his route: magic = [3, 2,
	 * 5, 4] dist = [2, 3, 4, 2].
	 * 
	 *   The first attempt is starting at the first source, magic[0] = 3.   He
	 * transports there without cost and collects 3  units of magic     The distance
	 * to the next point is  dist[0] = 2.  It takes 2  units of magic to get there
	 * and he collects magic[1] = 2  units upon arrival, so he has 3 - 2 + 2 = 3
	 *  units of magic after making his first carpet ride. Continuing along the
	 * journey: 3 - dist[1] + magic[2] = 3 - 3 + 5 = 5 5 - dist[2] + magic[3] = 5 -
	 * 4 + 4 = 5 5 - dist[3] = 5 - 2 = 3
	 * 
	 * At this point, he is back to the first source. Because he can complete his
	 * journey starting at source magic[0] , there is no reason to continue with the
	 * analysis so its index, 0  is returned. To illustrate a point from the same
	 * example, if he starts at position 2 , where magic[1] = 2 dist[1] = 3, he will
	 * not be able to proceed to the next point because the distance is greater than
	 * his magic units. Note that the list is circular, so from magic[3]  in this
	 * example, the next source on the path is magic[0].
	 * 
	 * Sample Input For Custom Testing 4 2 4 5 2 4 4 3 1 3 Sample Output 1
	 * Explanation Here magic = [2, 4, 5, 2] dist = [4, 3, 1, 3].   If Aladdin
	 * starts at the second magical source, his magic levels are:   magic[1] = 4   4
	 * - dist[1] + magic[2] = 4 - 3 + 5 = 6   6 - dist[2] + magic[3] = 6 - 1 + 2 = 7
	 *   7 - dist[3] + magic[0] = 7 - 3 + 2 = 6   6 - dist[0] = 6 - 4 = 2.     The
	 * first point from where Aladdin can start his journey is the  2nd magical
	 * source. The output should be 1 the index of the 2nd location
	 */
	
	@Test
	public void eg1() {
		List<Integer> magic = new ArrayList<>(Arrays.asList(3,2,5,4));
		List<Integer> dist = new ArrayList<>(Arrays.asList(2,3,4,2));
		System.out.println(optimalPoint(magic, dist));
	}
	
	@Test
	public void eg2() {
		List<Integer> magic = new ArrayList<>(Arrays.asList(2,4,5,2));
		List<Integer> dist = new ArrayList<>(Arrays.asList(4,3,1,3));
		System.out.println(optimalPoint(magic, dist));
	}
	 
	
	public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
	    int currPos=0; int diffMg=0;int diffDis=0;
	    
	    for(int i=0;i<magic.size();i++){
	        int temp=magic.get(i)-dist.get(i);
	        diffMg=diffMg+temp;
	        diffDis=diffDis+temp;
	        if(diffMg <0){
	            currPos=i+1;
	            diffMg=0;
	        }
	        
	    }
	    if(diffDis >= 0){
	        return currPos;
	    }
	    
	    return -1;
	    }

}

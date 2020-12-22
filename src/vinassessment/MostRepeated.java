package vinassessment;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostRepeated {
    /*
        Pseudo-code:
        Iterate a given input array and store it in map
        Get the max value using collections from map
        Now using entry set iterate map get the max value's corresponding key
     */

    @Test
    public void dataSet1(){
        int[]arr= {4,5,2,1,5,4,2,1,0,1};
        getMostRepeatedNum(arr);
    }
    @Test
    public void dataSet2(){
        int[]arr= {1,2,3,4,2,3,4,4};
        getMostRepeatedNum(arr);
    }

    public void getMostRepeatedNum(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer eachInt : arr) {
            map.put(eachInt, map.getOrDefault(eachInt, 0)+1);
        }
        Integer max = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue().equals(max)) System.out.println(entry.getKey());
        }
    }
}

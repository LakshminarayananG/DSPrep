package practice.old;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubsequenceRemoval {

	
	@Test
	public void eg1() {
		List<Integer> input=new ArrayList<Integer>();
		input.add(3);
		input.add(2);
		input.add(2);
		input.add(1);
		input.add(1);
		System.out.println(sub(input));
		
	}
	private List<Integer> sub(List<Integer> input) {
		List<Integer> list = new ArrayList<Integer>();
	    List<Integer> output= new ArrayList<Integer>();
	    List<Integer> out=new ArrayList<Integer>();
	    int val=0;
	    for (Integer integer : input) {
	        if(list.contains(integer)){
	            if(output.size()>=1){
	                if(integer>=output.get(val)){
	                output.add(integer);
	                val++;
	            }
	            else{
	                out.add(-1);
	                return out;
	            }
	            }
	            else{
	                output.add(integer);
	            }
	        }
	        else{
	            list.add(integer);
	        }
	    }

	    return output;
	}
}

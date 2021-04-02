package practice.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ListArrRotation {
	
	@Test
	public void eg1() {
		List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> rotate = new ArrayList<>(Arrays.asList(1,2,3,4));
		System.out.println(rotatelist(a, rotate));
	}
	
	private List<Integer> rotatelist(List<Integer> a, List<Integer> rotate){
		List<Integer> output = new ArrayList<>();
		for(int i=0;i<rotate.size();i++) {
			int val=rotate(a,rotate.get(i));
			output.add(val);
		}
		return output;
	}
	
	private int rotate(List<Integer> list, int rotate){
		if(rotate>list.size()) rotate=rotate%list.size();
		List<Integer> templist = new ArrayList<>(list);
		int temp = list.size()-rotate;
		swap(templist,0,templist.size()-1);
		swap(templist,temp,templist.size()-1);
		swap(templist,0,temp-1);
		return templist.indexOf(Collections.max(templist));
	}
	
	private List<Integer> swap(List<Integer> list, int start, int end){
		while(start<end) {
			int temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			start++;
			end--;
		}
		
		return list;
	}

}

package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class IntersectionOfSets {
	
	//Find the intersection of given K arrays.
		//List of arrays
		
		@Test
		public void example() {
			List<Integer[]> lst = new ArrayList<Integer[]>();
			lst.add(new Integer[] {1,2,3,4,5});
			lst.add(new Integer[] {11,21,31,14,5});
			lst.add(new Integer[] {12,22,23,24,5});
			lst.add(new Integer[] {31,32,33,34,5});
			method1(lst);
//			Output : 5
		}
		
		@Test
		public void example2() {
			List<Integer[]> lst = new ArrayList<Integer[]>();
			lst.add(new Integer[] {1,2,3,4,5});
			lst.add(new Integer[] {1,2,3,4,5});
			lst.add(new Integer[] {1,2,3,4,5});
			method1(lst);
//			Output : 5
		}
		
		@Test
		public void example3() {
			List<Integer[]> lst = new ArrayList<Integer[]>();
			lst.add(new Integer[] {1,2,3,4,5});
			lst.add(new Integer[] {7,8,9});
			lst.add(new Integer[] {10,11});
			method1(lst);
//			Output : 5
		}
		
		@Test
		public void example4() {
			List<Integer[]> lst = new ArrayList<Integer[]>();
			lst.add(new Integer[] {-1,2,3,4,5});
			lst.add(new Integer[] {7,8,1});
			lst.add(new Integer[] {10,-1});
			method1(lst);
//			Output : 5
		}
		
		public void method1(List<Integer[]> lst) {
			List<Integer> out = new ArrayList<Integer>();
			Integer[] inp1 = inter(lst.get(0), lst.get(1), out);
			
			for(int i = 2; i<lst.size(); i++) {
				inp1 = interWithMap(inp1, lst.get(i));
			}
			System.out.println(Arrays.toString(inp1));
		}
		
		public Integer[] inter(Integer[] arr1, Integer[] arr2, List<Integer> out) {
			Set<Integer> st = new HashSet<Integer>(Arrays.asList(arr1));
			for(int i = 0; i<arr2.length; i++) {
				if(!(st.add(arr2[i]))) {
					out.add(arr2[i]);
				}
			}
			
			Integer[] output = new Integer[out.size()];
			for(int i = 0; i<out.size(); i++) {
				output[i] = out.get(i);
			}
			return output;
			
		}
		
		public Integer[] interWithMap(Integer[] arr1, Integer[] arr2) {
			
			List<Integer> out = new ArrayList<Integer>();

			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int i = 0; i<arr1.length; i++) {
				map.put(arr1[i], 1);
			}
			for(int i = 0; i<arr2.length; i++) {
				if(map.containsKey(arr2[i])) {
					out.add(arr2[i]);
				}
			}
			Integer[] output = out.toArray(new Integer[out.size()]);
			return output;
			
		}

}

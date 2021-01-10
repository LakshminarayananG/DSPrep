package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ReturnDuplicate {

	@Test
	public void eg1() {
		int[] arr = { 2, 1, 3, 1, 3, 1, 4 };
		System.out.println("Method 1");
		returnDup(arr);
	}

	@Test
	public void eg2() {
		int[] arr = { 2, 1, 3, 1, 3, 1, 3, 4 };
		System.out.println("Method 2");
		returnDup1(arr);
	}


	private void returnDup2(int[] arr) {
		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1])
				System.out.println(arr[i]);
		}
	}

	private void returnDup1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : arr)
			if (map.containsKey(a))
				map.put(a, map.get(a) + 1);
			else
				map.put(a, 1);

		Stream<Integer> flatMap = map.entrySet().stream().filter(m -> m.getValue() > 1)
				.flatMap(m -> Stream.of(m.getKey()));
		flatMap.forEach(a -> System.out.println(a));
	}
	
	private void returnDup(int[] arr) {
		Set<Integer> set=new HashSet<Integer>();
		
		for (int i : arr) {
			if(!set.add(i))
				System.out.println(i);
		}
	}
}

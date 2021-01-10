package job;

import java.util.Arrays;
import java.util.List;

public class Problem2 {


	public static int maxTrailing(List<Integer> arr) {

		int maxDiff = 0, max = arr.get(arr.size() - 1);
		for (int i = arr.size() - 2; i >= 0; i--) {
			max = Math.max(max, arr.get(i));
			maxDiff = Math.max(maxDiff, max - arr.get(i));
		}
		return maxDiff == 0 ? -1 : maxDiff;
	}


	public static void main(String[] args) {
		Integer[] data = {5,3,2,2,1,1};
		List<Integer> lst = Arrays.asList(data);
		System.out.println( maxTrailing(lst));
	}


}

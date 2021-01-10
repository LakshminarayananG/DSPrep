package ds.assignments;

import java.util.Arrays;

import org.junit.Test;

public class SortColors {
	
	@Test
	public void example1() {
		int[] nums = {2,0,2,1,1,0};
		int[] sortColors = sortColors(nums);
		System.out.println(Arrays.toString(sortColors));
	}
	
	private int[] sortColors(int[] nums) {
		int low = 0, mid = 0;
		int high = nums.length-1;
		int tmp;
		
		while(mid <= high) {
			if(nums[mid] == 0) {
				tmp = nums[low];
				nums[low++] = nums[mid];
				nums[mid++] = tmp;
			} else if (nums[mid] == 2) {
				tmp = nums[mid];
				nums[mid] = nums[high];
				nums[high--] = tmp;
			} else {
				mid++;
			}
		}
		return nums;
	}

}

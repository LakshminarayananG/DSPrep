package week17.weekwork;

import org.junit.Test;

public class JumpGame {
	
	/*
	* Given an array of non-negative integers nums, you are initially positioned at
	* the first index of the array.
	*
	* Each element in the array represents your maximum jump length at that
	* position.
	*
	* Your goal is to reach the last index in the minimum number of jumps.
	*
	* You can assume that you can always reach the last index.
	*
	*
	*
	* Example 1:
	*
	* Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps
	* to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
	* the last index.
	*
	* Example 2: *
	* Input: nums = [2,3,0,1,4]
	* Output: 2
	*
	*
	* Constraints:
	*
	* 1 <= nums.length <= 3 * 104 0 <= nums[i] <= 105
	*/

	//@Test
	public void eg1() {
	int [] nums= {2,3,1,1,4};
	System.out.println(jumps(nums));
	}

	//@Test
	public void eg2() {
	int [] nums= {1,3,2,5,1,2,3,4,8};
	System.out.println(jumps(nums));
	}

	//@Test
	public void eg3() {
	int [] nums= {2,3,0,1,4};
	System.out.println(jumps(nums));
	}

	//@Test
	public void eg4() {
	int [] nums= {1,2,3};
	System.out.println(jumps(nums));
	}

	//@Test
	public void eg5() {
	int [] nums= {2,1};
	System.out.println(jumps(nums));
	}

	//@Test
	public void eg6() {
	int [] nums= {1,2,3,4,5};
	System.out.println(jumps(nums));
	}

	@Test
	public void eg7() {
	int [] nums= {4,1,1,3,1,1,1};
	System.out.println(jumps(nums));
	}

	@Test
	public void eg8() {
	int [] nums= {1, 3, 4, 6, 1, 2, 6, 1, 8};
	System.out.println(jumps(nums));
	}

	@Test
	public void eg9() {
	int [] nums= {3, 3, 4, 4, 6, 4, 8, 2, 6, 2, 4, 7, 4, 2, 4, 6, 2, 5, 4, 6, 4, 3, 3, 5};
	System.out.println(jumps(nums));
	}

	@Test
	public void eg10() {
	int [] nums= {3, 3, 4, 4, 6, 4, 8, 2, 6, 2, 4,
	1, 4, 2, 4, 6, 2, 5, 4, 6, 4, 3, 3, 5, 2, 6, 3, 5, 2, 4, 1, 5, 1,
	3, 1, 6, 1, 5, 1, 5, 2, 3, 4, 5, 1, 6, 9};
	System.out.println(jumps(nums));
	}



	private int jumps(int[] nums) {
	int count=0,left=0,right=0;

	for(int i=0;i<nums.length;i++) {
	right=Math.max(right, i+nums[i]);

	if(i==left) {
	left=right;
	count++;
	}

	if(left>=nums.length-1) break;

	}

	return count;
	}

}

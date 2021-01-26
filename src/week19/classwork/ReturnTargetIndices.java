package week19.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class ReturnTargetIndices {
	
	/*
	 * Given a sorted integer array, return the first and last occurring index of the target integer
	 * input={11,14,19,19,19,19,19,23,24}
	 * target=19
	 * output=[3,5]
	 * 
	 * input={11,14,17,18,19,20,23,24}
	 * target=19
	 * output=[4,4]
	 * 
	 * input={11,14,17,18,19,20,23,24}
	 * target=16
	 * output=[-1,-1]
	 */
	
	
	//Pseudo code
	//Brute force
	/*
	 * Add all elements to a list
	 * use contains method to find element is present in the array, if not found return -1 for both indices
	 * use methods indexOf and lastIndexOf and return the indices of first and last occurring indices of the target
	 * Space: O[N]
	 * Time: O[N]
	 */

	//Linear search
	/*
	 * iterate through each element in the array
	 * if target found, get the starting index
	 * iterate till element ending index
	 * finally return both starting and ending index of the target in input
	 * if element not found return -1 for both indices
	 * Space: O[1]
	 * Time: O[N]
	 */

	//Two pointer
	/*
	 * start left pointer from 0 and right from end of array
	 * parallely iterate array from both sides
	 * if left pointer finds target, start right from left
	 * if right finds target, start left from right 
	 * iterate till both start and end index is found
	 * 
	 * Space: O[1]
	 * Time: O[N]
	 */

	//Binary search
	/*
	 * initialize 2 variables left and right where left is 0 and right is end of array
	 * find the mid point
	 * if the mid element is target expand from mid to find the starting and ending index of target and return the indices
	 * if mid value is greater than target move right to mid-1
	 * else move left to mid+1
	 * iterate till left is less than target
	 * if no target found return -1 for both start and end indices
	 * 
	 * Space: O[1]
	 * Time: O[N]
	 */

	//Binary Search - optimized
	/*
	 * initialize 2 variables left and right
	 * find 
	 */
	
	
	
	@Test // +ve
	public void example1() {
		System.out.println("Test 1");
		int[] nums = { 11, 14, 17, 19, 19, 19, 23, 24 };
		int target = 19;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	@Test // edge
	public void example2() {
		System.out.println("Test 2");
		int[] nums = { 11, 14, 17, 19, 19, 19, 23, 24 };
		int target = 23;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	@Test // -ve
	public void example3() {
		System.out.println("Test 3");
		int[] nums = { 11, 14, 17, 19, 19, 19, 23, 24 };
		int target = 16;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	@Test
	public void example4() {
		System.out.println("Test 4");
		int[] nums = { 9, 9, 9, 9, 9 };
		int target = 9;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	private String bruteForce(int[] nums, int target) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		if (!list.contains(target))
			return Arrays.toString(new int[] { -1, -1 });

		return Arrays.toString(new int[] { list.indexOf(target), list.lastIndexOf(target) });
	}

	private String linearApproach(int[] nums, int target) {
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			end = i;
			if (nums[i] == target) {
				while (end < nums.length && nums[end] == target)
					end++;
				return Arrays.toString(new int[] { i, end - 1 });
			}
		}

		return Arrays.toString(new int[] { -1, -1 });
	}

	private String twoPointer(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {

			if (nums[left] == target && nums[right] == target)
				return Arrays.toString(new int[] { left, right });

			if (nums[left] != target)
				left++;
			else if (nums[right] != target)
				right--;
		}

		return Arrays.toString(new int[] { -1, -1 });

	}

	private String binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				left = mid;
				right = mid;
				while ((left >= 0 && nums[left] == target) || (right < nums.length && nums[right] == target)) {
					if (nums[left] == target)
						left--;
					if (nums[right] == target)
						right++;
				}
				return Arrays.toString(new int[] { left + 1, right - 1 });
			}

			if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return Arrays.toString(new int[] { -1, -1 });
	}

	private String optimizedSolution(int[] nums, int target) {
		int left = search(nums, target);
		if (left == nums.length || nums[left] != target)
			return Arrays.toString(new int[] { -1, -1 });

		return Arrays.toString(new int[] { left, search(nums, target + 1) - 1 });
	}

	private int search(int[] nums, int target) {
		int left = 0, right = nums.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}
	
	
	
	/*
     * Given an Array, find the first & last match of the element
     * 
     * Example 1:
     * Input: [11,14,17,19,19,19,23,25]
     * target: 19
     * Output: [3,5]
     * 
     * Example 2:
     * Input: [11,14,17,19,19,19,23,25]
     * Target 23
     * Output: [6,6]
     * 
     */
	
	@Test
	public void data1() {
		int[] input= {1,3,4,9,12,12,12,12,45,67};
		int target=12;
//		System.out.println(Arrays.toString(getFirstLastIndexBF(input,target)));
//		System.out.println(Arrays.toString(getFirstLastIndexUsingList(input,target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(input,target)));
		
		
		
	}
	
//	@Test
	public void data2() {
		int[] input= {11,14,17,19,19,19,23,25};
		int target=23;
//		System.out.println(Arrays.toString(getFirstLastIndexBF(input,target)));
//		System.out.println(Arrays.toString(getFirstLastIndexUsingList(input,target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(input,target)));
	}
	
//	@Test
	public void data3() {
		int[] input= {11,14,17,19,19,19,23,25};
		int target=18;
//		System.out.println(Arrays.toString(getFirstLastIndexBF(input,target)));
//		System.out.println(Arrays.toString(getFirstLastIndexUsingList(input,target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(input,target)));
	}
	
	@Test
	public void data4() {
		int[] input= {18,18,18,18,18,18};
		int target=18;
//		System.out.println(Arrays.toString(getFirstLastIndexBF(input,target)));
//		System.out.println(Arrays.toString(getFirstLastIndexUsingList(input,target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(input,target)));
	}
	
	/* Pseudo Code - Brute Force - Two for loops
	 * 
	 * declare int[] out= {-1,-1};
	 * Incremental For loop iterate from 0
	 * 		If value matches target -> assign out[0] = i, Then break
	 * Decremental For loop iterate from array length
	 * 		If value matches target -> assign out[1] = i, Then break
	 * return out;
		
	* Time - O(N) + O(N) - O(N)
	 * Space - O(1)
	 * 
	 
	 */
	
	public int[] getFirstLastIndexBF(int[] input,int target) {
		int[] out= {-1,-1};
		for (int i = 0; i < input.length; i++) {
			if(input[i] == target) {
				out[0]=i;
				break;
			}
			
		}
		for (int i = input.length-1; i >=0; i--) {
			if(input[i] == target) {
				out[1]=i;
				break;
			}
			
		}
		return out;
	}
	
	
	/*Pseudo code - Two POinter
	 * 
	 * Declare variables: Left=0, Right=input.length-1, int[] out= {-1,-1};
	 * 
	 * While (left <input.length && right >0)
	 * if value of left, equals to target
	 * 		Yes -> out[0]=left
			No -> left++
		If value of right, equal to target
			Yes -> out[1]=left
			No -> right--
			
	* Time - O(N)
	 * Space - O(1)
	*/
	
	private void getFirstLastIndex(int[] input,int target) {
		int left=0;
		int right=input.length-1;
		int[] out= {-1,-1};
		
//		while(left)
		
	}
	
	/* Pseudo Code - Using List
	 * 
	 * Converting the integer array to List
	 * To get the first occurance -> indexOf function
	 * To get the last occurance -> lastIndexOf function
	 */
	
	public int[] getFirstLastIndexUsingList(int[] input,int target) {
		
		List<Integer> output=new ArrayList<>();
		
		for (Integer eachInt : input) {
			output.add(eachInt);
		}
		
		return new int[] {output.indexOf(target) , output.lastIndexOf(target)};
	}
	
	/* Pseudo Code - Binary search
	 * 
	 * 
	 * Int left=0;int right=lengh-1;mid=left+right/2
	 * If value of mid > target
	 * 		right=mid-1;
	 * else if mid <target
	 * 		left=mid+1;
	 * 
	 * 
	 * 
	 */
	
	public int[] getFirstLastIndexUsingBinary(int[] input,int target) {
		
		int left=getLastOrFirstIndex(input,target,true);
		int right=getLastOrFirstIndex(input,target,false);
		return new int[] {left,right};
	}
	
	private int getLastOrFirstIndex(int[] input, int target,boolean flag) {
		
		int left=0;int right=input.length-1;
		int temp=-1;
		
		
		while(left <= right) {
			int mid=(left+right)/2;
			if(input[mid] == target) {
				temp=mid;
				if(flag ==true)
					right=mid-1;
				else {
					left=mid+1;
				}
			}else if(input[mid] > target) {
				right=mid-1;
			}else left=mid+1;
			
		}
		return temp;
		//11,14,17,19,19,19,23,25
	}

	
	
	/* Pseudo Code - Using HashMap
	 * 
	 * 
	 */
	
	/* Pseudo Code - Using Set
	 * 
	 * Intialize the set
	 * declare out[] ={-1,-1}
	 * 
	 * Using for loop add the array element into the set
	 * 		if (array[i] == target && set.add)
	 * 			Assign the i value to both the out indexes
	 * 		else if(array[i] ==target && !set.add)
	 * 			Assign the i value to second index of out
	 * 
	 */
	
	public int[] getFirstLastIndexSet(int[] input,int target) {
		int[] out= {-1,-1};
		Set<Integer> set=new HashSet<>();
		
		for (int i = 0; i < input.length; i++) {
//			if(input[])
			
		}
		
		return out;
	}

}

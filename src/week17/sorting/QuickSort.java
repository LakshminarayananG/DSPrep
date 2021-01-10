package week17.sorting;

import java.util.Arrays;
import org.junit.Test;

public class QuickSort {
	
	//@Test
		public void test1(){
			int[] nums = {11,8,1,3,12,9,22,0,2};
			System.out.println(Arrays.toString(quickSort(nums)));
		}
		
		@Test
		public void test2(){
			int[] nums = {2,2,3,1,4};
			System.out.println(Arrays.toString(quickSort(nums)));
		}
		
		//@Test
		public void test3(){
			int[] nums = {-11,-8,-1,-3,-12,-9,-22,0,-2};
			System.out.println(Arrays.toString(quickSort(nums)));
		}
		
		
		
		public int[] quickSort(int[] nums){
			quickSort(nums, 0, nums.length-1);
			return nums;
		}

		
		public void quickSort(int[] nums, int left, int right){
			
			if(left>=right) return;
			int mid = partition(nums, left, right);
			
				quickSort(nums,left, mid);
				quickSort(nums,mid+1, right);
		}
		
		
		public int partition(int[] nums, int left, int right){
			int pivot = nums[left];
			while(left<right){
				while(left<right && nums[right]>=pivot){
					right--;
				}
				nums[left]=nums[right];
				while(left<right && nums[left]<=pivot){
					left++;
				}
				
				nums[right]=nums[left];
			}
			nums[left]=pivot;			
			return right;
		}

}

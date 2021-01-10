package week15.weekwork;

import java.util.Arrays;

import org.junit.Test;

public class MedianOfSortedArray {

	@Test
	public void example1() {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example2() {
		int[] nums1 = { 4, 20, 32, 50, 55, 61 };
		int[] nums2 = { 1, 15, 22, 30, 70 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example3() {
		int[] nums1 = { 16, 20, 23, 50, 54, 60 };
		int[] nums2 = { 65, 72, 72, 85, 93 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example4() {
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example5() {
		int[] nums1 = {};
		int[] nums2 = { 1 };
		findMedian(nums1, nums2);
	}

	private void findMedian(int[] nums1, int[] nums2) {
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;

		int[] merged = new int[nums1Len + nums2Len];

		int mergLen = merged.length;
		int ind = 0, p1 = 0, p2 = 0;

		while (ind < mergLen && p1 < nums1Len && p2 < nums2Len) {
			if (nums1[p1] < nums2[p2])
				merged[ind++] = nums1[p1++];
			else
				merged[ind++] = nums2[p2++];
		}

		if (p1 < nums1Len)
			for (int i = p1; i < nums1Len; i++)
				merged[ind++] = nums1[i];
		else
			for (int i = p2; i < nums2Len; i++)
				merged[ind++] = nums2[i];

		if (mergLen % 2 != 0)
			System.out.println(merged[mergLen / 2]);
		else
			System.out.println((double) (merged[mergLen / 2] + merged[(mergLen / 2) - 1]) / 2);

		System.out.println(Arrays.toString(merged));
	}
}

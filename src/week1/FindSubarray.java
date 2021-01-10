package week1;

import org.junit.Test;

public class FindSubarray {

	@Test
	public void eg1() throws Exception {
		int[] arr = { 1, 7, 4, 3, 1, 2, 1, 5, 1 };
		int k = 7;
		findSubarray(arr, k);
	}

	//@Test
	public void eg2() throws Exception {
		System.out.println("Method 2");
		int[] arr = { 1, 7, 4, 3, 1, 2, 1, 5, 1 };
		int k = 26;
		findSubarray(arr, k);
	}
	
	@Test
	public void eg3() throws Exception {
		int[] arr = { 1, 7, 4, 3, 1, 2, 1, 5, 1 };
		int k = 7;
		findSubarraySliding(arr, k);
	}

	private void findSubarray(int arr[], int k) throws Exception {
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			String seq = "";
			int sum = 0;
			if (arr[i] <= k) {
				if (arr[i] == k) {
					flag = true;
					System.out.println(arr[i]);
				} else {
					for (int j = i; j < arr.length; j++) {
						sum += arr[j];
						seq += arr[j] + " ";
						if (sum == k) {
							flag = true;
							i = j - 1;
							System.out.println(seq);
							break;
						} else if (sum > k) {
							seq = "";
							break;
						} else {
							continue;
						}
					}
				}
			}
		}

		if (!flag)
			throw new Exception("No subarray found");
	}

	private void findSubarraySliding(int[] arr, int k) {
		int op=0;
		for (int i = 0; i < arr.length; i++) {
			op+=arr[i];
			if(op==k) {
				System.out.println("Match");
			}
			else if(op<k || op>k)
				continue;
		}
	}
}

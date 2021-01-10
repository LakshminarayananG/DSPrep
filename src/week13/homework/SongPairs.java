package week13.homework;

import org.junit.Test;

public class SongPairs {
	
	/*
	You are given a list of songs where the ith song has a duration of time[i] seconds.
	Return the number of pairs of songs for which their total duration in seconds is divisible by 60. 
	Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
	Example 1:
	Input: time = [30,20,150,100,40]
	Output: 3
	Explanation: Three pairs have a total duration divisible by 60:
	(time[0] = 30, time[2] = 150): total duration 180
	(time[1] = 20, time[3] = 100): total duration 120
	(time[1] = 20, time[4] = 40): total duration 60
	Example 2:
	Input: time = [60,60,60]
	Output: 3
	Explanation: All three pairs have a total duration of 120, which is divisible by 60.
	*/
	
	int cnt = 0;

	@Test
	public void example1() {
		int[] arr = { 30, 20, 150, 100, 40 };
		System.out.println(songPairs(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 60, 60, 60 };
		System.out.println(songPairs(arr));
	}

	private int songPairs(int[] arr) {
		findCombo(arr, 2, 0, 0);
		return cnt;
	}

	private void findCombo(int[] arr, int k, int sum, int start) {
		if (k == 0 && sum % 60 == 0) {
			cnt++;
			return;
		}

		if (k == 0 && sum % 60 != 0)
			return;

		for (int i = start; i < arr.length; i++)
			findCombo(arr, k - 1, sum + arr[i], i + 1);
	}

	private int songPairs1(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if ((sum + arr[j]) % 60 == 0)
					cnt++;
			}
		}
		return cnt;
	}

}

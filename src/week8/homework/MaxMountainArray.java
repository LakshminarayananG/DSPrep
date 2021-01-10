package week8.homework;

public class MaxMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr= {0,1,2,3,4,5,4,3,2,1,0};
		 //int[] arr= {2,1,4,7,3,2,5};
		// int[] arr= {0,1,2,3,4,5,6,7,8,9};
		// int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		//int[] arr = { 0, 2, 0, 2, 1, 2, 3, 4, 4, 1 };

		boolean inc = true;
		int ind = 0, size = 1, max = 0;

		while (ind < arr.length - 1) {
			if (arr[ind] < arr[ind + 1] && inc)
				size++;
			else if (arr[ind] > arr[ind + 1] && size > 1) {
				inc = false;
				size++;
			} else if (arr[ind] < arr[ind + 1] && !inc) {
				max = Math.max(size < 3 ? 0 : size, max);
				inc = true;
				size = 1;
				ind--;
			} else {
				size=1;
			}

			if (!inc)
				max = Math.max(size, max);

			ind++;
		}

		System.out.println(max);
	}
}

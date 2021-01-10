package recursion;

import org.junit.Test;

/*
n=5

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
*/

public class PascalTriangle {

	@Test
	public void example1() {
		int n = 5;
		generatePascalTriangle(n);
	}

	private void generatePascalTriangle(int row) {

		for (int k = 1; k <= row; k++) {
			for (int i = 1; i <= k; i++)
				System.out.print(helperFunc(k, i) + " ");
			System.out.println();
		}
	}

	private int helperFunc(int row, int col) {
		if (col == 1 || row == col)
			return 1;

		return helperFunc(row - 1, col) + helperFunc(row - 1, col - 1);
	}
}

package week15.classwork;

import org.junit.Test;

public class IslandProblem {
	
	/*
	 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number
	 * of islands.
	 * 
	 * An island is surrounded by water and is formed by connecting adjacent lands
	 * horizontally or vertically. You may assume all four edges of the grid are all
	 * surrounded by water.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"],
	 * ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1 
	 * 
	 * Example 2: * 
	 * Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"],
	 * ["0","0","1","0","0"], ["0","0","0","1","1"] ] Output: 3
	 * 
	 * 
	 * Constraints:
	 * 
	 * m == grid.length n == grid[i].length 1 <= m, n <= 300 grid[i][j] is '0' or
	 * '1'.
	 */
	
	
	@Test
	public void example1() {
		int[][] grid = new int[4][5];
		grid[0][0] = 1;
		grid[0][1] = 1;
		grid[0][2] = 1;
		grid[0][3] = 1;
		grid[0][4] = 0;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[1][3] = 1;
		grid[1][4] = 0;
		grid[2][0] = 1;
		grid[2][1] = 1;
		grid[2][2] = 0;
		grid[2][3] = 0;
		grid[2][4] = 0;
		grid[3][0] = 0;
		grid[3][1] = 0;
		grid[3][2] = 0;
		grid[3][3] = 0;
		grid[3][4] = 0;

		int islandCount = findIslandCount(grid);
		System.out.println(islandCount);
	}

	@Test
	public void example2() {
		int[][] grid = new int[4][5];
		grid[0][0] = 1;
		grid[0][1] = 1;
		grid[0][2] = 0;
		grid[0][3] = 0;
		grid[0][4] = 0;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[1][3] = 0;
		grid[1][4] = 0;
		grid[2][0] = 0;
		grid[2][1] = 0;
		grid[2][2] = 1;
		grid[2][3] = 0;
		grid[2][4] = 0;
		grid[3][0] = 0;
		grid[3][1] = 0;
		grid[3][2] = 0;
		grid[3][3] = 1;
		grid[3][4] = 1;

		int islandCount = findIslandCount(grid);
		System.out.println(islandCount);
	}

	private int findIslandCount(int[][] grid) {

		int islandCount = 0;

		for (int horizontal = 0; horizontal < grid.length; horizontal++) {
			for (int vertical = 0; vertical < grid[horizontal].length; vertical++) {
				if (grid[horizontal][vertical] == 1)
					islandCount += islandRecursion(grid, horizontal, vertical);
			}
		}

		return islandCount;
	}

	private int islandRecursion(int[][] grid, int horizontal, int vertical) {
		if (horizontal < 0 || horizontal >= grid.length || vertical < 0 || vertical >= grid[horizontal].length
				|| grid[horizontal][vertical] == 0)
			return 0;

		grid[horizontal][vertical] = 0;

		islandRecursion(grid, horizontal - 1, vertical);
		islandRecursion(grid, horizontal + 1, vertical);
		islandRecursion(grid, horizontal, vertical - 1);
		islandRecursion(grid, horizontal, vertical + 1);

		return 1;
	}

}

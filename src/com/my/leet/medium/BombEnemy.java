package com.my.leet.medium;

public class BombEnemy {

	// https://medium.com/@rebeccahezhang/361-bomb-enemy-1b4b36d5a47a
	// https://massivealgorithms.blogspot.com/2016/06/leetcode-361-bomb-enemy.html
	//

	/*
	 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
	 * (the number zero), return the maximum enemies you can kill using one bomb.
	 * The bomb kills all the enemies in the same row and column from the planted
	 * point until it hits the wall since the wall is too strong to be destroyed.
	 * Note that you can only put the bomb at an empty cell. Example: For the given
	 * grid
	 * 
	 * 0 E 0 0
	 * 
	 * E 0 W E
	 * 
	 * 0 E 0 0
	 * 
	 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
	 */
	
	//TODO understand the logic well.

	public int maxKilledEnemies(char[][] grid) {
		// iterate through the matrx by i(row), j(column)
		// if it's '0', update the max so far by compare the current max and
		// (enemies number in current row + enemies number in current column)
		// Becareful the grid.length == 0 should be the first thing to check
		// in case of array out of bound exception happens on grid[0].length
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		int rowCount = 0;
		int[] colCount = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// start from first row, count the enemies in the current row between two walls
				// store it to avoid recompute
				if (j == 0 || grid[i][j - 1] == 'W') {
					rowCount = 0;
					for (int k = j; k < n && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E')
							rowCount++;
					}
				}
				// start from column, count the enemies in the current col between two walls
				if (i == 0 || grid[i - 1][j] == 'W') {
					colCount[j] = 0;
					for (int k = i; k < m && grid[k][j] != 'W'; k++) {
						if (grid[k][j] == 'E')
							colCount[j]++;
					}
				}
				// if this is a position to place the bomb, get the current max
				if (grid[i][j] == '0') {
					max = Math.max(max, rowCount + colCount[j]);
				}
			}
		}
		return max;
	}
}

package com.my.leet.medium.dp;

public class MinPathSumInMatrix {

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		int[][] minPath = new int[m][n];

		minPath[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			minPath[i][0] = minPath[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < n; i++) {
			minPath[0][i] = minPath[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
			}
		}
		return minPath[m - 1][n - 1];
	}

}

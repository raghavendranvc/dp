package com.my.leet.medium;

public class UniquePathsWithObstacles {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}

		int[][] ways = new int[m][n];

		ways[m - 1][n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (obstacleGrid[m - 1][i] == 1) {
				ways[m - 1][i] = 0;
			} else {
				ways[m - 1][i] = ways[m - 1][i + 1];
			}
		}

		for (int i = m - 2; i >= 0; i--) {
			if (obstacleGrid[i][n - 1] == 1) {
				ways[i][n - 1] = 0;
			} else {
				ways[i][n - 1] = ways[i + 1][n - 1];
			}
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1) {
					ways[i][j] = 0;
				} else {
					ways[i][j] = ways[i + 1][j] + ways[i][j + 1];
				}

			}
		}

		return ways[0][0];
	}

}

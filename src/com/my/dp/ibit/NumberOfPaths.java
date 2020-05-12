package com.my.dp.ibit;

public class NumberOfPaths {

	public int uniquePathsWithObstacles(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}

		int m = A.length;
		int n = A[0].length;

		if (A[0][0] == 1 || A[m - 1][n - 1] == 1) {
			return 0;
		}

		int[][] path = new int[m][n];

		/*
		 * x x+1 ....... n y+1
		 * 
		 * m---------------t
		 */
		path[m - 1][n - 1] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				if (i == m - 1 && j == n - 1) {
					path[i][j] = 1;
					continue;
				}

				if (i + 1 < m && A[i + 1][j] != 1) {
					path[i][j] += path[i + 1][j];
				}

				if (j + 1 < n && A[i][j + 1] != 1) {
					path[i][j] += path[i][j + 1];
				}
			}
		}
		return path[0][0];
	}

}

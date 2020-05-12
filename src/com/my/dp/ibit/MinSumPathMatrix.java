package com.my.dp.ibit;

public class MinSumPathMatrix {
	public int minPathSum(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}

		int m = A.length;
		int n = A[0].length;

		int[][] minSum = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					minSum[i][j] = A[m - 1][n - 1];
					continue;
				}

				int minimum = Integer.MAX_VALUE;

				if (i + 1 < m) {
					minimum = Math.min(minimum, minSum[i + 1][j]);
				}

				if (j + 1 < n) {
					minimum = Math.min(minimum, minSum[i][j + 1]);
				}

				minSum[i][j] = A[i][j] + minimum;

			}
		}
		return minSum[0][0];

	}

}

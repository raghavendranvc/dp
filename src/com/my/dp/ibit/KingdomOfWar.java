package com.my.dp.ibit;

public class KingdomOfWar {
	
	// Greedy approach
	// Check the question first
	// Position where resistence can be large
	// simply find the max strength place(i,j)
	// start from right-bottom most point
	
	public int solve(int[][] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int m = A.length;
		int n = A[0].length;

		int maxStrength = Integer.MIN_VALUE;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int currentStrength = A[i][j];
				// We check only forward.
				// i+1,j; i,j+1; i+1,j+1
				if (i + 1 < m) {
					currentStrength += A[i + 1][j];
				}
				if (j + 1 < n) {
					currentStrength += A[i][j + 1];
				}

				// We are removing i+1,j+1 because we have already
				// accounted for it either in i+1,j or i,j+1
				if (i + 1 < m && j + 1 < n) {
					currentStrength -= A[i + 1][j + 1];
				}
				// We use the same table for dp
				A[i][j] = currentStrength;
				maxStrength = Math.max(maxStrength, currentStrength);

			}
		}
		return maxStrength;
	}
}

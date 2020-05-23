package com.my.dp.ibit;

public class DunjeonPrincess {
	
	//A contains health that consumes at that place. 
	// -ve value indicate that health is consumed at that place
	// +ve value indicate that health is add to health

	public int calculateMinimumHP(int[][] A) {

		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}

		int m = A.length;
		int n = A[0].length;
		int[][] minHealth = new int[m][n];
		//We added 1 extra because minimum 1 is needed
		// if a[m-1][n-1]=-5, then we need 6
		// if a[m-1][n-1]=-50, then we need 51
		// if a[m-1][n-1]=0, then we need 1
		// if a[m-1][n-1]=30, then we need 1
		minHealth[m - 1][n - 1] = Math.max(-A[m - 1][n - 1] + 1, 1);

		// We calculate minHeath in the last column
		// We already calculated for m-2 to let's do between m-2 to 0
		for (int i = m - 2; i >= 0; i--) {
			// The power gets added.
			// If the power is very large, its no use. Overall we need only 1
			// If i,n-1 needs health(-ve value),
			// then it will addup to minHealth[i+1][n-1]
			minHealth[i][n - 1] = Math.max(minHealth[i + 1][n - 1] - A[i][n - 1], 1);
		}

		for (int i = n - 2; i >= 0; i--) {
			minHealth[m - 1][i] = Math.max(minHealth[m - 1][i + 1] - A[m - 1][i], 1);
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				minHealth[i][j] = Math.min(minHealth[i + 1][j], minHealth[i][j + 1]) - A[i][j];
				// If minHealthNeeded <=0, then it means we have extra power.
				// We only need 1 extra power
				minHealth[i][j] = Math.max(minHealth[i][j], 1);
			}
		}

		return minHealth[0][0];
	}

}

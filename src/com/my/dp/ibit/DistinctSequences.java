package com.my.dp.ibit;

public class DistinctSequences {

	public int numDistinct(String A, String B) {
		
		/*
		 * At each position of B, 
		 * 	if there is no match, we ignore it (sol[i][j] = sol[i][j-1])
		 * 	if there is a match, we use it or we ignore it
		 * 				sol[i][j] = sol[i][j-1] + sol[i-1][j-1]
		 */
		
		int n = A.length();
		int m = B.length();

		if (m > n) {
			return 0;
		}

		int[][] sol = new int[m + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			sol[0][i] = 1; // deleting char in A makes empty. So only 1 way
		}

		for (int j = 1; j <= n; j++) { //A
			for (int i = 1; i <= m; i++) {//B
			
				if (B.charAt(i - 1) != A.charAt(j - 1)) {
					// char is not matching. We fallback to previous value,
					// ignoring the A[j]
					sol[i][j] = sol[i][j - 1];
				} else {
					// here we can use it or we can ignore it
					sol[i][j] = sol[i][j - 1] + sol[i - 1][j - 1];
				}

			}
		}
		return sol[m][n];
	}

}

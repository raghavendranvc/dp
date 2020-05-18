package com.my.dp.ibit;

import java.util.Arrays;

public class LongestRepeatingSubString {

	public int lrs(String s) {
		int n = s.length();
		int[][] sol = new int[n + 1][n + 1];

		Arrays.fill(sol, 0);

		// ABCDABCDAB
		// TODO
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
					sol[i][j] = sol[i - 1][j - 1] + 1;
				} else {
					// move either way backwards
					sol[i][j] = Math.max(sol[i - 1][j], sol[i][j - 1]);
				}
			}
		}
		return sol[n][n];
	}

}

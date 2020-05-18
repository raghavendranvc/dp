package com.my.dp.ibit;

import java.util.Arrays;

public class CountDistinctSubsequences {
	
	
	//TODO, practice again
	public int disSubSequence(String s) {

		int n = s.length();
		int[] sol = new int[n + 1];

		if (n == 0) {
			return 0;
		}

		sol[0] = 1; //Empty string is also one of the subsequence
		int[] last = new int[256];
		Arrays.fill(last, -1);

		for (int i = 1; i <= n; i++) {
			sol[i] = 2 * sol[i - 1];

			int lastOccuranceIndex = last[s.charAt(i-1)];

			if (lastOccuranceIndex == -1) {
				sol[i] = sol[i] - sol[lastOccuranceIndex];
			}
			last[s.charAt(i-1)] = i-1;

		}

		return sol[n];
	}

}

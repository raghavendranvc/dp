package com.my.leet.hard.notdone;

public class DistinctSubsequences {

	// THis is DP
	// https://leetcode.com/problems/distinct-subsequences/
	// https://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/

	/*
	 * Given a string S and a string T, count the number of distinct subsequences of
	 * S which equals T.
	 * 
	 * A subsequence of a string is a new string which is formed from the original
	 * string by deleting some (can be none) of the characters without disturbing
	 * the relative positions of the remaining characters. (ie, "ACE" is a
	 * subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * It's guaranteed the answer fits on a 32-bit signed integer.
	 */

	public int numDistincts(String S, String T) {
		int[][] table = new int[S.length() + 1][T.length() + 1];

		for (int i = 0; i < S.length(); i++)
			table[i][0] = 1;

		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					// When matched,
					// we either use it or ignore it
					// Use it means we add (i-1,j-1)
					// If we don't use it (i-1,j) so that we have covered T of length 'j'
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					// We just ignore the character is 's'
					table[i][j] += table[i - 1][j];
				}
			}
		}

		return table[S.length()][T.length()];
	}

}

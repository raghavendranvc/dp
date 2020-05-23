package com.my.dp;

import com.my.common.UtilityClass;

public class LongestCommonSubStringLength {
	
	/********************One way********************************************/

	public int lcSubString(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int[][] table = new int[m + 1][n + 1];

		int maxVal = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				/*
				 * Initial condition when one of the substrings is empty. No common substring.
				 */
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					/*
					 * Now compare the first index. If they are equal then value will be 1
					 */
					table[i][j] = 1 + table[i - 1][j - 1];
					maxVal = Math.max(maxVal, table[i][j]);
				} else {
					/*
					 * If the chars are not same then there will be no substring by including those
					 * 2 chars
					 */
					table[i][j] = 0;
				}
			}
		}

		UtilityClass.printArray(table);

		return maxVal;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "OldSite:GeeksforGeeks.org";
		String str2 = "NewSite:GeeksQuiz.com";

		LongestCommonSubStringLength lcss = new LongestCommonSubStringLength();
		int val1 = lcss.lcSubString(str1.toLowerCase(), str2.toLowerCase());
		System.out.println("val1=" + val1);

	}

	public int lcSubStringPractice(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int sol[][] = new int[m + 1][n + 1];

		
		/*
		 * DP (i,j) represents the max length of common substring str1(0,i) and str2(0,j)
		 *
		 */
		
		int maxLength = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// For empty string , the lcs is 0
				if (i == 0 || j == 0) { // first col is all 0,  first row all 0
					sol[i][j] = 0;
				} else if (str1.charAt(i - 1) == str1.charAt(j - 1)) {
					sol[i][j] = sol[i - 1][j - 1] + 1;
					maxLength = Math.max(maxLength, sol[i][j]);
				} else {
					sol[i][j] = 0;
				}
			}
		}
		
		return maxLength;

	}

}

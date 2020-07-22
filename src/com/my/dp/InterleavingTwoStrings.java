package com.my.dp;

public class InterleavingTwoStrings {
	
	/********************One way********************************************/

	public boolean isInterleaved(String a, String b, String c) {
		if (a.length() + b.length() != c.length()) {
			return false;
		}
		return isInterleaved(a, 0, b, 0, c, 0);
	}

	public boolean isInterleaved(String a, int i, String b, int j, String c, int k) {
		if (k == c.length()) {
			if (i == a.length() && j == b.length()) {
				return true;
			} else {
				return false;
			}
		}
		if (i == a.length() && j == b.length()) {
			if (k < c.length()) {
				return false;
			}
		}

		boolean aVal = false;
		if (i < a.length() && a.charAt(i) == c.charAt(k)) {
			aVal = isInterleaved(a, i + 1, b, j, c, k + 1);
		}

		boolean bVal = false;
		if (j < b.length() && b.charAt(j) == c.charAt(k)) {
			bVal = isInterleaved(a, i, b, j + 1, c, k + 1);
		}

		return (aVal || bVal);

	}

	/********************One way********************************************/
	
	public boolean isInterleavedIter(String a, String b, String c) {
		int m = a.length();
		int n = b.length();
		int p = c.length();

		if (m + n != p) {
			return false;
		}

		if (m == 0 && n == 0 && p == 0) {
			return true;
		}

		if (m == 0) {
			return (n == p && b.equals(c));
		}

		if (n == 0) {
			return (m == p && a.equals(c));
		}

		boolean[][] table = new boolean[m + 1][n + 1];

		/*
		 * Empty strings
		 */

		table[0][0] = true;

		/*
		 * Base condition. When String A is empty. Then String B should match String C.
		 * First Row (row=0) The value will be true till the characters of strings (b,c)
		 * matches. Thereafter it will be false.
		 */
		for (int j = 1; j <= n; j++) {
			if (b.charAt(j - 1) == c.charAt(j - 1)) {
				table[0][j] = table[0][j - 1]; // TODO, missed this base condition
			}
		}

		/*
		 * Base condition. When String B is empty. Then String A should match String C.
		 * First Column (column=0)
		 * 
		 */

		for (int i = 1; i <= m; i++) {
			if (a.charAt(i - 1) == c.charAt(i - 1)) {
				table[i][0] = table[i - 1][0];
			}
		}

		/*
		 * For the rest of the string
		 */

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				
				boolean aMatches = (a.charAt(i - 1) == c.charAt(i + j - 1));
				boolean bMatches = (b.charAt(j - 1) == c.charAt(i + j - 1));

				if (aMatches || bMatches) {
					table[i][j] = table[i - 1][j] || table[i][j - 1];
				}
			}
		}

		return table[m][n];

	}

	/********************One way********************************************/
	
	public boolean isInterleavedPractice(String a, String b, String c) {

		int m = a.length();
		int n = b.length();

		if (m + n != c.length()) {
			return false;
		}

		if (m == 0 && n == 0) {
			return true; // m+n which is will also be 0
		}

		/*
		 * if(m == 0){ return b.equals(c); }
		 * 
		 * if(n == 0){ return a.equals(c); }
		 */

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true; // For empty strings

		// if a is empty then b=c
		if (m == 0) {
			for (int i = 1; i <= n; i++) {
				if (b.charAt(i) != c.charAt(i)) {
					return false;
				} else {
					dp[0][i] = dp[0][i - 1]; // true
				}
			}
		}

		// if b is empty then a=c
		if (n == 0) {
			for (int i = 1; i <= m; i++) {
				if (a.charAt(i) != c.charAt(i)) {
					return false;
				} else {
					dp[i][0] = dp[i - 1][0];// true
				}
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				boolean aEquals = a.charAt(i - 1) == c.charAt(i + j - 1);
				boolean bEquals = b.charAt(j - 1) == c.charAt(i + j - 1);
				if (aEquals || bEquals) {
					dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
				}
			}
		}

		return dp[m][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InterleavingTwoStrings its = new InterleavingTwoStrings();

		System.out.println("val1=" + its.isInterleaved("XXY", "XXZ", "XXZXXXY"));
		System.out.println("val2=" + its.isInterleaved("XY", "WZ", "WZXY"));
		System.out.println("val3=" + its.isInterleaved("XY", "X", "XXY"));
		System.out.println("val4=" + its.isInterleaved("YX", "X", "XXY"));
		System.out.println("val5=" + its.isInterleaved("XXY", "XXZ", "XXXXZY"));

		System.out.println("val1=" + its.isInterleavedIter("XXY", "XXZ", "XXZXXXY"));
		System.out.println("val2=" + its.isInterleavedIter("XY", "WZ", "WZXY"));
		System.out.println("val3=" + its.isInterleavedIter("XY", "X", "XXY"));
		System.out.println("val4=" + its.isInterleavedIter("YX", "X", "XXY"));
		System.out.println("val5=" + its.isInterleavedIter("XXY", "XXZ", "XXXXZY"));

	}

}

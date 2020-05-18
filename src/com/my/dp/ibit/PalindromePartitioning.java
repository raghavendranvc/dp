package com.my.dp.ibit;

import com.my.common.UtilityClass;

public class PalindromePartitioning {

	public int minCutsForPalindromePartitioning(String str, int i, int j) {

		if (i == j) {
			return 0;
		}

		if (isPalindromeIter(str, i, j)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			min = Math.min(min,
					minCutsForPalindromePartitioning(str, i, k) + 1 + minCutsForPalindromePartitioning(str, k + 1, j));
		}

		return min;

	}

	private boolean isPalindromeIter(String str, int i, int j) {
		if (i == j) {
			return true;
		}

		if (i + 1 == j) {
			return (str.charAt(i) == str.charAt(j));
		}

		return ((str.charAt(i) == str.charAt(j)) && isPalindrome(str, i + 1, j - 1));
	}

	private boolean isPalindrome(String str, int i, int j) {
		int midSize = (j - i + 1) / 2;
		for (int k = 0; k < midSize; k++) {
			if (str.charAt(i + k) != str.charAt(j - k)) {
				return false;
			}
		}
		return true;
	}

	public int minCutsForPalindromePartition(String str) {
		int size = str.length();

		int[][] table = new int[size][size];
		boolean[][] isPalTable = new boolean[size][size];

		/*
		 * Below is for length = 1. For length 1 - every string(character) is a
		 * palindrome and '0' cuts are made/needed/
		 */
		for (int i = 0; i < size; i++) {
			table[i][i] = 0;
			isPalTable[i][i] = true;
		}

		for (int length = 2; length <= size; length++) {

			for (int startIndexForEachSize = 0; startIndexForEachSize < (size - length + 1); startIndexForEachSize++) {

				int endIndexForEachSize = startIndexForEachSize + length - 1;

				if (length == 2) {
					isPalTable[startIndexForEachSize][endIndexForEachSize] = (str.charAt(startIndexForEachSize) == str
							.charAt(endIndexForEachSize));
				} else {
					isPalTable[startIndexForEachSize][endIndexForEachSize] = (str.charAt(startIndexForEachSize) == str
							.charAt(endIndexForEachSize))
							& isPalTable[startIndexForEachSize + 1][endIndexForEachSize - 1];
				}

				if (isPalTable[startIndexForEachSize][endIndexForEachSize]) {
					table[startIndexForEachSize][endIndexForEachSize] = 0;
				} else {

					/*
					 * For size length-1 Get the minimum of all the cuts between
					 * startIndexForEachSize - endIndexForEachSize
					 */

					table[startIndexForEachSize][endIndexForEachSize] = Integer.MAX_VALUE; // First value

					for (int i = startIndexForEachSize; i < endIndexForEachSize; i++) {
						table[startIndexForEachSize][endIndexForEachSize] = Math.min(
								table[startIndexForEachSize][endIndexForEachSize],
								table[startIndexForEachSize][i] + 1 + table[i + 1][endIndexForEachSize]);
					}
				}
			}

			// diagonal length = (row -column) represents all the cuts needed for that
			// length

		}

		UtilityClass.printArray(table);

		return table[0][size - 1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PalindromePartitioning pp = new PalindromePartitioning();

		String str1 = "ababbbabbababa";
		// System.out.println("a\tb\ta\tb\tb\tb\ta\tb\tb\ta\tb\ta\tb\ta");
//		String str1 = "ababbabbababa";
		int cuts = pp.minCutsForPalindromePartitioning(str1, 0, str1.length() - 1);
		System.out.println("Cuts =" + cuts);

		int cuts2 = pp.minCutsForPalindromePartition(str1);
		System.out.println("Cuts2 =" + cuts2);

	}

	/***
	 * 
	 * P(0,n) = 0 when n=0 // Zero size text. So no partition needed = 0 when P(0,n)
	 * is Palindrome //No partitions needed = = Min (1 + P(0,i)+P(i+1,n)) where i is
	 * between 1 and n (n-1) partitions
	 * 
	 */

	public int minCut(String A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}

		int n = A.length();

		if (isPalindromeNew(A, 0, A.length()-1)) {
			return 0;
		}

		int[][] part = new int[n][n];
		boolean[][] isPalindrome = new boolean[n][n];
		// (i,j) stores min ways to Partition String (i,j)

		// (0,j) stores min ways to partition String (0,j)
		// Array is filled in incremental position

		for (int i = 0; i < n; i++) {
			isPalindrome[i][i] = true;
			part[i][i] = 0;
		}

		/*
		 * n = 5 length = 2 0 (0,1) 1 (1,2) 2 (2,3) 3 (3,4)
		 * n = 10 length = 4
		 * (0,3) (1,4) (2,5) (3,6), (4,7) (5,8) (6,9) 10-4
		 * 
		 */

		for (int length = 2; length <= n; length++) {
			for (int startIndex = 0; startIndex <= n - length; startIndex++) {
				int endIndex = startIndex + length - 1;

				/**
				 * We will not calculate Palindrome Table
				 */

				if (length == 2) {
					isPalindrome[startIndex][endIndex] = (A.charAt(startIndex) == A.charAt(endIndex));
				} else {
					isPalindrome[startIndex][endIndex] = isPalindrome[startIndex + 1][endIndex - 1]
							&& (A.charAt(startIndex) == A.charAt(endIndex));
				}

				if (isPalindrome[startIndex][endIndex]) {
					part[startIndex][endIndex] = 0;
				} else {
					for (int i = startIndex; i < endIndex; i++) {
						part[startIndex][endIndex] = Math.min(part[startIndex][endIndex],
								part[startIndex][i] + 1 + part[i + 1][endIndex]);
					}

				}

			}
		}
		return part[0][n - 1];
	}
	/*
	 * 4 5 6 7 8 (8-4+1) = 5/2 = 3 4 5 6 7 8 9 (9-4+1) = 6/2 = 3
	 * 
	 */

	private boolean isPalindromeNew(String A, int s, int e) {
		int halfLength = (e - s + 1) / 2;
		for (int i = 0; i <= halfLength; i++) {
			if (A.charAt(s + i) != A.charAt(e - i)) {
				return false;
			}
		}
		return true;
	}

}

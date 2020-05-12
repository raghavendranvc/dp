package com.my.dp;

import java.util.ArrayList;
import java.util.List;

public class EditOperationsOnTwoStrings {

	public enum OPERATION {
		NOOP('N', 0), REPLACE('R', 1), INSERT('I', 1), DELETE('D', 1);

		private final int val;
		private final char name;

		OPERATION(char name, int val) {
			this.name = name;
			this.val = val;
		}

		public int getVal() {
			System.out.println(name + " val=" + val);
			return val;
		}

		public char getName() {
			return name;
		}

	}

	/*
	 * Not fully implemented. Convert into Array. Don't try to use List
	 */
	public int getEditOperationsNeededIter(String str1, String str2, List<OPERATION> operations) {

		int m = str1.length();
		int n = str2.length();

		int[][] table = new int[m + 1][n + 1];

		List<List<List<OPERATION>>> listOps = new ArrayList<List<List<OPERATION>>>();

		for (int j = 0; j <= n; j++) {
			List<List<OPERATION>> innerList = new ArrayList<List<OPERATION>>();
			for (int i = 0; i <= m; i++) {
				List<OPERATION> opsList = new ArrayList<OPERATION>();
				innerList.add(opsList);
			}
			listOps.add(innerList);
		}

		table[0][0] = 0;

		/*
		 * When Given string is empty. All Insertions. First Columns - Column 0
		 */
		for (int j = 1; j <= n; j++) {
			table[0][j] = j * (OPERATION.INSERT.getVal());

			List<List<OPERATION>> innerList = listOps.get(j);
			List<OPERATION> opsList = innerList.get(0);
			for (int k = 0; k < j; k++) {
				opsList.add(OPERATION.INSERT);
			}

		}

		/*
		 * When Target String is empty. All Deletions
		 */
		List<List<OPERATION>> innerList = listOps.get(0); // No need to get repeatedly. First Row - Row 0
		for (int i = 1; i <= m; i++) {
			table[i][0] = i * (OPERATION.DELETE.getVal());

			List<OPERATION> opsList = innerList.get(i);
			for (int k = 0; k < i; k++) {
				opsList.add(OPERATION.INSERT);
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				int currentOpVal = 0; // If Chars are equal then no OPERATION needs to be performed
				OPERATION currentOp = OPERATION.NOOP;
				if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
					currentOpVal = OPERATION.REPLACE.getVal();
					currentOp = OPERATION.REPLACE;
				}

				int minVal = table[i - 1][j - 1] + currentOpVal;
				int val1 = table[i - 1][j] + OPERATION.INSERT.getVal();
				int val2 = table[i][j - 1] + OPERATION.DELETE.getVal();

				List<OPERATION> minOps = listOps.get(j - 1).get(i - 1);
				List<OPERATION> minOps1 = listOps.get(j - 1).get(i);
				List<OPERATION> minOps2 = listOps.get(j).get(i - 1);

				if (minVal > val1) {
					currentOp = OPERATION.INSERT;
					minVal = val1;
					minOps = minOps1;
				}

				if (minVal > val2) {
					currentOp = OPERATION.DELETE;
					minVal = val2;
					minOps = minOps2;
				}

				table[i][j] = minVal;

				List<OPERATION> updateOps = listOps.get(j).get(i);
				updateOps.clear();
				updateOps.addAll(minOps);
				updateOps.add(currentOp);
			}
		}

		System.out.println("OpsList=" + listOps.get(n).get(m));

		return table[m][n];

	}

	public int getNumberOfEditOperationsNeededIter(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();

		int[][] table = new int[m + 1][n + 1];

		table[0][0] = 0;

		/*
		 * When Given string is empty. All Insertions
		 */
		for (int j = 1; j <= n; j++) {
			table[0][j] = j * (OPERATION.INSERT.getVal()); // This is the cost to insert from 1..j. Preparing string of
															// length j
		}

		/*
		 * When Target String is empty. All Deletions
		 */
		for (int i = 1; i <= m; i++) {
			table[i][0] = i * (OPERATION.DELETE.getVal());
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int currentOpVal = OPERATION.NOOP.getVal(); // If Chars are equal then no OPERATION needs to be
															// performed
				if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
					currentOpVal = OPERATION.REPLACE.getVal();
				}

				table[i][j] = getMin(currentOpVal + table[i - 1][j - 1], OPERATION.INSERT.getVal() + table[i - 1][j],
						OPERATION.DELETE.getVal() + table[i][j - 1]);
			}
		}

		return table[m][n];

	}

	public int getNumberOfEditOperationsNeededRecur(String str1, String str2, int i, int j) {

		if (i == 0 && j == 0) { // For empty strings
			return 0;
		}

		if (i == 0) { // Given String is empty. So we need all insertions and make it equal to target
						// string
			return j * (OPERATION.INSERT.getVal());
		}

		if (j == 0) { // Target String is empty. So we need to delete all from given string
			return i * (OPERATION.DELETE.getVal());
		}

		System.out
				.println("str[" + (i - 1) + "]=" + str1.charAt(i - 1) + "  str[" + (j - 1) + "]" + str2.charAt(j - 1));

		int currentOpVal = OPERATION.NOOP.getVal(); // If Chars are equal then no OPERATION needs to be performed
		if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
			currentOpVal = OPERATION.REPLACE.getVal();
		}

		return getMin(currentOpVal + getNumberOfEditOperationsNeededRecur(str1, str2, i - 1, j - 1),
				OPERATION.INSERT.getVal() + getNumberOfEditOperationsNeededRecur(str1, str2, i - 1, j),
				OPERATION.DELETE.getVal() + getNumberOfEditOperationsNeededRecur(str1, str2, i, j - 1));
	}

	private int getMin(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EditOperationsOnTwoStrings op = new EditOperationsOnTwoStrings();
		String str1 = "abaabbbbabaabaa";
		String str2 = "aaaababa";

		/*
		 * String str1 = "RAGHAVENDRA"; String str2 = "SANDYA";
		 */

		/*
		 * String str1 = "HELLO"; String str2 = "HELLO";
		 */

		/*
		 * String str1 = "ABCDEFGH"; String str2 = "MNOPQRST";
		 */

//		int val1 = op.getNumberOfEditOperationsNeededRecur(str1, str2, str1.length(), str2.length());
		int val2 = op.getNumberOfEditOperationsNeededIter(str1, str2);
//		System.out.println("Val1="+val1);
		System.out.println("Val2="+val2);

		List<OPERATION> listOps = null;
		//int val3 = op.getEditOperationsNeededIter(str1, str2, listOps);

		//System.out.println("Val3=" + val3);
		// TODO Auto-generated method stub

	}

	public int minDistance(String A, String B) {

		int n = A.length();
		int m = B.length();

		/*
		 * a b a d
		 * 
		 * a b a c
		 * 
		 * (i,j) represents transformation of A(0,i) to B(0,j)
		 */
		int[][] result = new int[n + 1][m + 1];

		// if target string is empty (m=0) then we need deletions
		// only one way possible for all chars are deleted

		result[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			result[i][0] = 1;
		}

		// if input string is empty (n=0) then we need insertions
		// only one way possible - all chars are inserted

		for (int i = 1; i <= m; i++) {
			result[0][i] = 1;
		}

		/**
		 * 1) if char matches we move further 2) if it doesn't match we can a) insert
		 * from earlier b) delete and move to next c) replace from the ealier
		 * 
		 */

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// when we have same chars. We will have the same value
				int cost = 0;
				if (A.charAt(i - 1) != B.charAt(j - 1)) {
					cost = 1; //This is replacement cost
				}
				// Insert A(i) at result[i-1][j]
				// a b c d
				// a b d e // a b and insert c
				// Insert at result[i][j-1]

				// a b c d
				// a b d
				// delete will make it a b result[i-1][j] is deletion.

				// Replace A(i) at result[i-1][j-1]
				result[i][j] = min(result[i - 1][j] + 1, result[i][j - 1] + 1, result[i - 1][j - 1] + cost);

			}
		}

		return result[n][m];
	}

	private int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}

}

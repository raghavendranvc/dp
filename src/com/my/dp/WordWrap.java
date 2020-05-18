package com.my.dp;

import com.my.common.UtilityClass;

public class WordWrap {

	static void solveWordWrap(int arr[], int n, int k) {
		int i, j;

		// Variable to store number of characters in given line.
		int currlen;

		// Variable to store possible minimum cost of line.
		int cost;

		// DP table in which dp[i] represents cost of line starting with word arr[i].
		int dp[] = new int[n];

		// Array in which ans[i] store index of last word in line starting with word
		// arr[i].
		int ans[] = new int[n];

		// If only one word is present then only one line is required. Cost of last line
		// is zero. Hence cost of this line is zero. Ending point is also n-1 as single
		// word is present.
		dp[n - 1] = 0;
		ans[n - 1] = n - 1;

		// Make each word first word of line by iterating over each index in arr.
		for (i = n - 2; i >= 0; i--) {
			currlen = -1;
			dp[i] = Integer.MAX_VALUE;

			// Keep on adding words in current line by iterating from starting word upto
			// last word in arr.
			for (j = i; j < n; j++) {

				// Update number of characters in current line. arr[j] is number of characters
				// in current word and 1 represents space character between two words.
				currlen += (arr[j] + 1);

				// If limit of characters is violated then no more words can be added to current
				// line.
				if (currlen > k)
					break;

				// If current word that is added to line is last word of arr then current line
				// is last line. Cost of last line is 0. Else cost is square of extra spaces
				// plus cost of putting line breaks in rest of words from j+1 to n-1.
				if (j == n - 1)
					cost = 0;
				else
					cost = (k - currlen) * (k - currlen) + dp[j + 1];

				// Check if this arrangement gives minimum cost for line starting with word
				// arr[i].
				if (cost < dp[i]) {
					dp[i] = cost;
					ans[i] = j;
				}
			}
		}

		// Print starting indexs and ending index of words present in each line.
		i = 0;
		while (i < n) {
			System.out.print((i + 1) + " " + (ans[i] + 1) + " ");
			i = ans[i] + 1;
		}
	}

	public void wordWrapIter(int[] consecutiveWordLengths, int lineLimit) {

		int totalWords = consecutiveWordLengths.length;
		int INFINITY = ((int) Math.pow(lineLimit, 3)) + 1; // Integer.MAX_VALUE. But x power 3 is also OK. For the sake
															// of tabbed printing we used this.

		/*
		 * characters[i][j] contains the number of character entries needed for a line
		 * formed with the words between i and j.
		 * 
		 * i and j starts from 1 for SIMPLICITY reasons
		 */
		int characters[][] = new int[totalWords + 1][totalWords + 1];
		for (int i = 1; i <= totalWords; i++) {
			/*
			 * Space left after filling the line with a single word at i
			 */
			characters[i][i] = lineLimit - consecutiveWordLengths[i - 1];

			/*
			 * For every other line/sentence formed by the words between i and j: Use the
			 * previous cost of word between i and j-1 and reduce it with the current used
			 * word which is j and the space between the words
			 */
			for (int j = i + 1; j <= totalWords; j++) {
				characters[i][j] = characters[i][j - 1] - consecutiveWordLengths[j - 1] - 1;
			}
		}

		UtilityClass.printArray(characters);
		System.out.println();

		int table[][] = new int[totalWords + 1][totalWords + 1];

		for (int i = 1; i <= totalWords; i++) {
			for (int j = i; j <= totalWords; j++) {
				/*
				 * For each word starting at i and ending at j
				 */

				/*
				 * If characters[i][j] < 0 then no line is possible with words between i and j
				 * (i & j inclusive)
				 * 
				 * If characters[i][j] >= 0 and the line includes the last word (j == n-1) : It
				 * is a valid line and is the last line. The space cost is '0'
				 */

				if (characters[i][j] < 0) {
					table[i][j] = INFINITY;
				} else if (j == totalWords) {
					table[i][j] = 0;
				} else {
					table[i][j] = (int) (Math.pow(characters[i][j], 2));
				}
			}
		}

		UtilityClass.printArray(table);

		int[] minCost = new int[totalWords + 1];

		minCost[0] = 0;

		int[] solution = new int[totalWords + 1];

		for (int j = 1; j <= totalWords; j++) {
			minCost[j] = INFINITY;

			for (int i = 1; i <= j; i++) {
				/*
				 * Do this only if minCost[j-1] forms a line and table[i][j] has enough space
				 * for a line to be formed with the words between i and j
				 */
				if (minCost[i - 1] != INFINITY && table[i][j] != INFINITY) {
					if (minCost[j] > minCost[i - 1] + table[i][j]) {
						minCost[j] = minCost[i - 1] + table[i][j];
						solution[j] = i;
					}
				}
			}
		}

		System.out.println();

		UtilityClass.print(minCost);
		UtilityClass.print(solution);

		printSolution(solution, totalWords);

	}

	private int printSolution(int p[], int n) {

		System.out.println("n=" + n + " p[" + n + "]=" + p[n]);

		int k;
		if (p[n] == 1)
			k = 1;
		else
			k = printSolution(p, p[n] - 1) + 1;

		System.out.println("Line number " + k + ": From word no. " + p[n] + " to " + n);
		return k;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] words = { 3, 2, 2, 5 };
		int M = 6;
		UtilityClass.print(words);
		System.out.println();
		WordWrap ww = new WordWrap();
		ww.wordWrapIter(words, M);

	}

}

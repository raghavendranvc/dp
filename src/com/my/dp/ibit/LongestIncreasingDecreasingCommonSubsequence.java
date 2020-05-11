package com.my.dp.ibit;

import com.my.common.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingDecreasingCommonSubsequence {

	// TODO revisit this again. Remember LCS and DCS
	// LongestBitonicSubsequence

	public int longestSubsequenceLength(final List<Integer> A) {

		int n = A.size();
		/*
		 * StringBuilder sb = new StringBuilder(); for(int i : A){
		 * sb.append(i).append(","); } System.out.println("Given="+sb.toString());
		 */

		int[] increasingLengths = new int[n];
		Arrays.fill(increasingLengths, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A.get(j) < A.get(i) && (increasingLengths[j] + 1) > increasingLengths[i]) {
					increasingLengths[i] = increasingLengths[j] + 1;
				}
			}
		}
		UtilityClass.print(increasingLengths);

		int[] decreasingLenghts = new int[n];
		Arrays.fill(decreasingLenghts, 1);

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) { // For evey elements between (i) i+1,.... n-1
				if (A.get(i) > A.get(j) && decreasingLenghts[i] < (decreasingLenghts[j] + 1)) {
					decreasingLenghts[i] = decreasingLenghts[j] + 1;
				}
			}
		}
		UtilityClass.print(decreasingLenghts);

		int longestRequiredLength = 0;

		for (int i = 0; i < n; i++) {
			longestRequiredLength = Math.max(longestRequiredLength, increasingLengths[i] + decreasingLenghts[i] - 1);
		}
		return longestRequiredLength;
	}

	public static void main(String[] args) {
		/* int[] a = {1,3,5,6,4,8,4,3,2,1}; */
		int[] a = { 8, 6, 3, 4, 2, 1 };
		UtilityClass.print(a);
		List<Integer> list = UtilityClass.getList(a);
		LongestIncreasingDecreasingCommonSubsequence longestIncreasingDecreasingCommonSubsequence = new LongestIncreasingDecreasingCommonSubsequence();
		longestIncreasingDecreasingCommonSubsequence.longestSubsequenceLength(list);
	}

	public int lis(int[] A) {
		int n = A.length;
		int[] lcs = new int[n];
		Arrays.fill(lcs, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					lcs[i] = Math.max(lcs[i], lcs[j] + 1);
				}
			}
		}
		return max(lcs);
	}

	private int max(int[] lcs) {
		int max = Integer.MAX_VALUE;
		for (int i : lcs) {
			max = Math.max(max, i);
		}
		return max;
	}

	public int dis(int[] A) {
		int n = A.length;
		int[] dis = new int[n];
		Arrays.fill(dis, 1);

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (A[j] < A[i]) {
					dis[i] = Math.max(dis[i], dis[j] + 1);
				}
			}
		}
		return max(dis);
	}
}

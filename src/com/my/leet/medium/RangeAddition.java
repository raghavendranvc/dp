package com.my.leet.medium;

public class RangeAddition {

	// https://www.programcreek.com/2014/07/leetcode-range-addition-java/

	/*
	 * Assume you have an array of length n initialized with all 0's and are given k
	 * update operations.
	 * 
	 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which
	 * increments each element of subarray A[startIndex ... endIndex] (startIndex
	 * and endIndex inclusive) with inc.
	 * 
	 * 
	 * Return the modified array after all k operations were executed.
	 * 
	 * For example, Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]] Output:
	 * [-2,0,3,5,3]
	 */

	// TODO
	// Nice logic. We scan from left to right and know where we need to increment
	// and where we need to decrement for each update

	public int[] getModifiedArray(int length, int[][] updates) {
		int[] result = new int[length];
		if (updates == null || updates.length == 0)
			return result;

		for (int i = 0; i < updates.length; i++) {
			result[updates[i][0]] += updates[i][2];
			if (updates[i][1] < length - 1) {
				result[updates[i][1] + 1] -= updates[i][2];
			}
		}

		int v = 0;
		for (int i = 0; i < length; i++) {
			v += result[i];
			result[i] = v;
		}

		return result;
	}

}

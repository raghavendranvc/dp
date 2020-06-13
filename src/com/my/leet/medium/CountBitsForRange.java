package com.my.leet.medium;

public class CountBitsForRange {
	// https://leetcode.com/problems/counting-bits/

	// https://www.programcreek.com/2015/03/leetcode-counting-bits-java/

	// TODO Nice logic. Remember.
	// Analuze the bit patterns

	public int[] countBits(int num) {
		int[] result = new int[num + 1];

		int p = 1; // p tracks the index for number x

		int pow = 1;
		for (int i = 1; i <= num; i++) {
			if (i == pow) {
				result[i] = 1;
				pow <<= 1; // Next power of 2.
				p = 1; // we reset P to 1 after we find 2^x
			} else {
				result[i] = result[p] + 1;
				// We would have calculated all p here. This calculated between 5 to 7 and 9 to
				// 15
				p++;
			}

		}

		return result;
	}

}

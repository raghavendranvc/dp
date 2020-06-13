package com.my.leet.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

	// https://leetcode.com/problems/4sum-ii/

	// http://anothercasualcoder.blogspot.com/2016/12/leetcode-4sum-ii.html

	public int FourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> htCD = new HashMap<>();
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				if (!htCD.containsKey(sum))
					htCD.put(sum, 0);

				htCD.put(sum, htCD.get(sum) + 1);

			}
		}

		int result = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = -(A[i] + B[j]);
				if (htCD.containsKey(sum))
					result += htCD.get(sum);
			}
		}

		return result;
	}
}

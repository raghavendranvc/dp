package com.my.leet.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumToK {

	public int subarraySum(int[] nums, int k) {
		// assume nums is not null
		int n = nums.length;

		int count = 0;

		for (int i = 0; i < n; ++i) {
			int sum = 0;
			for (int j = i; j < n; ++j) {
				// For each subarray i to n (0,n)(1,n)(2,n)
				sum += nums[j];
				if (sum == k) {
					++count;
				}
			}
		}
		return count;
	}

	public int subarraySumOptimised(int[] nums, int k) {
		// assume nums is not null

		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>(); // <prefixSum, count>
		map.put(0, 1);
		int count = 0;
		int sum = 0;

		for (int i = 0; i < n; ++i) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}

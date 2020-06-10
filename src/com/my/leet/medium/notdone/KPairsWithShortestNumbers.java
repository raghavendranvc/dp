package com.my.leet.medium.notdone;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithShortestNumbers {

	// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
	// https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/

	// Use PQ to store, indices, sum
	// Min heap, Heap ordered by sum. Do duplicate index pairs
	// Heap is ordered by first value i.e sum of both elements.

	/*
	 * We can use a heap to store k candidate pairs. For every numbers in nums1, its
	 * best partner (yields min sum) always starts from nums2[0] since arrays are
	 * all sorted; And for a specific number in nums1, its next candidate should be
	 * [this specific number] + nums2[current_partner_index + 1], unless out of
	 * boundary for nums2.
	 */

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		k = Math.min(nums1.length * nums2.length, k);

		List<int[]> res = new ArrayList<>(k);
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));


		for (int i = 0; i < Math.min(k, nums1.length); i++)
			q.offer(new int[] { nums1[i], nums2[0], 0 }); 
		//pair(x,y) + nums2index(i) forms the PQ element

		for (int i = 0; i < k; i++) {
			int[] arr = q.poll();
			res.add(new int[] { arr[0], arr[1] });
			if (arr[2] < nums2.length - 1)
				q.offer(new int[] { arr[0], nums2[++arr[2]], arr[2] });
		}
		return res;
	}

}

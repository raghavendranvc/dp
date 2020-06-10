package com.my.leet.medium.notdone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	// https://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
	// https://leetcode.com/problems/top-k-frequent-elements/

	public List<Integer> topKFrequent(int[] nums, int k) {
		// count the frequency for each element
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// create a min heap
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
				Comparator.comparing(mapEntry -> mapEntry.getValue()));

		// maintain a heap of size k.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		// get all elements from the heap
		List<Integer> result = new ArrayList<>();
		while (queue.size() > 0) {
			result.add(queue.poll().getKey());
		}

		// reverse the order
		Collections.reverse(result);

		return result;
	}

}

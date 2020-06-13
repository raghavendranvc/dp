package com.my.leet.hard.notdone;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

	// https://www.programmersought.com/article/5914488435/
	// https://leetcode.com/problems/lfu-cache/
	// https://www.geeksforgeeks.org/least-frequently-used-lfu-cache-implementation/

	// Save the key, value
	HashMap<Integer, Integer> mainMap;

	// Save the key to the value of the number of visits
	HashMap<Integer, Integer> frequencyCounts;

	// Set the set of keys that save the same number of accesses
	HashMap<Integer, LinkedHashSet<Integer>> freqListMap; // Reverse of FrequencyCounts Map

	int cap;
	// Initialize the frequency of data occurrences
	int min = -1;

	public LFUCache(int capacity) {
		cap = capacity;
		mainMap = new HashMap<>();
		frequencyCounts = new HashMap<>();
		freqListMap = new HashMap<>();
	}

	public int get(int key) {
		if (!mainMap.containsKey(key))
			return -1;

		int count = frequencyCounts.get(key);
		frequencyCounts.put(key, count + 1);
		freqListMap.get(count).remove(key);

		// Determine whether min should add 1
		if (count == min && freqListMap.get(count).size() == 0) {
			min++;
		}

		if (!freqListMap.containsKey(count + 1)) {
			freqListMap.put(count + 1, new LinkedHashSet<>());
		}
		freqListMap.get(count + 1).add(key);
		return mainMap.get(key);
	}

	public void put(int key, int value) {
		if (cap <= 0)
			return;

		if (mainMap.containsKey(key)) {
			mainMap.put(key, value);
			get(key);
			return;
		}

		if (mainMap.size() >= cap) {
			int minFreKey = freqListMap.get(min).iterator().next();
			freqListMap.get(min).remove(minFreKey);
			mainMap.remove(minFreKey);
			frequencyCounts.remove(minFreKey);
		}

		mainMap.put(key, value);
		frequencyCounts.put(key, 1);
		min = 1;
		if (!freqListMap.containsKey(1)) {
			freqListMap.put(1, new LinkedHashSet<>());
		}
		freqListMap.get(1).add(key);
	}

	public class LFUCacheSol2 {

		class Node {
			public int count = 0;
			public LinkedHashSet<Integer> keys = null;
			public Node prev = null, next = null;

			public Node(int count) {
				this.count = count;
				keys = new LinkedHashSet<Integer>();
				prev = next = null;
			}
		}

		private Node head = null;
		private int cap = 0;
		private HashMap<Integer, Integer> valueHash = null;
		private HashMap<Integer, Node> nodeHash = null;

		public LFUCacheSol2(int capacity) {
			this.cap = capacity;
			valueHash = new HashMap<Integer, Integer>();
			nodeHash = new HashMap<Integer, Node>();
		}

		public int get(int key) {
			if (valueHash.containsKey(key)) {
				increaseCount(key);
				return valueHash.get(key);
			}
			return -1;
		}

		public void set(int key, int value) {
			if (cap == 0)
				return;
			if (valueHash.containsKey(key)) {
				valueHash.put(key, value);
			} else {
				if (valueHash.size() < cap) {
					valueHash.put(key, value);
				} else {
					removeOld();
					valueHash.put(key, value);
				}
				addToHead(key);
			}
			increaseCount(key);
		}

		private void addToHead(int key) {
			if (head == null) {
				head = new Node(0);
				head.keys.add(key);
			} else if (head.count > 0) {
				Node node = new Node(0);
				node.keys.add(key);
				node.next = head;
				head.prev = node;
				head = node;
			} else {
				head.keys.add(key);
			}
			nodeHash.put(key, head);
		}

		private void increaseCount(int key) {
			Node node = nodeHash.get(key);
			node.keys.remove(key);

			if (node.next == null) {
				node.next = new Node(node.count + 1);
				node.next.prev = node;
				node.next.keys.add(key);
			} else if (node.next.count == node.count + 1) {
				node.next.keys.add(key);
			} else {
				Node tmp = new Node(node.count + 1);
				tmp.keys.add(key);
				tmp.prev = node;
				tmp.next = node.next;
				node.next.prev = tmp;
				node.next = tmp;
			}

			nodeHash.put(key, node.next);
			if (node.keys.size() == 0)
				remove(node);
		}

		private void removeOld() {
			if (head == null)
				return;
			int old = 0;
			for (int n : head.keys) {
				old = n;
				break;
			}
			head.keys.remove(old);
			if (head.keys.size() == 0)
				remove(head);
			nodeHash.remove(old);
			valueHash.remove(old);
		}

		private void remove(Node node) {
			if (node.prev == null) {
				head = node.next;
			} else {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}
		}
	}
}

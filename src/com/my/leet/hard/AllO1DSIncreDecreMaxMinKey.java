package com.my.leet.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllO1DSIncreDecreMaxMinKey {
	// https://leetcode.com/problems/all-oone-data-structure/
	// https://medium.com/@null00/all-o-one-data-structure-b1f69c93d3ab

	/*
	 * Use HashMap and DLL. Prepare our own DLL. Don't use LinkedList
	 * 
	 * 
	 * Each Node contain 1) frequency 2) Word Set
	 * 
	 * Map is <String, Node>
	 * 
	 * 
	 */

	class Node {
		int val;
		Set<String> keys;
		Node prev;
		Node next;

		public Node(int val) {
			this.val = val;
			this.keys = new HashSet<String>();
		}
	}

	private Node head;
	private Node tail;
	private Map<String, Node> map;

	/** Initialize your data structure here. */
	public AllO1DSIncreDecreMaxMinKey() {
		head = new Node(-1);
		head.keys.add("");
		tail = new Node(-1);
		tail.keys.add("");
		head.next = tail;
		tail.prev = head;
		map = new HashMap<String, Node>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		if (!map.containsKey(key)) {
			Node node = new Node(0);
			node.keys.add(key);
			insert(head, node);
			map.put(key, node);
		}

		Node cur = map.get(key);
		if (cur.next == tail || cur.next.val > cur.val + 1) {
			Node node = new Node(cur.val + 1);
			node.keys.add(key);
			insert(cur, node);
			map.put(key, node);
		} else {
			Node next = cur.next;
			next.keys.add(key);
			map.put(key, next);
		}

		cur.keys.remove(key);
		if (cur.keys.size() == 0)
			remove(cur);
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 */
	public void dec(String key) {
		if (!map.containsKey(key))
			return;
		Node cur = map.get(key);
		cur.keys.remove(key);
		if (cur.val == 1) {
			map.remove(key);
		} else if (cur.prev == head || cur.prev.val < cur.val - 1) {
			Node node = new Node(cur.val - 1);
			node.keys.add(key);
			insert(cur.prev, node);
			map.put(key, node);
		} else {
			cur.prev.keys.add(key);
			map.put(key, cur.prev);
		}

		if (cur.keys.size() == 0)
			remove(cur);
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return tail.prev.keys.iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return head.next.keys.iterator().next();
	}

	private void insert(Node cur, Node node) {
		Node next = cur.next;
		cur.next = node;
		node.prev = cur;
		node.next = next;
		next.prev = node;
	}

	private void remove(Node cur) {
		Node next = cur.next;
		Node prev = cur.prev;
		prev.next = next;
		next.prev = prev;
	}

}

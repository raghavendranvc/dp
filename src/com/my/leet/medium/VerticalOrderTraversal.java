package com.my.leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

	static class Node {
		int key;
		Node left;
		Node right;

		// Constructor
		Node(int data) {
			key = data;
			left = null;
			right = null;
		}
	}

	// Utility function to store vertical order in map 'm'
	// 'hd' is horizontal distance of current node from root.
	// 'hd' is initially passed as 0
	static void getVerticalOrder(Node root, int hd, TreeMap<Integer, List<Integer>> m) {
		// Base case
		if (root == null)
			return;

		// get the vector list at 'hd'
		List<Integer> get = m.get(hd);

		// Store current node in map 'm'
		if (get == null) {
			get = new ArrayList<>();
			get.add(root.key);
		} else
			get.add(root.key);

		m.put(hd, get);

		// Store nodes in left subtree
		getVerticalOrder(root.left, hd - 1, m);

		// Store nodes in right subtree
		getVerticalOrder(root.right, hd + 1, m);
	}

	// The main function to print vertical order of a binary tree
	// with the given root
	static void printVerticalOrder(Node root) {
		// Create a map and store vertical order in map using
		// function getVerticalOrder()
		TreeMap<Integer, List<Integer>> m = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(root, hd, m);

		// Traverse the map and print nodes at every horigontal
		// distance (hd)
		for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}

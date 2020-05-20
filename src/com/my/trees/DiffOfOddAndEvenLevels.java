package com.my.trees;

public class DiffOfOddAndEvenLevels {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right;
		}
	}

	int getLevelDiff(Node node) {
		// Base case
		if (node == null)
			return 0;

		// Difference for root is root's data - difference for
		// left subtree - difference for right subtree
		return node.data - getLevelDiff(node.left) - getLevelDiff(node.right);
	}

}

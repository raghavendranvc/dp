package com.my.trees;

public class SecondLargestElementInABST {

	class Node {
		Node left;
		Node right;
		int val;
	}

	class Result {
		int count;
		int value;
	}

	public int secondLargestMain(Node root) {
		Result result = new Result();
		secondLargest(root, result);
		return result.value;
	}

	// Reverse inOrder
	private void secondLargest(Node root, Result r) {
		if (root == null || r.count >= 2) {
			return;
		}

		secondLargest(root.right, r);
		r.count++;

		if (r.count == 2) {
			r.value = root.val;
			return;
		}

		secondLargest(root.left, r);

	}

}

package com.my.leet.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();

		current.add(root);

		// need to track when each level starts
		while (!current.isEmpty()) {
			TreeNode head = current.removeFirst();

			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			ArrayList<Integer> numberList = new ArrayList<Integer>();
			numberList.add(head.val);

			if (head.left != null) {
				next.add(head.left);
			}
			if (head.right != null) {
				next.add(head.right);
			}

			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<TreeNode>();
				result.add(numberList);
				numberList = new ArrayList<Integer>();
			}
		}
		return result;
	}

}

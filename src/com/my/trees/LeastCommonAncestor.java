package com.my.trees;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public int lca(TreeNode A, int B, int C) {
		List<TreeNode> list1 = new ArrayList<>();
		if (!lca(A, B, new ArrayList<>(), list1)) {
			return -1;
		}

		List<TreeNode> list2 = new ArrayList<>();
		if (!lca(A, C, new ArrayList<>(), list2)) {
			return -1;
		}

		TreeNode rootNode = A;
		for (int i = 0; i < list1.size() && i < list2.size(); i++) {
			if (list1.get(i).val == list2.get(i).val) {
				rootNode = list1.get(i);
			} else {
				break;
			}

		}

		return rootNode.val;
	}

	public boolean lca(TreeNode A, int B, List<TreeNode> values, List<TreeNode> result) {
		if (A == null) {
			return false;
		}

		values.add(A);

		if (A.val == B) {
			result.addAll(values);
			return true;
		}

		if (A.left != null) {
			if (lca(A.left, B, new ArrayList<>(values), result)) {
				return true;
			}
		}

		if (A.right != null) {
			if (lca(A.right, B, new ArrayList<>(values), result)) {
				return true;
			}
		}
		return false;
	}

	/***
	 * Better approach
	 */

	class Node {
		boolean foundB = false, foundC = false;
		int ans = -1;

		public Node() {
			foundB = false;
			foundC = false;
			ans = -1;
		}
	}

	public Node helper(TreeNode A, int B, int C) {

		// If A is Null then LCA is Not Present
		if (A == null)
			return new Node();

		Node leftNode = helper(A.left, B, C);

		if (leftNode.foundB && leftNode.foundC) // If B and C both found in the left Subtree then return leftNode
			return leftNode;

		Node rightNode = helper(A.right, B, C); // If B and C both found in the right Subtree then return rightNode

		if (rightNode.foundB && rightNode.foundC)
			return rightNode;

		// if B ans C are found in left Subtree or right Subtree or root.val == b or
		// root.val == c
		Node pair = new Node();
		pair.foundB = (A.val == B) || leftNode.foundB || rightNode.foundB;
		pair.foundC = (A.val == C) || leftNode.foundC || rightNode.foundC;

		if (pair.foundB && pair.foundC) // If both B and C are found the update the ans
			pair.ans = A.val;

		return pair;

	}

	public int lcaHelper(TreeNode A, int B, int C) {

		Node res = helper(A, B, C);
		return res.ans;
	}

}

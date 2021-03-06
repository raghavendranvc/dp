package com.my.trees;

public class BalancedBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// ---------------------------
	public int getHeight(TreeNode a) {
		if (a == null)
			return 0;

		int left = getHeight(a.left);
		if (left < 0)
			return -1;

		int right = getHeight(a.right);
		if (right < 0)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}

	public int isBalancedWithHeights(TreeNode a) {
		if (getHeight(a) < 0)
			return 0;
		return 1;

	}

	// ----------------------------

	public int isBalanced(TreeNode A) {
		if (isBalancedBool(A)) {
			return 1;
		}
		return 0;
	}

	public boolean isBalancedBool(TreeNode A) {
		if (A == null || (A.left == null && A.right == null)) {
			return true;// True
		}

		boolean isSubTreesBalanced = isBalancedBool(A.left) && isBalancedBool(A.right);
		if (!isSubTreesBalanced) {
			return false;
		}

		int difference = Math.abs(height(A.left) - height(A.right));
		if (difference > 1) {
			return false;
		}
		return true;
	}

	public int height(TreeNode A) {
		if (A == null) {
			return 0;
		}

		int leftHeight = height(A.left);
		int rightHeight = height(A.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

}

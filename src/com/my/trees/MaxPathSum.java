package com.my.trees;

public class MaxPathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	int maxVal = Integer.MIN_VALUE;
	
	//TODO remember this
	int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lValue = Math.max(maxPathSum(root.left), 0);
		int rValue = Math.max(maxPathSum(root.right), 0);

		maxVal = Math.max(maxVal, root.val + lValue + rValue);

		return root.val + Math.max(lValue, rValue);

	}

}

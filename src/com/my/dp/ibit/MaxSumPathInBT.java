package com.my.dp.ibit;

public class MaxSumPathInBT {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// This does not work as expected. We need to find the bug

	public int maxPathSum1(TreeNode A) {
		maxPathSumRecurAndThisDoesNotWork(A);
		return countMax;
	}

	int countMax = Integer.MIN_VALUE;

	public int maxPathSumRecurAndThisDoesNotWork(TreeNode A) {
		if (A == null) {
			return 0;
		}

		int l = maxPathSum(A.left);
		int r = maxPathSum(A.right);

		int valueAtTree = Math.max(A.val, Math.max(l, r) + A.val);

		int mVal = Math.max(valueAtTree, A.val + l + r);

		countMax = Math.max(countMax, mVal);
		return valueAtTree;
	}

	// TODO //We need to understand the logic will
	int countMaxSum = Integer.MIN_VALUE; 
	//We need to think when we should need such global variable
	public int maxPathSum(TreeNode A) {

		if (A == null)
			return 0;

		int sumL = Math.max(maxPathSum(A.left), 0);// 0, x
		int sumR = Math.max(maxPathSum(A.right), 0); // 0, y

		countMaxSum = Math.max(countMaxSum, A.val + sumL + sumR); // A.val+x+y

		return A.val + Math.max(sumL, sumR);
	}

}

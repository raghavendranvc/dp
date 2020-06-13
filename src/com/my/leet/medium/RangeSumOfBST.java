package com.my.leet.medium;

public class RangeSumOfBST {

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

	public int rangeSumBST(TreeNode root, int L, int R) {
		if(root == null) {
			return 0;
		}
		
		if(root.val < L) {
			rangeSumBST(root.right, L, R);
		}
		
		if(root.val > R) {
			rangeSumBST(root.left, L, R);
		}
		
		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
		
	}

}

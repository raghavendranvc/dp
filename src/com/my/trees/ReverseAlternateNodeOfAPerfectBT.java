package com.my.trees;

public class ReverseAlternateNodeOfAPerfectBT {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	//TODO practice again
	void reverseNode(TreeNode root) {
		if (root == null) {
			return;
		}
		reverseNodes(root.left, root.right, 0); //This split is critical
	}

	void reverseNodes(TreeNode left, TreeNode right, int level) {
		if (left == null || right == null) {
			return;
		}

		if (level % 2 == 0) {
			int temp = left.val;
			left.val = right.val;
			right.val = temp;
		}
		// We should trust recursion. If we see tree, these are the nodes that gets interchanged
		reverseNodes(left.left,right.right,level+1);
		reverseNodes(left.right,right.left,level+1);
	}

}

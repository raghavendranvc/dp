package com.my.trees;

public class RemoveNodesOfLengthLessThanKFromBT {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// TODO Remember that the logic here is POSTORDER like not PreOrder. First
	// recurse and then delete. Practice it

	TreeNode removeNodesRecur(TreeNode root, int k, int level) {

		if (root == null) {
			return null;
		}

		root.left = removeNodesRecur(root.left, k, level + 1);
		root.right = removeNodesRecur(root.right, k, level + 1);

		if (root.left == null && root.right == null && level < k) {
			return null;
		}

		return root;
	}

	TreeNode removeNode(TreeNode root, int k) {
		return removeNodesRecur(root, k, 1);
	}

}

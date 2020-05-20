package com.my.trees;

public class CheckIfBTIsASubTreeOfAnother {
	
	/*
	 * Another way is to check if both InOrder and PreOrder traversals of S(subtree) are
	 * substrings of the InOrder and PreOrder traversals of MainTree(subtree)
	 */

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// Do some traversal and then check for identical
	// We need identical subroutine

	boolean checkIdentical(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}

		if (a == null || b == null) {
			return false;
		}

		return (a.val == b.val) && (checkIdentical(a.left, b.left)) && (checkIdentical(a.right, b.right));
	}
	
	//TODO ,practice again

	public boolean isSubTree(TreeNode A, TreeNode S) {
		if (S == null) {
			return true;
		}

		if (A == null) {
			return false;
		}

		if (checkIdentical(A, S)) {
			return true;
		}

		return isSubTree(A.left, S) && isSubTree(A.right, S);
	}

}

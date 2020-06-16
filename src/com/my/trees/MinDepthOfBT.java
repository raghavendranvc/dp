package com.my.trees;

public class MinDepthOfBT {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	int minD = Integer.MAX_VALUE;

	public int minDepth(TreeNode A) {
		minDepth(A, 0);
		return minD;
	}

	public void minDepth(TreeNode A, int depth) {
		if (A == null) {
			return;
		}

		if (A.left == null && A.right == null) {
			minD = Math.min(minD, depth + 1);
		}

		minDepth(A.left, depth + 1);
		minDepth(A.right, depth + 1);
	}

	/**
	 *
	 *
	 * @param A
	 * @return
	 */
	// TODO practice below solution.

	public int minDepthReharse(TreeNode A) {
		if (A == null) {
			return 0;
		}
		return minDepthReharse(A, 0);
	}

	public int minDepthReharse(TreeNode A, int depth) {
		if (A == null) {
			return Integer.MAX_VALUE; // Check this. Very important
		}
		if (A.left == null && A.right == null) {
			return depth + 1;
		}
		return Math.min(minDepthReharse(A.left, depth + 1), minDepthReharse(A.right, depth + 1));
	}

	public int minDepthSimple(TreeNode A) {
		if (A == null)
			return Integer.MAX_VALUE;

		if (A.right == null && A.left == null)
			return 1;

		return 1 + Math.min(minDepth(A.left), minDepth(A.right));
	}
	
	//TODO. Read this Elegant

	public int minDepthElegant(TreeNode a) {

		if (a == null)
			return 0;

		if (a.left == null && a.right == null)
			return 1;

		if (a.left == null)
			return minDepthElegant(a.right) + 1;

		if (a.right == null)
			return minDepthElegant(a.left) + 1;

		return Math.min(minDepthElegant(a.left), minDepthElegant(a.right)) + 1;
	}

}

package com.my.leet.medium;

import java.util.HashMap;

public class SubTreeWithDeepestNodes {

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

	TreeNode getSubTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		int diff = depth(root.left) - depth(root.right);

		if (diff == 0) {
			return root;
		}

		if (diff > 0) {
			return getSubTree(root.left);
		} else {
			return getSubTree(root.right);
		}

	}

	int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(depth(node.left), depth(node.right));
	}

	// ===========================================
	public int depth(TreeNode root, HashMap<TreeNode, Integer> map) {
		if (root == null)
			return 0;
		
		if (map.containsKey(root))
			return map.get(root);
		
		int depth = Math.max(depth(root.left, map), depth(root.right, map)) + 1;
		map.put(root, depth);
		return depth;
	}

	public TreeNode dfs(TreeNode root, HashMap<TreeNode, Integer> map) {
		
		
		int left = depth(root.left, map);
		int right = depth(root.right, map);
		
		if (left == right)
			return root;
		
		if (left > right)
			return dfs(root.left, map);
		
		return dfs(root.right, map);
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null)
			return null;
		
		HashMap<TreeNode, Integer> map = new HashMap<>();
		
		depth(root, map); //populate depth math
		
		return dfs(root, map);
	}

}

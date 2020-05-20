package com.my.trees;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintBottomViewOfBT {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int axis;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public Collection<Integer> printBottomView(TreeNode root) {

		Map<Integer, Integer> bottomView = new TreeMap<>();

		root.axis = 0; // intitalRootAxis

		// Level Order Traversal
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode pNode = queue.remove();
			int rAxis = pNode.axis;
			bottomView.put(rAxis, root.val);

			if (pNode.left != null) {
				pNode.left.axis = rAxis - 1;
				queue.add(pNode.left);
			}

			if (pNode.right != null) {
				pNode.right.axis = rAxis + 1;
				queue.add(pNode.right);
			}
		}

		// bottomView values are the bottomView
		return bottomView.values();
	}

}

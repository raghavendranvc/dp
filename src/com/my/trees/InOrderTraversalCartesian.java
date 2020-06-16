package com.my.trees;

import java.util.ArrayList;

public class InOrderTraversalCartesian {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 
	 * 3 1 3
	 * 
	 * 3 1
	 * 
	 * 3 2 (tempNode.right.val < curretNode.val)
	 * 
	 * 
	 */

	public TreeNode buildTree(ArrayList<Integer> A) {

		/*
		 * Given an inorder traversal of a cartesian tree, construct the tree.
		 * 
		 * Cartesian tree : is a heap ordered binary tree, where the root is greater
		 * than all the elements in the subtree.
		 */

		TreeNode rootNode = null;

		for (int i = 0; i < A.size(); i++) {
			TreeNode currentNode = new TreeNode(A.get(i));

			if (rootNode == null) {
				rootNode = currentNode;
				continue;
			}

			/*
			 * if currentNode is greater than root, then make entire tree as leftNode of the
			 * new element
			 * 
			 * Else
			 * 
			 * find the rightNode which is smaller than the current Node If found then take
			 * that subtree and make it as the left tree of the currentNode If not found
			 * simply place it as the right most node.
			 * 
			 */
			if (currentNode.val > rootNode.val) {
				currentNode.left = rootNode;
				rootNode = currentNode;
			} else {
				TreeNode tempNode = rootNode;
				while (tempNode.right != null) {
					if (tempNode.right.val < currentNode.val) {
						currentNode.left = tempNode.right;
						tempNode.right = currentNode;
						break;
					}
					tempNode = tempNode.right;
				}
				tempNode.right = currentNode;
			}
		}
		return rootNode;
	}

}

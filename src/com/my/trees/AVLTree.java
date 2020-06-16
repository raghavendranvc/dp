 package com.my.trees;

public class AVLTree {
	class Node {
		int val;
		Node left;
		Node right;
		int height;

		Node(int val) {
			this.val = val;
			this.height = 1;
			left = right = null;
		}

	}

	Node root;

	int height(Node n) {
		return (n == null) ? 0 : n.height;
	}

	int balance(Node n) {
		return (n == null) ? 0 : height(n.left) - height(n.right);
	}

	Node doRightRotate(Node node) {
		Node leftChild = node.left;
		node.left = node.left.right;
		leftChild.right = node;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		leftChild.height = Math.max(height(leftChild.left), height(leftChild.right)) + 1;

		return leftChild;
	}

	Node doLeftRotate(Node node) {
		Node rightChild = node.right;
		node.left = node.right.left;
		rightChild.left = node;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		rightChild.height = Math.max(height(rightChild.left), height(rightChild.right)) + 1;
		return rightChild;
	}

	Node insert(Node root, int val) {

		if (root == null) {
			return new Node(val);
		}

		if (val < root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		} else {
			return root;
		}

		root.height = 1 + Math.max(height(root.left), height(root.right));

		int balance = balance(root);

		if (balance > 1) {
			if (val < root.left.val) {
				return doRightRotate(root);
			} else {
				doLeftRotate(root.left);
				return doRightRotate(root);
			}
		} else {
			if (val > root.right.val) {
				return doLeftRotate(root);
			} else {
				doRightRotate(root.right);
				doLeftRotate(root);
			}
		}

		return root;
	}

}

package com.my.trees;

public class IsomorphicTree {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right;
		}
	}

	boolean isIsomorphic(Node n1, Node n2) {
		// Both roots are NULL, trees isomorphic by definition
		if (n1 == null && n2 == null)
			return true;

		// Exactly one of the n1 and n2 is NULL, trees not isomorphic
		if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been
		// "Flipped".
		// Both of these subtrees have to be isomorphic.
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}

}

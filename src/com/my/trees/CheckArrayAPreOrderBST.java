package com.my.trees;

import java.util.Stack;

public class CheckArrayAPreOrderBST {

	/*
	 * The idea is to use a stack. This problem is similar to Next (or closest)
	 * Greater Element problem. Here we find the next greater element and after
	 * finding next greater, if we find a smaller element, then return false.
	 * 
	 * 1) Create an empty stack. 2) Initialize root as INT_MIN. 3) Do following for
	 * every element pre[i] a) If pre[i] is smaller than current root, return false.
	 * b) Keep removing elements from stack while pre[i] is greater then stack top.
	 * Make the last removed item as new root (to be compared next). At this point,
	 * pre[i] is greater than the removed root (That is why if we see a smaller
	 * element in step a), we return false) c) push pre[i] to stack (All elements in
	 * stack are in decreasing order)
	 * 
	 * 
	 * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-
	 * traversal-of-binary-search-tree/
	 */

	// TODO didn't do it. Analyse the logic carefully and implement it

	boolean canRepresentBST(int pre[], int n) {
		// Create an empty stack
		Stack<Integer> s = new Stack<Integer>();

		// Initialize current root as minimum possible
		// value
		int root = Integer.MIN_VALUE;
		
		//order is important
		//we assume left subtree is on the stack
		// and the array contains only right subtree

		// Traverse given array
		for (int i = 0; i < n; i++) {
			// If we find a node who is on right side
			// and smaller than root, return false
			if (pre[i] < root) {
				return false;
			}

			// If pre[i] is in right subtree of stack top,
			// Keep removing items smaller than pre[i]
			// and make the last removed item as new root.
			while (!s.empty() && s.peek() < pre[i]) {
				root = s.pop();
			}

			// At this point either stack is empty or
			// pre[i] is smaller than root, push pre[i]
			s.push(pre[i]);
		}
		return true;
	}

}

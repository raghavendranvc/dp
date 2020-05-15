package com.my.graphs;

import java.util.ArrayList;

public class SortedListToBalancedBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public TreeNode sortedListToBST(ListNode a) {
		ArrayList<Integer> list = new ArrayList<>();
		while (a != null) {
			list.add(a.val);
			a = a.next;
		}
		return insert(list, 0, list.size() - 1);
	}

	/*
	 * odd 15 (0+15)/2= 7 (0,6) 7 (8,15) 7 1 7
	 * 
	 * even 16 (0,7) 8 (9,16) 8 1 7
	 */

	private TreeNode insert(ArrayList<Integer> list, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = insert(list, low, mid - 1);
		root.right = insert(list, mid + 1, high);

		return root;
	}

}

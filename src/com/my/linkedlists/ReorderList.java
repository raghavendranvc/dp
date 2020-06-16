package com.my.linkedlists;

import java.util.Stack;

public class ReorderList {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return "" + val + ",";
		}

	}

	/*
	 * 
	 * s d s d s d s d s d 1 2 3 4 5 6 7 8 9 10 d.next =null;
	 * 
	 * 1 10 2 9 3 8 4 7 5 6
	 * 
	 * 6 7 8 9 10
	 * 
	 * 1 10 2 9
	 * 
	 * //odd d = null; 1 2 3 4 5 6 7 8 9 10 11 s d s d s d s d s d s d
	 * 
	 * 1 11 2 10 3 9 4 8 5 7 6
	 * 
	 */

	// --------------- Reorder list----------------------

	public ListNode reverseList(ListNode root) {
		
		ListNode prev = null;
		ListNode curr = root;

		while (curr != null) {
			// System.out.println(curr.val);
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public ListNode reorderListWithoutStack(ListNode A) {

		if (A == null)
			return A;

		ListNode root = A;
		ListNode slow = root;
		ListNode fast = slow.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode middleNode = slow.next;
		slow.next = null; //break the list into first half

		ListNode r = reverseList(middleNode); //reversed second half

		ListNode l = root;

		while (l != null && r != null) { //merge the 2 lists
			ListNode lNext = l.next;
			l.next = r;
			
			ListNode rNext = r.next;
			r.next = lNext;
			
			r = rNext;
			l = lNext;
		}

		return root;

	}

	public ListNode reorderList(ListNode A) {

		Stack<ListNode> stack = new Stack<ListNode>();
		if (A == null || A.next == null || A.next.next == null) {
			return A;
		}

		ListNode s = A;
		ListNode d = A.next;

		while (d != null && d.next != null) {
			s = s.next;
			d = d.next.next;
		}

		while (s.next != null) {
			s = s.next;
			stack.push(s);
		}

		s = A;
		while (s != null && !stack.isEmpty()) {
			ListNode save = s.next;
			s.next = stack.pop();
			s.next.next = save;
			s = save;
		}

		if (s != null) {
			s.next = null;
		}

		return A;

	}

	public ListNode reorderListWithReverse(ListNode A) {
		if (A == null || A.next == null || A.next.next == null) {
			return A;
		}

		ListNode s = A;
		ListNode d = A.next;

		while (d != null && d.next != null) {
			s = s.next;
			d = d.next.next;
		}

		ListNode centralNode = s.next;
		s.next = null;

		ListNode reverseList = getReverseList(centralNode);

		ListNode first = A;

		while (first != null && reverseList != null) {
			ListNode fnext = first.next;
			ListNode rnext = reverseList.next;

			first.next = reverseList;
			reverseList.next = fnext;

			reverseList = rnext;
			first = fnext;
		}
		return A;
	}

	// ---------Reverse List------------

	public ListNode getReverseList(ListNode n) {
		ListNode current = n;
		ListNode previous = null;

		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous; // We return the previous in Reversal
	}

	// ---------Reverse k lists at a time----------------
	/*
	 * 
	 * 1 2 3 4 5 6 7 8 9 10 11 12 3 2 1 6 5 4 9 8 7 12 11 10
	 * 
	 * 
	 */

	public ListNode reverseList(ListNode first, int k) {

		ListNode current = first;
		ListNode previous = null;
		ListNode next = null;

		int i = 0;
		while (current != null && i < k) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			i++;
		}

		if (next != null) {
			first.next = reverseList(next, k);
		}

		return previous;
	}

	// ---------Swap pairs

	public ListNode swapPairsRecursive(ListNode A) {

		if (A != null && A.next != null) {
			ListNode nextNode = A.next;

			A.next = swapPairsRecursive(nextNode.next);
			nextNode.next = A;

			return nextNode;
		}
		return A;
	}

	/*
	 * 
	 * A N 1 ->2-> 3 4 5 6 7 8
	 * 
	 * P A o 2 1 3 4 5
	 * 
	 * 2 1 4 3 5
	 * 
	 */

	public ListNode swapPairs(ListNode A) {

		if (A == null || A.next == null) {
			return A;
		}
		ListNode nextRootNode = A.next;
		ListNode prev = null;

		while (A != null && A.next != null) {

			ListNode otherNode = A.next;
			A.next = A.next.next; // otherNode.next
			otherNode.next = A;

			if (prev != null) {
				prev.next = otherNode;
			}

			prev = A;
			A = A.next;
		}

		return nextRootNode;

	}
}

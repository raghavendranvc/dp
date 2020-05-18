package com.my.linkedlists;

public class MergeSort {

	class ListNode {
		int val;
		ListNode next;
	}

	public ListNode getMiddle(ListNode current) {
		if (current == null) {
			return null;
		}

		if (current.next == null) {
			return current;
		}

		if (current.next.next == null) {
			return current;
		}

		ListNode slow = current;
		ListNode fast = current;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	// 1-> 3-> 5
	// 2-> 4->6

	public ListNode merge(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		if (a.val <= b.val) {
			a.next = merge(a.next, b);
			return a;
		} else {
			b.next = merge(a, b.next);
			return b;
		}
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode middleNode = getMiddle(head);

		ListNode rightHead = middleNode.next;
		middleNode.next = null;
		
		return merge(mergeSort(head), mergeSort(rightHead));
	}

}

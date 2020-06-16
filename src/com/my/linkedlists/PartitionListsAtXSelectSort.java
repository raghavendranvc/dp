package com.my.linkedlists;

public class PartitionListsAtXSelectSort {

	// TODO not done

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
	 * 6 5 9 2 6 4 7 8 3 4 Given 5
	 * 
	 * 6* 5 9 2 6 4 7 8 3 4 9* 2 6 4 7 8 3 4 5 6 2 6* 4 7 8 3 4 5 6 9 2 4 7* 8 3 4 5
	 * 6 9 6 2 4 8* 3 4 5 6 9 6 7 2 4 3 4 5 6 9 6 7 8
	 * 
	 */

	// https://www.programcreek.com/2013/02/leetcode-partition-list-java/

	public ListNode partitionCopied(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode fakeHeadForSmaller = new ListNode(0);
		ListNode fakeHeadForGreater = new ListNode(0); 
		//We add these so that we don't need to bother about the head
		
		fakeHeadForSmaller.next = head;

		ListNode current = head;
		ListNode prev = fakeHeadForSmaller;
		
		ListNode p2 = fakeHeadForGreater; 

		while (current != null) {
			if (current.val < x) {
				current = current.next;
				prev = prev.next;
			} else {

				p2.next = current;
				prev.next = current.next;

				current = current.next;
				p2 = p2.next;
			}
		}

		// close the list
		p2.next = null; //p2 points to greaterNodes
		prev.next = fakeHeadForGreater.next; //previous points to last smaller element

		return fakeHeadForSmaller.next;
	}

}

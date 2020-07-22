package com.my.leet.medium.graphs;

import java.util.Random;

public class SelectRandomNodeInLargeLL {

	class ListNode {
		int val;
		ListNode next;
	}

	Random r = null;
	ListNode head = null;

	public SelectRandomNodeInLargeLL(ListNode head) {
		r = new Random();
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {

		int count = 1;
		ListNode current = head;

		int result = 0;
		while (current != null) {
			// [0,count)
			if (r.nextInt(count) == 0) // Returns value between 0 (inclusive) and count (exclusive)
				result = current.val;
			
			count++; //To get random, we are traversing the entire LL
			current = current.next;
		}
		return result;
	}

}

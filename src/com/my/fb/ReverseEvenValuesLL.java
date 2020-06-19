package com.my.fb;

public class ReverseEvenValuesLL {

	/*
	 * 
	 * You are given a singly-linked list that contains N integers. A subpart of the
	 * list is a contiguous set of even elements, bordered either by the end of the
	 * list or an odd element. 
	 * 
	 * For example, if the list is [1, 2, 8, 9, 12, 16], the
	 * subparts of the list are [2, 8] and [12, 16]. Then, for each subpart, the
	 * order of the elements is reversed. In the example, this would result in the
	 * new list, [1, 8, 2, 9, 16, 12].
	 */

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	Node reverse(Node head) {
		// Write your code here
		Node prevNode = null;
		Node currentNode = head;

		while (currentNode != null && currentNode.next != null) {
			if (currentNode.data % 2 == 0 && currentNode.next.data % 2 == 0) {

				Node removeNode = currentNode.next;
				currentNode.next = removeNode.next;

				if (prevNode != null) {
					removeNode.next = prevNode.next;
					prevNode.next = removeNode;
				} else {
					removeNode.next = head;
					head = removeNode;
				}

			} else {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
		}

		return head;

	}

}

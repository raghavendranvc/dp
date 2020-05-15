package com.my.linkedlists;

public class RotateList {

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
	 * 1->2->3->4->5->NULL k=3
	 * 
	 * 1 2 3 4 5 6 NULL p c
	 * 
	 * c(3) c(2) c(1) c(0) p p c p c
	 * 
	 * 
	 * 4 5 6 1 2 3 NULL
	 * 
	 * c.next = A; save = p.next; p.next = NULL; return p.next
	 * 
	 * 
	 */

	public ListNode rotateRight(ListNode A, int B) {

		int length = 0;
		ListNode tempNode = A;
		while (tempNode != null) {
			length++;
			tempNode = tempNode.next;
		}
		B = B % length;

		ListNode currentNode = A;
		ListNode previousNode = null;

		while (currentNode.next != null && B > 0) {
			currentNode = currentNode.next;
			B--;
		}

		previousNode = A;

		while (currentNode.next != null) {
			currentNode = currentNode.next;
			previousNode = previousNode.next;
		}

		currentNode.next = A;
		ListNode save = previousNode.next;
		previousNode.next = null;
		return save;

	}

	/*
	 * c m n s 1->2->3->4->5->6->7->8
	 * 
	 * m s 1->2->3<-4->5->6->7->8 m 1->2->3<-4<-5->6->7->8 m 1->2->3<-4<-5<-6->7->8
	 * m c.next.next=s; 1->2->6->5->4->3->7->8
	 * 
	 * 
	 */

	public ListNode reverseBetween(ListNode A, int B, int C) {
		System.out.print("Initial");
		print(A);

		if (B == C) {
			return A;
		}

		if (B == 1) {
			A = reverseNodes(A, C - B);
			return A;
		}

		ListNode nNode = A;
		ListNode startRevNode;

		B--;
		C--;
		while (B > 1 & nNode != null) {
			nNode = nNode.next;
			B--;
			C--;
		}
		startRevNode = nNode;
		/*
		 * System.out.println("StartRevrse f0r="+nNode.next); print(nNode.next);
		 */
		//For this, don't touch C and B. Here both B and C are reduced. B is reduced to 0
		startRevNode.next = reverseNodes(nNode.next, C - B); 

		/*
		 * System.out.print("ReverseList="); print(A);
		 */
		return A;
	}

	/*
	 * 
	 * A p c s 3->4->5->6->7->8 p c s 3><4 5->6->7->8 s 3<-4<-5<-6 7->8
	 * 
	 * 6-<5->4->3->7->8
	 * 
	 */

	public ListNode reverseNodes(ListNode A, int x) {

		ListNode current = A;
		ListNode prev = null;

		System.out.println("current=" + current + " prev=" + prev + " x=" + x);
		while (current != null && x >= 0) { //This is important. Check currentNode, not current.Next

			ListNode tempNode = current.next;
			current.next = prev;
			prev = current;
			current = tempNode;
			x--;
			System.out.println("next=" + tempNode + " current=" + current + " prev=" + prev + " x=" + x);
		}

		A.next = current;  //Another important two setting. Don't miss
		print(prev);		// Always use example and do the operation
		
		return prev;
	}

	public void print(ListNode node) {
		StringBuilder StringBuilder = new StringBuilder();
		while (node != null) {
			StringBuilder.append(node.val + " ");
			node = node.next;
		}
		System.out.println(StringBuilder.toString());
	}

	public static void main(String[] args) {
		ListNode first = new ListNode(1);

		ListNode n2 = new ListNode(2);
		first.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		/*
		 * ListNode n4 = new ListNode(4); n3.next=n4; ListNode n5 = new ListNode(5);
		 * n4.next=n5; ListNode n6 = new ListNode(6); n5.next=n6; ListNode n7 = new
		 * ListNode(7); n6.next=n7; ListNode n8 = new ListNode(8); n7.next=n8;
		 */

		// ListNode n4 = new ListNode(1); n3.next=n4;
		int B = 2;
		int C = 3;

		RotateList rotateList = new RotateList();
		rotateList.reverseBetween(first, B, C);

	}

	public ListNode reverseBetweenCopied(ListNode A, int B, int C) {
		if (A == null)
			return A;
		if (B == C)
			return A;

		ListNode curr = A, nxt = curr.next, p1 = A, p2 = A, temp;
		int count = 1;

		while (true) {
			if (count < B) {
				if (B > 1 && count == B - 1) {
					p1 = curr;
				}
				count++;
				curr = curr.next;
				nxt = nxt.next;
				continue;
			}
			if (count == B)
				p2 = curr;

			temp = nxt;
			nxt = nxt.next;
			temp.next = curr;
			curr = temp;
			count++;
			if (count == C) {
				if (B == 1) {
					p2.next = nxt;
					return curr;
				}
				p1.next = curr;
				p2.next = nxt;
				return A;
			}

		}
	}

	public ListNode reverserList(ListNode A, int k) {

		/*
		 * 1 2 3 4 5 4 3 2 1
		 */

		ListNode current = A;
		while (current.next != null && k > 0) {
			current = current.next;
			k--;
		}

		/*
		 * 5 6 7 8 9 10 NULL 1 2 3 4 5 6
		 */

		ListNode newEndingNode = A;
		while (current.next != null) {
			current = current.next;
			newEndingNode = newEndingNode.next;
		}

		current.next = A;
		A = newEndingNode.next;
		newEndingNode.next = null;

		return A;

	}

}

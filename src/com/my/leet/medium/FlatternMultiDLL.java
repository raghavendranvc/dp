package com.my.leet.medium;

public class FlatternMultiDLL {

	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
		Node(int val){
			this.val = val;
		}
	};

	public Node flatten(Node head) {

		Node currentNode = head;
		while (currentNode != null) {

			if (currentNode.child == null) {
				currentNode = currentNode.next;
				continue;
			}

			Node flatList = flatten(currentNode.child);

			Node nextNode = currentNode.next;
			currentNode.next = flatList;
			flatList.prev = currentNode;
			if (nextNode == null) {
				break;
			}

			currentNode = currentNode.next;

			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}

			currentNode.next = nextNode;
			nextNode.prev = currentNode;
		}

		return head;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		
		node1.next = node2; node2.prev = node1;
		node2.next = node3; node3.prev = node2;
		node3.next = node4; node4.prev = node3;
		node4.next = node5; node5.prev = node4;
		node5.next = node6; node6.prev = node5;
		
		node7.next = node8; node8.prev = node7;
		node8.next = node9; node9.prev = node8;
		node9.next = node10;node10.prev = node9;
		
		node11.next = node12; node12.prev = node11;
		
		node3.child = node7;
		node8.child = node11;
		
		FlatternMultiDLL flatternMultiDLL = new FlatternMultiDLL();
		Node saveNode1 = flatternMultiDLL.flatten(node1);
		
		Node retNode = saveNode1;
		while(retNode != null) {
			System.out.print(retNode.val + " ");
			retNode = retNode.next;
		}
		System.out.println();
		
		retNode = saveNode1;
		while(retNode.next != null) {
			retNode = retNode.next;
		}
		
		while(retNode != null) {
			System.out.print(retNode.val + " ");
			retNode = retNode.prev;
		}
		System.out.println();
		
	}

}

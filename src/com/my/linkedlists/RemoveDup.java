package com.my.linkedlists;

public class RemoveDup {

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        public String toString(){
            return ""+val+",";
        }

    }

    public ListNode deleteDuplicatesOneVariable(ListNode A) {
    	if(A == null) {
    		return null;
    	}
    	
    	ListNode currentNode = A;
    	
    	while(currentNode.next != null) {
    		if(currentNode.val == currentNode.next.val) {
    			currentNode.next = currentNode.next.next;
    		}else {
    			currentNode = currentNode.next;
    		}
    	}
    	return A;
    }

    /**
     *
     *  1   2   3   3   3   4   5   5   6
     *  c
     *  p
     *      c
     *      p
     *          c
     *          p
     *              c
     *                  c
     *                      c
     *                      p   c
     *                              c
     *                                  c
     *
     *
     */

    public ListNode deleteDuplicates(ListNode A) {
        ListNode currentNode = A;
        ListNode previousNode = null;
        boolean duplicate = false;
        ListNode returnNode = null;

        while(currentNode !=null && currentNode.next!=null){
            if(currentNode.val == currentNode.next.val) {
                duplicate = true;
            } else {
                if(!duplicate) {
                    if (previousNode == null) {
                        previousNode = currentNode;
                        returnNode = previousNode;
                    } else {
                        previousNode.next = currentNode;
                        previousNode = previousNode.next;
                    }
                }
                duplicate = false;
            }
            currentNode = currentNode.next;
        }

        ListNode lastElement = null;
        if(currentNode != null && !duplicate){
            lastElement = currentNode;
        } else {
            lastElement = null;
        }

        if (previousNode == null) {
            previousNode = lastElement;
            returnNode = previousNode;
        } else {
            previousNode.next = lastElement;
            //previousNode = previousNode.next;// Not needed because it is already the last element
        }

        return returnNode;
    }
}

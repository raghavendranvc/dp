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

    public ListNode deleteDuplicatesMakeUnique(ListNode A) {

        ListNode currentNode = A;
        ListNode previousNode = A;
        while (currentNode != null && currentNode.next != null){
            if(currentNode.val != currentNode.next.val){
                previousNode.next = currentNode.next;
                previousNode = previousNode.next;
            }
            currentNode = currentNode.next;
        }
        if(currentNode == null || currentNode.val==previousNode.val){
            previousNode.next=null;
        } else {
            previousNode.next=currentNode;
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

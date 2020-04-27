package com.my.linkedlists;

public class PartitionLists {

    //TODO not done

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

    /*

    6   5   9   2   6   4   7   8   3   4
    Given 5

    6*  5   9   2   6   4   7   8   3   4
    9*  2   6   4   7   8   3   4   5   6
    2   6*  4   7   8   3   4   5   6   9
    2   4   7*  8   3   4   5   6   9   6
    2   4   8*  3   4   5   6   9   6   7
    2   4   3   4   5   6   9   6   7   8

     */

    public ListNode partition(ListNode A, int B) {

        if(A == null || A.next == null){
            return A;
        }

        ListNode lastNode = A;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }

        ListNode previous = null;
        ListNode currentNode = A;
        //ListNode lastKnownSmallerElement = null;
        while (currentNode != null){

            if(currentNode.val > B){
                if(currentNode == A){

                }
            }

        }

        return lastNode;

    }

}

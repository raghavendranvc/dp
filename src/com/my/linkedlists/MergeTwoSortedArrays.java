package com.my.linkedlists;

public class MergeTwoSortedArrays {

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

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode result = null;
        if(A == null){
            return B;
        }

        if(B == null){
            return A;
        }

        if(A.val <= B.val){
            result = A;
            A = A.next;
        } else {
            result = B;
            B = B.next;
        }

        ListNode pointer = result;
        while (A != null && B != null){
            if(A.val <= B.val){
                pointer.next = A;
                A = A.next;
            } else {
                pointer.next = B;
                B = B.next;
            }
            pointer = pointer.next;
        }

        if(A == null){
            pointer.next=B;
        } else {
            pointer.next=A;
        }

        return result;
    }
}

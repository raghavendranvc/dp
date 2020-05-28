package com.my.linkedlists;

import org.w3c.dom.NodeList;

import java.util.Stack;

public class ReorderList {

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

        s   d
            s       d
                s           d
                    s               d
                        s                   d
        1   2   3   4   5   6   7   8   9   10
        d.next =null;

        1   10  2   9   3   8   4   7   5   6

        6
        7
        8
        9
        10

        1   10  2   9

        //odd
        d = null;
        1   2   3   4   5   6   7   8   9   10  11
        s   d
            s       d
                s           d
                    s               d
                        s                   d
                            s                       d

        1   11  2   10   3   9   4   8   5   7  6

     */

    public ListNode reorderList(ListNode A) {

        Stack<ListNode> stack = new Stack<ListNode>();
        if(A==null || A.next==null || A.next.next==null) {
            return  A;
        }

        ListNode s = A;
        ListNode d = A.next;

        while(d!=null && d.next!=null){
            s=s.next;
            d=d.next.next;
        }

        while(s.next != null){
            s=s.next;
            stack.push(s);
        }

        s = A;
        while(s != null && !stack.isEmpty()){
            ListNode save = s.next;
            s.next = stack.pop();
            s.next.next = save;
            s = save;
        }

        if(s!=null) {
            s.next = null;
        }

        return A;

    }

    public ListNode reorderListWithReverse(ListNode A) {
        if(A==null || A.next==null || A.next.next==null) {
            return  A;
        }

        ListNode s = A;
        ListNode d = A.next;

        while(d!=null && d.next!=null){
            s=s.next;
            d=d.next.next;
        }

        ListNode centralNode = s.next;
        s.next=null;

        ListNode reverseList = getReverseList(centralNode);

        ListNode first = A;

        while(first!=null && reverseList!=null){
            ListNode fnext = first.next;
            ListNode rnext = reverseList.next;

            first.next = reverseList;
            reverseList.next = fnext;

            reverseList = rnext;
            first = fnext;
        }
        return A;
    }

    public ListNode getReverseList(ListNode n){
        ListNode current = n;
        ListNode previous = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /*

        1   2   3   4   5   6   7   8   9   10  11  12
        3   2   1   6   5   4   9   8   7   12  11  10


     */

    public ListNode reverseList(ListNode first, int k){
        ListNode current = first;
        ListNode previous = null;
        ListNode next = null;

        int i=0;
        while (current != null && i<k){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }

        if(next != null){
            first.next = reverseList(next,k);
        }

        return previous;
    }



    public ListNode swapPairsRecursive(ListNode A) {

        if(A != null && A.next != null){
            ListNode nextNode = A.next;
            A.next = swapPairs(nextNode.next);
            nextNode.next = A;
            return nextNode;
        }
        return A;
    }

    /*

    A   N
    1 ->2-> 3   4   5   6   7   8

        P   A   o
    2   1   3   4   5

    2   1   4   3   5

     */

    public ListNode swapPairs(ListNode A) {

        if(A == null || A.next == null){
            return A;
        }
        ListNode nextRootNode = A.next;
        ListNode prev= null;

        while (A != null && A.next!=null ){

            ListNode otherNode = A.next;
            A.next = A.next.next;
            otherNode.next = A;

            if(prev!=null) {
                prev.next=otherNode;
            }

            prev = A;
            A=A.next;
        }

        return nextRootNode;

    }
}

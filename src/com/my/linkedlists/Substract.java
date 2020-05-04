package com.my.linkedlists;

import java.util.Stack;

public class Substract {

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

    s   f
        s       f
            s           f
                s               f
                    s                   f

    1   2   3   4   5   6   7   8   9   NULL
                    m
    s   f
        s       f
            s           f
                s               f
                    s                   f
    1   2   3   4   5   6   7   8   9   10  NULL

     */

    public ListNode subtract(ListNode A) {

        if(A == null || A.next == null) {
            return A;
        }
        ListNode slow = A;
        ListNode fast = A.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        System.out.println("Rest of the list");
        print(slow);

        Stack<Integer> save = new Stack<>();
        while( slow != null){
            save.push(slow.val);
            slow = slow.next;
        }

        System.out.println("Stack="+save);

        slow=A;
        while (!save.isEmpty()){
            slow.val = save.pop() - slow.val;
            slow = slow.next;
        }

        return A;
    }


    public static void main(String[] args){

        //95 -> 59 -> 26 -> 16 -> 31 -> 39
        ListNode first = new ListNode(95);

        ListNode n2 = new ListNode(59); first.next=n2;
        ListNode n3 = new ListNode(26); n2.next=n3;
        ListNode n4 = new ListNode(16); n3.next=n4;
        ListNode n5 = new ListNode(31); n4.next=n5;
        ListNode n6 = new ListNode(39); n5.next=n6;

        print(first);
        Substract substract = new Substract();
        System.out.println("Result=");
        print(substract.subtract(first));


    }

    public static void print(ListNode node){
        StringBuilder StringBuilder = new StringBuilder();
        while(node != null){
            StringBuilder.append(node.val+" ");
            node = node.next;
        }
        System.out.println(StringBuilder.toString());
    }

}

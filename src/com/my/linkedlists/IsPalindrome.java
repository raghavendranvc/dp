package com.my.linkedlists;

import java.util.Stack;

public class IsPalindrome {

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
    1   4   5   6   6   5   4   1

    1
    4
    5
    6


    6=6
    5=5
    4=4
    1=1


    s   f
        s       f
            s           f
                s               f
                    s                   f
    1   4   5   6   7   6   5   4   1   NULL

     */
    public int lPalin(ListNode A) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = A;

        if(A.next == null){
            return 1;
        }

        ListNode fast = A.next;
        stack.push(slow.val);
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        System.out.println("End stack="+stack+" fast"+fast+" slow="+slow);

        slow = slow.next;
        /*
        Odd number size
         */
        if(fast ==null) {
            stack.pop();//middle element
        }
        while( slow != null){
            if(stack.pop() != slow.val){
                return 0;
            }
            slow = slow.next;
        }
        return 1;
    }

    public static void main(String[] args){
        ListNode first = new ListNode(1);

        ListNode n2 = new ListNode(2); first.next=n2;
        ListNode n3 = new ListNode(1); n2.next=n3;
        //ListNode n4 = new ListNode(1); n3.next=n4;

        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.lPalin(first);

    }

    public void print(ListNode node){
        StringBuffer stringBuffer = new StringBuffer();
        while(node != null){
            stringBuffer.append(node.val+" ");
            node = node.next;
        }
        System.out.println(stringBuffer.toString());
    }

}

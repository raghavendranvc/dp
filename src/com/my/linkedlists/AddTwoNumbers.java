package com.my.linkedlists;

import com.my.common.UtilityClass;

public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        int carry = 0;
        ListNode result = null;

        ListNode next = null;

        while(A != null && B!= null){
            int sum = (carry + A.val + B.val)%10;
            carry = (carry + A.val + B.val)/10;
            if(next == null){ //For the first time
                next = new ListNode(sum);
                result = next;
            } else {
                next.next = new ListNode(sum);
                next = next.next;
            }
            A = A.next;
            B = B.next;
        }

        if(A == null){
            add( next, B,  carry);
            if(result == null){
                result = next;
            }
        } else if(B == null){
            add( next, A,  carry);
            if(result == null){
                result = next;
            }

        }
        return result;
    }

    private void add(ListNode result, ListNode A, int carry){
        while(A != null){
            int sum = (carry + A.val)%10;
            carry = (carry + A.val)/10;
            result.next = new ListNode(sum);
            result = result.next;

            A = A.next;
        }

        if(carry > 0){
            result.next = new ListNode(carry);
            //result = result.next;
        }
    }

    public static void print(ListNode node){
        StringBuilder StringBuilder = new StringBuilder();
        while(node != null){
            StringBuilder.append(node.val+" ");
            node = node.next;
        }
        System.out.println(StringBuilder.toString());
    }

    public static void main(String[] args){
        ListNode first = new ListNode(9);

        ListNode n2 = new ListNode(9); first.next=n2;
        ListNode n3 = new ListNode(1); n2.next=n3;

        ListNode second = new ListNode(1);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        print(first);
        print(second);
        addTwoNumbers.addTwoNumbers(first,second);

    }

}

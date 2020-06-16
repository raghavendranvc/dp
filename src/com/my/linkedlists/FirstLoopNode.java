package com.my.linkedlists;

public class FirstLoopNode {

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

        f       s
        s   s   f   s   sf      s       sff     s       sf   f
        1   2   3   4   5       6       7       8       9       10
                                        14      13      12      11
                                                 f              f

     */

    public ListNode detectCycle(ListNode a) {

        ListNode slow = a;
        ListNode fast = a;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow ==fast){
                break;
            }
        }

        if(fast == null || slow==null || fast != slow){
            return null;
        }

        slow = a; //slow is reset to the first node.
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public ListNode detectCycleCopied(ListNode a) {
        ListNode slow=a,fast=a;
        boolean flag=false;

        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                flag=true;
                break;
            }
        }
        if(flag==true) {
            slow=a;
            while(slow!=fast) {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
    
    //TODO break the loop.
    //Since we know the loopStartNode, 
    // we need to break the link which is node.next->loopStartNode
    // So start from current = loopStartNode and move one node at a time till current.next=loopStartNode.
    // Remove the link. Make current.next = null;

}

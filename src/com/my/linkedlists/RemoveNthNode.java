package com.my.linkedlists;

public class RemoveNthNode {
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

        n=3
                        **
        1   2   3   4   5   6   7
        0   1   2   3   4   5   6
                    p               c
                P               c
            p               c
        p               c(0)
                    c(1)
                c(2)
            c(3)
        c(4)



        1       2    3    4      5       6       7
        c(3) c(2)  c(1)

        P                 c
                p                c
                    p                    c
                          p                     c




     */

    /*

        1       2       3       4       5
        c(5)
               c(4)
                        c(3)
                                c(2)
                                        c(1)
                                                c(0)
        p

     */
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode currentNode = A;

        while(currentNode!=null && B>=0){
            currentNode = currentNode.next;
            B--;
        }

        if(B>=0){
            return A.next;
        }

        ListNode previousNode = A;


        while(currentNode != null){
            currentNode = currentNode.next;
            previousNode = previousNode.next;
        }

        previousNode.next = previousNode.next.next;

        return A;

    }
}

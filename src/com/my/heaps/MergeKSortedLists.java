package com.my.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    /*

    1 -> 10 -> 20
    4 -> 11 -> 13
    3 -> 8 -> 9


     */

    public class Solution {
        public ListNode mergeKLists(ArrayList<ListNode> a) {

            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });

            pq.addAll(a);
            ListNode returnListHead = null;
            ListNode currentNode = null;
            while(!pq.isEmpty()){
                ListNode previousNode = currentNode;
                currentNode = pq.poll();
                if(previousNode == null){
                    returnListHead = currentNode;
                } else {
                    previousNode.next = currentNode;
                }

                if(currentNode.next != null){
                    pq.add(currentNode.next);
                }

            }
            return returnListHead;
        }
    }

}

package com.my.hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyList {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public void print(RandomListNode randomListNode){
        while( randomListNode != null ){
            System.out.print(randomListNode.label+" ");
            randomListNode = randomListNode.next;
        }
        System.out.println();
    }

    /**
     *
     * Not working
     * @param head
     * @return
     */

    public RandomListNode copyRandomListHardWayStillDoesNotWork(RandomListNode head) {
        RandomListNode newHead = null;
        RandomListNode preNodeOfNewList = null;

        RandomListNode loopNode = head;
        while (loopNode != null){
            RandomListNode rNode = new RandomListNode(loopNode.label);
            if(preNodeOfNewList == null){
                newHead = rNode;
            } else {
                preNodeOfNewList.next = rNode;
            }
            preNodeOfNewList = rNode;
            loopNode = loopNode.next;
        }

        print(newHead);

        Map<RandomListNode,RandomListNode> nextMapping = new HashMap<>();
        loopNode = head;
        while (loopNode != null){
            nextMapping.put(loopNode,loopNode.next);
            loopNode = loopNode.next;
        }

        System.out.println("nextMapping="+nextMapping);

        loopNode = head;
        RandomListNode loopNode2 = newHead;
        while (loopNode != null){
            RandomListNode saveNode = loopNode.next;
            loopNode.next = loopNode2;
            loopNode2.random = loopNode;

            loopNode = saveNode;
            loopNode2 = loopNode2.next;
        }

        loopNode2 = newHead;
        while (loopNode2 != null){
            loopNode2.random = loopNode2.random.random.next;
            loopNode2 = loopNode2.next;
        }


        loopNode = head;
        while (loopNode != null){
            loopNode.next = nextMapping.get(loopNode);
            loopNode = loopNode.next;
        }

        return newHead;

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode currentNode = head;

        while(currentNode != null){
            RandomListNode newRandomListNode = new RandomListNode(currentNode.label);
            newRandomListNode.next = currentNode.next;
            currentNode.next = newRandomListNode;
            currentNode = newRandomListNode.next;
        }

        currentNode = head;
        while(currentNode!=null){

            if(currentNode.next != null) {
                currentNode.next.random = (currentNode.random != null)? currentNode.random.next : currentNode.random;
            }
            currentNode = (currentNode.next != null)? currentNode.next.next :  currentNode.next;
        }

        RandomListNode newHead = head.next;

        currentNode = head;
        RandomListNode currentCopyNode = newHead;
        while(currentNode!=null && currentCopyNode!=null){

            currentNode.next     = (currentNode.next != null)?      currentNode.next.next       : currentNode.next;
            currentCopyNode.next = (currentCopyNode.next !=null)?   currentCopyNode.next.next   : currentCopyNode.next;

            currentNode = currentNode.next;
            currentCopyNode = currentCopyNode.next;
        }

        return newHead;
    }

}

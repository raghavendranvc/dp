package com.my.hashing;

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
                currentNode.next.random = (currentNode.random != null)? currentNode.random.next : null;
            }
            currentNode = (currentNode.next != null)? currentNode.next.next :  null;
        }

        RandomListNode newHead = head.next;

        currentNode = head;
        RandomListNode currentCopyNode = newHead;
        while(currentNode!=null && currentCopyNode!=null){

            currentNode.next     = (currentNode.next != null)?      currentNode.next.next       : null;
            currentCopyNode.next = (currentCopyNode.next !=null)?   currentCopyNode.next.next   : null;

            currentNode = currentNode.next;
            currentCopyNode = currentCopyNode.next;
        }

        return newHead;
    }

}

package com.my.trees;

import java.util.*;

public class PopulateNextRightPointers {
    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int val){
            this.val = val;
        }

    }

    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> currentList = Collections.singletonList(root);

        while(!currentList.isEmpty()){

            List<TreeLinkNode> nextList = new LinkedList<>();

            Iterator<TreeLinkNode> iterator = currentList.iterator();
            TreeLinkNode previousNode = null;
            while(iterator.hasNext()){
                TreeLinkNode tempNode = iterator.next();
                if(previousNode != null){
                    previousNode.next = tempNode; //Populating the next pointer
                }
                previousNode = tempNode;
                if(tempNode.left != null){      // Simulataneously we are also preparing nextList
                    nextList.add(tempNode.left);
                }
                if(tempNode.right != null){
                    nextList.add(tempNode.right);
                }
            }
            currentList = nextList;
        }
    }
}

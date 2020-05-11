package com.my.trees;

import java.util.Stack;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }


    private TreeNode currentNode = null;

    private TreeNode inOrderSuccWhenThereIsNoRightNode() {
        if(root == null){
            return null;
        }

        if(currentNode == null ){
            this.currentNode = getMinValue(root);
        }

        TreeNode tempNode = root;
        TreeNode succNode = null;

        while(tempNode != null){
            if(currentNode.val < root.val){
                succNode = tempNode;
                tempNode = tempNode.left;
            } else if(currentNode.val > root.val){
                tempNode = tempNode.right;
            } else {
                break;
            }
        }
        return succNode;
    }

    private TreeNode getMinValue(TreeNode currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    //TODO read this again. Make sure to use Stack

    private Stack<TreeNode> stack;
    private TreeNode root = null;

    public Solution(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        pushLeftTreeToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
                    8
            3             10
         1      6              14
             4     7        13

        When we remove 3 from the stack,
        we need to make sure the we push 6 and 4 to to the stack. So when we pop
        4 will be the next value to be popped out.

        Similarly when 6 is popped out, we push its right subtree which is 7

     */

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()){
            return -1;
        }

        TreeNode treeNode = stack.pop();
        //Before returning, we need to push the values of the right node Tree to stack
        pushLeftTreeToStack(treeNode.right);
        return treeNode.val;

    }

    public void pushLeftTreeToStack(TreeNode treeNode){
        while(treeNode != null){
            stack.push(treeNode);
            treeNode = treeNode.left;
        }
    }


}

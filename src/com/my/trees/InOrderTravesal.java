package com.my.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTravesal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }



    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        Stack<TreeNode> staack = new Stack<>();
        ArrayList<Integer> inOrderList = new ArrayList<>();
        if(A == null){
            return inOrderList;
        }
        pushLeftTreeToStack(A, staack);
        while(!staack.isEmpty()){
            TreeNode tempNode = staack.pop();
            pushLeftTreeToStack(tempNode.right, staack);
            inOrderList.add(tempNode.val);
        }
        return inOrderList;
    }

    private void pushLeftTreeToStack(TreeNode node, Stack<TreeNode> staack){
        while(node != null){
            staack.push(node);
            node = node.left;
        }
    }

    
}

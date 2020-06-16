package com.my.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    //TODO practice again

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> postOrderTravelsal = new ArrayList<>();
        if(A == null){
            return postOrderTravelsal;
        }
        Stack<TreeNode> tempStack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();

        tempStack.push(A);
        //Order of print is left, right, root
        //So we need to push root, right, left to stack2 - in that order
        //So stack1 needs to be pushed and poped accordingly
        // so we need to push root, left, right to stack1
        while (!tempStack.isEmpty()){
            TreeNode treeNode = tempStack.pop();
            
            resultStack.push(treeNode);//R,L,R 
            
            if(treeNode.left != null){
                tempStack.push(treeNode.left);
            }

            if(treeNode.right != null){
                tempStack.push(treeNode.right);
            }
        }

        while(!resultStack.isEmpty()){
            postOrderTravelsal.add(resultStack.pop().val);
        }
        return postOrderTravelsal;
    }

}

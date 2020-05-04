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
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(A);

        while (!stack1.isEmpty()){
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode);
            if(treeNode.left != null){
                stack1.push(treeNode.left);
            }

            if(treeNode.right != null){
                stack1.push(treeNode.right);
            }
        }

        while(!stack2.isEmpty()){
            postOrderTravelsal.add(stack2.pop().val);
        }
        return postOrderTravelsal;
    }

    // TODO not done fully. Refer Geeks - Complex - No Time
    public ArrayList<Integer> postorderTraversalSingleStack(TreeNode A) {
        ArrayList<Integer> postOrderTravelsal = new ArrayList<>();
        if(A == null){
            return postOrderTravelsal;
        }
        Stack<TreeNode> stack = new Stack<>();

        pushLeftTreeToStack(A.left, stack);

        while (A.left == null || !stack.isEmpty() ){
            if(stack.isEmpty()){
                pushLeftTreeToStack(A.right, stack);
            }

            if(!stack.isEmpty()){
                A = stack.pop();

            }
        }

        return postOrderTravelsal;

    }

    private void pushLeftTreeToStack(TreeNode node, Stack<TreeNode> stack){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

}

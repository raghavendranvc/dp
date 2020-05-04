package com.my.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

    public int[] preorderTraversalArray(BST.TreeNode A) {

        ArrayList<Integer> preList = new ArrayList<>();
        preorderTraversalRecur(A, preList);
        int[] returnArray = new int[preList.size()];
        for(int i=0;i<preList.size();i++){
            returnArray[i] = preList.get(i);
        }
        return returnArray;
    }


    private void preorderTraversalRecur(BST.TreeNode A, ArrayList<Integer> preList) {
        if(A == null) {
            return;
        }
        preList.add(A.val);
        preorderTraversalRecur(A.left,preList);
        preorderTraversalRecur(A.right,preList);
    }

    //TODO remember how to use the stack
    public ArrayList<Integer> preorderTraversal(BST.TreeNode A) {
        ArrayList<Integer> preOrderList = new ArrayList<>();
        if( A == null){
            return preOrderList;
        }

        Stack<BST.TreeNode> stack = new Stack<>();
        while(A != null){ //Very cirtical
            preOrderList.add(A.val);
            stack.push(A);

            if(A.left != null){
                A = A.left;
                continue;
            }

            A = null;
            while(!stack.isEmpty()) { //stack is only used to make sure we processed the right nodes of the nodes stored
                A = stack.pop().right;
                if(A != null){
                    break;
                }
            }

        }

        return preOrderList;
    }
}

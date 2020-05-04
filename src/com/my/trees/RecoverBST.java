package com.my.trees;

import java.util.ArrayList;

public class RecoverBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    //TODO this solution is read from Geeks. Remember to use the 3 pointers

    public ArrayList<Integer> recoverTree(TreeNode A) {
        recoverTreeRecur(A);

        ArrayList<Integer> returnList = new ArrayList<>();

        if(thirdNode != null){
            returnList.add(thirdNode.val);
        } else {
            returnList.add(secondNode.val);
        }
        returnList.add(firstNode.val);
        return returnList;
    }


    TreeNode previousNode;

    TreeNode firstNode;
    TreeNode secondNode;
    TreeNode thirdNode;

    public void recoverTreeRecur(TreeNode A) {
        if( A == null){
            return;
        }
        recoverTreeRecur(A.left);
        if(previousNode != null){
            if(previousNode.val > A.val){
                if(firstNode == null) {
                    firstNode = previousNode;
                    secondNode = A;
                } else {
                    thirdNode = A;
                }
            }
        }
        previousNode = A;
        recoverTreeRecur(A.right);
    }

}

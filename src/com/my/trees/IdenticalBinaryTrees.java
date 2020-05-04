package com.my.trees;

public class IdenticalBinaryTrees {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if(isSameTreeBool(A,B)){
            return 1;
        }
        return 0;
    }

    public boolean isSameTreeBool(TreeNode A, TreeNode B) {
        if( A == B ){
            return true;
        }

        if(A == null || B == null){
            return false;
        }

        return (A.val == B.val && isSameTreeBool(A.left,B.left) && isSameTreeBool(A.right,B.right) );
    }

}

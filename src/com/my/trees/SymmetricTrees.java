package com.my.trees;

import java.util.TreeSet;

public class SymmetricTrees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int isSymmetric(TreeNode A) {
        if(isSymmetricBoolean(A)){
            return 1;
        }
        return 0;
    }

    public boolean isSymmetricBoolean(TreeNode A) {
        if(A == null){
            return true;
        }
        return isIdentical(A.left, A.right);
    }
    public boolean isIdentical(TreeNode A, TreeNode B){
        if(A == null && B == null){
            return true;
        }

        if(A == null || B == null){
            return false;
        }

        return (A.val == B.val) && isIdentical(A.left, B.right) && isIdentical(A.right,B.left);
    }

}

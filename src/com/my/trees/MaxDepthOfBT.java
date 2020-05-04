package com.my.trees;

public class MaxDepthOfBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int maxDepth(TreeNode A) {
        if(A == null){
            return 0;
        }

        if(A.left == null && A.right == null){
            return 1;
        }
        return Math.max(maxDepth(A.left),maxDepth(A.right))+1;
    }
}

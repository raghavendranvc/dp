package com.my.trees;

public class ReturnPathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int hasPathSum(TreeNode A, int B) {
        if(hasPathSumRecur(A,B)){
            return 1;
        }
        return 0;
    }

    public boolean hasPathSumRecur(TreeNode A, int B) {
        if(A.left == null && A.right==null && A.val == B){
            return true;
        }

        if(A.left!= null && hasPathSumRecur(A.left, B-A.val)){
            return true;
        }

        if(A.right != null && hasPathSumRecur(A.right, B-A.val)){
            return true;
        }
        return false;
    }
}

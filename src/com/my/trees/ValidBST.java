package com.my.trees;

public class ValidBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int isValidBSTWrong(TreeNode A) {
        if(isValidBSTRecur(A)){
            return 1;
        }
        return 0;

    }

    //This is wrong.//TODO remember this
    public boolean isValidBSTRecur(TreeNode A) {
        if(A == null || (A.left==null && A.right==null)){
            return  true;
        }

        if((A.left != null && A.val <= A.left.val) ||  (A.right != null && A.val >= A.right.val)){
            return false;
        }

        if(!isValidBSTRecur(A.left)){
            return false;
        }

        return (isValidBSTRecur(A.right));
    }

    public int isValidBST(TreeNode A) {
        if(isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return 1;
        }
        return 0;
    }

    public boolean isValidBST(TreeNode A, int minVal, int maxVal){

        if(A == null){
            return true;
        }

        if(A.val < minVal || A.val > maxVal){
            return false;
        }

        return isValidBST(A.left,minVal, A.val-1) && isValidBST(A.right,A.val+1,maxVal);
    }

    public boolean isValidBSTReturn(TreeNode A, int minVal, int maxVal){

        if(A == null){
            return true;
        }

        if(A.val < minVal || A.val > maxVal){
            return false;
        }

        if(!isValidBSTReturn(A.left,minVal, A.val-1)){
            return false;
        }

        return isValidBSTReturn(A.right,A.val+1,maxVal);
    }
}

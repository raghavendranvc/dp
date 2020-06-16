package com.my.trees;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int t2Sum(TreeNode A, int B) {
        if(t2SumTraverse(A, A, B)){
            return 1;
        }
        return 0;
    }

    public boolean t2SumTraverse(TreeNode root, TreeNode A, int B) {
        if(A == null){
            return false;//Not found
        }

        if((A.val != B-A.val) && foundValue(root, B-A.val)){
            return true;
        }
        if(t2SumTraverse(root, A.left,B)){
            return true;
        }
        return t2SumTraverse(root, A.right,B);
    }


    public boolean foundValue(TreeNode root, int value){
        if(root == null) {
            return false;
        }

        if(root.val == value){
            return true;
        }

        if(value < root.val){
            return foundValue(root.left, value);
        }

        return foundValue(root.right, value);
    }
    
    //TODO Remember this logic

    public int t2SumSet(TreeNode A, int B) {
        Set<Integer> set = new HashSet<>();
        if(t2SumSet(A,B,set)){
            return 1;
        }
        return 0;
    }

    public boolean t2SumSet(TreeNode A, int B, Set<Integer> set){
        if(A == null){
            return false;
        }

        if(set.contains(B-A.val)){
            return true;
        }

        set.add(A.val);

        if(t2SumSet(A.left, B, set)){
            return true;
        }

        return t2SumSet(A.right, B, set);
    }


}

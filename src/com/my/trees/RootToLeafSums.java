package com.my.trees;

import java.util.ArrayList;

public class RootToLeafSums {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        pathSumRecursion( A,  B,  result, new ArrayList<>());
        return result;
    }

    public void pathSumRecursion(TreeNode A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if(A == null){
            return;
        }

        list.add(A.val);

        if(A.left == null && A.right == null && A.val == B){
            result.add(list);
        }

        if(A.left != null){
            pathSumRecursion(A.left,B-A.val, result, new ArrayList<>(list));
        }

        if(A.right != null){
            pathSumRecursion(A.right,B-A.val, result, new ArrayList<>(list));
        }
    }



}

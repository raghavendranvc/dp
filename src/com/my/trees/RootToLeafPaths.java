package com.my.trees;

import java.math.BigInteger;

public class RootToLeafPaths {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    double value = 0;
    public int sumNumbers(TreeNode A) {
        sumNumbers(A,  "");
        return (int)value%1003;
    }

    public void sumNumbers(TreeNode A, String currentString) {
        if(A == null){
            return ;
        }

        currentString = (currentString + A.val);

        if(A.left == null && A.right == null){
            value += (Double.parseDouble(currentString)%1003);
            value %= 1003;
        }

        if(A.left != null ) {
            sumNumbers(A.left, currentString);
        }

        if(A.right != null) {
            sumNumbers(A.right, currentString);
        }
    }
}

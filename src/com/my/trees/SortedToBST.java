package com.my.trees;

public class SortedToBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(final int[] A) {
        return sortedArrayToBSTOverloaded(A,0,A.length-1);
    }

    public TreeNode sortedArrayToBSTOverloaded(final int[] A, int startIndex, int endIndex){
        if(startIndex <= endIndex){
            int mid = (startIndex+endIndex)/2;
            TreeNode treeNode = new TreeNode(A[mid]);
            treeNode.left = sortedArrayToBSTOverloaded(A,startIndex,mid-1);
            treeNode.right = sortedArrayToBSTOverloaded(A,mid+1, endIndex);
            return treeNode;
        }
        return null;
    }
}

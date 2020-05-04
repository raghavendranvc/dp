package com.my.trees;

public class InPreOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] A, int[] B) {
        return buildTree( A, 0, A.length-1,   B, 0, B.length-1);
    }

    public TreeNode buildTree(int[] A, int startPre, int endPre, int[] B, int startIn, int endIn) {
        if(startIn > endIn || startPre > endPre) {
            return null;
        }

        int root = A[startPre];

        int rootIndexInInOrder = startIn;
        while(B[rootIndexInInOrder] != root){
            rootIndexInInOrder++;
        }

        /*

        length = rootIndexInInOrder-startIn-1
                  si          r           se
         0    1   2   3   4   5   6   7   8   9   10

                  length = r-si = 5-2 = 3
                  Endindex = 2+3-1

         */

        int length =  rootIndexInInOrder-startIn;

        TreeNode treeNode = new TreeNode(root);
        treeNode.left =  buildTree(A,  startPre+1, startPre+1+length -1,  B,  startIn,  rootIndexInInOrder-1);
        treeNode.right =  buildTree(A,  startPre+length+1, endPre,  B,  rootIndexInInOrder+1,  endIn);

        return treeNode;
    }
}

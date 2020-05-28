package com.my.trees;

public class InorderPostOrderToBT {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    /*
        Inorder : [2, 1, 3] left, root, right
        Postorder : [2, 3, 1] left,right, root
     */

    public TreeNode buildTree(int[] A, int[] B) {
        return buildTree(A,0,A.length-1, B, 0, B.length-1);
    }

    public TreeNode buildTree(int[] A, int startIn, int endIn, int[] B, int startPost,int endPost) {

        if(startIn > endIn || startPost > endPost) {
            return null;
        }

        /*if(startIn == endIn) {
            return new TreeNode(A[startIn]);
        }*/

        int root = B[endPost];

        int rootIndexInInOrder = startIn;
        while(A[rootIndexInInOrder] != root){
            rootIndexInInOrder++;
        }
        // startIn                  rootIndexInInOrder                        endIn
        // 0        1   2   3   4   5(root)                 6   7   8   9       10
        // 0        1   2   3   4   6                       7   8   9   10      5

        /*
                          si              r               se
          0   1   2   3   4   5   6   7   8   9   10  11  12  13  14
          length = root - si = 8-4 = 4
          NewPostIn = PostIn + length -1 =   Assuming postIn = startIn = 4 + 4 -1 = 7
                    = PostIn + root - si -1
         */

        int leftSubTreeLength = rootIndexInInOrder-startIn; //6 //TODO recheck this

        TreeNode treeNode = new TreeNode(root);
        treeNode.left = buildTree(A,startIn,rootIndexInInOrder-1,B, startPost, startPost+leftSubTreeLength-1);
        treeNode.right = buildTree(A, rootIndexInInOrder+1, endIn, B, startPost+leftSubTreeLength, endPost-1);
        return treeNode;
    }

}

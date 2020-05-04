package com.my.trees;

public class MinDepthOfBT {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode A) {
        minDepth(A, 0);
        return minDepth;
    }

    public void minDepth(TreeNode A, int depth) {
        if(A == null){
            return;
        }

        if(A.left == null && A.right == null){
            minDepth = Math.min(minDepth,depth+1);
        }

        minDepth(A.left,depth+1);
        minDepth(A.right, depth+1);
    }

    /**
     *
     *
     * @param A
     * @return
     */
    //TODO practice below solution.

    public int minDepthReharse(TreeNode A) {
        if(A==null) {
            return 0;
        }
        return minDepthReharse(A,0);
    }

    public int minDepthReharse(TreeNode A, int depth) {
        if(A == null){
            return Integer.MAX_VALUE; //Check this. Very important
        }
        if(A.left == null && A.right == null){
            return depth+1;
        }
        return Math.min(minDepthReharse(A.left,depth+1),minDepthReharse(A.right,depth+1));
    }
}

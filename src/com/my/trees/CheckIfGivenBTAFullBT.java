package com.my.trees;

public class CheckIfGivenBTAFullBT {
	
	class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
	
	boolean checkT(TreeNode node) {
		if(node == null) {
			return true;
		}
		
		if(node.left == null && node.right == null) {
			return true;
		}
		
		if(node.left == null || node.right == null) {
			return false;
		}
		
		return checkT(node.left) && checkT(node.right);
		
	}

}
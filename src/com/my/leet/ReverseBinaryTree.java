package com.my.leet;


public class ReverseBinaryTree {
	
	/*
	 * Input: [1,2,3,4,5]
    1
   / \
  2   3
 / \
4   5
Output: return the root of the binary tree [4,5,2,#,#,3,1]
   4
  / \
 5   2
    / \
   3   1
	 */
	
	class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
	
	//TODO practice again
	public TreeNode reverseTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		TreeNode previousRight = null;
		TreeNode previous = null;
		
		TreeNode current = root;
		while(current != null) {
			TreeNode next = current.left;
			current.left = previousRight;
			previousRight = current.right;
			current.right = previous;
			previous = current;
			current = next; 
		}
		
		return previous;
	}
	
	

}

package com.my.dp;


public class LargestIndependentSubsetOfBST {

	static class Node{
		int value;
		Node left;
		Node right;
		Node(int val){
			this.value = val;
		}
	}
	
	public int getLargestISubSetOfBST(Node root){
		if(root == null){
			return 0;
		}
		
		int childSubSet = getLargestISubSetOfBST(root.left) + getLargestISubSetOfBST(root.right);
		int rootSubset = 1
				+ ((root.left == null)? 0: getLargestISubSetOfBST(root.left.left) + getLargestISubSetOfBST(root.left.right)) 
				+ ((root.right == null)? 0: getLargestISubSetOfBST(root.right.left) + getLargestISubSetOfBST(root.right.right));
		
		return Math.max(childSubSet, rootSubset);
		
	}
	
	static class LisNode{
		int value;
		int lisVal = -1;
		LisNode left;
		LisNode right;
		LisNode(int val){
			this.value = val;
		}
		
	}
	
	public int getLargestISubSetOfBST(LisNode root){
		
		if(root == null){
			return 0;
		}
		
		if(root.lisVal != -1){
			return root.lisVal;
		}
		
		/*if(root.left == null && root.right == null){
			root.lisVal = 1;
			return root.lisVal;
		}*/
		
		
		int childSubSet = getLargestISubSetOfBST(root.left) + getLargestISubSetOfBST(root.right);
		int rootSubset = 1
				+ ((root.left == null)? 0: getLargestISubSetOfBST(root.left.left) + getLargestISubSetOfBST(root.left.right)) 
				+ ((root.right == null)? 0: getLargestISubSetOfBST(root.right.left) + getLargestISubSetOfBST(root.right.right));
		
		root.lisVal = Math.max(childSubSet, rootSubset);
		return root.lisVal;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 *          20
		 *      8          22
		 *   4    12            25
		 *      10   14
		 */
		Node root         		= new Node(20);               
	    root.left               = new Node(8);
	    root.left.left          = new Node(4);
	    root.left.right         = new Node(12);
	    root.left.right.left   	= new Node(10);
	    root.left.right.right  	= new Node(14);
	    root.right              = new Node(22);
	    root.right.right        = new Node(25);
	    
	    LargestIndependentSubsetOfBST lsb = new LargestIndependentSubsetOfBST();
	    int val1 = lsb.getLargestISubSetOfBST(root);
	    System.out.println("val1="+val1);
	    
	    LisNode root1         	= new LisNode(20);               
	    root1.left              = new LisNode(8);
	    root1.left.left         = new LisNode(4);
	    root1.left.right        = new LisNode(12);
	    root1.left.right.left   = new LisNode(10);
	    root1.left.right.right  = new LisNode(14);
	    root1.right             = new LisNode(22);
	    root1.right.right       = new LisNode(25);
	    
	    int val2 = lsb.getLargestISubSetOfBST(root);
	    System.out.println("val2="+val2);

	}

}

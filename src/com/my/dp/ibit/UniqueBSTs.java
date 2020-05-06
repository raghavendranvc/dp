package com.my.dp.ibit;

import java.util.ArrayList;

public class UniqueBSTs {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public ArrayList<TreeNode> generateTrees(int a) {
		if(a == 0) {
			return new ArrayList<>();
		}
		return generateTrees(1,a);
    }
	
	public ArrayList<TreeNode> generateTrees(int left, int right){
		
		ArrayList<TreeNode> currentList = new ArrayList<>();
		
		if(left > right) {
			currentList.add(null); // for end nodes
		}
		
		for(int i=left;i<=right;i++) {
			ArrayList<TreeNode> leftSubTree = generateTrees(left,i-1); //first iteration of (left,left-1) is to prepare the null node?
			ArrayList<TreeNode> rightSubTree = generateTrees(i+1,right); //last iteration of (right+1, right) is to prepare the null node?
			
			//We got all left and right sub tress possible. We now will need to prepare all Trees from these lists
			
			for(int j=0;j< leftSubTree.size(); j++) { //We could also choose right sub tree first
				TreeNode leftNode = leftSubTree.get(j);
				for(int k=0;k<rightSubTree.size(); k++) {
					TreeNode rightNode = rightSubTree.get(k);
					
					TreeNode rootNode = new TreeNode(i);
					rootNode.left = leftNode;
					rootNode.right = rightNode;
					currentList.add(rootNode);
				}
			}
		}
		return currentList;
	}
}

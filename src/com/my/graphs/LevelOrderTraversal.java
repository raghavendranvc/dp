package com.my.graphs;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(A == null) {
			return result;
		}
		
		ArrayList<TreeNode> currentList = new ArrayList<>();
		currentList.add(A);
		
		while(!currentList.isEmpty()) {
			
			addToResult(currentList, result);
				
			List<TreeNode> nextList = new ArrayList<TreeNode>();
			for(TreeNode t : currentList) {
				if(t.left!= null) {
					nextList.add(t.left);
				}
				if(t.right != null) {
					nextList.add(t.right);
				}
			}
			currentList.clear();
			currentList.addAll(nextList);
		}
		return result;
	}
	
	private void addToResult(ArrayList<TreeNode> currentList, ArrayList<ArrayList<Integer>> result) {
		
		//ArrayList<Integer> list = new ArrayList<>(currentList.stream().map( t -> t.val).collect(Collectors.toList()));
		//currentList.stream().map(t -> t.val).collect(Collectors.toList());
		ArrayList<Integer> list = new ArrayList<>(); //list is primarly to add to result
		for(TreeNode t : currentList) {
			list.add(t.val);
		}
		
		result.add(list); 
	}

}

package com.my.leet.medium.graphs;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
	//https://www.programcreek.com/2014/07/leetcode-find-leaves-of-binary-tree-java/
	/*
	 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree


          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].
	 */
	
	/*
	 * The key to solve this problem is converting the problem to be finding the index of the element in the result list. Then this is a typical DFS problem on trees.
	 */
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		Integer val;
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, root);
	    return result;
	}
	 
	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, TreeNode root){
	    if(root==null)
	        return -1; //Key idea is this value. For leaves, height is 0.
	 
	    int left = helper(list, root.left);
	    int right = helper(list, root.right);
	    
	    int curr = Math.max(left, right)+1; //constructing height from bottom up.
	 
	    // the first time this code is reached is when curr==0,
	    //since the tree is bottom-up processed.
	    if(list.size()<=curr){
	        list.add(new ArrayList<Integer>());
	    }
	 
	    list.get(curr).add(root.val);
	 
	    return curr;
	}

}

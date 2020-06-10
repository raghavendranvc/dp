package com.my.leet.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerElementsAndSelf {
	
	class Node{
		int val;
		Node left;
		Node right;
		
		int frequency;
		int numOfLefts;
		
		Node (int val){
			this.val = val;
		}
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length==0) {
			return result;
		}
		
		int n = nums.length-1;
		
		Node root = new Node(nums[n-1]);
		root.frequency++;
		
		for(int i=n-2; i>=0;i--) {
			result.add(insertNodeAndGetSmallerCount(root,nums[i]));
		}
		
		Collections.reverse(result);
		return result;
		
	}
	
	private int insertNodeAndGetSmallerCount(Node root, int num) {
		int smallElements = 0;
		
		while(root != null) {
			if(root.val == num) {
				root.frequency++;
				smallElements += root.numOfLefts;
				return smallElements;
			}
			
			if(root.val < num) {
				smallElements += root.numOfLefts+root.frequency;
				if(root.right == null) {
					Node newNode = new Node(num);
					newNode.frequency++;
					root.right = newNode;
					return smallElements; 
					//Note that we are not storing smallElement.  
					//We are only storing the size of the left subtree
					//We can get the smallerElement count while insertion
				} else {
					root = root.right;
				}
			}
			
			if(root.val > num) {
				root.numOfLefts++;
				if(root.left == null) {
					Node newNode = new Node(num);
					newNode.frequency++;
					root.left = newNode;
					return smallElements; 
				} else {
					root = root.left;
				}
			}
		}
		return smallElements;
		
	}
}

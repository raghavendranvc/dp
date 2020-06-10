package com.my.leet.medium.notdone;

import java.util.List;

import com.my.leet.medium.notdone.NestedListWeightSum2BottomUp.NestedInteger;

public class NestedListWeightSumTopDown {
	// https://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/

	/*
	 * Given a nested list of integers, return the sum of all integers in the list
	 * weighted by their depth.
	 * 
	 * Each element is either an integer, or a list -- whose elements may also be
	 * integers or other lists.
	 * 
	 * 
	 * Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2,
	 * one 2 at depth 1)
	 * 
	 * Java Solution 1 - Recursive
	 */
	
	public interface NestedInteger {
	      // Constructor initializes an empty nested list.
	      
		 //public NestedInteger(){};
		
	      // Constructor initializes a single integer.
	      //public NestedInteger(int value) {};
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	
	      // Set this NestedInteger to hold a single integer.
	      public void setInteger(int value);
	 
	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	      public void add(NestedInteger ni);
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	
	public int depthSum(List<NestedInteger> nestedList) {
	    return helper(nestedList, 1);
	}
	 
	public int helper(List<NestedInteger> nestedList, int depth){
	    if(nestedList==null||nestedList.size()==0)
	        return 0;
	 
	    int sum=0;
	    for(NestedInteger ni: nestedList){
	        if(ni.isInteger()){
	            sum += ni.getInteger() * depth;
	        }else{
	            sum += helper(ni.getList(), depth+1);
	        }
	    }
	 
	    return sum;
	}

}

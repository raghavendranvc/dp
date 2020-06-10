package com.my.leet.medium.notdone;

import java.util.List;

public class NestedListWeightSum2BottomUp {
	
	//http://buttercola.blogspot.com/2018/09/leetcode-364-nested-list-weight-sum-ii.html
	//https://www.programcreek.com/2014/08/leetcode-nested-list-weight-sum-ii-java/#:~:text=LeetCode%20%E2%80%93%20Nested%20List%20Weight%20Sum%20II%20(Java),be%20integers%20or%20other%20lists.

	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
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
	 
	class Solution {
	    private int maxDepth = 0;
	    public int depthSumInverse(List<NestedInteger> nestedList) {
	        if (nestedList == null || nestedList.size() == 0) {
	            return 0;
	        }
	         
	        getDepth(1, nestedList);
	         
	        return depthSumHelper(maxDepth, nestedList);
	    }
	     
	    private void getDepth(int level, List<NestedInteger> nestedList) {
	        maxDepth = Math.max(maxDepth, level);
	        for (NestedInteger n : nestedList) {
	            if (!n.isInteger()) {
	                getDepth(level + 1, n.getList());
	            }
	        }
	    }
	     
	    private int depthSumHelper(int depth, List<NestedInteger> nestedList) {
	        int sum = 0;
	        for (NestedInteger n : nestedList) {
	            if (n.isInteger()) {
	                sum += depth * n.getInteger();
	            } else {
	                sum += depthSumHelper(depth - 1, n.getList());
	            }
	        }
	         
	        return sum;
	    }
	}
}

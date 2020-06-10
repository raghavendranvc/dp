package com.my.leet.medium.notdone;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedList {
	// https://leetcode.com/problems/flatten-nested-list-iterator/

	/**
	 * // This is the interface that allows for creating nested lists. // You should
	 * not implement it, or speculate about its implementation
	 */
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer // Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list // Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	/*
	 * Given a nested list of integers, implement an iterator to flatten it.
	 * 
	 * Each element is either an integer, or a list -- whose elements may also be
	 * integers or other lists.
	 * 
	 * Example 1:
	 * 
	 * Input: [[1,1],2,[1,1]] Output: [1,1,2,1,1] Explanation: By calling next
	 * repeatedly until hasNext returns false, the order of elements returned by
	 * next should be: [1,1,2,1,1]. Example 2:
	 * 
	 * Input: [1,[4,[6]]] Output: [1,4,6] Explanation: By calling next repeatedly
	 * until hasNext returns false, the order of elements returned by next should
	 * be: [1,4,6].
	 */
	public class NestedIterator implements Iterator<Integer> {

		// https://www.programcreek.com/2014/05/leetcode-flatten-nested-list-iterator-java/

		public NestedIterator(List<NestedInteger> nestedList) {

		}

		@Override
		public Integer next() {
			return null;
		}

		@Override
		public boolean hasNext() {
			return false;
		}
	}

	public class NestedIteratorCopied implements Iterator<Integer> {
		Stack<NestedInteger> stack = new Stack<NestedInteger>();

		public NestedIteratorCopied(List<NestedInteger> nestedList) {
			if (nestedList == null)
				return;

			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}

		@Override
		public Integer next() {
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty()) {
				NestedInteger top = stack.peek();
				if (top.isInteger()) {
					return true;
				} else {
					stack.pop();
					for (int i = top.getList().size() - 1; i >= 0; i--) {
						stack.push(top.getList().get(i));
					}
				}
			}

			return false;
		}
	}

}

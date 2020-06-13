package com.my.leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiniParserForNestedInteger {

	public class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger() {
		};

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
		};

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger() {
			return false;
		}

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return -1;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
		};

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni) {
		};

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return new ArrayList<NestedInteger>();
		}
	}

	public NestedInteger deserialize(String s) {
		Stack<NestedInteger> stack = new Stack<>();
		boolean inNum = false;
		int sign = 1;
		int curr = 0;
		NestedInteger currInt = null;
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				inNum = true;
				curr = curr * 10 + (c - '0');
			} else if (c == ',') {
				if (inNum) {
					if (currInt == null)
						currInt = new NestedInteger(curr * sign);
					else
						currInt.add(new NestedInteger(curr * sign));
					curr = 0;
					sign = 1;
					inNum = false;
				}
			} else if (c == '[') {
				if (currInt != null) {
					stack.push(currInt);
				}
				currInt = new NestedInteger();
			} else if (c == ']') {
				if (inNum) {
					currInt.add(new NestedInteger(curr * sign));
					curr = 0;
					inNum = false;
					sign = 1;
				}
				if (stack.size() > 0) {
					NestedInteger last = stack.pop();
					last.add(currInt);
					currInt = last;
				}
			} else if (c == '-') {
				sign = -1;
			}
		}
		if (currInt == null && inNum)
			currInt = new NestedInteger(curr * sign);
		if (currInt == null)
			currInt = new NestedInteger();

		return currInt;
	}

}

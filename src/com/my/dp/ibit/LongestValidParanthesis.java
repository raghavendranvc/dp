package com.my.dp.ibit;

import java.util.Stack;

public class LongestValidParanthesis {
	//TODO
	public int longestValidParenthesesStack(String A) {
		if (A == null || A.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();

		stack.push(-1); // this is the base index of an empty length string //TODO this is important

		int maxValid = 0;
		for (int i = 0; i < A.length(); i++) {

			if (A.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i); // this will be our new base index for the next part of the string
				} else {
					int length = i - stack.peek();
					maxValid = Math.max(maxValid, length);
				}
			}
		}

		return maxValid;
	}

	//TODO check this logic again
	public int longestValidParentheses(String A) {
		if (A == null || A.length() == 0) {
			return 0;
		}

		int left = 0, right = 0, maxLength = 0;

		// From Left to Right
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				maxLength = Math.max(maxLength, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
		}

		// From Right to Left
		left = 0;
		right = 0;
		for (int i = A.length() - 1; i >= 0; i--) {
			if (A.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				maxLength = Math.max(maxLength, 2 * right);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return maxLength;
	}

}

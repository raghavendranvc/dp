package com.my.fb;

import java.util.Stack;

public class ParanthesisBalanced {

	boolean isBalanced(String s) {
		// Write your code here
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			switch (ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);
				break;

			case ')':
				if (stack.peek() != '(') {
					return false;
				}
				stack.pop();
				break;
			case '}':
				if (stack.peek() != '{') {
					return false;
				}
				stack.pop();
				break;
			case ']':
				if (stack.peek() != ']') {
					return false;
				}
				stack.pop();
				break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;

	}

}

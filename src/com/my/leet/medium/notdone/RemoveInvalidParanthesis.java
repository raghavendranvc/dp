package com.my.leet.medium.notdone;

import java.util.Stack;

public class RemoveInvalidParanthesis {
	// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
	// https://developersinspired.com/2020/03/17/minimum-remove-to-make-valid-parentheses/

	public class OpenBracketWithIndex {
		public int Index;
		public char OpenBracket;

		public OpenBracketWithIndex(int index, char openBracket) {
			Index = index;
			OpenBracket = openBracket;
		}
	}

	public String MinRemoveToMakeValid(String s) {

		StringBuilder sb = new StringBuilder();

		Stack<OpenBracketWithIndex> stack = new Stack<OpenBracketWithIndex>();

		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == '(') {
				sb.append(s.charAt(i));
				stack.push(new OpenBracketWithIndex(sb.length() - 1, s.charAt(i)));
				
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					sb.append(')');
					stack.pop();
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			OpenBracketWithIndex res = stack.pop();
			int index = res.Index;
			sb.delete(index, 1);
		}
		return sb.toString();
	}

}

package com.my.leet.medium;

import java.util.Stack;

public class FindPattern132 {

	boolean find132pattern(int[] nums) {
		int s3 = Integer.MIN_VALUE;

		Stack<Integer> st = new Stack<>();

		for (int i = nums.length - 1; i >= 0; i--) {
			// nums[i] is s1
			// peek of stack contains s2
			// we only need to check for s3 and the condition s1<s3
			if (nums[i] < s3) {
				return true;
			} else {
				// We pop all smaller numbers from stack, because they are
				// candidates for s3
				// We have recorded all the potential s3 numbers in stack
				// nums[i] is the s1/si and each element is the largest
				// s2 is always the top of the stack. 
				// s3 is obtained from the stack which is smaller.
				while (!st.empty() && nums[i] > st.peek()) {
					s3 = st.peek();
					st.pop();
				}
			}
			st.push(nums[i]);
		}
		return false;
	}

}

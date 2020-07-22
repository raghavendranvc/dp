package com.my.leet.medium.arrays;

public class RemoveKDigits {

	// https://codenuclear.com/leetcode-remove-k-digits/

	/*
	 * Given a non-negative integer num represented as a string, remove k digits
	 * from the number so that the new number is the smallest possible.
	 * 
	 * Note: The length of num is less than 10002 and will be ≥ k. The given num
	 * does not contain any leading zero. Example 1:
	 * 
	 * Input: num = “1432219”, k = 3 Output: “1219” Explanation: Remove the three
	 * digits 4, 3, and 2 to form the new number 1219 which is the smallest. Example
	 * 2:
	 * 
	 * Input: num = “10200”, k = 1 Output: “200” Explanation: Remove the leading 1
	 * and the number is 200. Note that the output must not contain leading zeroes.
	 * Example 3:
	 * 
	 * Input: num = “10”, k = 2 Output: “0” Explanation: Remove all the digits from
	 * the number and it is left with nothing which is 0.
	 * 
	 * Here we can use Stack to keep track of the visited characters, Start
	 * iterating number from left and push it to the Stack, We can get minimum
	 * number if current digit is smaller then the previous digit.
	 */

	public String removeKdigits(String num, int k) {

		int digits = num.length() - k;
		char[] stack = new char[num.length()]; // Character arr as Stack
		int topInd = 0;

		for (int i = 0; i < num.length(); ++i) {
			char c = num.charAt(i);
			while (topInd > 0 && stack[topInd - 1] > c && k > 0) {
				topInd -= 1;
				k -= 1;
			}
			stack[topInd++] = c;
		}
		// find the index of first non-zero digit
		int idx = 0;
		while (idx < digits && stack[idx] == '0')
			idx++;
		
		return idx == digits ? "0" : new String(stack, idx, digits - idx);

	}

}

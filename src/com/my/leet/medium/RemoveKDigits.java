package com.my.leet.medium;

public class RemoveKDigits {

	// https://codenuclear.com/leetcode-remove-k-digits/

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

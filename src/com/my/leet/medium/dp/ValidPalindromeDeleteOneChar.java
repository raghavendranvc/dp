package com.my.leet.medium.dp;

public class ValidPalindromeDeleteOneChar {

	public boolean validPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;

		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}

		if (left >= right) {
			return true;
		}

		if (isPalin(s, left + 1, right) || isPalin(s, left, right - 1)) {
			return true;
		}

		return false;
	}

	private boolean isPalin(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				break;
			}
		}

		return left >= right;
	}

}

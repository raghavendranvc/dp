package com.my.strings;

public class MinCharsForPalindrome {

	/*
	 * 
	 * A.length=7 
	 * 0 1 2 3 4 5 6 
	 * B A A B C A B
	 *       4 5 6 7
	 *         f f f
	 *  
	 * We need to insert 3 elements which are number of times we reduced result
	 * So that number will be A.length-result             
	 */

	public int sovle(String A) {

		int result = A.length();

		while (result > 1 && !isPal(A.substring(0, result))) {
			result--; // reduce the length from right and check if there is a match
		}
		return A.length() - result;

	}

	public boolean isPal(String A) {
		int i = 0, j = A.length() - 1;
		while (i < j && A.charAt(i) == A.charAt(j)) {
			i++;
			j--;
		}

		if (i > j) {
			return true;
		} else {
			return false;
		}
	}

	public int solve(String A) {
		if (isPalindrome(A)) {
			return 0;
		}

		for (int i = 1; i <= A.length(); i++) {
			System.out.println("Checking for length=" + i);
			if (isPalindrome(getReverseString(A.substring(A.length() - i).toCharArray()) + A)) {
				return i;
			}
		}
		return -1;
	}

	public String getReverseString(char[] str) {
		for (int i = 0; i < str.length / 2; i++) {
			char ch = str[i];
			str[i] = str[str.length - 1 - i];
			str[str.length - 1 - i] = ch;
		}
		return new String(str);
	}

	public boolean isPalindrome(String s) {
		System.out.println("Checking s=" + s);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "apple";
		MinCharsForPalindrome minCharsForPalindrome = new MinCharsForPalindrome();
		System.out.println("min Chars required=" + minCharsForPalindrome.solve(str));
	}
}

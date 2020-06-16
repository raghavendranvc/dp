package com.my.backtracking;

import java.util.ArrayList;

public class LetterPhone {

	String[] phoneArray = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public ArrayList<String> letterCombinations(String A) {
		ArrayList<String> result = new ArrayList<>();
		if (A == null || A.isEmpty()) {
			return result;
		}
		letterCombinations(A.toCharArray(), phoneArray, result, 0, "");
		return result;
	}

	public void letterCombinations(char[] A, String[] phoneArray, ArrayList<String> result, int startIndex,
			String prefix) {
		if (startIndex == A.length) {
			System.out.println("One Answer=" + prefix);
			result.add(prefix);
			return;
		}
		for (char ch : phoneArray[A[startIndex] - '0'].toCharArray()) {
			prefix = prefix + ch;
			letterCombinations(A, phoneArray, result, startIndex + 1, prefix);
			System.out.println("Beefore Removing char=" + prefix + " prefix length=" + prefix.length());
			prefix = prefix.substring(0, prefix.length() - 1);
			System.out.println("After Removing char=" + prefix + " prefix length=" + prefix.length());
		}
	}

	public static void main(String[] args) {
		String A = "23";
		LetterPhone letterPhone = new LetterPhone();
		System.out.println("Result=" + letterPhone.letterCombinations(A));
	}

	public void printAllTelephonicWords(int number) {
		String[] alphbhets = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
		int[] d = getNumberOfDigits(number);

		printAllTelehonicWordsRecur(alphbhets, d, d.length, new char[d.length]);
	}

	private void printAllTelehonicWordsRecur(String[] alphbhets, int[] digits, int currLength, char[] word) {
		if (currLength == 0) {
			System.out.println(new String(word));
			return;
		}
		int digit = digits[digits.length - currLength];
		String digitChars = alphbhets[digit];

		for (int i = 0; i < digitChars.length(); i++) {
			word[digits.length - currLength] = digitChars.charAt(i);
			printAllTelehonicWordsRecur(alphbhets, digits, currLength - 1, word);
		}
	}

	public int[] getNumberOfDigits(int number) {
		int tmp = number;
		int count = 0;
		while (tmp > 0) {
			count++;
			tmp = tmp / 10;
		}
		int[] digits = new int[count];

		/*
		 * count--; while(count>-1){ digits[count] = (int)(number/Math.pow(10, count));
		 * count--; }
		 */

		count--;
		int i = 0;
		while (i <= count) {
			digits[count - i] = number % 10;
			number = number / 10;
			i++;
		}

//		UtilityClass.print(digits);

		return digits;
	}

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		LetterPhone tw = new LetterPhone();
		tw.printAllTelephonicWords(92400);

	}
}

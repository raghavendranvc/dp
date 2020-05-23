package com.my.dp;

public class LongestCommonSubsquenceString {
	
	/********************One way********************************************/

	public String getLongestCommonSubSequenceStringRecur(char[] a, char[] b, int i, int j) {
		if (i < 0 || j < 0) {
			return "";
		}

		if (a[i] == b[j]) {
			return getLongestCommonSubSequenceStringRecur(a, b, i - 1, j - 1) + a[i];
		} else {
			String str1 = getLongestCommonSubSequenceStringRecur(a, b, i - 1, j);
			String str2 = getLongestCommonSubSequenceStringRecur(a, b, i, j - 1);
			return ((str1.length() >= str2.length()) ? str1 : str2);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1 = "ABCDABBA";
		String str2 = "AAABBCABA";

		/*
		 * String str1 = "AAAAA"; String str2 = "BBBBBBBB";
		 */

		/*
		 * String str1 = "BAABAABA"; String str2 = "BBBAABAAAA";
		 */

		LongestCommonSubsquenceString lcs = new LongestCommonSubsquenceString();

		
		String lcsString = lcs.getLongestCommonSubSequenceStringRecur(str1.toCharArray(), str2.toCharArray(),
				str1.length() - 1, str2.length() - 1);
		System.out.println("LCSString=" + lcsString);

	}

}

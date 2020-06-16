package com.my.strings;

public class StrStr {

	//TODO
	
	/**
	 * 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 8 9 10
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public int strStr(final String A, final String B) {
		if (A.length() == 0 || B.length() == 0 || A.length() < B.length()) {
			return -1;
		}

		if (A.equals(B)) {
			return 1;
		}

		for (int i = 0; i < A.length() - B.length(); i++) {
			if (A.substring(i, i + B.length()).equals(B)) {
				return i;
			}
		}

		return -1;
	}

	public int strStrCopied(final String A, final String B) { //KMP Algorithm

		if (null == A || A.length() == 0 || null == B || B.length() == 0 || (A.length() < B.length())) {
			return -1;
		}

		int n = B.length();
		int[] lps = new int[n];

		int i = 1;
		int j = 0;
		lps[0] = 0;

		while (i < n) {
			if (B.charAt(i) == B.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else {
				if ((j - 1) >= 0) {
					j = lps[j - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}

		n = A.length();

		i = 0;
		j = 0;
		while (i < n) {
			if (A.charAt(i) == B.charAt(j)) {
				i++;
				j++;
				if (j == B.length()) {
					return (i - j);
				}
			} else {
				if (j - 1 >= 0) {
					j = lps[j - 1];
				} else {
					j = 0;
					i++;
				}
			}
			// System.out.println(i + ":" + j);
		}

		return -1;
	}
}

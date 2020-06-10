package com.my.dp.ibit;

public class ScrambleString {

	/*
	 * Given two strings s1 and s2 of the same length, determine if s2 is a
	 * scrambled string of s1.
	 */

	// TODO below is copied. Check the recursion logic.
	// We split the strings 1 and 2 at every place (say i, i=1 to n-1)
	// We compare the 4 parts if they are equal
	// 1 = a+b
	// 2 = c+d we will compare (a,c) & (b,d) also (a,d) and (b,c) here equal length
	// are assumed.
	// But it could be different

	public boolean isScramble(String s1, String s2) {
		if ((s1 == null && s2 != null) || (s1 != null && s2 == null))
			return false;
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		int length = s1.length();
		int chars1 = 0;
		int chars2 = 0;

		// check if two strings consists of the same characters
		for (int i = 0; i < length; i++) {
			chars1 += Character.getNumericValue(s1.charAt(i));
			chars2 += Character.getNumericValue(s2.charAt(i));
		}
		if (chars1 != chars2)
			return false;

		if (s1.length() == 1)
			return true;
		// the string must be swapped at certain position assume s2 is a scramble string
		// iterate through all positions and recursively check
		for (int i = 1; i < length; i++) {
			// Partition at each position i and check both sides

			/*
			 * String s1LeftFront = s1.substring(0, i); String s1RightFront =
			 * s1.substring(i);
			 * 
			 * String s2LeftFront = s2.substring(0,i); String s2RightFront =
			 * s2.substring(i);
			 * 
			 * String s2LeftEnd = s2.substring(length-i); String s2RightEnd =
			 * s2.substring(0,length-i);
			 * 
			 * //1. isScramble(s1LeftFront, s2LeftFront) && isScramble(s1RightFront,
			 * s2RightFront)); //2. isScramble(s1LeftFront,s2LeftEnd) &&
			 * isScramble(s1RightFront,s2LeftEnd);
			 * 
			 */

			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
				return true;
			// if the string is reversed, the reversed one is also a scramble string
			if (isScramble(s1.substring(0, i), s2.substring(length - i))
					&& isScramble(s1.substring(i), s2.substring(0, length - i)))
				return true;
		}
		return false;
	}

	public boolean isScrambleDP(String s1, String s2) {
		// Check lengths.
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		int L = s1.length();
		boolean[][][] scramble = new boolean[L][L][L];
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++)
				if (s1.charAt(i) == s2.charAt(j))
					scramble[0][i][j] = true;
		}

		for (int k = 2; k <= L; k++) {
			for (int i = L - k; i >= 0; i--) {
				for (int j = L - k; j >= 0; j--) {
					boolean canScramble = false;
					for (int m = 1; m < k; m++) {
						canScramble = (scramble[m - 1][i][j] && scramble[k - m - 1][i + m][j + m])
								|| (scramble[m - 1][i][j + k - m] && scramble[k - m - 1][i + m][j]);
						if (canScramble)
							break;
					}
					scramble[k - 1][i][j] = canScramble;
				}
			}
		}

		return scramble[L - 1][0][0];
	}

}

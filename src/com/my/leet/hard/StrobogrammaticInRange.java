package com.my.leet.hard;

public class StrobogrammaticInRange {

	/*
	 * A strobogrammatic number is a number that looks the same when rotated 180
	 * degrees (looked at upside down). Write a function to count the total
	 * strobogrammatic numbers that exist in the range of low <= num <= high.
	 * 
	 * For example, Given low = "50", high = "100", return 3. Because 69, 88, and 96
	 * are three strobogrammatic numbers. Note: Because the range might be a large
	 * number, the low and high numbers are represented as string. Tips: Construct
	 * char array from lenLow to lenHigh and increase count when s is between low
	 * and high. Add the stro pairs from outside to inside until left > right.
	 */

	char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };
	int count = 0;

	// strobogrammaticInRange("50","100")

	public int strobogrammaticInRange(String low, String high) {
		for (int len = low.length(); len <= high.length(); len++) {
			dfs(low, high, new char[len], 0, len - 1);
		}
		return count;
	}

	public void dfs(String low, String high, char[] c, int left, int right) {

		if (left > right) {// Termination condition
			String s = new String(c);

			if ((s.length() == low.length() && s.compareTo(low) < 0)
					|| (s.length() == high.length() && s.compareTo(high) > 0)) {
				return;
			}

			count++;
			return;
		}

		for (char[] p : pairs) {

			c[left] = p[0];
			c[right] = p[1];

			// For non-single digits, first char cannot be '0'
			if (c.length != 1 && c[0] == '0')
				continue;

			if (left < right || left == right && p[0] == p[1]) {
				dfs(low, high, c, left + 1, right - 1);
			}
		}
	}

}

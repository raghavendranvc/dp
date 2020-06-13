package com.my.leet.medium;

public class NthDigit {

	/*
	 * number range: # of digits in total
	 * 
	 * 1 - 9 : 9
	 * 
	 * 10 - 99 : 90 * 2
	 * 
	 * 100 - 999 : 900 * 3
	 * 
	 * 1000 - 9999 : 9000 * 4
	 *
	 * For example given n is 1000, we first -9 and then -180. The left is 811. The
	 * number is 100+810/3=370. The digit is 0th (810%3). Therefore, the digit is 3.
	 */

	public int findNthDigit(int m) {
		long n = m; // convert int to long
		long start = 1, len = 1, count = 9;

		while (n > len * count) {
			n = n - len * count;
			len++;
			count = count * 10;
			start = start * 10;
		}

		// identify the number
		start = start + (n - 1) / len;

		// identify the digit
		return String.valueOf(start).charAt((int) ((n - 1) % len)) - '0';
	}

}

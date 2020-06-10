package com.my.leet.medium.notdone;

import java.util.HashMap;

public class FractionToDecimal {
	// https://leetcode.com/problems/fraction-to-recurring-decimal/
	// https://leetcode.com/problems/fraction-to-recurring-decimal/
	// https://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
	/*
	 * Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2,
	 * denominator = 1, return "2". Given numerator = 2, denominator = 3, return
	 * "0.(6)".
	 */

	public String fractionToDecimal(int numerator, int denominator) {

		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";

		String result = "";

		// is result is negative. One amoing them is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}

		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);

		// quotient
		long res = num / den;
		result += String.valueOf(res);

		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;

		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			map.put(remainder, result.length()); // store starting point of this remainder
			
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
			// because we are dealing with stuff beyond decimal place
		}

		return result;
	}

}

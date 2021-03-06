package com.my.leet.easy;

public class ConvertToHex {

	// https://leetcode.com/problems/convert-a-number-to-hexadecimal/

	// http://sumocode.blogspot.com/2016/10/convert-number-to-hexadecimal.html

	public String toHex(int num) {
		char[] map = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		if (num == 0)
			return "0";

		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(map[(num & 15)]);
			num >>>= 4;
		}
		return sb.reverse().toString();
	}

}

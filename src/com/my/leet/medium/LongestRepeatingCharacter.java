package com.my.leet.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {

	/*
	 * The basic idea is to iterate all substring which could satisfy the condition.
	 * That is, the substring would become repeating character string if k
	 * characters were replaced. If we have count of all substring characters, we
	 * know that the maximum number of characters to be replaced = the total number
	 * of characters - the max number of any single letter. It would takes O (n^2 *
	 * k) time.
	 * 
	 * We can improve the performance. Notice that if substring(i, j) is a repeating
	 * character string and substring(i, j+1) is not, then all substring(i, j+n)
	 * will not be a repeating character as well. So we have to increase the i to
	 * have another repeating character substring. It is actual a slide window and
	 * takes O(n*k) time.
	 */

	// Sliding window chars/Total Chars = k + MaxRepeatedChar

	int getCount(Map<Character, Integer> m, int k) {

		int maxVal = 0;
		int total = 0;

		for (Character c : m.keySet()) {
			total += m.get(c);
			maxVal = Math.max(maxVal, m.get(c));
		}

		if (total - maxVal > k)
			return -1;

		return total; // total = k + maxVal (we will need to find this window)
	}

	public int characterReplacement(String s, int k) {
		int result = 0;
		int i = 0; //lower part of window
		int j = 0; //upper part of window

		Map<Character, Integer> m = new HashMap<>();
		while (j < s.length()) {
			m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
			
			int count = getCount(m, k);
			// if not satisfied, shrink the windows by increasing i

			if (count > 0) {//count != -1
				result = Math.max(result, count);
				j++;
				continue;
			}

			//loop until we get count is not -1
			// if (count < 0) { 
			while (i < j && count < 0) {// count == -1
				m.put(s.charAt(i), m.get(s.charAt(i)) - 1);
				count = getCount(m, k);
				i++;
			}
		}

		return result;
	}

}

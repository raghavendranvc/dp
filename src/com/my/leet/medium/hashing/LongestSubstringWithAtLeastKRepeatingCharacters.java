package com.my.leet.medium.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
	// https://www.programcreek.com/2014/09/leetcode-longest-substring-with-at-least-k-repeating-characters-java/

	/*
	 * This problem can be solved using DFS. When all chars in the input string
	 * occurs >=k, return the length. But we first need to split the input string by
	 * using the characters whose occurrence < k.
	 */

	public int longestSubstring(String s, int k) {
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			if (counter.containsKey(c)) {
				counter.put(c, counter.get(c) + 1);
			} else {
				counter.put(c, 1);
			}

		}

		HashSet<Character> splitSet = new HashSet<Character>();
		for (char c : counter.keySet()) {
			if (counter.get(c) < k) {
				splitSet.add(c);
			} 
		}

		if (splitSet.isEmpty()) {
			return s.length();
		}

		int max = 0;
		int i = 0, j = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (splitSet.contains(c)) {
				if (j != i) {
					max = Math.max(max, longestSubstring(s.substring(i, j), k));
				}
				i = j + 1;
			}
			j++;
		}

		if (i != j)
			max = Math.max(max, longestSubstring(s.substring(i, j), k));

		return max;
	}

}

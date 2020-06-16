package com.my.leet.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak2AllSentences {

	// https://leetcode.com/problems/word-break-ii/

	/*
	 * Given a non-empty string s and a dictionary wordDict containing a list of
	 * non-empty words, add spaces in s to construct a sentence where each word is a
	 * valid dictionary word. Return all such possible sentences.
	 * 
	 * Note:
	 * 
	 * The same word in the dictionary may be reused multiple times in the
	 * segmentation. You may assume the dictionary does not contain duplicate words.
	 * Example 1:
	 * 
	 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
	 * Output: [ "cats and dog", "cat sand dog" ] Example 2:
	 * 
	 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
	 * "pine", "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple",
	 * "pine applepen apple" ] Explanation: Note that you are allowed to reuse a
	 * dictionary word. Example 3:
	 * 
	 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
	 * Output: []
	 */

	public List<String> wordBreak(String s, Set<String> wordDict) {

		ArrayList<String>[] pos = new ArrayList[s.length() + 1];

		pos[0] = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) { // n^2 Operation
			if (pos[i] == null) {
				continue;
			}
			
			for (int j = i + 1; j <= s.length(); j++) { // j is the end word position
				String sub = s.substring(i, j);
				if (wordDict.contains(sub)) { //Each substring starting at i
					if (pos[j] == null) {
						ArrayList<String> list = new ArrayList<String>();
						list.add(sub);
						pos[j] = list;
					} else {
						pos[j].add(sub);
					}

				}
			}
		}

		if (pos[s.length()] == null) {
			return new ArrayList<String>();
		} else {
			ArrayList<String> result = new ArrayList<String>();
			dfs(pos, result, "", s.length());
			return result;
		}
	}

	public void dfs(ArrayList<String>[] pos, ArrayList<String> result, String curr, int lastIndex) {
		if (lastIndex == 0) {
			result.add(curr.trim());
			return;
		}

		for (String s : pos[lastIndex]) {
			dfs(pos, result, s + " " + curr, lastIndex - s.length());
		}
	}

}

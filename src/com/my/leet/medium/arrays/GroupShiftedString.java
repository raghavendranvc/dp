package com.my.leet.medium.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedString {
	// https://www.geeksforgeeks.org/group-shifted-string/
	/*
	 * Given an array of strings (all lowercase letters), the task is to group them
	 * in such a way that all strings in a group are shifted versions of each other.
	 * Two string S and T are called shifted if,
	 * 
	 * S.length = T.length and S[i] = T[i] + K for 1 <= i <= S.length for a constant
	 * integer K For example strings {acd, dfg, wyz, yab, mop} are shifted versions
	 * of each other.
	 * 
	 * Input : str[] = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x",
	 * "moqs"};
	 * 
	 * Output : a x acd dfg wyz yab mop bdfh moqs All shifted strings are grouped
	 * together.
	 */
	int ALPHA = 26;

	String getDiffString(String str) {
		String shift = "";
		for (int i = 1; i < str.length(); i++) {
			int dif = str.charAt(i) - str.charAt(i - 1);
			if (dif < 0)
				dif += ALPHA;

			// Representing the difference as char
			shift += (dif + 'a');
		}

		// This string will be 1 less length than str
		return shift;
	}

	// Method for grouping shifted string
	void groupShiftedString(String str[], int n) {
		// map for storing indices of string which are
		// in same group
		Map<String, List<Integer>> groupMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String diffStr = getDiffString(str[i]);
			groupMap.get(diffStr).add(i);
		}

	}
}

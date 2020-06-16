package com.my.backtracking;

import java.util.List;

public class StringPermuation {

	// TODO revisit this
	// pairwiseHammingDistance.computePermutation(s, "");

	public void computePermutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String restOfTheString = str.substring(0, i) + str.substring(i + 1);
			computePermutation(restOfTheString, prefix + ch);
		}

	}

	void getPermuation1(String prefix, String s, List<String> result) {
		if (s.isEmpty()) {
			result.add(prefix);
		}

		for (int i = 0; i < s.length(); i++) {
			String currentPrefixChar = s.charAt(i) + "";
			String restOfTheString = s.substring(0, i) + s.substring(i + 1);
			getPermuation1(prefix + currentPrefixChar, restOfTheString, result);
		}
	}
}

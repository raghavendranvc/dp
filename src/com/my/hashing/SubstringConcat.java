package com.my.hashing;

import java.util.*;

public class SubstringConcat {

	public ArrayList<Integer> findSubstringCopied(String A, final List<String> B) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < B.size(); i++) {
			int val = 1;
			if (map.containsKey(B.get(i))) {
				val += map.get(B.get(i));
			}
			map.put(B.get(i), val);
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		int total_len = B.size() * B.get(0).length(); //This is the length of all substrings, we need to find
		int word_len = B.get(0).length();
		
		for (int i = 0; i < A.length() - total_len + 1; i++) {
			HashMap<String, Integer> currMap = new HashMap<>();
			//For each substring of length "total_len"
			// i to i+total_len
			for (int j = i; j < i + total_len; j += word_len) {
				String word = A.substring(j, j + word_len);
				int val = 1;
				if (currMap.containsKey(word)) {
					val += currMap.get(word);
				}
				currMap.put(word, val);
			}
			if (map.equals(currMap)) {
				res.add(i);
			}
		}
		return res;
	}

	public ArrayList<Integer> findSubstring(String A, final List<String> B) {

		// Set<String> subStrings = new HashSet<>(B);
		ArrayList<Integer> result = new ArrayList<>();
		if (B.size() == 0) {
			return result;
		}

		if (A.length() < B.get(0).length()) {
			return result;
		}

		int l = B.get(0).length();
		HashMap<String, Integer> subStringCountMap = getSubStringMap(B);
		System.out.println("subStringCountMap=" + subStringCountMap);

		for (int i = 0; i < A.length(); i++) {
			HashMap<String, Integer> tempSubStringCountMap = (HashMap) subStringCountMap.clone();
			System.out.println("clonedMap=" + tempSubStringCountMap);
			int numberOfSubStrings = B.size();
			int j = i;
			while (j + l <= A.length() && numberOfSubStrings > 0) {

				String checkSubStr = A.substring(j, j + l);
				if (tempSubStringCountMap.containsKey(checkSubStr) && tempSubStringCountMap.get(checkSubStr) > 0) {
					tempSubStringCountMap.put(checkSubStr, tempSubStringCountMap.get(checkSubStr) - 1);
					numberOfSubStrings--;
					System.out.println("matched happened for " + checkSubStr);
				} else {
					break;
				}
				j = j + l;
			}
			if (numberOfSubStrings == 0) {
				result.add(i);
			}
		}
		return result;
	}

	private HashMap<String, Integer> getSubStringMap(final List<String> B) {
		HashMap<String, Integer> subStringCountMap = new HashMap<>();
		for (String s : B) {
			int count = subStringCountMap.getOrDefault(s, 0);
			subStringCountMap.put(s, count + 1);
		}
		return subStringCountMap;
	}

	public static void main(String[] args) {
		String A = "";
		String[] b = {};
		ArrayList<String> B = new ArrayList<>();
		for (String s : b) {
			B.add(s);
		}
		SubstringConcat substringConcat = new SubstringConcat();
		System.out.println("Result=" + substringConcat.findSubstring(A, B));

	}

}

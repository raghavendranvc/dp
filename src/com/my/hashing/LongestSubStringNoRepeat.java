package com.my.hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubStringNoRepeat {

	public int lengthOfLongestSubstring(String A) {
		HashSet<Character> hashSet = new LinkedHashSet<Character>();
		
		int maxCount = 0;
		int start = 0;
		
		for (char c : A.toCharArray()) {
			//pumpuout all characters till you see the repeated character
			while (hashSet.contains(c)) { 
				hashSet.remove(A.charAt(start)); //Insertion Order??? Use LinkedHashSet
				start++;
			}
			hashSet.add(c);
			maxCount = Math.max(maxCount, hashSet.size());
		}

		return maxCount;
	}

	public int lengthOfLongestSubstringBad(String A) {
		int maxLength = Integer.MIN_VALUE;

		int n = A.length();

		for (int i = 0; i < n; i++) { // i is the startIndex

			Set<Character> chars = new HashSet<>();
			chars.add(A.charAt(i));
			for (int j = i + 1; j < n; j++) {
				if (chars.contains(A.charAt(j))) {
					break;
				} else {
					chars.add(A.charAt(j));
				}
			}
			maxLength = Math.max(maxLength, chars.size());
		}
		return maxLength;
	}
}

package com.my.hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LongestSubStringNoRepeat {
	
	//TODO logic is very important. Data structure - LinkedHashSet critical

	public int lengthOfLongestSubstring(String A) {
		HashSet<Character> hashSet = new LinkedHashSet<Character>();
		
		int maxCount = 0;
		int start = 0; // index of first character of the substring
		
		for (char c : A.toCharArray()) {
			//pump out all characters till you see the repeated character 
			// in the original string sequence
			while (hashSet.contains(c)) { 
				hashSet.remove(A.charAt(start)); //Insertion Order??? Use LinkedHashSet
				start++;
			}
			hashSet.add(c);
			maxCount = Math.max(maxCount, hashSet.size());
		}

		return maxCount;
	}
}

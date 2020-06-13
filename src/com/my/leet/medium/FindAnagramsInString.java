package com.my.leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramsInString {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return result;
		}
		if (p.length() > s.length()) {
			return result;
		}
		
		//Prepare map for p 
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int match = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) { 
				map.put(c, map.get(c) - 1); //Reduces the requirement
				if (map.get(c) == 0) { // only when it makes map zero, we have a match
					match++;
				}
			}
			
			
			if (i >= p.length()) { 
				// if the parsing size is at-least p length, we then need to
				// check if the one at i-p,length() has matched and again increment
				// the counts so that we are moving in the sliding window
				c = s.charAt(i - p.length());
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
					if (map.get(c) == 1) {
						match--;
					}
				}
			}
			if (match == map.size()) {
				result.add(i - p.length() + 1);
			}
		}
		return result;
	}
	
	//Normal, default solution

	public List<Integer> findAnagramsNormal(String s, String p) {

		List<Integer> result = new ArrayList<Integer>();
		if (p.length() > s.length())
			return result;

		char[] pArr = p.toCharArray();
		Arrays.sort(pArr); // Sort the char array
		p = new String(pArr);

		for (int i = 0; i <= s.length() - p.length(); i++) {

			String sTemp = s.substring(i, i + p.length());
			char[] sTempArr = sTemp.toCharArray();
			Arrays.sort(sTempArr);
			sTemp = new String(sTempArr);
			if (p.equals(sTemp))
				result.add(i);
		}
		return result;
	}
}

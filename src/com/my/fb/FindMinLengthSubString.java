package com.my.fb;

import java.util.HashMap;
import java.util.Map;

public class FindMinLengthSubString {
	
	//TODO Remeber the logic written here

	int minLengthSubstring(String s, String t) {
		// Write your code here
		Map<Character, Integer> mapT = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			mapT.put(c, mapT.getOrDefault(c, 0) + 1);
		}

		
		
		int minLength = Integer.MAX_VALUE;
		boolean found = false;
		int count = 0;
		Map<Character, Integer> mapS = new HashMap<Character, Integer>();
		int startIndex = -1;
		int i = 0;

		for (i = 0; i < s.length(); i++) {

			if (found) {
				char startChar = s.charAt(startIndex);

				if (mapT.containsKey(startChar)) {
					int tc = mapS.get(startChar);
					if (tc == mapT.get(startChar)) {
						mapS.put(startChar, tc - 1);
						count--;
						System.out.println(
								"Reduced Count due to losing=" + startIndex + " value=" + s.charAt(startIndex));
					}
				}
				startIndex++;
			}

			char ch = s.charAt(i);

			if (mapT.containsKey(ch)) {
				if (startIndex == -1) {
					startIndex = i;
					System.out.println("Start created=" + startIndex);
				}
				mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
				if (mapS.get(ch) <= mapT.get(ch)) {
					count++;
					System.out.println("Incre Count to" + count + " due to i=" + i + " value=" + s.charAt(i));
				}
			}

			if (count == t.length()) {
				minLength = Math.min(minLength, (i - startIndex + 1));
				System.out.println("First MinLength=" + minLength);
				found = true;
			}
		}

		if (!found) {
			return -1;
		}
		
		return minLength;

	}

	public static void main(String[] args) {
		String s = "dcbefebce";
		String t = "fd";
		FindMinLengthSubString findMinLengthSubString = new FindMinLengthSubString();
		int result = findMinLengthSubString.minLengthSubstring(s, t);
		System.out.println("Result=" + result);
	}

}

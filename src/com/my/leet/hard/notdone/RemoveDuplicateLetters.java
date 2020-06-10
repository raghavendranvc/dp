package com.my.leet.hard.notdone;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {
	// https://ttzztt.gitbooks.io/lc/content/remove-duplicate-letters.html
	// http://buttercola.blogspot.com/2016/01/leetcode-remove-duplicate-letters.html

	/*
	 * The basic idea is to find out the smallest result letter by letter (one
	 * letter at a time). Here is the thinking process for input "cbacdcbc":
	 * 
	 * find out the last appeared position for each letter; c - 7 b - 6 a - 2 d - 4
	 * 
	 * find out the smallest index from the map in step 1 (a - 2);
	 * 
	 * the first letter in the final result must be the smallest letter from index 0
	 * to index 2;
	 * 
	 * repeat step 2 to 3 to find out remaining letters.
	 * 
	 * the smallest letter from index 0 to index 2: a
	 * 
	 * the smallest letter from index 3 to index 4: c
	 * 
	 * the smallest letter from index 4 to index 4: d
	 * 
	 * the smallest letter from index 5 to index 6: b so the result is "acdb"
	 * 
	 * Notes:
	 * 
	 * after one letter is determined in step 3, it need to be removed from the
	 * "last appeared position map", and the same letter should be ignored in the
	 * following steps
	 * 
	 * in step 3, the beginning index of the search range should be the index of
	 * previous determined letter plus one
	 */

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		// Step 1: find the last index for each char
		Map<Character, Integer> lastIndexMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			lastIndexMap.put(c, i);
		}

		// Step 2: for each character, find the smallest index in the map
		// Then find out the smallest char before the index.
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = findSmallestIndex(lastIndexMap);

		while (!lastIndexMap.isEmpty()) {
			char curr = 'z' + 1;
			int index = 0;
			for (int i = start; i <= end; i++) {
				char c = s.charAt(i);
				if ((c < curr) && (lastIndexMap.containsKey(c))) {
					curr = c;
					index = i;
				}
			}

			// append result
			sb.append(curr);
			lastIndexMap.remove(curr);

			// update the start and end
			start = index + 1;
			end = findSmallestIndex(lastIndexMap);
		}

		return sb.toString();
	}

	private int findSmallestIndex(Map<Character, Integer> lastIndexMap) {
		int result = Integer.MAX_VALUE;
		for (int index : lastIndexMap.values()) {
			result = Math.min(result, index);
		}

		return result;
	}

	/*
	 * Greedy: In the search space of i to j where the last character in s[i...j] in
	 * also of its last appearance of the whole string s, find the small character
	 * in lexicographical order, delete it in the subsequent substring and then
	 * perform the search starting from j + 1.
	 */

	public String removeDuplicateLettersRecur(String s) {
		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}

		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(pos) > s.charAt(i))
				pos = i;
			if (--cnt[s.charAt(i) - 'a'] == 0)
				break;
		}

		return s.length() == 0 ? ""
				: s.charAt(pos) + removeDuplicateLettersRecur(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

	/*
	 * Using stack:
	 * 
	 * Count the letter frequency with an Array
	 * 
	 * Build a ascending stack: Each time adding a letter to the stack if it has not
	 * been added into the stack, mark letter as visited. If current letter is
	 * smaller than the that on top of the stack, and top letter has remaining
	 * appearance after (as checked by indexing the letter frequency array), pop the
	 * letter out and mark it as not visited
	 */
	
	public String removeDuplicateLettersStack(String s) {
        int [] res = new int[26];
        boolean [] vis = new boolean [26];
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char c: chars){
            res[c - 'a']++;
        }
        int index = -1;
        for (char c: chars){
            index = c - 'a';
            res[index] --;
            if (vis[index])
                continue;
            while (!st.isEmpty() && c < st.peek() && res[st.peek() - 'a']!= 0){
                char top = st.pop();
                vis[top - 'a'] = false;
            }
            st.push(c);
            vis[index] = true;

        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

}

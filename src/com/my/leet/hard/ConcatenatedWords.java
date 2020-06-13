package com.my.leet.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatenatedWords {
	
	//---------------DFS Way -recursion----------------------------------

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> dict = new HashSet<>();
		for (String s : words)
			dict.add(s);

		Map<String, Boolean> canform = new HashMap<>();
		List<String> res = new ArrayList<>();

		for (String s : words) {
			if (check(s, canform, dict))
				res.add(s);
		}
		return res;
	}

	private boolean check(String s, Map<String, Boolean> canform, Set<String> dict) {
		if (canform.containsKey(s)) {
			return canform.get(s);
		} else {
			for (int i = 1; i <= s.length(); i++) {
				String pre = s.substring(0, i);
				if (dict.contains(pre)) {
					String post = s.substring(i);
					if (dict.contains(post) || check(post, canform, dict)) {
						canform.put(s, true);
						return true;
					}
				}
			}
			canform.put(s, false);
			return false;

		}
	}
	
	//----------------------DP WAY---------------------------------

	public static List<String> findAllConcatenatedWordsInADictDP(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> preWords = new HashSet<>();

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (canForm(words[i], preWords)) {
				result.add(words[i]);
			}
			preWords.add(words[i]);
		}

		return result;
	}

	private static boolean canForm(String word, Set<String> dict) {
		if (dict.isEmpty())
			return false;

		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j])
					continue;
				if (dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}
	
	//--------------------------Bestway ----------------------------

	public List<String> findAllConcatenatedWordsInADictTrie(String[] words) {
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return res;
		}
		TrieNode root = new TrieNode();
		for (String word : words) { // construct Trie tree
			if (word.length() == 0) {
				continue;
			}
			addWord(word, root);
		}
		for (String word : words) { // test word is a concatenated word or not
			if (word.length() == 0) {
				continue;
			}
			if (testWord(word.toCharArray(), 0, root, 0)) {
				res.add(word);
			}
		}
		return res;
	}

	public boolean testWord(char[] chars, int index, TrieNode root, int count) { // count means how many words during
																					// the search path
		TrieNode cur = root;
		int n = chars.length;
		for (int i = index; i < n; i++) {
			if (cur.sons[chars[i] - 'a'] == null) {
				return false;
			}
			
			if (cur.sons[chars[i] - 'a'].isEnd) {
				if (i == n - 1) { // no next word, so test count to get result.
					return count >= 1;
				}
				if (testWord(chars, i + 1, root, count + 1)) {
					return true;
				}
			}
			cur = cur.sons[chars[i] - 'a'];
		}
		return false;
	}

	public void addWord(String str, TrieNode root) {
		char[] chars = str.toCharArray();
		TrieNode cur = root;
		for (char c : chars) {
			if (cur.sons[c - 'a'] == null) {
				cur.sons[c - 'a'] = new TrieNode();
			}
			cur = cur.sons[c - 'a'];
		}
		cur.isEnd = true;
	}

	class TrieNode {
		TrieNode[] sons;
		boolean isEnd;

		public TrieNode() {
			sons = new TrieNode[26];
		}
	}

}

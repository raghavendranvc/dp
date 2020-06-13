package com.my.leet.medium;

public class AddAndSearchWord {

	class TrieNode {
		TrieNode[] arr;
		boolean isLeaf;

		public TrieNode() {
			arr = new TrieNode[26];
		}
	}

	public class WordDictionary {
		TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			TrieNode p = root;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (p.arr[index] == null) {
					TrieNode temp = new TrieNode();
					p.arr[index] = temp;
					p = temp;
				} else {
					p = p.arr[index];
				}
			}

			p.isLeaf = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return dfsSearch(root, word, 0);
		}

		public boolean dfsSearch(TrieNode p, String word, int currentIndex) {
			if (p.isLeaf && currentIndex == word.length()) {
				return true;
			}

			if (currentIndex >= word.length()) {
				return false;
			}

			char c = word.charAt(currentIndex);

			if (c == '.') {
				boolean tResult = false;
				for (int j = 0; j < 26; j++) {
					if (p.arr[j] != null) {
						if (dfsSearch(p.arr[j], word, currentIndex + 1)) {
							tResult = true;
							break;
						}
					}
				}

				if (tResult)
					return true;
			} else {
				int index = c - 'a';

				if (p.arr[index] != null) {
					return dfsSearch(p.arr[index], word, currentIndex + 1);
				} else {
					return false;
				}
			}

			return false;
		}
	}

}

package com.my.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	String[] list = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like", "ice",
			"cream" };

	String list2[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "love", "ice",
			"cream" };

	Set<String> dictionary = new HashSet<String>();
	Set<String> dictionary2 = new HashSet<String>();

	public WordBreak() {
		for (String s : list)
			dictionary.add(s);

		for (String s : list2)
			dictionary2.add(s);

	}

	public boolean dictionaryContains(String word) {
//		System.out.println("Check word="+word);
		return dictionary.contains(word);
	}

	public boolean dictionary2Contains(String word) {
//		System.out.println("Check word="+word);
		return dictionary2.contains(word);
	}

	public boolean wordBreak(String str) {
//		System.out.println("Str=="+str);
		int n = str.length();
		if (n == 0) {
			return true;
		}

		for (int i = 1; i <= n; i++) {

			if (dictionaryContains(str.substring(0, i))) {
				if (wordBreak(str.substring(i))) {
					return true;
				}
			}
		}
		return false;
	}

	// TODO check this logic again
	public boolean wordBreakIter(String str) {
		int n = str.length();
		if (n == 0) {
			return true;
		}
		boolean[] table = new boolean[n + 1];

		/*
		 * For each prefix ending at i-1
		 */
		for (int i = 1; i <= n; i++) {

			if (!table[i]) {
				if (dictionaryContains(str.substring(0, i))) {
					table[i] = true;
				}
			}

			// We will loop till we get a valid substring

			if (!table[i]) {
				continue;
			}

			if (i == n) {
				return true;
			}

			/*
			 * table[i] is true For each suffix
			 */
			for (int j = i + 1; j <= n; j++) {
				if (!table[j]) {
					if (dictionaryContains(str.substring(i, j))) {
						table[j] = true;
					}
				}

				if (j == n && table[j]) {
					return true;
				}
			}

		}
		return false;

	}
	
	/*
	 * 
	 * We could also use trie.
	 * First insert all dictionary words
	 * Each trieNode will contain 26 childerenNodes
	 * And indicate whether it is the end of any word
	 * 
	 * We recursively search for the given sentence for each prefix 
	 * if the prefix points to an end char which signals end of the word
	 * 
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "ilikesamsungi";
		String str2 = "iiiiiiii";
		String str3 = "";
		String str4 = "ilikelikeimangoiii";
		String str5 = "samsungandmango";
		String str6 = "samsungandmangok";

		WordBreak wb = new WordBreak();

		/*
		 * boolean val1 = wb.wordBreak(str1); System.out.println("val1=" + val1);
		 * boolean val2 = wb.wordBreak(str2); System.out.println("val2=" + val2);
		 * boolean val3 = wb.wordBreak(str3); System.out.println("val3=" + val3);
		 * boolean val4 = wb.wordBreak(str4); System.out.println("val4=" + val4);
		 * boolean val5 = wb.wordBreak(str5); System.out.println("val5=" + val5);
		 * boolean val6 = wb.wordBreak(str6); System.out.println("val6=" + val6);
		 * 
		 * boolean val11 = wb.wordBreakIter(str1); System.out.println("val11=" + val11);
		 * boolean val21 = wb.wordBreakIter(str2); System.out.println("val21=" + val21);
		 * boolean val31 = wb.wordBreakIter(str3); System.out.println("val31=" + val31);
		 * boolean val41 = wb.wordBreakIter(str4); System.out.println("val41=" + val41);
		 * boolean val51 = wb.wordBreakIter(str5); System.out.println("val51=" + val51);
		 * boolean val61 = wb.wordBreakIter(str6); System.out.println("val61=" + val61);
		 */

		String A = "iloveicecreamandmango";
		// String B = "ilovesamsungmobile";
		System.out.println("Result of " + A + " is " + wb.wordBreakBackTrack(A));
		// System.out.println("Result of "+B+" is "+ wb.wordBreakBackTrack(B));

	}

	/*************** Below is backtracking to print all ********************/

	ArrayList<String> wordBreakBackTrack(String str) {
		// last argument is prefix
		ArrayList<String> printList = new ArrayList<String>();
		wordBreakUtilRecur(str, str.length(), "", printList);
		return printList;
	}

	void wordBreakUtilRecur(String str, int n, String result, ArrayList<String> printList) {

		for (int i = 1; i <= str.length(); i++) {
			String prefix = str.substring(0, i);

			if (dictionary2Contains(prefix)) {

				if (i == n) {
					result = result + prefix;
					printList.add(result);
					return;
				}

				wordBreakUtilRecur(str.substring(i, n), n - i, result + prefix + " ", printList);
			}

		}

	}

}

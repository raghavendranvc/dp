package com.my.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeParitioning {

	// TODO practice again

	private boolean isPalindrome2(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	
	private boolean isPalindrome(String str) {
		for(int i=0;i<str.length()-1-i;i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (a == null || a.isEmpty()) {
			return result;
		}
		partition(a, result, 0, new LinkedList<>());
		return result;
	}

	public void partition(String a, ArrayList<ArrayList<String>> result, int startIndex, Deque<String> tempSet) {
		if (startIndex >= a.length()) {
			result.add(new ArrayList<>(tempSet));
			return;
		}

		/*Step1 */for (int i = startIndex; i < a.length(); i++) { // For each string starting with startIndex and ending with "i"
			/*Step2 */if (isPalindrome(a.substring(startIndex, i + 1))) {
				/*Step3 */tempSet.addLast(a.substring(startIndex, i + 1));
				/*Step4 */partition(a, result, i + 1, tempSet); // Now the startIndex is end of the earlier palindrome string
				tempSet.removeLast();
			}
		}
	}

}

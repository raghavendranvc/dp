package com.my.leet.hard;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParanthesis {

	// BFS approach

	boolean isParenthesis(char c) {
		return ((c == '(') || (c == ')'));
	}

	// method returns true if string contains valid
	// parenthesis
	boolean isValidString(String str) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				cnt++;
			else if (str.charAt(i) == ')')
				cnt--;
			if (cnt < 0)
				return false;
		}
		return (cnt == 0);
	}

	// method to remove invalid parenthesis
	void removeInvalidParenthesis(String str) {
		if (str.isEmpty())
			return;

		// visit set to ignore already visited string
		HashSet<String> visit = new HashSet<String>();

		// queue to maintain BFS
		Queue<String> q = new LinkedList<>();
		String temp;
		boolean level = false;

		// pushing given string as
		// starting node into queue
		q.add(str);
		visit.add(str);
		while (!q.isEmpty()) {
			str = q.peek();
			q.remove();
			if (isValidString(str)) {
				System.out.println(str);

				// If answer is found, make level true
				// so that valid string of only that level
				// are processed.
				level = true;
			}
			if (level)
				continue;
			for (int i = 0; i < str.length(); i++) {
				if (!isParenthesis(str.charAt(i)))
					continue;

				// Removing parenthesis from str and
				// pushing into queue,if not visited already
				temp = str.substring(0, i) + str.substring(i + 1);
				if (!visit.contains(temp)) {
					q.add(temp);
					visit.add(temp);
				}
			}
		}
	}

	// DFS approach

	ArrayList<String> result = new ArrayList<String>();
	int max = 0;

	public List<String> removeInvalidParentheses(String s) {
		if (s == null)
			return result;

		dfs(s, "", 0, 0);
		if (result.size() == 0) {
			result.add("");
		}

		return result;
	}

	public void dfs(String givenString, String currentString, int requiredRight, int maxLeft) {
		if (givenString.length() == 0) {
			if (requiredRight == 0 && currentString.length() != 0) {
				if (maxLeft > max) {
					max = maxLeft;
					result = new ArrayList<String>();
					// we only want to return largest valid ones
				}

				if (maxLeft == max && !result.contains(currentString)) {
					result.add(currentString);
				}
			}

			return;
		}

		if (givenString.charAt(0) == '(') {
			dfs(givenString.substring(1), currentString + "(", requiredRight + 1, maxLeft + 1);// keep (
			dfs(givenString.substring(1), currentString, requiredRight, maxLeft);// drop (
		} else if (givenString.charAt(0) == ')') {
			if (requiredRight > 0) {
				dfs(givenString.substring(1), currentString + ")", requiredRight - 1, maxLeft);
			}

			dfs(givenString.substring(1), currentString, requiredRight, maxLeft);

		} else {
			dfs(givenString.substring(1), currentString + String.valueOf(givenString.charAt(0)), requiredRight,
					maxLeft);
		}
	}

	// Re-did DFS approach

	int maxLength = 0;

	public List<String> removeInvalidParentheses1(String s) {
		ArrayList<String> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return result;
		}
		removeParanthesisDFS(s, "", 0, 0, result);
		if (result.size() == 0) {
			result.add("");
		}
		return result;
	}

	private void removeParanthesisDFS(String givenString, String currentString, int rightsNeeded, int maxLeftsProcessed,
			ArrayList<String> result) {
		if (givenString.isEmpty()) {
			if (rightsNeeded == 0 && currentString.length() > 0) {
				if (max < maxLeftsProcessed) {
					max = maxLeftsProcessed;
					result = new ArrayList<>();
				}
				if (max == maxLeftsProcessed && !result.contains(currentString)) {
					result.add(currentString);
				}
			}
			return;
		}

		char ch = givenString.charAt(0);
		switch (ch) {
		case '(':
			// we either ignore
			removeParanthesisDFS(givenString.substring(1), currentString, rightsNeeded, maxLeftsProcessed, result);
			// we include it
			removeParanthesisDFS(givenString.substring(1), currentString + "(", rightsNeeded + 1, maxLeftsProcessed + 1,
					result);
			break;
		case ')':
			// we ignore if no rights are needed. Else we include it
			if (rightsNeeded > 0) {
				removeParanthesisDFS(givenString.substring(1), currentString + ")", rightsNeeded - 1, maxLeftsProcessed,
						result);
			}
			removeParanthesisDFS(givenString.substring(1), currentString, rightsNeeded, maxLeftsProcessed, result);
			break;
		default:
			removeParanthesisDFS(givenString.substring(1), currentString + ch, rightsNeeded, maxLeftsProcessed, result);
			break;
		}

	}
}

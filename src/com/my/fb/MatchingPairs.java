package com.my.fb;

public class MatchingPairs {

	int matchNumber(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				count++;
			}
		}
		System.out.println("s=" + s + " t=" + t + " count=" + count);
		return count;
	}

	int matchingPairs(String s, String t) {
		// Write your code here
		if (s.length() == 0) {
			return 0;
		}

		if (s.equals(t)) {
			return s.length() - 2;
		}

		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				System.out.println("Swapping " + i + " and " + j);
				StringBuilder sb = new StringBuilder();
				if (i > 0) {
					sb.append(s.substring(0, i));
				}
				sb.append(s.substring(j, j + 1))
				.append(s.substring(i+1,j))
				.append(s.substring(i, i + 1));
				if (j + 1 < s.length()) {
					sb.append(s.substring(j + 1));
				}

				max = Math.max(max, matchNumber(sb.toString(), t));
			}

		}
		return max;
	}

	public static void main(String[] args) {
		String s = "abcde";
		String t = "adcbe";
		MatchingPairs matchingPairs = new MatchingPairs();
		matchingPairs.matchingPairs(s, t);
	}

}

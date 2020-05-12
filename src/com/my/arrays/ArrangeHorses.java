package com.my.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrangeHorses {

	public static void main(String[] args) {
		ArrangeHorses ah = new ArrangeHorses();
		String A = "WBWB";
		int B = 2;
		System.out.println("Result=" + ah.arrange(A, B));
	}

	/*
	 * 
	 * W B W W B W B
	 * 
	 * n horses
	 * 
	 * max n-2 splits
	 * 
	 * 
	 */
	public int arrange(String A, int B) {
		if (A == null || A.length() == 0) {
			return 0;
		}
		return arrangeRecur(A, B, new HashMap<String, Map<Integer, Integer>>());
	}

	public int arrangeRecur(String A, int B, Map<String, Map<Integer, Integer>> map) {
		// No solution if
		// We do not have stables to store horses
		// We have more stables than horses. So stables shall be empty
		if (B < 1 || B > A.length()) {
			return 0;
		}

		if (B == 1) {

			int retVal = getVal(A);
			return retVal;
		}

		if (map.containsKey(A) && map.get(A).containsKey(B)) {
			return map.get(A).get(B);
		}

		int minVal = Integer.MAX_VALUE;

		// assuming (start,i) (i+1,end) as the 2 partitions
		for (int i = 0; i < A.length(); i++) {
			/*
			 * String p1 = A.substring(start,i+1); //i+1 is not included String p2 =
			 * A.substring(i+1,end+1); //end is not included Number of chars = end+1-(i+1)=
			 * 
			 * i i+1 end 0 1 2 3 4 5 6 7 8 9 Number of chars = 9-4+1 = 6 If we still have
			 * partitions, those partitions should be less than the Number of chars We
			 * cannot have empty partitions IF we have 3 partitions, then we need 4 chars
			 * at-least
			 */

			String preFix = A.substring(0, i + 1);// ending at i. So we need to use i+1
			int val = getVal(preFix);
			int recurVal = arrangeRecur(A.substring(i + 1, A.length()), B - 1, map);
			minVal = Math.min(minVal, val + recurVal);

		}
		System.out.println("**With " + B + " parititons For String2=" + A + " value=" + minVal);

		map.getOrDefault(A, new HashMap<Integer, Integer>()).put(B, minVal);

		return minVal;
	}

	private int getVal(String A) {
		int b = 0;
		for (char ch : A.toCharArray()) {
			if (ch == 'B') {
				b++;
			}
		}

		return b * (A.length() - b);
	}

	private int getVal1(String A, int start, int end) {
		int b = 0;
		for (int i = start; i < end; i++) {
			if (A.charAt(i) == 'B') {
				b++;
			}
		}

		return b * (end - start - b);
	}

	int countW(String A) {
		int cnt = 0;
		for (int i = 0; i < A.length(); i++) {
			cnt += A.charAt(i) == 'W' ? 1 : 0;
		}
		return cnt;
	}

	Map<String, Map<Integer, Integer>> memo = new HashMap<>();

	public int arrangeCopied(String A, int B) {

		if (B > A.length() || B == 0)
			return -1;

		if (B == 1) {
			int whites = countW(A);
			return whites * (A.length() - whites);
		}

		if (memo.containsKey(A) && memo.get(A).containsKey(B)) {
			return memo.get(A).get(B);
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= 1 + A.length() - B; i++) {

			String prefix = A.substring(0, i); // i excluded

			int whitesPrefix = countW(prefix);

			String suffix = A.substring(i, A.length()); // n is excluded

			min = Math.min(min, (whitesPrefix * (i - whitesPrefix)) + arrange(suffix, B - 1));
		}

		memo.putIfAbsent(A, new HashMap<>());
		memo.get(A).put(B, min);

		return min;
	}

	public int arrangeDP(String a, int b) {
		if (a.length() < b) {
			return -1;
		}
		int[][] dp = new int[b][a.length()];
		// for (int []i: dp){Arrays.fill(i,-1);}
		for (int i = 0; i < b; i++) {
			int w, l;
			w = l = 0;
			for (int j = i; j <= i + a.length() - b; j++) {

				if (i == 0) {
					if (a.charAt(j) == 'W')
						w++;
					else
						l++;
					dp[0][j] = w * l;
				} else {
					w = l = 0;
					int k = j;
					int min = Integer.MAX_VALUE;
					while (k >= i) {
						if (a.charAt(k) == 'W')
							w++;
						else
							l++;
						// System.out.println("ss "+dp[i-1][k-1]+w*l);
						dp[i][j] = dp[i - 1][k - 1] + w * l;
						if (dp[i][j] == 0)
							break;
						if (min > dp[i][j]) {
							min = dp[i][j];
						} else
							dp[i][j] = min;
						k--;
					}

				}

			}
		}
		/*
		 * for (int []i:dp){ for (int j:i){ System.out.print(j+" "); }
		 * System.out.println(); }
		 */
		return dp[b - 1][a.length() - 1];
	}

}

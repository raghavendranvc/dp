package com.my.dp.ibit;

public class StairsOREncodingNumbers {

	/*
	 * //0 1 2 3 4 // 1 2 3 4 //1 1 1+1 (1)/(2)=3 // At 0th step, has only one
	 * possible solution // At step 1, we have only one solution // At step 2, we
	 * have 2 ways We can come from step 0. So Step0 ways We can come from step 2.
	 * So step1 ways At step 3, we have 2 ways We can come from step 1. So step1
	 * ways We can come from step 2. So step2 ways
	 * 
	 * This is similar to encoding numbers problem
	 */
	public int climbStairs(int A) {

		if (A < 1) {
			return 0;
		}

		if (A == 1) {
			return 1;
		}

		if (A == 2) {
			return 2;
		}

		int[] dp = new int[A + 1];
		dp[0] = dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= A; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[A];
	}

	/*
	 * 
	 * 345
	 * 
	 * 5 - 1
	 * 
	 * 45 == 4, 45 - 1
	 * 
	 * 345 === 3 - 1 34
	 * 
	 * 
	 */

	/*
	 * TODO practice logic Similar problem Stair case movement with 1 step or 2
	 * steps
	 */

	public int numDecodingsCopied(String str) {
		int n = str.length();

		if (str == null || n == 0)
			return 0;

		int dp[] = new int[n + 1];

		dp[0] = 1;

		if (str.charAt(0) != '0')
			dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int first = Integer.parseInt(str.substring(i - 1, i));
			int second = Integer.parseInt(str.substring(i - 2, i));
			if (first >= 1 && first <= 9)
				dp[i] += dp[i - 1];
			if (second >= 10 && second <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}

	public int numDecodings(String A) {

		if (A == null || A.length() == 0) {
			return 0;
		}

		if (A.charAt(0) == '0') {
			return 0;
		}

		int n = A.length();

		int[] decodings = new int[n + 1];
		// decoding array contains all the ways for strings ending at [i-1]

		decodings[0] = 1; // Why? For length=0, number of decodings possible is 0
		decodings[1] = 1;

		for (int endIndex = 2; endIndex <= n; endIndex++) {

			int singleNumber = Integer.parseInt(A.substring(endIndex - 1, endIndex)); // [1,2)
			int doubleNumber = Integer.parseInt(A.substring(endIndex - 2, endIndex)); // [0,2)

			if (singleNumber >= 1 && singleNumber <= 9) {
				decodings[endIndex] += decodings[endIndex - 1];
			}

			if (doubleNumber >= 10 && doubleNumber <= 26) {
				decodings[endIndex] += decodings[endIndex - 2];
			}

		}

		return decodings[n];

	}

}

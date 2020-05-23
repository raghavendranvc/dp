package com.my.dp.ibit;

public class CircleChords {
	
	/**
	 * This is similar to Unique BSTs count
	 * @param A
	 * @return
	 */

	// ways to divide circle using N non-intersecting chords.

	int chordCount(int A) {

		int points = 2 * A;

		// dp array containing the sum
		int[] dpArray = new int[points + 1];
		dpArray[0] = 1;
		dpArray[2] = 1;
		for (int i = 4; i <= points; i += 2) {
			for (int j = 0; j < i - 1; j += 2) {
				dpArray[i] += (dpArray[j] * dpArray[i - 2 - j]);
			}
		}

		// returning the required number
		return dpArray[points];
	}

	/*
	 * 0 = 0 1 = 1 2 = 2 3 = 5 = dp(0)*dp(2) + dp(1)*dp(1) + dp(2)*dp(0) =
	 * 1*2+1*1+2*1 = 2+1+2 =  dp(0)*dp(3) + dp(1)*dp(2) + dp(2)*dp(1) + dp(3) * dp(0)
	 * 1*5+2*1+1*2+5*1 = 5+2+2+5 = 
	 * 
	 * 
	 */
	// A is number of chords

	public int chordCnt(int A) {

		if (A < 1) {
			return 1; //For zero chords, number of non-intersecting parts in circle is 1
		}

		if (A == 1) {
			return 1;
		}

		if (A == 2) {
			return 2;
		}

		long[] dp = new long[A + 1];
		dp[0] = 1; //TODO base condition is important
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= A; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i] += (dp[j] * dp[i - 1 - j]) % 1000000007;
				dp[i] %= 1000000007;
			}

		}

		return (int) dp[A];
	}

}

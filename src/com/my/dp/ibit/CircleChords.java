package com.my.dp.ibit;

public class CircleChords {
	
	/*
	 * 0 = 1
	 * 1 = 1
	 * 2 = 2  
	 * 3 = 5  = dp(0)*dp(2) + dp(1)*dp(1) + dp(2)*dp(0) = 1*2+1*1+2*1 = 2+1+2 = 5
	 * 4 = 14 = dp(0)*dp(3) + dp(1)*dp(2) + dp(2)*dp(1) + dp(3)*dp(0) = 1*5+1*2+2*1+5*1 = 5+2+2+5 = 14
	 * 5 =    =
	 * 
	 * 
	 */
	
	public int chordCnt(int A) {
		
		if(A < 1) {
			return 0;
		}
		
		if (A == 1) {
			return 1;
		}
		
		if (A == 2) {
			return 2;
		}
		
		long[] dp = new long[A+1];
		dp[0] = 0; 
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3;i<=A;i++) {
			for(int j=0;j<=i-1;j--) {
				dp[i] += (dp[j] * dp[i-1-j])%1000000007;
				dp[i] %= 1000000007;
			}
			
		}
		
		return (int)dp[A];
    }

}

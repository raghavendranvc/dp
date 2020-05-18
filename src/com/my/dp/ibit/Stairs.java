package com.my.dp.ibit;

public class Stairs {
	
	/*
	//0 	1 	2 		3				4
	//		1 	2 		3				4
	//1 	1	1+1 	(1)/(2)=3		
	// At 0th step, has only one possible solution
	// At step 1, we have only one solution
	// At step 2, we have 2 ways 
	 * 		We can come from step 0. So Step0 ways  
	 * 		We can come from step 2. So step1 ways 
	   At step 3, we have 2 ways
	   		We can come from step 1. So step1 ways
	   		We can come from step 2. So step2 ways
	   		
	   This is similar to encoding numbers problem		
	 */
	public int climbStairs(int A) {
		
		if(A < 1) {
			return 0;
		}
		
		if(A==1) {
		    return 1;
		}
		
		if(A == 2) {
		    return 2;
		}
		
		int[] dp = new int[A+1];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		
		
		for(int i=3;i<=A;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[A];
	}

}

package com.my.dp.ibit;

public class CoinChangeNumberOfWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoinChangeNumberOfWays c = new CoinChangeNumberOfWays();
	    
	    int arr[] = {1, 2, 3};
	    int val = 4;
	    
	    int ways1 = c.coinChangeRecur(arr, arr.length, val);
	    System.out.println("ways="+ways1);

	}
	
	public int coinChangeRecur(int[] coins,int m,int val){
		
		/*
		 * Val is o. So this is a Solution
		 */
		if(val==0){
			return 1;
		}
		
		/*
		 * val got below '0'. So no solution exists
		 */
		
		if(val<0){
			return 0;
		}
		
		/*
		 * All 'm' are considered. But still val > 0
		 * val is anyway greater than 0 here
		 */
		if(m<=0){
			return 0;
		}
		
		/*
		 * When m is not considered        : coinChange(coins,m-1,val)
		 * When m is present at-least once : coinChange(coins,m,val-coins[m])
		 */
		
		return coinChangeRecur(coins,m-1,val)+coinChangeRecur(coins,m,val-coins[m-1]);
	}
	
	
}

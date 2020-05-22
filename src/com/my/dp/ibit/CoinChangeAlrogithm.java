package com.my.dp.ibit;

public class CoinChangeAlrogithm {

	public int coinChangeIter(int[] coins,int total) {
		//Time complexity of this function: O(mn) 
        //Space Complexity of this function: O(n) 
  
        // table[i] will be storing the number of solutions 
        // for value i. We need n+1 rows as the table is 
        // constructed in bottom up manner using the base 
        // case (n = 0) 
		
		int[] solution = new int[total+1]; //See this array size is total+1 //TODO
		//solution[i] contains numOfWays to get i 
		
		solution[0] = 1; //base condition. This will make sure that every coin gets one way for every value it matters
		/*
		 * For each coin we iterate over
		 */
		for(int i=0;i<coins.length;i++) {
			/*
			 * Using the coin 'i' we need to find the ways t
			 */
			//TODO, important to remember this dp recurrence.
			//It is similar to recursive solution.
			for(int j=coins[i];j<=total;j++) {
				// by excluding coins[i] for each solution what is the numberOfWays
				solution[j] += solution[j-coins[i]]; 
			}
		}
		return solution[total];
	}
	
	public static void main(String[] args) {
	
		int totalValue = 100;
		int[] denominations = {25,10,5,1};
		
		int noOfWays = getNumberOfWaysToRepresentTotalValue(totalValue,denominations,0);
		System.out.println(noOfWays);
		System.out.println("------------");
		System.out.println(makeChange(totalValue, 25));
		
	}
	
	private static int getNumberOfWaysToRepresentTotalValue(int value,int[] denominations,int currentDenomIndex){
		
		/*
		 * Using the last Denomination, there is only one way with it. 
		 */
		if(currentDenomIndex == denominations.length-1 ){ 
			return 1;
		}
		
		/*
		 * Get the current denomination.
		 */
		
		int currentDenom = denominations[currentDenomIndex];
		
		/*
		 * We now find ways using we used current Denomination as 0,1,2,3...(value/currentDenomination)
		 * 
		 */
		
		int ways = 0;
		for(int i=0; i*currentDenom <= value; i++){
//			System.out.println("i="+i+" currentDenom="+currentDenom);
			int uniqueWays = getNumberOfWaysToRepresentTotalValue(value - currentDenom*i,denominations,currentDenomIndex+1); 
			ways += uniqueWays;
//			System.out.println("uniqueWays="+uniqueWays);
		}
		return ways;
	}
	
	public static int makeChange(int value, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		for (int i = 0; i * denom <= value; i++) {
			ways += makeChange(value - i * denom, next_denom);
		}
		return ways;
	}
		
		

}

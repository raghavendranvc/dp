package com.my.dp;

public class EggBreakProblem {
	
	public int eggBreak(int floors,int eggs){
		
//		System.out.println("Floors="+floors+" eggs="+eggs);
		
		/*
		 * For floor 0. No tests are performed. No eggs needs to be broke
		 * For floor 1, we need one egg to test.
		 */
		if(floors ==0 || floors==1){
			return floors;
		}
		
		/*
		 * If number of eggs to test is 1, then we need to test at all the floors from 1 to the last floor
		 */
		
		if(eggs==1){
			return floors;
		}
		
		int minTries = Integer.MAX_VALUE;
		/*
		 * One of the floors will generate the minValue.
		 */
		for(int i=2;i<=floors;i++){
			
			// When Egg breaks        - Try with the remaining eggs below that floor  eggBreak(i-1, eggs-1)
			// When Egg doesn't break - Try with all the existing eggs from that floor to end
			
			int maxValue = Math.max(eggBreak(i-1, eggs-1), eggBreak(floors-i,eggs));

			minTries = Math.min(minTries, maxValue);
			
		}
		// We need to consider the test at current floor. Which is 1.
		// Min Tries = 1 + Min Tries from the loop
		
		return minTries+1;
		
	}
	
	public int getEggBreakIter(int floors,int eggs){
		if(floors < 2){
			return floors;
		}
		
		if(eggs == 1){
			return floors;
		}
		
		/*
		 * When only '1' egg is left.
		 */
		int[][] table = new int[floors+1][eggs+1];
		for(int i=0;i<=floors;i++){
			table[i][1] = i;
		}
		
		/*
		 * For Floor '0' and '1'
		 */
		for(int j=1;j<=eggs;j++){
			table[1][j] = 1;
			table[0][j] = 0; 
		}
		
		for(int i=2;i<=floors;i++){
			for(int j=2;j<=eggs;j++){
				
				int minValue = Integer.MAX_VALUE;
				/*
				 * For each floor from 1 to i using j eggs, find the values
				 * When egg is broken at floor k, we need to test  k-1 with one less egg :: table[k-1][j-1]
				 * When egg is not broken at floor k, we need to test k+1 th floor to last floor(i) using the same eggs :: table[i-k][j]
				 *
				 */
				for(int k=1;k<=i;k++){
					int max =  1+Math.max(table[k-1][j-1], table[i-k][j]);
					minValue = Math.min(minValue, max);
				}
				
				
				
				table[i][j] = minValue;
			}
		}
		
		
		return table[floors][eggs];
	}
	
	public int getEggBreakIterReverse(int eggs,int floors){
		/*
		 * For Floor '0' and '1'
		 *
		 */
		int[][] table = new int[eggs+1][floors+1];
		for(int i=0;i<=eggs;i++){
			table[i][0]=0;
			table[i][1]=1;
		}
		
		/*
		 *  When only '1' egg is left.
		 */
		
		for(int j=0;j<=floors;j++){
			table[1][j] = j;
		}
		
		for(int i=2;i<=eggs;i++){
			for(int j=2;j<=floors;j++){
				table[i][j] = Integer.MAX_VALUE;
				
				/*
				 * For eggs 'i'
				 * Do this for all the floors from 1 to j (k)
				 * If egg is broken at k then we need to search k-1 floors using i-1 eggs :: table[i-1][k-1]
				 * If egg is not broken at k then we need to search from k+1 to j th floor using i eggs :: table[i][j-k]
				 */
				
				for(int k=1;k<=j;k++){
					int max = 1+Math.max(table[i-1][k-1], table[i][j-k]);
					
					table[i][j] = Math.min(table[i][j], max);
					
				}
			}
		}
		
		return table[eggs][floors];
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int floors = 100;
		int eggs = 10;
		
		EggBreakProblem egg = new EggBreakProblem();
		/*int minTries1 = egg.eggBreak(floors, eggs);
		System.out.println("Floors="+floors+" Eggs="+eggs+" minTries1="+minTries1);*/
		
		int minTries2 = egg.getEggBreakIter(floors, eggs);
		System.out.println("Floors="+floors+" Eggs="+eggs+" minTries2="+minTries2);
		
		int minTries3 = egg.getEggBreakIterReverse(eggs, floors);
		System.out.println("Floors="+floors+" Eggs="+eggs+" minTries2="+minTries3);

	}

}

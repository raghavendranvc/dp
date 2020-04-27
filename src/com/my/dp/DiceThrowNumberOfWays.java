package com.my.dp;

public class DiceThrowNumberOfWays {
	
	public int getNumberOfWaysForSum(int faces,int dices,int sum){
		
		if(dices <1 && sum >0){
			return 0;
		}
		
		if(dices > sum){
			return 0;
		}
		
		if(dices == sum){
			return 1;
		}

		int numberOfWays = 0;
		
		for(int i=faces;i>0;i--){
			if(sum >= i){
				numberOfWays += getNumberOfWaysForSum(faces,dices-1,sum-i);
			} 
		}
		return numberOfWays;
	}

	//TODO read

	public int getNumberOfWaysForSumIter(int faces,int dices,int sum){
		int[][] table = new int[dices+1][sum+1];
		
		/*
		 * Using only dice 1 - First row (row =1)
		 * we can produce sums from 1 to faces 
		 * (if faces = 6, then we can produce 1, 2, 3, 4, 5, 6)
		 * But if the sum < faces then the boundary to fill up is sum only. 
		 * If sum = 5 and faces = 6, then first row will be 1, 2, 3, 4, 5
		 * If sum = 10 and faces = 6, then first row will be 1, 2, 3, 4, 5, 6, 0, 0, 0, 0
		 * 
		 * 
		 */
		for(int i=1;i<=Math.min(faces,sum);i++){
			table[1][i] = 1;
		}
		
		for(int i=2;i<=dices;i++){  // i is the number of dice used
			for(int j=1;j<=sum;j++){  // j is the sum obtained with i dice
				/*
				 * To get sum j using dice d/i table[d/][j]
				 * we need to add k [= 1 to (faces,j-1)] to sums got using d-1 dice
				 * So for that how we do is reverse
				 * for table[i][j] the values will be equal to k=1...j-1/faces added at row table[i-1][j-k]
				 * If we add k to table[i-1][j-k] we get value at table[i][j]
				 */
				for(int k=1;k<=Math.min(faces, j-1);k++){ 
					table[i][j] += table[i-1][j-k];
				}
			}
			
		}
		
		return table[dices][sum];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DiceThrowNumberOfWays dt = new DiceThrowNumberOfWays();
		
		int val1 = dt.getNumberOfWaysForSum(4, 2, 1);
		System.out.println("val1="+val1);
		
		int val2 = dt.getNumberOfWaysForSum(2, 2, 3);
		System.out.println("val2="+val2);

		int val3 = dt.getNumberOfWaysForSum(6, 3, 8);
		System.out.println("val3="+val3);
	    
		int val4 = dt.getNumberOfWaysForSum(4, 2, 5);
		System.out.println("val4="+val4);
	    
		int val5 = dt.getNumberOfWaysForSum(4, 3, 5);
		System.out.println("val5="+val5);
		
		int val11 = dt.getNumberOfWaysForSumIter(4, 2, 1);
		System.out.println("val11="+val11);
		
		int val21 = dt.getNumberOfWaysForSumIter(2, 2, 3);
		System.out.println("val21="+val21);

		int val31 = dt.getNumberOfWaysForSumIter(6, 3, 8);
		System.out.println("val31="+val31);
	    
		int val41 = dt.getNumberOfWaysForSumIter(4, 2, 5);
		System.out.println("val41="+val41);
	    
		int val51 = dt.getNumberOfWaysForSumIter(4, 3, 5);
		System.out.println("val51="+val51);

	}

}

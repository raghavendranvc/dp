package com.my.dp;

public class CountingBooleanParantehsis {
	
	/*
	 * Expression = operand1 op1 operand2 op2 operand3 op3 operand4
	 */

	public int GetNumberOfBooleanParanthesis(boolean[] operands,String[] operators){
		int n = operands.length;
		int[][] TrueValues = new int[n][n];
		int[][] FalseValues = new int[n][n];
		
		for(int i=0;i<n;i++){
			
			/* true & true = 1
			 * true or true = 1
			 * true ^ true = 0
			 * 
			 * false & false = 0
			 * false or false = 0
			 * false ^ false = 0
			 */
			
			TrueValues[i][i] = 2;
			FalseValues[i][i] = 4;
		}
		
		for(int length=2;length<n;length++){
			for(int i=0,j=length-1;j<n;i++,j++){
				for(int k=i;k<j;k++){ // i to ...k  and k+1....j
					TrueValues[i][j] = 
							/*  AND */		TrueValues[i][k]*TrueValues[k+1][j] +  
							/*  OR */		(TrueValues[i][k]+FalseValues[i][k])*(TrueValues[k+1][j]+FalseValues[k+1][j])  - FalseValues[i][k]*FalseValues[k+1][j]+ 
							/* XOR */		TrueValues[i][k]*FalseValues[k+1][j] + FalseValues[i][k]*TrueValues[k+1][j] ;
					
					FalseValues[i][j] = 
							/*  AND */		(TrueValues[i][k]+FalseValues[i][k])*(TrueValues[k+1][j]+FalseValues[k+1][j])  - TrueValues[i][k]*TrueValues[k+1][j]+
							/*  OR */		FalseValues[i][k]*FalseValues[k+1][j] +  
							/* XOR */		TrueValues[i][k]*TrueValues[k+1][j] + FalseValues[i][k]*FalseValues[k+1][j] ;
				}
			}
		}
		
		return TrueValues[0][n-1];	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

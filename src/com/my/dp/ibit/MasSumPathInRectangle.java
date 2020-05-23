package com.my.dp.ibit;

public class MasSumPathInRectangle {

	
	int maxPathSum(int tri[][], int m, int n) {
		
		//https://www.geeksforgeeks.org/maximum-path-sum-triangle/
			
		/**
		 * We will do bottom up.
		 * For i,j , we need to check i+1,j & i+1,j+1 
		 * below and below-right
		 */
		
		for(int i=m-2;i>=0;i--) { //m-2 because, we leave the leaf nodes/end row
			for(int j=0;j<=i;j++) { //matrix is a triangle. So j will be <= i
				tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);
				
			}
		}
		
		return tri[0][0];
	}
	
	
}

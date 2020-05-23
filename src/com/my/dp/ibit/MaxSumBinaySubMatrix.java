package com.my.dp.ibit;

public class MaxSumBinaySubMatrix {
	
	void maxSubSquare(int[][] a) {
		
		int m = a.length;
		int n = a[0].length;
		
		int[][] sol = new int[m][n];
		
		int maxSum = a[0][0], maxSumI = 0, maxSumJ = 0;
		
		for(int i=0;i<m;i++) {
			sol[i][0] = a[i][0];
		}
		
		for(int i=0;i<n;i++) {
			sol[0][i] = a[0][i];
		}
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(a[i][j] == 0) {
					sol[i][j]=0;
					continue;
				}
				sol[i][j] = getMin(sol[i-1][j],sol[i-1][j-1],sol[i][j-1]);
				if(sol[i][j] > maxSum) {
					maxSum = sol[i][j];
					maxSumI = i;
					maxSumJ = j;
				}
			}
		}
	
		/*Sub matrix is at ,
		 * 
		 * TOP,LEFT
		 * (maxSumI-maxSum),(maxSumJ-maxSum)				
		 * 		
		 * 
		 * BOTTOM,RIGHT	
		 * (maxSumI,maxSumJ)
		 * 							
		 */
		//
	}
	
	private int getMin(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	

}

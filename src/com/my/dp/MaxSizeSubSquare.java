package com.my.dp;

import com.my.common.UtilityClass;

public class MaxSizeSubSquare {
	
	static class SubSquare{
		int i;
		int j;
		int size;
		public SubSquare(int i,int j,int size){
			this.i = i;
			this.j = j;
			this.size = size;
		}
		public String toString(){
			return "i="+i+" j="+j+" size="+size;
		}
		
	}
	
	public void getMaxSizeSubSquare(int[][] m,SubSquare s){
		int[][] sizeMatrix = new int[m.length][];
		
		for(int i=0;i<m.length;i++){
			sizeMatrix[i] = new int[m[i].length];
			sizeMatrix[i][0] = m[i][0];
		}
		
		for(int j=0;j<sizeMatrix[0].length;j++){
			sizeMatrix[0][j] = m[0][j];
		}
		
		int maxVal = 0;
		for(int i=1;i<sizeMatrix.length;i++){
			for(int j=1;j<sizeMatrix[i].length;j++){
				if(m[i][j]==0){
					sizeMatrix[i][j]=0;
				}else {
					sizeMatrix[i][j]=1+Math.min(sizeMatrix[i-1][j-1], Math.min(sizeMatrix[i-1][j], sizeMatrix[i][j-1]));
					if(maxVal < sizeMatrix[i][j]){
						maxVal = sizeMatrix[i][j];
						s.size = maxVal;
						s.i = i-maxVal+1;
						s.j = j-maxVal+1;
					}
				}
			}
		}
	
		UtilityClass.printArray(sizeMatrix);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m[][] = {
					{0, 1, 1, 0, 1}, 
					{1, 1, 1, 1, 0}, 
					{1, 1, 1, 1, 0},
					{1, 1, 1, 1, 0},
					{1, 1, 1, 1, 1},
					{0, 0, 0, 0, 0}
			};
		
		SubSquare ss = new SubSquare(0, 0, 0);
		MaxSizeSubSquare ms = new MaxSizeSubSquare();
		ms.getMaxSizeSubSquare(m, ss);
		System.out.println(ss);

	}

}

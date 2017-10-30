package com.my.dp;

public class OptimumGameStrategy {
	
	public int getOptStrategey(int[] a){
		return getOptStrategey(a,0,a.length-1);
		
	}
	
	public int getOptStrategey(int[] a,int i,int j){
		if(i==j){
			return a[i];
		}
		
		if(i+1 == j){
			return Math.max(a[i], a[j]);
		}
		
		return Math.max(
				a[i]+ Math.min(getOptStrategey(a, i+2,j),getOptStrategey(a,i+1,j-1)), 
				a[j]+ Math.min(getOptStrategey(a, i+1,j-1),getOptStrategey(a,i,j-2))
				);
		
	}
	
	public int getOptStrategeyIter(int[] a){
		
		int n = a.length;
		
		int[][] table = new int[n][n];
		
		for(int gap=0;gap<n;gap++){
			for(int i=0,j=gap;j<n;i++,j++){
				
				/*
				 * Check for diagonal property.
				 * We are constructing diagonal with gap 0, 1, 2, 3, 4, ...n-1
				 */
				int x = (i+2 <= j)  ? table[i+2][j]  :0;
				int y = (i+1 <= j-1)? table[i+1][j-1]:0;
				int z = (i   <= j-2)? table[i][j-2]  :0;
				
				table[i][j] = Math.max(
						a[i]+Math.min(x, y), 
						a[j]+Math.min(y, z)
						);
				
			}
			
		}
		
		return table[0][n-1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1 = {8, 15, 3, 7};
		int[] a2 = {2, 2, 2, 2};
		int[] a3 = {20, 30, 2, 2, 2, 10};
		
		OptimumGameStrategy ogs = new OptimumGameStrategy();
		
		int val1 = ogs.getOptStrategey(a1);
		System.out.println("val1="+val1);
		
		int val2 = ogs.getOptStrategey(a2);
		System.out.println("val2="+val2);
		
		int val3 = ogs.getOptStrategey(a3);
		System.out.println("val3="+val3);
		
		
		
		int val11 = ogs.getOptStrategeyIter(a1);
		System.out.println("val11="+val11);
		
		int val21 = ogs.getOptStrategeyIter(a2);
		System.out.println("val21="+val21);
		
		int val31 = ogs.getOptStrategeyIter(a3);
		System.out.println("val31="+val31);
		
		
	}

}

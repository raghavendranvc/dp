package com.my.dp;

public class MinCostPathInASquare {
	
	// From Destination
	
	/********************One way********************************************/
	
	public int minCostFromDestinationRecur(int[][] cost,int i,int j){
		
		if(i==0 && j==0){
			return cost[0][0];
		}
		if(i<0 || j<0){
			return Integer.MAX_VALUE;
		}
		
		return (cost[i][j]+ Math.min(minCostFromDestinationRecur(cost,i-1,j-1),Math.min(minCostFromDestinationRecur(cost,i-1,j),minCostFromDestinationRecur(cost,i,j-1))));
		
	}
	
	/********************One way********************************************/
	
	// From Source
	public int minCostFromSourceRecur(int[][] cost,int m,int n,int i,int j){
		
		if(i==m && j==n){
			return cost[i][j];
		}
		
		if(i>m || j>n){
			return Integer.MAX_VALUE;
		}
		
		
		return (cost[i][j]+ Math.min(minCostFromSourceRecur(cost,m,n,i+1,j+1),Math.min(minCostFromSourceRecur(cost,m,n,i+1,j),minCostFromSourceRecur(cost,m,n,i,j+1))));
	}
	
	/********************One way********************************************/
	
	public int minCostFromDestinationIter(int[][] cost,int dx,int dy){
		
		int[][] spcs = new int[dx+1][dy+1];
		
		spcs[0][0] = cost[0][0];
		
		/*
		 *  This calculates cost paths for the first row if the first row points are destinations.
		 *  Cumulative additions happen horizontally 
		 */
		for(int i=1;i<=dx;i++){ 
			spcs[i][0] = spcs[i-1][0] + cost[i][0]; 
		}
		
		/*
		 *  This calculates cost paths for the first column if the first column points are destinations.
		 *  Cumulative additions happen vertically 
		 */
		for(int j=1;j<=dy;j++){ 
			spcs[0][j] = spcs[0][j-1] + cost[0][j]; 
		}
		for(int i=1;i<=dx;i++){
			for(int j=1;j<=dy;j++){
				spcs[i][j] = cost[i][j] + Math.min(spcs[i-1][j-1],Math.min(spcs[i-1][j],spcs[i][j-1]));
			}
		}
		
		return spcs[dx][dy];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int cost[][] = { 
				{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		
		MinCostPathInASquare squ = new MinCostPathInASquare();
		int val1 = squ.minCostFromDestinationRecur(cost, 2, 2);
		System.out.println("val1="+val1);
		
		int val2 = squ.minCostFromSourceRecur(cost, 2, 2,0,0);
		System.out.println("val2="+val2);
		
		int val3 = squ.minCostFromDestinationIter(cost, 2, 2);
		System.out.println("val3="+val3);

	}

}

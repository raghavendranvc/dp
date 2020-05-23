package com.my.dp;

public class AssemblyLineScheduling {
	
	/*
	 * Only 2 assembly lines
	 * 
	 * a => assembly cost at station a[0][i] of assembly line 0
	 * t => transfer cost at station t[0][i] of assembly line 0
	 * e => entry cost at assembly line
	 * x => exit cost at assembly line
	 */
	public int getMinTimeForCar(int[][] a,int[][] t,int[] e,int[] x){
		
		int numberOfStations = a[0].length;
		
		int[] T1 = new int[numberOfStations];
		int[] T2 = new int[numberOfStations];
		
		/*
		 * T1[i] represents time taken to leave station i on assembly line 1
		 * T2[i] represents time taken to leave station i on assembly line 2
		 * 
		 * T1[0] = entry time (e[0]) on assembly line 1 + time taken at station '0' on assembly line 1 (a[0][0])
		 * Similarly for T2[0]
		 * 
		 */
		
		T1[0] = e[0] + a[0][0];  
		T2[0] = e[1] + a[1][0];
		
		for(int i=1;i<numberOfStations;i++){
			/*
			 * T1[i] can be reached from 2 stations
			 * 	station i-1 on Line 0
			 *  station i-1 on Line 1
			 *  
			 *  No Extra cost/time is incurred if it is in the same line
			 *  Extra cost t[line][i] is incurred when line is shifted to reach station i
			 *  
			 *  So T1[i] = a[0][i] + Minimum of T1[i-1] or T2[i-1]+Extra overhead (t[1][i])
			 *  
			 *  
			 */
			T1[i] = Math.min(T1[i-1],T2[i-1]+t[1][i]) + a[0][i];
			T2[i] = Math.min(T2[i-1],T1[i-1]+t[0][i]) + a[1][i];
		}
		
		/*
		 * x[0] is exit time at Station 0
		 * x[1] is exit time at Station 1
		 */
		return Math.min(T1[numberOfStations-1]+x[0], T2[numberOfStations-1]+x[1]);
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*int NUM_STATION=4;
		int NUM_LINES=2;*/
		
		int[][] assemblyCost = 
			{
				{4, 5, 3, 2},
                {2, 10, 1, 4}
			};
		int[][] transferCost = 
			{
				{0, 7, 4, 5},
                {0, 9, 2, 8}
			};
		int[] entryTimes = {10, 12};
		int[] exitTimes = {18, 7};
		
		AssemblyLineScheduling als = new AssemblyLineScheduling();
		int val1 = als.getMinTimeForCar(assemblyCost, transferCost, entryTimes, exitTimes);
		System.out.println("val1="+val1);

	}

}

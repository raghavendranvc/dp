package com.my.leet.medium.arrays;

public class TeemoAttack {

	// https://leetcode.com/problems/teemo-attacking/

	public int findPosisonedDuration(int[] timeSeries, int duration) {

		if (timeSeries.length == 0)
			return 0;

		if (timeSeries.length == 1)
			return duration;

		int total = 0;
		for (int i = 1; i < timeSeries.length; i++) {
			total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
			//Each loop for "i" calculates if how much "i-1" contribution lasts
			//it will be min of either to the currentTimestamp or duration
		}

		total += duration;

		return total;
	}
	
	//Better one. Use this TODO 

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0)
			return 0;
		
		int previousTS = timeSeries[0], total = 0;
		
		for (int currentTS : timeSeries) {
			total = total + (currentTS < previousTS + duration ? currentTS - previousTS : duration);
			previousTS = currentTS;
		}
		return total + duration;
	}

}

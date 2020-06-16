package com.my.twopointers;

import java.util.ArrayList;

public class MaxContinuousOnes {
	// TODO GIVEN UP After a while

	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
		
		int maxLeftIndex = 0, maxCount = 0;
		int left = 0;
		int flips = B;
		
		//sliding window with at-most k zeroes
		
		for(int i=0;i<A.size();) {
			if(A.get(i) == 1) {
				i++;
			} else if (flips > 0) {
				flips--;
				i++;
			} else if (left < i) {
				if(A.get(left) == 1) {
					flips++;
				}
				left++;
				//we don't increment i here, because we want to contract from the start
				// and see how many zeros we can thorw away so that we can
				// reuse the flips
			} else {
				i++; //think if A.get(0) == 0, we should increment both
				left++;
			}
			
			if(maxCount < i-left) {
				maxCount = i-left;
				maxLeftIndex = left;
			}
			
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < maxCount; i++)
			result.add(maxLeftIndex + i);
		return result;
	}

}

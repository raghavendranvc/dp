package com.my.arrays;

import java.util.ArrayList;

public class MaxAbsDiff {

	// f(i, j) = |A[i] - A[j]| + |i - j|
	// = -(A[i]+i) + (A[j]+j)

// C     0,1  0,2  0,3  0,4
// 1,0   C   1,3  1,3  1,4
// 2,0     C
// 3,0
// 4,0

//TODO practice this logic. Mathematics

	// f(i, j) = |A[i] - A[j]| + |i - j|
	// = -(A[i]+i) + (A[j]+j)
//            = -x + y
//            = y - x

	/*
	 * We find 4 values
	 * 
	 * 1) max and min of below A[i]+i
	 * 
	 * 2) max and min of below A[i]-i
	 * 
	 * Now the max becomes the max of (Max1-Min1 OR Max2-Min2)
	 * 
	 * 
	 * We can derive the logic by the 4 relationships between
	 * 
	 * A[i], A[j] and i & j
	 * 
	 * 1) A[i] < A[j] and i < j 2) A[i] > A[j] and i > j
	 * 
	 * 3) A[i] < A[j] but i > j 4) A[i] > A[j] but i < j
	 * 
	 * 
	 */

	public int maxArr(ArrayList<Integer> A) {

		int smallestValueOfSum = Integer.MAX_VALUE;
		int largestValueOfSum = Integer.MIN_VALUE;

		int smallestValueOfSub = Integer.MAX_VALUE;
		int largestValueOfSub = Integer.MIN_VALUE;

		for (int i = 0; i < A.size(); i++) {
			int sum = A.get(i) + i;
			if (sum > largestValueOfSum) {
				largestValueOfSum = sum;
			}

			if (sum < smallestValueOfSum) {
				smallestValueOfSum = sum;
			}

			int diff = A.get(i) - i;

			if (diff > largestValueOfSub) {
				largestValueOfSub = diff;
			}

			if (diff < smallestValueOfSub) {
				smallestValueOfSub = diff;
			}
		}

		return Math.max(largestValueOfSum - smallestValueOfSum, largestValueOfSub - smallestValueOfSub);
	}

	/*
	 * 
	 * (A[i] + i) - (A[j] + j) -(A[i] - i) + (A[j] - j) (A[i] - i) - (A[j] - j)
	 * (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
	 * 
	 * 
	 */
	// 0 1 2 Index
	// 1 3 -1 Array
	// 1 4 1 A[i]+i

	// f(1,2) = |3 - (-1)| + |(1-2)| = 5
//           =  (3+1) - (-1-2) = 4 - (-3) = 7

	public static void main(String[] args) {

	}
	/*
	 * public static void main(String[] args){
	 * 
	 * }
	 * 
	 * 
	 */
}

package com.my.dp.ibit;

import java.util.ArrayList;
import java.util.Arrays;

import com.my.common.UtilityClass;

public class MinimumJumps {
	
	/***************************once sol *************************/

	public int jumpReverse(ArrayList<Integer> A) {

		if (A == null) {
			return 0;
		}

		if (A.isEmpty()) {
			return 0;
		}

		int n = A.size();

		int[] minWays = new int[n];
		Arrays.fill(minWays, Integer.MAX_VALUE); //Remember this //TODO
		minWays[n - 1] = 0;
		
		// Idea is to move from the end

		for (int i = n - 2; i >= 0; i--) {
			int jumpsPossible = A.get(i);
			if (i + jumpsPossible >= n - 1) {
				minWays[i] = 1;
				continue;
			}
			for (int j = 1; j <= jumpsPossible; j++) {
				if (minWays[i + j] < Integer.MAX_VALUE) {
					minWays[i] = Math.min(minWays[i], 1 + minWays[i + j]);
				}
			}
		}

		UtilityClass.print(minWays);

		if (minWays[0] == Integer.MAX_VALUE) {
			return -1;
		}

		return minWays[0];

	}
	
	/***************************once sol *************************/

	public int jump(ArrayList<Integer> A) {

		if (A == null) {
			return -1;
		}

		if (A.isEmpty()) {
			return 0;
		}

		int n = A.size();

		int[] minWays = new int[n];
		Arrays.fill(minWays, Integer.MAX_VALUE);
		minWays[0] = 0;

		// 1 ....(n-1) elements (minimum number of steps needed to reach i
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) { // For each earlier index,
				int jumpsPossible = A.get(j);
				if (minWays[j] != Integer.MAX_VALUE && j + jumpsPossible >= i) {
					minWays[i] = Math.min(minWays[i], 1 + minWays[j]);
					break;// TODO Still not aware why we need to break here. Why???
				}
			}
		}

		if (minWays[n - 1] == Integer.MAX_VALUE) {
			return -1;
		}

		return minWays[n - 1];
	}

	public static void main(String[] args) {
		int[] a = { 33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0,
				47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18,
				33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23,
				22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 };
		ArrayList<Integer> A = UtilityClass.getList(a);

		MinimumJumps minimumJumps = new MinimumJumps();
		System.out.println("Result=" + minimumJumps.jump(A));

	}
	
	/***************************once sol *************************/

	public int jumpCopied(ArrayList<Integer> A) {
		if (A.size() == 1) {
			return 0;
		}

		int jumps = 1; // We need to jump 1 for the base
		int lastReach = A.get(0);
		int maxReach = A.get(0);
		// maxReach simply checks the maximum distance that can be moved using the
		// values in the array.
		// It can reach beyond any point.

		// we start with the second one
		for (int i = 1; i < A.size(); i++) {

			if (maxReach < i) { // At any point of time, our maxReach is less than the current position, then
								// there is no path
				return -1;
			}

			// If
			if (lastReach < i) {
				jumps++;
				// We jump only when necessary. So when our first/initial jump works, we will
				// remain there
				// But if the current position has reached
				lastReach = maxReach;
			}
			maxReach = Math.max(maxReach, i + A.get(i));

		}
		return jumps;
	}
	
	/***************************once sol *************************/

	/*
	 * 
	 * We need to calculate the minimum jumps needed
	 * 
	 */

	public int jumpP1(ArrayList<Integer> A) {
		if (A.size() == 1) {
			return 0;
		}
		int jumps = 1;

		int lastReached = A.get(0);
		int maxReachPosition = A.get(0);

		for (int i = 1; i < A.size(); i++) {
			if (maxReachPosition < i) {
				return -1;
			}
			if (lastReached < i) {
				jumps++;
				lastReached = maxReachPosition;
			}
			maxReachPosition = Math.max(maxReachPosition, i + A.get(i));
		}
		return jumps;
	}
	
	
	/***************************once sol *************************/

	public int jump2(ArrayList<Integer> a) {
		// int[] count= new int[a.size()];
		// int[] jumps = new int[a.size()];

		if (a == null || (a.size() > 1 && a.get(0) == 0))
			return -1;

		if (a.size() == 1)
			return 0;

		int count = a.get(0);
		int max = 0;
		int steps = 0;

		for (int i = 1; i < a.size(); i++) {
			count--; // We took a step to i
			max--;
			max = Math.max(max, a.get(i));

			if (i == a.size() - 1)
				return steps + 1;

			if (count == 0) {

				if (max == 0) {
					return -1;
				}

				count = max;
				max = 0;
				steps++;

			}
		}
		return steps;
	}

	
	/***************************once sol *************************/
	
	
	public int getMinJumpsNeeded(int[] a, int s, int d) {
		if (s == d) {
			System.out.println("Dest reached*****");
			return 0;
		}

		if (a[s] == 0) {
			System.out.println("a[" + s + "]=" + a[s] + "---------");
			return Integer.MAX_VALUE;
		}

		int minVal = Integer.MAX_VALUE;
		/*
		 * For all i from s+1 to s+a[s] or till i<=d, compute the minval for (i,d)
		 */
		for (int i = s + 1; i <= (s + a[s]) && i <= d; i++) {
//			System.out.println("---------For s="+s+" Checking i="+(s+i));
			minVal = Math.min(minVal, 1 + getMinJumpsNeeded(a, i, d));
//			System.out.println("For s="+s+" i="+i+" minVal="+minVal+"---------");
		}

		System.out.println("=====" + s + "," + d + "=" + minVal);
		return minVal;
	}
	
	/***************************once sol *************************/

	public int getMinJumpsIter(int[] a) {
		int numberOfPos = a.length;

		if (numberOfPos == 0) {
			return 0;
		}

		if (a[0] == 0) {
			return Integer.MAX_VALUE;
		}

		int[] jumps = new int[numberOfPos];
		/*
		 * The last position needs no jump
		 */

		jumps[numberOfPos - 1] = 0;

		/*
		 * We calculate the jumps needed from right to left. lastElement needs '0' So
		 * start from pen-ultimate element till the first element
		 * 
		 * The value at a[i] will Min of all from
		 * a[i+1],a[i+2]....a[i+a[i]]/a[lastIndex] plus 1
		 * 
		 */

		for (int i = numberOfPos - 2; i >= 0; i--) {
			jumps[i] = Integer.MAX_VALUE;
			/*
			 * Calculate how many jumps are needed for an element at j using the jumps
			 * needed for i+1,i+2 ... i+a[i]/a[lastIndex]
			 */
			for (int j = i + 1; j <= i + a[i] && j < numberOfPos; j++) {
				System.out.println("Comparing i=" + i + " j=" + j);
				jumps[i] = Math.min(jumps[i], jumps[j] + 1);
			}
		}

		UtilityClass.print(jumps);
		return jumps[0];

	}

	/**
	 * @param args
	 */
	public static void main2(String[] args) {
		// 0 1 2 3 4 5 6 7 8 9 //s=0 d=9
		int[] a = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };

		MinimumJumps mj = new MinimumJumps();
//		int val1 = mj.getMinJumpsNeeded(a, 0, a.length-1);
//		System.out.println("val1="+val1);

		int val2 = mj.getMinJumpsIter(a);
		System.out.println("val2=" + val2);

	}

}

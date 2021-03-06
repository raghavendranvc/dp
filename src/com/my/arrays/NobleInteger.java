package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.*;

public class NobleInteger {

	// 5 2 4 5 9 7 6

	public int solve(ArrayList<Integer> A) {

		Integer[] sortedList = A.toArray(new Integer[A.size()]);
		Arrays.sort(sortedList);

		// UtilityClass.print(sortedList);

		/*
		 * for(int i=0;i<sortedList.length;i++){ if(i> 0 && sortedList[i] ==
		 * sortedList[i-1]){ //Traversing same element further continue; }
		 * if(sortedList[i] == sortedList.length-i-1){ return 1; } }
		 */

		// 0 1 2 3 4 5
		// 1 2 3 4 5 6
		//

		for (int i = sortedList.length - 1; i >= 0; i--) {
			if (i < sortedList.length - 1 && sortedList[i] == sortedList[i + 1]) { // Traversing same element further
				continue;
			}

			if (sortedList[i] == sortedList.length - 1 - i) {
				return 1;
			}
		}

		return -1;
	}
	
	// Simple non-sort-------------------------------------

	public int solveNonSort(ArrayList<Integer> A) {

		for (int i = 0; i < A.size(); i++) {
			int count = 0;
			for (int j = 0; j < A.size(); j++) {
				if (i == j) {
					continue;
				}
				if (A.get(i) < A.get(j)) {
					count++;
				}
			}
			if (A.get(i) == count) {
				return 1;
			}

		}

		return -1;

	}

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int n = A.size();

		/**
		 * Max of all elements should be at the end
		 * Once we prepare the elements, 
		 * if max is the end, then max[end] = maxElement
		 * So we want such an array prepared where 
		 * we get all max from left to end
		 * 
		 */
		int[] maxs = new int[n];
		maxs[0] = A.get(0);
		for (int i = 1; i < n; i++) {
			maxs[i] = Math.max(A.get(i), maxs[i - 1]);
		}
		
		/*
		 * Here we want to make sure that the minimum of all
		 * elements is at min[0] so we start to from right to left
		 */

		int[] mins = new int[n];
		mins[n - 1] = A.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			mins[i] = Math.min(A.get(i), mins[i + 1]);
		}
		
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int start = 0;
		while (start < n && mins[start] == A.get(start))
			start++;
		
		int end = n - 1;
		while (end >= 0 && maxs[end] == A.get(end))
			end--;
		
		
		if (start == n) // are in increasing order
			result.add(new Integer(-1));
		else {
			result.add(new Integer(start));
			result.add(new Integer(end));
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0,
				-8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6,
				3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8,
				-2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10,
				-4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2,
				-1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6,
				4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };
		UtilityClass.print(a);

		ArrayList<Integer> intList = new ArrayList<Integer>(a.length);
		for (int i : a) {
			intList.add(i);
		}
		NobleInteger nobleInteger = new NobleInteger();
		nobleInteger.solve(intList);
	}

}

	package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;

public class WaveArrayOrZigZagOrWiggle {
	
	public void wiggleSort(int[] nums) {
	    if (nums == null || nums.length <= 1) {
	        return;
	    }
	 
	    for (int i = 1; i < nums.length; i++) {
	        if (i % 2 == 1) {
	            if (nums[i - 1] > nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        } else {
	            if (nums[i - 1] < nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        }
	    }
	}

	// 6, 0, 6, 12 12
	// 0 6 6 12 12
	// 0 12 6 12 6

	// 1 2 3 4 5 6 7 8 9 10
	// 2 1 4 3 6 5 8 7 10 9

	//Better approach
	//Uses Bubble sort technique
	static void zigZag(int[] arr) {
		// Flag true indicates relation "<" is expected,
		// else ">" is expected. The first expected relation
		// is "<"
		boolean flag = true;

		int temp = 0;

		for (int i = 0; i <= arr.length - 2; i++) {
			// Use i%2 == 0 rather than flag
			if (flag) /* "<" relation expected */ 
			{
				/*
				 * If we have a situation like A > B > C, we get A > B < C by swapping B and C
				 */
				if (arr[i] > arr[i + 1]) {
					// swap
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			} else /* ">" relation expected */
			{
				/*
				 * If we have a situation like A < B < C, we get A < C > B by swapping B and C
				 */
				if (arr[i] < arr[i + 1]) {
					// swap
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag; /* flip flag */
		}
	}

	public ArrayList<Integer> waveCopied(ArrayList<Integer> A) {
		if (A.size() < 2) {
			return A;
		}
		Integer[] values = A.toArray(new Integer[A.size()]);
		Arrays.sort(values);

		for (int i = 0; i < values.length - 1; i += 2) {
			swap(values, i, i + 1);
		}

		return new ArrayList<>(Arrays.asList(values));
	}

	private void swap(Integer[] A, int i, int j) {
		int save = A[i];
		A[i] = A[j];
		A[j] = save;
	}
	
	private void swap(int[] A, int i, int j) {
		int save = A[i];
		A[i] = A[j];
		A[j] = save;
	}

	public void reverseArray(Integer[] A, int s, int e) {
		while (s < e) {
			int save = A[s];
			A[s] = A[e];
			A[e] = save;
			s++;
			e--;
		}
		UtilityClass.print(A);
	}

	public static void main(String[] argrs) {
		// int[] a = new int[] {5, 1, 3, 2, 4 };
		int[] a = new int[] { 6, 17, 15, 13 };
		UtilityClass.print(a);

		ArrayList<Integer> intList = new ArrayList<Integer>(a.length);
		for (int i : a) {
			intList.add(i);
		}
		WaveArrayOrZigZagOrWiggle waveArray = new WaveArrayOrZigZagOrWiggle();
		ArrayList<Integer> returnList = waveArray.waveCopied(intList);
		System.out.println(returnList);
	}
}

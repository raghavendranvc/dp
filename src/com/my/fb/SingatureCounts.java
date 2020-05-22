package com.my.fb;

import com.my.common.UtilityClass;

import sun.misc.Signal;

public class SingatureCounts {

	int[] findSignatureCounts(int[] arr) {
		// Write your code here

		int[] solution = new int[arr.length];

		// (2,1
		int i = 0;
		while (i < arr.length) {
			System.out.println("i="+i);
			UtilityClass.print(arr);
			UtilityClass.print(solution);
			if (i + 1 == arr[i]) {
				solution[i]++;
				i++;
				continue;
			}

			int other = arr[i] ; // other = 2
			arr[i] = arr[other-1]; // [1,2]
			solution[i]++; // [1,0]

			arr[other-1] = other; // [1,1]
			solution[other-1]++;// [1,1]
			
			System.out.println("After swammping for i="+i);
			UtilityClass.print(arr);
			UtilityClass.print(solution);
			
		}
		System.out.println("Result");
		UtilityClass.print(solution);
		return solution;

	}
	
	public static void main(String[] args) {
		int[] arr = {2,1};
		SingatureCounts singatureCounts = new SingatureCounts();
		singatureCounts.findSignatureCounts(arr);
	}

}

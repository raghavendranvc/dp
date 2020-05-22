package com.my.fb;

public class MinOpsToSort {

	void reverseSubArray(int[] a, int i, int j) {
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}

	int minOperations(int[] arr) {
		// Write your code here
		int minOps = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i + 1) {
				continue;
			} else {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] == i + 1) {
						reverseSubArray(arr, i, j);
						minOps++;
						break;
					}
				} // for
			} // else

		}
		return minOps;
	}

}

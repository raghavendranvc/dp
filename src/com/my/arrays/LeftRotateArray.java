package com.my.arrays;

import com.my.common.UtilityClass;

public class LeftRotateArray {

	void rightRotate(int[] numbers, int rotate) {

		int n = numbers.length;

		int src = numbers[0];
		int destIndex = rotate % n;

		int dest;
		int totalOperations = n; //overall we shall have n operations
		while (totalOperations > 0) {

			/*
			 * 1) First store the value at destIndex
			 * 2) Now you can safely move the source/current Element to destIndex
			 * 3) Now for the next iteration, dest becomes source. So assign dest to src
			 */
			dest = numbers[destIndex];
			numbers[destIndex] = src;
			src = dest;
			
			/*
			 * Previous steps have saved the values for the next iteration
			 * 
			 * recalculate the new destIndex
			 * Reduce the operations
			 */
			
			destIndex = (destIndex + rotate) % n;
			totalOperations--;
		}

	}

	void leftRotate(int arr[], int d, int n) {
		/* To handle if d >= n */
		d = d % n;
		int i, j, k, temp;
		int g_c_d = -1;//gcd(d, n);
		for (i = 0; i < g_c_d; i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		LeftRotateArray leftRotate = new LeftRotateArray();
		UtilityClass.print(a);
		leftRotate.rightRotate(a, 4);
		UtilityClass.print(a);
	}
}

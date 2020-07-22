package com.my.arrays;

import com.my.common.UtilityClass;

public class LeftRotateArray {

	int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}

	void leftRotate(int arr[], int d) {
		int n = arr.length;
		/* To handle if d >= n */
		d = d % n;
		int g_c_d = gcd(d, n);
		
		for (int i = 0; i < g_c_d; i++) {
			/* move i-th values of blocks */
			
			int temp = arr[i];
			int srcIndex = i;
			while (true) {
				int destIndex = srcIndex + d;
				if (destIndex >= n)
					destIndex = destIndex - n;
				
				if (destIndex == i)
					break;
				
				arr[srcIndex] = arr[destIndex];
				srcIndex = destIndex;
			}
			arr[srcIndex] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		LeftRotateArray leftRotate = new LeftRotateArray();
		UtilityClass.print(a);
		leftRotate.leftRotate(a, 5);
		UtilityClass.print(a);
	}
}

package com.my.arrays;

import com.my.common.UtilityClass;

public class InsertionSort {
	
	/** 
	 * 
	 * 11	12	13	6
	 * 
	 * 
	 * @param a
	 */
	
	public void sort(int[] a) {
		for(int i=1;i<a.length;i++) {
			
			int j=i;
			for(;j>=1;j--) {
				if(a[j-1] > a[j]) {
					swap(a,j-1,j);
				}
			}
			System.out.println("For "+a[i]);
			UtilityClass.print(a);
			
		}
	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {11,12,13,6,5,14};
		UtilityClass.print(A);
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(A);
		UtilityClass.print(A);
		
	}

}

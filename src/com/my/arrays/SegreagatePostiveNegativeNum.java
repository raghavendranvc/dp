package com.my.arrays;

public class SegreagatePostiveNegativeNum {
	
	private void segregate(int[] array) {
		
		int i = -1;
		// i points to the last index of the negative numbers found so far. Initially it will be at -1
		// i increases as we find negative numbers. 
		// At the end i+1 represents the first non-negative number (may be 0 too)
		for(int j=0; j< array.length; j++) {
			if(array[j]< 0) {
				i++;
				if(i != j) {
					swap(array,i,j);
				}
			}
			
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	

}

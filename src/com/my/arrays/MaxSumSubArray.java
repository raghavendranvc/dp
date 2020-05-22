package com.my.arrays;

public class MaxSumSubArray {

	public int getMaxSum(int[] a){
		
		int max = a[0];
		int currentMax = a[0];
		for(int i=1;i<a.length;i++){
			
			//TODO remember this logic
			/*
			 * The subMax is useful if the same adds value to the current element
			 */
			/*currentMax = Math.max(a[i], currentMax+a[i]); 
			max = Math.max(max, currentMax);*/
			
			if(currentMax+a[i]>a[i]){
				currentMax = currentMax+a[i];
			}else {
				currentMax = a[i];
			}
			
			if(currentMax > max){
				max = currentMax;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {-2, -3, 14, -1, -2, -1, 5, -3};
		MaxSumSubArray mss = new MaxSumSubArray();
		int val1 = mss.getMaxSum(a);
		System.out.println("val1="+val1);

	}

}

package com.my.dp;

import com.my.common.UtilityClass;

public class MaxSumIncreasingSubsequence {
	
	public int maxSumIter(int[] a,int seqLength){
		int[] table = new int[seqLength];
		for(int i=0;i<seqLength;i++){
			table[i] = a[i];
		}
		
		for(int i=1;i<seqLength;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i]  && table[i]< table[j]+a[i]){
					table[i] = table[j]+a[i];
				}
			}
			UtilityClass.print(table,i);
		}
		
		UtilityClass.print(table);
		
		int max = table[0];
		for(int i=1;i<seqLength;i++){
			max = Math.max(max, table[i]);
		}
		
		return max;
	}
	
	public int maxSum(int[] a){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			max = Math.max(max,maxSum(a,i+1));
		}
		return max;
	}
	
	public int maxSum(int[] a,int seqLength){
		
		if(seqLength == 1){
			return a[seqLength-1];
		}
		
		int max = a[seqLength-1];
		System.out.println("seqLength="+seqLength+" Init max="+max+"-------------");
		
		for(int i=1;i<seqLength;i++){
			int subMax = maxSum(a,i);
//			System.out.println("seqLength="+seqLength+" i="+i+" subMax="+subMax);
			
			if(a[i-1]<a[seqLength-1] && (max < subMax+a[seqLength-1])) {
				max = subMax+a[seqLength-1];
			} 
			
//			System.out.println("Selected Max="+max);
		}
		
		System.out.println("-------seqLength="+seqLength+" Max="+max);
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] a = {1, 101, 2, 3, 100, 4, 5};
		MaxSumIncreasingSubsequence m = new MaxSumIncreasingSubsequence();
		int val1 = m.maxSum(a);
		System.out.println("val1="+val1);
		
		int val2 = m.maxSumIter(a, a.length);
		System.out.println("val2="+val2);
		
		
	}

}

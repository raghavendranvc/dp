package com.my.dp;

public class LongestBitonicSubsequence {
	
	public int lbs(int[] a,int length){
		if(length == 0 || length == 1){
			return length;
		}
		
		int[] increSeq = new int[length];
		increSeq[0] = 1;
		
		for(int i=1;i<length;i++){
			increSeq[i] = 1;
			for(int j=0;j<i;j++){
				if(a[j]<a[i]){
					increSeq[i] = Math.max(increSeq[i], increSeq[j]+1);
				}
			}
		}
		
		int[] decreSeq = new int[length];
		decreSeq[length-1] = 1;
		for(int i=length-2;i>=0;i--){
			decreSeq[i] = 1;
			for(int j=i;j<length;j++){
				if(a[j]<a[i]){
					decreSeq[i] = Math.max(decreSeq[i],decreSeq[j]+1);
				}
			}
		}
		
		int maxBiotVal = increSeq[0]+decreSeq[0];
		for(int i=1;i<length;i++){
			maxBiotVal = Math.max(maxBiotVal,increSeq[i]+decreSeq[i]);
		}
		
		return maxBiotVal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestBitonicSubsequence lbSubSeq = new LongestBitonicSubsequence();
//		int[] a = {1, 11, 2, 10, 4, 5, 2, 1};
//		int[] a = {12, 11, 40, 5, 3, 1};
		int[] a = {80, 60, 30, 40, 20, 10};
		
		int val1 = lbSubSeq.lbs(a, a.length-1);
		System.out.println("val1="+val1);
		
	}

}

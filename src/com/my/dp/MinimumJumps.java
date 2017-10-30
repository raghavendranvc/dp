package com.my.dp;

import com.my.common.UtilityClass;

public class MinimumJumps {
	
	public int getMinJumpsNeeded(int[] a,int s,int d){
		if(s==d){
			System.out.println("Dest reached*****");
			return 0;
		}
		
		if(a[s] == 0){
			System.out.println("a["+s+"]="+a[s]+"---------");
			return Integer.MAX_VALUE;
		}
		
		int minVal = Integer.MAX_VALUE;
		/*
		 * For all i from s+1 to s+a[s] or till i<=d,
		 * compute the minval for (i,d)
		 */
		for(int i=s+1;  i<=(s+a[s]) && i<=d;  i++){
//			System.out.println("---------For s="+s+" Checking i="+(s+i));
			minVal = Math.min(minVal, 1+getMinJumpsNeeded(a, i, d));
//			System.out.println("For s="+s+" i="+i+" minVal="+minVal+"---------");
		}
		
		System.out.println("====="+s+","+d+"="+minVal);
		return minVal;
	}
	
	public int getMinJumpsIter(int[] a){
		int numberOfPos = a.length;
		
		if(numberOfPos==0){
			return 0;
		}
		
		if(a[0] == 0){
			return Integer.MAX_VALUE;
		}
		
		int[] jumps = new int[numberOfPos];
		/*
		 * The last position needs no jump
		 */
		
		jumps[numberOfPos-1] = 0; 
		
		/*
		 * We calculate the jumps needed from right to left.
		 * lastElement needs '0'
		 * So start from pen-ultimate element till the first element
		 * 
		 * The value at a[i] will Min of all from a[i+1],a[i+2]....a[i+a[i]]/a[lastIndex]  plus 1 
		 * 
		 */
		
		for(int i=numberOfPos-2;i>=0;i--){
			jumps[i] = Integer.MAX_VALUE;
			/*
			 * Calculate how many jumps are needed for an element at j
			 * using the jumps needed for i+1,i+2 ... i+a[i]/a[lastIndex]
			 */
			for(int j=i+1;j<=i+a[i] && j<numberOfPos;j++){
				System.out.println("Comparing i="+i+" j="+j);
				jumps[i] = Math.min(jumps[i], jumps[j]+1);
			}
		}
		
		UtilityClass.print(jumps);
		return jumps[0];
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				 //0  1  2  3  4  5  6  7  8  9   //s=0 d=9
		int[] a = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		
		MinimumJumps mj = new MinimumJumps();
//		int val1 = mj.getMinJumpsNeeded(a, 0, a.length-1);
//		System.out.println("val1="+val1);
		
		int val2 = mj.getMinJumpsIter(a);
		System.out.println("val2="+val2);

	}

}

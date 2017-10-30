package com.my.dp;

public class LongestAPSeriesLength {
	
	public boolean is3LengthAPExsits(int[] a){
		int n = a.length;
		if(n<3){
			return false;
		}
		
		/*
		 *  for 1,2,3, ..... n-2 (leaving 0 and n-1) do the below
		 *  
		 */
		for(int i=1;i<n-1;i++){
			int j=i-1;
			int k=i+1;
			
			while(j>=0 && k <=n-1){
				if(2*a[i] == a[j]+a[k]){
					return true;
				}
				
				
				if(2*a[i] > a[j]+a[k]){
					k++;
				}else {
					j--;
				}
				
			}
		}
		
		return false;
		
	}
	
	/*
	 * This method needs to be implemented.
	 * http://www.geeksforgeeks.org/length-of-the-longest-arithmatic-progression-in-a-sorted-array/
	 */
	public int getLengthOfLongestAP(int[] a){
		int n = a.length-1;
		if(n<3){
			return n;
		}
		
		return 2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] set1 = {1, 7, 10, 13, 14, 19};
		int[] set2 = {1, 7, 10, 15, 27, 29};
		int[] set3 = {2, 4, 6, 8, 10};
		int[] set4 = {2, 5, 10, 19, 30, 42, 60};
		
		LongestAPSeriesLength lapSeries = new LongestAPSeriesLength();
		boolean val1 = lapSeries.is3LengthAPExsits(set1);
		System.out.println("val1="+val1);
		boolean val2 = lapSeries.is3LengthAPExsits(set2);
		System.out.println("val2="+val2);
		boolean val3 = lapSeries.is3LengthAPExsits(set3);
		System.out.println("val3="+val3);
		boolean val4 = lapSeries.is3LengthAPExsits(set4);
		System.out.println("val1="+val4);

	}

}

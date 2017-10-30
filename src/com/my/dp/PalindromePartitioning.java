package com.my.dp;

import com.my.common.UtilityClass;

public class PalindromePartitioning {
	
	public int minCutsForPalindromePartitioning(String str,int i,int j){
		
		if(i==j){
			return 0;
		}
		
		if(isPalindromeIter(str,i,j)){
			return 0;
		} 
		
		int min=Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			min = Math.min(min, minCutsForPalindromePartitioning(str,i,k) + 1 + minCutsForPalindromePartitioning(str,k+1,j));
		}
		
		return min;
		
	}
	
	private boolean isPalindromeIter(String str,int i,int j){
		if(i==j){
			return true;
		}
		
		if(i+1 == j){
			return (str.charAt(i) == str.charAt(j));
		}
		
		return ((str.charAt(i) == str.charAt(j)) && isPalindrome(str, i+1, j-1));
	}
	
	
	
	private boolean isPalindrome(String str,int i,int j){
		int midSize = (j-i+1)/2;
		for(int k=0;k<midSize;k++){
			if(str.charAt(i+k) != str.charAt(j-k)){
				return false;
			}
		}
		return true;
	}
	
	public int minCutsForPalindromePartition(String str){
		int size = str.length();
		
		int[][] table = new int[size][size];
		boolean[][] isPalTable = new boolean[size][size];
		
		/*
		 * Below is for length = 1. 
		 * For length 1 - every string(character) is a palindrome and '0' cuts are made/needed/
		 */
		for(int i=0;i<size;i++){
			table[i][i] = 0;
			isPalTable[i][i]=true;
		}
		
		for(int length=2;length<=size;length++){
			
			for(int startIndexForEachSize=0; startIndexForEachSize<(size-length+1); startIndexForEachSize++){
				
				int endIndexForEachSize = startIndexForEachSize+length-1;
				
				if(length == 2){
					isPalTable[startIndexForEachSize][endIndexForEachSize] = (str.charAt(startIndexForEachSize) == str.charAt(endIndexForEachSize));
				}else {
					isPalTable[startIndexForEachSize][endIndexForEachSize] = (str.charAt(startIndexForEachSize) == str.charAt(endIndexForEachSize)) & isPalTable[startIndexForEachSize+1][endIndexForEachSize-1];
				}
				
				if(isPalTable[startIndexForEachSize][endIndexForEachSize]){
					table[startIndexForEachSize][endIndexForEachSize] = 0;
				} else {
					
					/*
					 * For size length-1 Get the minimum of all the cuts between startIndexForEachSize - endIndexForEachSize
					 */
					
					table[startIndexForEachSize][endIndexForEachSize] = Integer.MAX_VALUE; // First value
					
					for(int i=startIndexForEachSize;i<endIndexForEachSize;i++){
						table[startIndexForEachSize][endIndexForEachSize] = Math.min(
								table[startIndexForEachSize][endIndexForEachSize], 
								table[startIndexForEachSize][i]+1+table[i+1][endIndexForEachSize]);
					}
				}
			}
			
			// diagonal length = (row -column) represents all the cuts needed for that length
			
		}
		
		UtilityClass.printArray(table);
		
		return table[0][size-1];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PalindromePartitioning pp = new PalindromePartitioning();
		
		String str1 = "ababbbabbababa";
		//System.out.println("a\tb\ta\tb\tb\tb\ta\tb\tb\ta\tb\ta\tb\ta");
//		String str1 = "ababbabbababa";
		int cuts = pp.minCutsForPalindromePartitioning(str1, 0, str1.length()-1);
		System.out.println("Cuts ="+cuts);
		
		
		int cuts2 = pp.minCutsForPalindromePartition(str1);
		System.out.println("Cuts2 ="+cuts2);
		
		
	}

}

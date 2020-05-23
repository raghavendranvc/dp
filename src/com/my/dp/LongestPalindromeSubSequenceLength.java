package com.my.dp;

import com.my.common.UtilityClass;

public class LongestPalindromeSubSequenceLength {
	
	/********************One way********************************************/
	
	public int lpsIter(String str){
		int size = str.length();
		int[][] table = new int[size][size];
		
		/*
		 * When length is 1 then lps is 1. 
		 * Length is 1 when we have i==j
		 */
		
		for(int i=0;i<size;i++){
			table[i][i]   = 1;
		}
		
		/*for(int i=0;i<size-1;i++){
			if(str.charAt(i) == str.charAt(i+1)){
				table[i][i+1] = 2;
			}
		}*/
		
		/*
		 * n = 5
		 * i = 0, 1, 2, 3, 4
		 * 
		 *  A  B  B  A  A
		 *  1  ?  ?  ?  ? 
		 *  0  1  ?  ?  ?
		 *  0  0  1  ?  ?
		 *  0  0  0  1  ?
		 *  0  0  0  0  1
		 *  
		 */
		/*
		 * 0,1  0,2  0,3  0,4  0,5  0,6
		 * 1,2  1,3  1,4  1,5  1,6
		 * The below doesn't work because, subproblems used are not yet calculated.
		 * The table[i][j] uses values of subproblems whose values are yet to be calculated
		 * 
		 */
		
		/*for(int i=0;i<size-1;i++){
			for(int j=i+1;j<size;j++){
				
				if(i+1 == j && str.charAt(i) == str.charAt(j)){
					table[i][j]=2;
				}else if(str.charAt(i) == str.charAt(j)){
					table[i][j] = 2 + table[i+1][j-1];
				} else {
					table[i][j] = Math.max(table[i+1][j],table[i][j-1]);
				}
			}
		}*/
		
		/*
		 * This is the way.
		 * First calculate values for all for size 2
		 * Then calculate the values for size 3
		 * and repeat for the entire size
		 * If size = 7
		 * For each size from 2 to 7  : 2,3,4,5,6,7
		 * 
		 */
		for(int currentLength = 2;currentLength<=size;currentLength++){
			
			/*
			 * For substrings starting with i=0 and length currentLength
			 * 	    currentLength: i,j  i,j  j,j  i,j  i,j  i,j  i,j
			 * currentLength = 2 : 0,1  1,2  2,3  3,4  4,5  5,6  6,7  // i<7-2+1=6 
			 * currentLength = 3 : 0,2  1,3  2,4  3,5  4,6  5,7   // i<7-3+1=5
			 * currentLength = 4 : 0,3  1,4  2,5  3,6  4,7 
			 * currentLength = 5 : 0,4  1,5  2,6  3,7
			 * currentLength = 6 : 0,5  1,6  2,7
			 * currentLength = 7 : 0,6  1,7
			 *  
			 */
			for(int i=0;i<size-(currentLength-1);i++){
				int j=i+(currentLength-1); 
				
				if(currentLength==2){
					if(str.charAt(i) == str.charAt(j)){
						table[i][j]=2;
					}
				}
				
				if(str.charAt(i) == str.charAt(j)){
					table[i][j] = 2 + table[i+1][j-1];
				} else {
					table[i][j] = Math.max(table[i+1][j],table[i][j-1]);
				}
				
			}
		}
		
		/*for (int cl=2; cl<=size; cl++) {
	        for (int i=0; i<size-cl+1; i++) {
	        	
	            int j = i+cl-1;
	            if (str.charAt(i) == str.charAt(j) && cl == 2)
	            	table[i][j] = 2;
	            else if (str.charAt(i) == str.charAt(j))
	            	table[i][j] = table[i+1][j-1] + 2;
	            else
	               table[i][j] = Math.max(table[i][j-1], table[i+1][j]);
	        }
	    }*/
	 
	    UtilityClass.printArray(table);
		
		return table[0][size-1];
	}
	
	/********************Recur way********************************************/
	
	public int lps(String str,int i,int j){
		
		/*
		 * When string length is 1
		 */
		if(i == j){
			return 1;
		}
		/*
		 * When string length is 2
		 */
		
		if(i+1 == j){
			if(str.charAt(i) == str.charAt(j)){
				return 2;
			}
		}
		
		/*
		 * For other cases
		 * Check chars at i and j
		 * if they are equal then lps is 2 + lps of substring(i+1,j-1)
		 * if length is not equal then lps is the max of : lps of substring(i+1,j) or lps of substring (i,j-1)
		 */
		
		if(str.charAt(i) == str.charAt(j)){
			return 2 + lps(str,i+1,j-1);
		} else {
			return Math.max(lps(str,i+1,j), lps(str,i,j-1));
		}
		
	}
	
	public static void main(String[] args) {
		
		LongestPalindromeSubSequenceLength lps = new LongestPalindromeSubSequenceLength();
//		String str1 = "ABCDEFGHABCDEFGHHGFEDCBA";
//		String str1 = "GEEKSFORGEEKS";
//		String str1 = "BBABCBCAB";
		String str1 = "ABBAA";
		int maxPalLength1 = lps.lps(str1, 0, str1.length()-1);
		System.out.println("maxPalLength1="+maxPalLength1);
//		System.out.println("B\tB\tA\tB\tC\tB\tC\tA\tB");
		System.out.println("A\tB\tB\tA\tA");
		int maxPalLength2 = lps.lpsIter(str1);
		System.out.println("maxPalLength2="+maxPalLength2);
		
	}

}

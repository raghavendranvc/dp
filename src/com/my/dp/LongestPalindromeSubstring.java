package com.my.dp;


public class LongestPalindromeSubstring {

	
	public int getLPalindSS(String str){
		int size = str.length();
		
		boolean[][] isPalTable = new boolean[size][size];
		
		/*
		 * For single char starting and ending at 'i', size is 1 and isPal is true
		 */
		int max = 0;
		int startIndex = 0;
		
		for(int i=0;i<size;i++){
			isPalTable[i][i] = true;
		}
		
		/*
		 * For palindrome of size = 2
		 */
		for(int i=0;i<size-1;i++){
			if(str.charAt(i) == str.charAt(i+1)){
				startIndex = i;
				max = 2;
				isPalTable[i][i+1]=true;
			}
		}
		
		/*
		 *  Length=3 to size
		 */
		for(int length=3;length<=size;length++){
			
			for(int tmpStartIndex=0;tmpStartIndex<size-length+1;tmpStartIndex++){
				
				int tmpEndIndex = tmpStartIndex+length-1;
				if(!isPalTable[tmpStartIndex+1][tmpEndIndex-1]){
					isPalTable[tmpStartIndex][tmpEndIndex] = false;
				} else if(str.charAt(tmpStartIndex)==str.charAt(tmpEndIndex)){
					isPalTable[tmpStartIndex][tmpEndIndex] = true;
					startIndex = tmpStartIndex;
					max = length;
				}
			}
		}
		
		System.out.println("startIndex="+startIndex);
		return max;
		
	}
	
	public static void main(String[] args) {
		
		LongestPalindromeSubstring lpss = new LongestPalindromeSubstring();
		
		String str1 = "ababbbabbababa";
		System.out.println("a\tb\ta\tb\tb\tb\ta\tb\tb\ta\tb\ta\tb\ta");
//		String str1 = "ababbabbababa";
		int val1 = lpss.getLPalindSS(str1);
		System.out.println("val1 ="+val1);

	}

}

package com.my.leet.hard;

public class MinimumInsertaionForPalindrome {
	
	private boolean isPali(String a, int s, int e) {
		while(s < e) {
			if(a.charAt(s) != a.charAt(e) ) {
				return false;
			}
			s++;e--;
		}
		return true;
	}
	
	//insertions are done at the beginning.
	public int minInsertions(String a) {
		for(int i=a.length()-1;i>=0;i--) {
			if(isPali(a,0,i)) {
				return a.length()-1-i;
			}
		}
		return a.length();//will never happen because the first 
		//character is always a palindrome string
	}
	

}

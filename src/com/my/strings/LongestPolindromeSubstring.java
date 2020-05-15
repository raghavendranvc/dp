package com.my.strings;

public class LongestPolindromeSubstring {

    public String longestPalindrome(String A) {
        int maxPlaindromeStringLength = 1;
        String longestPalindromeSubString = A.charAt(0)+"";

        for(int i=0;i<A.length()-1;i++){
            for(int j=i+maxPlaindromeStringLength;j<A.length();j++){
                System.out.println("Testing for "+A.substring(i,j+1));
                if(isPalindrome(A.substring(i,j+1))){
                    System.out.println("yes palindrome i="+i+" j="+j);
                    if(maxPlaindromeStringLength < j+1-i){
                        maxPlaindromeStringLength = j+1-i;
                        longestPalindromeSubString = A.substring(i,j+1);
                        System.out.println("new max palindrome length="+maxPlaindromeStringLength);
                    }
                }
            }
        }

        return longestPalindromeSubString;
    }

    private boolean isPalindrome(String str){

        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    
    public String getLongestPoliSubString(String s) {
    	int n = s.length();
    	boolean[][] poly = new boolean[n][n];
    	
    	for(int i=0;i<n;i++) {
    		poly[i][i] = true;
    	}
    	
    	int maxPolyLength=1;
    	int startIndexForPoly = 0;
    	
    	for(int i=0;i<n-1;i++) {
    		if(s.charAt(i) == s.charAt(i+1)) {
    			poly[i][i+1] = true;
    			maxPolyLength=2;
    			startIndexForPoly = i;
    		}
    	}
    	
    	for(int length=3;length<=n;length++) {
    		for(int startIndex=0;startIndex<n-length+1;startIndex++) {
    			int endIndex = startIndex+length-1;//
    			
    			if(s.charAt(startIndex)!=s.charAt(endIndex)) {
    				poly[startIndex][endIndex]=false;
    			}else {
    				poly[startIndex][endIndex] = poly[startIndex+1][endIndex-1];
    				if(poly[startIndex][endIndex]) { //Only when true update lengths
    					maxPolyLength = Math.max(maxPolyLength, length);
    					startIndexForPoly = startIndex;
    				}
    			}
    		}
    	}
    	
    	return s.substring(startIndexForPoly,startIndexForPoly+maxPolyLength);
    	
    }
    

    public static void main(String[] args){
        String str = "abbcccbbbcaaccbababcbcabca";
        LongestPolindromeSubstring longestPolindromeSubstring = new LongestPolindromeSubstring();
        System.out.println("answer="+longestPolindromeSubstring.longestPalindrome(str));

    }

}

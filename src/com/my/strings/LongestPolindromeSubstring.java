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

    public static void main(String[] args){
        String str = "abbcccbbbcaaccbababcbcabca";
        LongestPolindromeSubstring longestPolindromeSubstring = new LongestPolindromeSubstring();
        System.out.println("answer="+longestPolindromeSubstring.longestPalindrome(str));

    }

}

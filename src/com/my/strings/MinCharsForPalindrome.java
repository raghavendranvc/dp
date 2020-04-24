package com.my.strings;

public class MinCharsForPalindrome {

    /*

    A.length=7
    0   1   2   3   4   5   6
    A   A   B   B   C   A   B


     */
    public int solve(String A) {
        if(isPalindrome(A)){
            return 0;
        }

        for(int i=1;i<=A.length();i++){
            System.out.println("Checking for length="+i);
            if(isPalindrome(getReverseString(A.substring(A.length()-i).toCharArray())+A)){
                return i;
            }
        }
        return -1;
    }

    public String getReverseString(char[] str){
        for(int i=0;i< str.length/2;i++){
            char ch = str[i];
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = ch;
        }
        return new String(str);
    }

    public boolean isPalindrome(String s){
        System.out.println("Checking s="+s);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String str = "apple";
        MinCharsForPalindrome minCharsForPalindrome = new MinCharsForPalindrome();
        System.out.println("min Chars required="+minCharsForPalindrome.solve(str));
    }
}

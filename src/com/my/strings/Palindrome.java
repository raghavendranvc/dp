package com.my.strings;

public class Palindrome {

    public int isPalindrome(String A) {

        A = A.toLowerCase();

        int i=0;
        int j = A.length()-1;

        while (i<j) {

            if(!isAlphaNumeric(A.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphaNumeric(A.charAt(j))){
                j--;
                continue;
            }
            System.out.println("i="+i+" j="+j+" A.charAt(i)="+A.charAt(i)+" A.charAt(j)="+A.charAt(j));
            if(A.charAt(i) != A.charAt(j)){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }

    private final boolean isAlphaNumeric(char ch){
        // 0 - 9
        if( (int) ch >= (int)'0' && (int) ch <= (int)'9') {
            return true;
        }

        // a-z
        if( (int) ch >= (int)'a' && (int) ch <= (int)'z') {
            return true;
        }

        // A-Z
        /*if( (int) ch >= (int)'A' && (int) ch <= (int)'Z') {
            return true;
        }*/
        return false;
    }

    public static void main(String[] args){
        String str = "A man, a plan, a canal: Panama";
        Palindrome p = new Palindrome();
        System.out.println("result="+p.isPalindrome(str));

    }


}

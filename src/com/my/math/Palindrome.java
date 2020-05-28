package com.my.math;

public class Palindrome {

    // 9052
    // 2   2        905
    // 5   25        90
    // 0   250      9
    // 9    2509    0


    public int isPalindrome(int A) {

        if(A < 0){
            return 0;
        }
        int save = A;

        int reverseNumber = 0;

        while(A > 0){
            reverseNumber = reverseNumber*10 + A%10;
            A=A/10;
        }

        System.out.println("reverserNumber="+reverseNumber);

        if(save == reverseNumber){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args){
        int number = 2147447412;
        Palindrome p = new Palindrome();
        System.out.println("Status="+p.isPalindrome(number));

    }

}

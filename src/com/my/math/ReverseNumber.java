package com.my.math;

public class ReverseNumber {

    public int reverse(int A) {
        boolean isNegative = A < 1;
        if(isNegative){
            A = -A;
        }
        System.out.println("isNegative="+isNegative);
        System.out.println("A="+A);

        long reverseNumber = 0;
        while (A > 0){
            reverseNumber = reverseNumber*10*1L + A%10*1L;
            System.out.println("reverseNumber="+reverseNumber);
            A = A/10;
        }

        int intreverseNum = (int)reverseNumber;
        System.out.println("End intreverseNum="+intreverseNum);

        if(intreverseNum < reverseNumber){
            return 0;
        }

        if(isNegative){
            return -1*intreverseNum;
        } else {
            return intreverseNum;
        }

    }

    public static void main(String[] args){
        int number = -1146467285;
        ReverseNumber reverseNumber = new ReverseNumber();
        System.out.println("reverseNumber="+reverseNumber.reverse(number));
    }

}

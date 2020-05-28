package com.my.math;

public class TrailingZerosInFactorial {

    /*
    1! = 1
    2! = 2
    3! = 6
    4! = 24
    5! = 120
    6! = 720

    10! = 5*   5*2
    15! = 5*   5*2   5*3
    20! = 4*5
    25! = 5*5 + 5
    30!  = 6*5 + 5

    100! = 20*5 + 1*5

    125 =  20*5 + 2*5 + 1*5



     */



    public int trailingZeroes(int A) {
        int numberOfTrailingZeros = 0;
        int divisor = 5;

        while ( A/divisor > 0){
            numberOfTrailingZeros += A/divisor;
            divisor = divisor*5;
        }

        return numberOfTrailingZeros;

    }

    public static void main(String[] args){
        int fact = 64;
        TrailingZerosInFactorial trailingZerosInFactorial = new TrailingZerosInFactorial();
        System.out.println("trailingZerosInFactorial="+trailingZerosInFactorial.trailingZeroes(fact));
    }

}

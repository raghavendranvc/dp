package com.my.bitmanipulation;

public class DivideIntegers {

    public int divideNonBit(int A, int B) {

        if(A == Integer.MIN_VALUE && B == -1){
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if(A < 0){
            sign = sign*-1;
        }

        if(B<0) {
            sign = sign*-1;
        }

        A = Math.abs(A);
        B = Math.abs(B);

        int count=0;

        while(A>=B){
            A = A-B;
            count++;
        }
        return count*sign;
    }

    public int divideNotWorking(int A, int B) {

        int quotient = 1;
        int computedDivisor = B;
        while(computedDivisor <= A){
            computedDivisor = computedDivisor << 1;
            quotient = quotient << 1;
        }

        quotient = quotient + divide(A-computedDivisor,B);

        return quotient;

    }

    public int divideCopiedNonBit(int A, int B) {
        if(A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }

        int ans = 0;
        int check = 1;

        if(A<0)
            check*=-1;

        if(B<0)
            check*=-1;

        A = Math.abs(A);
        B = Math.abs(B);

        while(A-B>=0){
            A-=B;
            ans++;
        }
        return ans*check;
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;

        long ans = ((long)dividend)/divisor, num = Integer.MAX_VALUE;
        if(ans>num) return (int)num;

        return (int)ans;
    }

    public static void main(String[] args){
        DivideIntegers divideIntegers = new DivideIntegers();
        System.out.println(divideIntegers.divide(35, 8));
    }
}

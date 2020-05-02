package com.my.math;

public class GCD {

    public int gcdIter(int A, int B){

        while(B !=0 ) {
            int temp = B;
            B = A % B;
            A = temp;
        }

        return A;

    }

    public int gcdRecur(int A, int B){

        if( B == 0 ){
            return A;
        } else {
            return gcdRecur(B, A%B);
        }
    }

}

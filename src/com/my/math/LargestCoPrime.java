package com.my.math;

public class LargestCoPrime {

    /*
    You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

    X divides A i.e. A % X = 0
    X and B are co-prime i.e. gcd(X, B) = 1
     */



    public int cpFact(int A, int B) {

        if(gcd(A, B) == 1){
            return A;
        } else {
            return cpFact(A/gcd(A,B),B);
        }

    }

    public int gcd(int A, int B){

        if( A == 0){
            return B;
        }

        if( B == 0 ){
            return A;
        }

        if (A > B){
            return gcd( B, A%B);
        } else {
            return gcd(A, B%A);
        }
    }

}

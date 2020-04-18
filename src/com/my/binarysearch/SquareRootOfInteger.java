package com.my.binarysearch;

public class SquareRootOfInteger {

    public int sqrtUsual(int A) {

        int i = 1;
        while (i*i < A) {
            i++;
        }
        if(i*i == A){
            return i;
        } else {
            return i-1;
        }
    }


    public int sqrt(int A) {

        if(A ==0){
            return 0;
        }

        long low = 1; long high = A;

        while (low <= high){
            long mid = (low+high)/2;

            long midSquare = mid*mid;

            if (midSquare == A){
                return (int)mid;
            }

            if(A > midSquare){
                low = mid+1;
            } else if( A < midSquare){
                high = mid-1;
            }
        }
        return (int)high;
    }
}

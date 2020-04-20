package com.my.twopointers;

import java.util.List;

public class Array3Pointers {

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

        int i=0, j=0, k=0;

        int minimumAbsDiff = Integer.MAX_VALUE;
        while(i < A.size() && j <B.size() && k <C.size()){
            minimumAbsDiff = Math.min(minimumAbsDiff, getAbsDifference(A.get(i),B.get(j), C.get(k)));

            if (A.get(i) <= B.get(j) && A.get(i) <= C.get(k)) {
                i++;
            } else if(B.get(j) <= A.get(i) && B.get(j) <= C.get(k)){
                j++;
            } else if(C.get(k) <= A.get(i) && C.get(k) <= B.get(j)){
                k++;
            }
        }

        return minimumAbsDiff;

    }

    public int getAbsDifference(int a, int b, int c) {
        return Math.max(Math.abs(a-b), Math.max(Math.abs(a-c), Math.abs(b-c)));
    }

}

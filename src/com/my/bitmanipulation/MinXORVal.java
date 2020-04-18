package com.my.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class MinXORVal {

    public int findMinXor(ArrayList<Integer> A) {

        Integer[] sortInt = A.toArray(new Integer[A.size()]);
        Arrays.sort(sortInt);

        int minXOR = Integer.MAX_VALUE;

        for(int i=0;i<A.size()-1;i++){
            minXOR = Math.min(minXOR, sortInt[i]^sortInt[i+1]);
        }
        return minXOR;
    }
}

package com.my.arrays;

import java.util.ArrayList;

public class NumberOfContinuousSequences {

    //TODO need to to be refined further. Error Solution

    public int numRange2(ArrayList<Integer> A, int B, int C) {

        int count = 0;
        int result = 0;
        int firstIndexOfSequence = 0;

        for(int i=0;i<A.size();i++){
            count = count+A.get(i);
            if(count > C){
                i++;
                continue;
            }
            firstIndexOfSequence = i+1;
            int save = count;
            for(int j=firstIndexOfSequence;j<A.size();) {
                int newSum = count+A.get(j);
                if(newSum >= B && newSum <= C){
                    count = newSum;
                    j++;
                    result++;
                    continue;
                } else if (newSum < B){
                    count = newSum;
                    j++;
                    continue;
                } else if (newSum > C) {
                    firstIndexOfSequence++;
                    j = firstIndexOfSequence;
                    count = save;
                }
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[] a= new int[]{10, 5, 1, 0, 2};



    }

}

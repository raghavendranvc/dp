package com.my.twopointers;

import java.util.ArrayList;

public class ContainerWithMostWater {

    /**
     * 1    5   4   3
     *
     * 1    4   3
     *
     * 1    1   1   =3
     *      3   3   =6
     *      0   3   =3
     *
     * 1    1   1   1
     * 0    5   4   3
     * 0    0   4   3
     * 0    0   0   3
     *
     *
     * 1    3   3   3
     * 1    4   4   0
     * 1    5   0   0
     * 1    1   1   1
     */

    public int maxArea(ArrayList<Integer> A) {

        if(A == null || A.size() < 2){
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;

        for(int start=0, end = A.size()-1; start<end;){
            maxArea = Math.max(maxArea, Math.min(A.get(start),A.get(end))* (end-start));

            if(A.get(start) < A.get(end)){
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }




    public int maxAreaCopied(ArrayList<Integer> A) {
        long max = Integer.MIN_VALUE;
        if (A == null || A.size()<2)
            return 0;

        int start = 0;
        int end = A.size()-1;

        while (start<end){
            long water = (end-start)*Math.min(A.get(start), A.get(end));
            max = Math.max (water,max);

            if (A.get(start)<A.get(end))
                start++;
            else
                end--;
        }

        return (int) max;
    }

}

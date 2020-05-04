package com.my.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {


    /*

    4 -4 2
    4  0  5
    0  4  3

    -4  2 4
    0  4  5

    4  2  1

     */

    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);

        int maxTime = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            maxTime = Math.max(maxTime, Math.abs(A.get(i)-B.get(i)));
        }
        return maxTime;
    }

}

package com.my.greedy;

import java.util.ArrayList;

public class BulbFlips {

    /*

    0 1 0 1
    If 1 and evenFlips no need for flips
    If 0 and oddFlips then no need to flips
    else incrementFlips by 1


     */
    public int bulbs(ArrayList<Integer> A) {
        int flips = 0;
        for(int i : A){
            if( (i == 0 && flips%2 == 0) || (i == 1 && flips%2 == 1)){
                flips++;
            }
        }
        return flips;
    }
}

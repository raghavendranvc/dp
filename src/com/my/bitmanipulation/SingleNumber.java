package com.my.bitmanipulation;

import java.util.List;

public class SingleNumber {

    public int singleNumberNotTwice(final List<Integer> A) {


        // A = 1 1 0 0 1 1 1
        // A = 1 1 0 0 1 1 1
        //A^A= 0 0 0 0 0 0 0 = 0

        // A = 1 1 0 0 1 1 1
        // 0 = 0 0 0 0 0 0 0
        //A^0= 1 1 0 0 1 1 1 = A

        int single = A.get(0);
        for(int i=1;i<A.size();i++){
            single = single ^ A.get(i);
        }
        return single;
    }

    public int singleNumber(final List<Integer> A) {

    	//TODO 
    	
        // A ^ B ^ C = X
        // A ^ B ^ C = X
        //  3 3 1 = 1 1 1
        //  6 6 2 = 0 0 0
        //  9 9 3 = 1 1 1

        /*
        1
        1
        1
         */

        int ones = 0;
        int twos = 0;

        int commonBitMask = 0 ;
        for(int i=0;i<A.size();i++){
            twos = twos | (ones & A.get(i));
            ones = ones ^ A.get(i);

            commonBitMask = ~ (ones & twos);

            ones &= commonBitMask;
            twos &= commonBitMask;

        }

        return ones;

    }

}

package com.my.arrays;

import java.util.List;

public class DuplciateNumber {

    public int repeatedNumber(final List<Integer> A) {

        int[] tempArray = new int[A.size()+1];

        for(int i=0;i<A.size();i++){

            int element = A.get(i);

            if(tempArray[element-1] == element){
                return element;
            } else {
                tempArray[element-1] = element;
            }

        }

        return -1;

    }
}

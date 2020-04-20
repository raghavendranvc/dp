package com.my.twopointers;

import java.util.*;

public class MergeTwoSortedArrays {

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        /*

        1   3   5   7   9   11
        2   4   6   8   10  12

        1   2   5
        3   4

        i=0
        j=0

        i=1
        j=0

        -4  3
        -2  -2

        i=0,j=0
        -4  3
        -2  -2

        i=1,j=0
            -2
        3   -2

        -4  3
        -2  -2

        -4  -2  -2  3

         */

        ArrayList<Integer> tempList = new ArrayList<>(a);
        a.clear();

        int i =0, j=0;
        while(i<tempList.size() && j<b.size()){
            if(tempList.get(i)>b.get(j)){
                a.add(b.get(j));
                j++;
            } else {
                a.add(tempList.get(i));
                i++;
            }
        }

        while(i < tempList.size()){
            a.add(tempList.get(i));
            i++;
        }

        while(j < b.size()){
            a.add(b.get(j));
            j++;
        }

    }



}

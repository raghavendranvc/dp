package com.my.binarysearch;

import java.util.ArrayList;

public class SortedInsertPosition {

    /*
        finding first greater element
     */
    public int searchInsert(ArrayList<Integer> a, int b) {

        if(a.get(0) > b){
            return 0;
        }

        if(a.get(a.size()-1) < b){
            return a.size();
        }

        int low = 0;int high = a.size()-1;

        while (low <= high){
            int mid = (low+high)/2;

            if(b == a.get(mid)){
                return mid;
            }

            if(b > a.get(mid)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

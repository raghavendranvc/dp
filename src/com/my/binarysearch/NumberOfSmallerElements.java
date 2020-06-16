package com.my.binarysearch;

import java.util.List;

public class NumberOfSmallerElements {

    /*
    0       1       2       3       4       5       6       7       8       8       9      10       11                                                                                      11
    left                                                                                            right
    1       2       2       4       4       5       5       6       8       9       10      30      42


    number = 15
    left=0, right=11 , mid = 0 + (11-0)/2 = 5
    left=6  right=11,  mid = 6+5/2 = 8
    left=9  right=11   mid = 9+1 =10
    left=9  right=9    mid = 9

    number = 4
    left=0 right=11, mid = 5
    left=0 right=4  mid = 2
    left=3 right=4  mid = 3+1/2=3 (4 <=4)
    left=3 right=2

     */
    private int numberOfSmallerElements(final List<Integer> a, int number){
        int left = 0;
        int right = a.size()-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(number <= a.get(mid)){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}

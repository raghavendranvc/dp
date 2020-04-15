package com.my.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxUnosrtedSubArray {

    // 6 7 8 9 1 2 3 4
    // 1 4 3 2 6 7 8 9
    // 4 1 3 7 8 2 9 5

    // 1 2 3 4 6 7 8 9
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

        Integer[] sortedList = A.toArray(new Integer[A.size()]);
        Arrays.sort(sortedList);

        System.out.println("Oringal List="+A);
        System.out.println("Sorted List="+sortedList);

        int left = 0;
        while(left <A.size() && A.get(left) == sortedList[left]){
            left++;
        }

        int right = A.size()-1;
        while(right>=0 && A.get(right) == sortedList[right]){
            right--;
        }

        if(left < right){
            return new ArrayList(Arrays.asList(left,right));
        }

        ArrayList<Integer> returnList = new ArrayList<>();
        returnList.add(-1);

        return returnList;
    }

    //TODO

    //      4 1 3 7 8 2 9 5
    //max   4 4 4 7 8 8 9 9
    //min   1 1 2 2 2 2 5 5
    public ArrayList<Integer> subUnsortE(ArrayList<Integer> A) {
        int n = A.size();

        //Calculate min for each i where min is smallest between i and n.
        //So good to start from the back - where we find the minimum and set it at i


        int[] mins = new int[n];
        mins[n-1] = A.get(n-1);
        for(int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(A.get(i), mins[i+1]);
        }

        int start = 0;
        while (start < n && mins[start] == A.get(start)) {
            start++;
        }

        //Calculate max for each i where max is largest between 0 and i
        //We shall start from the begining - where we find the maximum and set it at i

        int[] maxs = new int[n];
        maxs[0] = A.get(0);
        for(int i = 1; i < n; i++) {
            maxs[i] = Math.max(A.get(i), maxs[i-1]);
        }

        int end = n - 1;
        while (end >= 0 && maxs[end] == A.get(end)) {
            end--;
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(start == n) {
            result.add(new Integer(-1));
        }
        else {
            result.add(new Integer(start));
            result.add(new Integer(end));
        }
        return result;
    }

}

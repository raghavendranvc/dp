package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;

public class WaveArray {

    //  6, 0, 6, 12 12
    //  0  6  6  12 12
    //  0  12 6  12  6

    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        if(A.size() < 2){
            return A;
        }
        Integer[] values = A.toArray(new Integer[A.size()]);
        Arrays.sort(values);

        for(int i=0;i<values.length-1;i+=2) {
            swap(values,i,i+1);
        }

        return new ArrayList<>(Arrays.asList(values));
    }

    private void swap(Integer[] A, int i, int j){
        int save = A[i];
        A[i] = A[j];
        A[j] = save;
    }

    //NOT Correct
    public ArrayList<Integer> wave1(ArrayList<Integer> A) {

        Integer[] values = A.toArray(new Integer[A.size()]);
        Arrays.sort(values);
        UtilityClass.print(values);

        // 1 1 1 2 2 2 3 4 4 4 5 6
        // 2 2 2 1 1 1 4 4 4 3 6 5
        int startIndex = 0;
        int endIndex = -1;

        for(int i=1;i<values.length;i++){
            if(values[startIndex] == values[i]) {
                System.out.println("incrementing startIndex="+startIndex);
                continue;
            }

            if(endIndex == -1) {
                endIndex = i;
                System.out.println("endIndex set="+endIndex);
                continue;
            }

            if(values[endIndex] == values[i]) {
                System.out.println("moving endIndex="+i);
                endIndex = i;
                continue;
            }

            System.out.println("startIndex="+startIndex+ " endIndex="+endIndex);
            reverseArray(values,startIndex,endIndex);

            startIndex = i;
            endIndex = -1;
            System.out.println("New startIndex="+startIndex+ " erased endIndex="+endIndex);
        }
        reverseArray(values, startIndex, endIndex);

        return new ArrayList<>(Arrays.asList(values));
    }

    public void reverseArray(Integer[] A, int s, int e){
        while(s<e) {
            int save = A[s];
            A[s] = A[e];
            A[e] = save;
            s++;
            e--;
        }
        UtilityClass.print(A);
    }

    public static void main(String[] argrs){
        //int[] a = new int[] {5, 1, 3, 2, 4 };
        int[] a = new int[] {6, 17, 15, 13  };
        UtilityClass.print(a);

        ArrayList<Integer> intList = new ArrayList<Integer>(a.length);
        for (int i : a)
        {
            intList.add(i);
        }
        WaveArray waveArray = new WaveArray();
        ArrayList<Integer> returnList = waveArray.wave(intList);
        System.out.println(returnList);
    }
}

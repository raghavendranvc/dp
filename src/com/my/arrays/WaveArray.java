package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;

public class WaveArray {

    //  6, 0, 6, 12 12
    //  0  6  6  12 12
    //  0  12 6  12  6
	
	// 1 2 3 4 5 6 7 8 9 10
	// 2 1 4 3 6 5 8 7 10 9

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

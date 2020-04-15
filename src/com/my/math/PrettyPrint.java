package com.my.math;

import com.my.common.UtilityClass;

import java.util.ArrayList;

public class PrettyPrint {

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        int arraySize = 2*A-1;
        int[][] result = new int[arraySize][arraySize];
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        for(int i=0;i<arraySize;i++){
            ArrayList<Integer> integers = new ArrayList<>();
            for(int j=0;j<arraySize;j++){
                integers.add(0);
            }
            resultList.add(integers);
        }

        for(int i=0;i<A;i++){
            for(int j=i;j<arraySize-i;j++){
                resultList.get(i).set(j,A-i);
                resultList.get(j).set(i,A-i);
                resultList.get(arraySize-1-i).set(j,A-i);
                resultList.get(j).set(arraySize-1-i,A-i);
                result[i][j]                = A-i;
                result[j][i]                = A-i;
                result[arraySize-1-i][j]    = A-i;
                result[j][arraySize-1-i]    = A-i;
            }
        }

        //UtilityClass.printArray(result);

        return resultList;
    }

    public static void main(String[] args){
        PrettyPrint p = new PrettyPrint();
        p.prettyPrint(4);
    }


}

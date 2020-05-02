package com.my.backtracking;

import java.util.ArrayList;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == 0 || B ==0 || B > A){
            return result;
        }

        combine(A, B, result, 1, new ArrayList<>());
        return result;
    }

    private void combine(int A, int B, ArrayList<ArrayList<Integer>> result, int startNum, ArrayList<Integer> tempArray){

        if(tempArray.size() == B){
            System.out.println("Adding tempArray="+tempArray);
            result.add(new ArrayList<>(tempArray));
        }

        for(int i=startNum;i<=A;i++){
            tempArray.add(i);
            combine(A, B, result, i+1, tempArray);
            tempArray.remove(tempArray.size()-1);
        }

    }

    public static void main(String[] args){
        Combinations combinations = new Combinations();
        System.out.println("Result="+combinations.combine(1,1));

    }

}

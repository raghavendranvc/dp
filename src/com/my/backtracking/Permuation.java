package com.my.backtracking;

import java.util.ArrayList;

public class Permuation {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == null || A.isEmpty()){
            return result;
        }
        permute( A,  result, 0);
        return result;
    }

    private void permute(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, int startIndex){
        if(startIndex == A.size()){
            System.out.println("Added result="+A);
            result.add(new ArrayList<>(A));
            return;
        }

        for(int k=startIndex; k < A.size();k++){
            System.out.println("New startIndex="+startIndex+" k="+k +" A="+A);
            swap(A,startIndex,k);
            permute( A,  result, startIndex+1);
            swap(A,startIndex,k);
            System.out.println("Backtrack startIndex="+startIndex+" k="+k +" A="+A);
            //System.out.println("k="+k+" startIndex="+startIndex +" new tempArray="+tempArray);
        }
    }

    private void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }


    public static void main(String[] args){
        int[] a = {1,2,3};
        ArrayList<Integer> A = new ArrayList<>();
        for(int i : a){
            A.add(i);
        }
        Permuation permuation = new Permuation();
        System.out.println("Result="+permuation.permute(A));
    }

}



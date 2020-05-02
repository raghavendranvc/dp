package com.my.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsDuplicates {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == null) {
            return null;
        }
        result.add(new ArrayList<>());
        if(A.isEmpty()){
            return result;
        }
        Collections.sort(A);
        subsetsWithDup( A,  result,  0, new ArrayList<>());
        return result;
    }

    public void subsetsWithDup(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, int startIndex, ArrayList<Integer> tempArray) {
        for(int i=startIndex;i<A.size();i++){
            tempArray.add(A.get(i));
            if(!result.contains(tempArray)) {
                System.out.println("Result=" + tempArray);
                result.add(new ArrayList<>(tempArray));
            }
            subsetsWithDup(A, result, i + 1, tempArray);
            tempArray.remove(tempArray.size() - 1);
        }
    }

    public static void main(String[] args){
        int a[] = {1,2,2};
        ArrayList<Integer> A = new ArrayList<>(a.length);
        for (int i : a){
            A.add(i);
        }

        SubsetsDuplicates s = new SubsetsDuplicates();
        System.out.println("Result="+s.subsetsWithDup(A));

    }
}

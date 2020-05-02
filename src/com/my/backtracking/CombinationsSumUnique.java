package com.my.backtracking;

import java.util.*;

public class CombinationsSumUnique {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a.isEmpty()){
            return result;
        }
        /*Set<Integer> setA = new HashSet<>(a);
        a.clear();
        Integer[] aInt = setA.toArray(new Integer[setA.size()]);
        List<Integer> A2 = Arrays.asList(aInt);
        a.addAll(A2);*/

        Collections.sort(a);

        combinationSum( a,  b,  result, 0,  0 , new ArrayList<>());
        return result;
    }

    public void combinationSum(ArrayList<Integer> a, int b, ArrayList<ArrayList<Integer>> result, int startIndex, int currentSum, ArrayList<Integer> tempArray){
        if(currentSum == b){
            if(!result.contains(tempArray)) {
                System.out.println("Adding array=" + tempArray);
                result.add(new ArrayList<>(tempArray));
            }
            return;
        }

        if(currentSum > b){
            return;
        }

        System.out.println("starting index=" + startIndex + " current sum=" + currentSum + " tempArry=" + tempArray);

        for(;startIndex<a.size();startIndex++) {
            /*if(startIndex > 1 && a.get(startIndex)  == a.get(startIndex-1)){
                continue;
            }*/

            if (a.get(startIndex) + currentSum <= b) { //Check first and proceed further
                tempArray.add(a.get(startIndex));
                combinationSum( a,  b,  result, startIndex+1, currentSum+a.get(startIndex), tempArray);
                tempArray.remove(tempArray.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        int a[] = {8, 10, 6, 11, 1, 16, 8};
        ArrayList<Integer> A = new ArrayList<>(a.length);
        for (int i : a){
            A.add(i);
        }
        int B = 28;
        CombinationsSumUnique combinationSum = new CombinationsSumUnique();
        System.out.println("Result="+combinationSum.combinationSum(A,B));
    }

}

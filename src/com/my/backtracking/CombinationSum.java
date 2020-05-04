package com.my.backtracking;

import java.util.*;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A); //Should remove duplicates
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinationSum(A, B, 0, 0, result, new ArrayList<>());
        return result;
    }

    public void combinationSum(ArrayList<Integer> A, int B, int startIndex, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempArray) {
        if (sum == B) {
            System.out.println("Adding array=" + tempArray);
            result.add(new ArrayList<>(tempArray));
            return;
        }

        if (sum > B) {
            return;
        }

        System.out.println("starting index=" + startIndex + " current sum=" + sum + " tempArry=" + tempArray);

        while (startIndex < A.size()) {

            if(startIndex>0  && (A.get(startIndex)==A.get(startIndex-1))){
                //(A.get(startIndex)==A.get(startIndex-1)) is needed when duplicates are present
                System.out.println("Same starting index=" + startIndex+" value="+A.get(startIndex));
                startIndex++;
                continue;
            }

            if (sum + A.get(startIndex) <= B) {
                tempArray.add(A.get(startIndex));
                combinationSum(A, B, startIndex, sum + A.get(startIndex), result, tempArray); //ignoring the startIndex number
                tempArray.remove(tempArray.size() - 1);
            }
            startIndex++;
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSumCopied(ArrayList<Integer> a, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        Collections.sort(a);//the element should be in non decreasing order as per the question
        //call the function
        func(arr,list,a,k,0,0);
        return arr;
    }

    void func(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> list,ArrayList<Integer> nums,int k,int currentsum,int i) {
        if(currentsum>k) {//return and undo the last elemnt added
            return;
        }
        if(currentsum==k) {//we found a solution..add it to the main list
            arr.add(new ArrayList<>(list));
            return;
        }
        for(;i<nums.size();i++) {//since an element can be repeated any number of times we start iterating from the last visited number
            if(i>0 && nums.get(i) == nums.get(i-1)) {
                continue;//to remove the duplicate nos.
            }

            if(nums.get(i)+currentsum<=k) {
                list.add(nums.get(i));
                func(arr,list,nums,k,currentsum+nums.get(i),i);
                list.remove(list.size()-1);//undo the elemnt added and iterate for the next element
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getCombinations(ArrayList<Integer> A, int B){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A.size() == 0 ){
            return result;
        }
        HashSet<Integer> h = new HashSet<>(A);//Deduping
        Integer[] a = h.toArray(new Integer[h.size()]);
        List<Integer> A2 = Arrays.asList(a);
        A.clear();
        A.addAll(A2);
        Collections.sort(A);

        getCombination( A,  B,  result, 0, 0, new ArrayList<>());
        return result;
    }

    public void getCombination(ArrayList<Integer> A, int B,ArrayList<ArrayList<Integer>> result, int startIndex, int currentSum, ArrayList<Integer> tempArray){
        if(currentSum == B){
            result.add(new ArrayList<>(tempArray));
            return;
        }

        if(currentSum > B){
            return;
        }

        for(;startIndex<A.size();startIndex++) {
            if (A.get(startIndex) + currentSum <= B) {
                tempArray.add(A.get(startIndex));
                getCombination( A,  B,  result, startIndex, currentSum+A.get(startIndex), tempArray);
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
        CombinationSum combinationSum = new CombinationSum();
        System.out.println("Result="+combinationSum.getCombinations(A,B));
    }

}

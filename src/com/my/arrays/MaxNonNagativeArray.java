package com.my.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxNonNagativeArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {

        if(A == null || A.size() ==0){
            return new ArrayList<>();
        }

        List<Integer> startIndex = new ArrayList<>();
        List<Integer> endIndex = new ArrayList<>();

        int subArrayIndex=0;
        boolean newSubArray = true;

        for(int i=0; i< A.size(); i++){

            if(A.get(i) < 0){
                newSubArray = true;
                continue;
            }

            if(newSubArray) {
                startIndex.add(i);
                endIndex.add(i); // This create element at that place
                newSubArray = false;
                subArrayIndex++;
            }
            endIndex.set(subArrayIndex-1,i); // This updates the element at that index

        }

        if(startIndex.size() ==0){
            return new ArrayList<>();
        }

        System.out.println("startIndex="+startIndex);
        System.out.println("endIndex="+endIndex);

        int maxArraySizeIndex = 0;
        long maxSubArraySum = sum(A,startIndex.get(maxArraySizeIndex),endIndex.get(maxArraySizeIndex));
        System.out.println("start: maxArraySizeIndex="+maxArraySizeIndex+ " maxSubArraySum="+maxSubArraySum+" maxArraySizeIndex="+maxArraySizeIndex);

        for(int i=1;i<subArrayIndex;i++) {

            long newSubArraySum = sum(A,startIndex.get(i),endIndex.get(i));

            if(newSubArraySum > maxSubArraySum) {
                maxArraySizeIndex = i;
                maxSubArraySum = newSubArraySum;
                System.out.println("maxArraySizeIndex="+maxArraySizeIndex+ " maxSubArraySum="+maxSubArraySum+" maxArraySizeIndex="+maxArraySizeIndex);
            }
        }

        return new ArrayList(A.subList(startIndex.get(maxArraySizeIndex),endIndex.get(maxArraySizeIndex)+1));
    }

    private long sum(ArrayList<Integer> A, int startIndex, int endIndex) {
        long sum = 0;
        for(int i=startIndex;i<=endIndex;i++){
            sum = sum + A.get(i);
        }
        return sum;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList();
        a.add(  336465782);
        a.add( -278722862);
        a.add( -2145174067);
        a.add(  1101513929);
        a.add(  1315634022);
        a.add(  -1369133069);
        a.add(  1059961393);
        a.add(  628175011);
        a.add(  -1131176229);
        a.add(  -859484421);

        System.out.println(a);
        MaxNonNagativeArray s = new MaxNonNagativeArray();
        System.out.println(s.maxset(a));

    }
}

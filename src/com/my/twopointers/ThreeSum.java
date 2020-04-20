package com.my.twopointers;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> A, int B) {

        Integer[] sortedA = A.toArray(new Integer[A.size()]);
        Arrays.sort(sortedA);
        UtilityClass.print(sortedA);

        long minTripletSum = Integer.MAX_VALUE;
        long returnSum = minTripletSum;
        for(int i=0;i<sortedA.length;i++){
            for(int j=i+1,k=sortedA.length-1;j<k;){
                long tempSum = sortedA[i] + sortedA[j] + sortedA[k];
                System.out.println("sortedA[i]="+sortedA[i]+" sortedA[j]="+sortedA[j]+" sortedA[k]="+sortedA[k]+" tempSum="+tempSum +" minTripletSum="+minTripletSum +" returnSum="+returnSum);
                if(minTripletSum > Math.abs(tempSum-B)){
                    minTripletSum = Math.abs(tempSum-B);
                    returnSum = tempSum;
                    System.out.println("new  minTripletSum="+minTripletSum +" returnSum="+returnSum);
                }

                if(tempSum < B){
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println("returnSum="+returnSum);
        return (int)returnSum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2147483647, -2147483648, -2147483648, 0, 1};
        int B = 0;
        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a){
            intListA.add(i);
        }
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSumClosest(intListA,B);

    }
}

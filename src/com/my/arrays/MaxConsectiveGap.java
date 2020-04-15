package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.*;

public class MaxConsectiveGap {

    // Size = 9
    // 10   20  24  5   8   34  19  22  16
    //  5   8   10  16  19  20  22  24  34

    public int maximumGap(final List<Integer> A) { //TODO Not done

        if(A.size() <=2){
            return 0;
        }

        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++){
            maxElement = Math.max(maxElement,A.get(i));
            minElement = Math.min(minElement,A.get(i));
        }

        int difference = maxElement - minElement;   //29
        int bucketSize = difference/(A.size());       //(29+8)/9 = 4  or 29/3=4

        int[] verification = new int[bucketSize*2];
        System.out.println("bucketSize="+bucketSize+" difference="+difference);

        for(int i=0;i<A.size();i++){

            int element = A.get(i);
            int bucket = element/bucketSize;
            System.out.println("i="+i+" element="+element+" bucket="+bucket);
            if(verification[2*bucket] ==0 || element < verification[2*bucket+1]){
                verification[2*bucket] = element;
            }

            if(verification[2*bucket] ==0 || element > verification[2*bucket+1]){
                verification[2*bucket+1] = element;
            }

        }

        int maxGap=0;
        for(int i=0;i<verification.length-1;i++){
            maxGap=Math.max(maxGap,(verification[i+1]-verification[i]));
        }

        return maxGap;
//        for(int i=0;i<verification.length;i++)

    }

    public static void main(String[] args){
        //int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683, 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653, 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406, 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557, 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160, 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742  };
        //int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};
        int[] a = new int[] {1, 10, 5};
        UtilityClass.print(a);

        ArrayList<Integer> intList = new ArrayList<>(a.length);
        for (int i : a){
            intList.add(i);
        }
        MaxConsectiveGap maxConsectiveGap = new MaxConsectiveGap();

        System.out.println("Max Distance="+maxConsectiveGap.maximumGap(intList));
    }
}

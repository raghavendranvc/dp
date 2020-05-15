package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

    //[3 5 4 2]

    // 3 3 3 2 (min)
    // 5 5 4 2 (max)



    // 2 (3,4)
    //   0 0  0

	//TODO . Understand the idea behind this again
	// We get the minSofar (from start). min of the array will be at nth element
	// We get the maxSofar (from end). max of the array will be at 0th element
	// We now work on these arrays observing the diff
	// 		We increment maxSoFar if we see max is increasing. 
	// 		But if we see minSoFar has higher value then we increase it.
	
    public int maximumGap(final List<Integer> A) {

        int[] min = new int[A.size()];
        min[0] = A.get(0);
        for(int i=1;i<A.size();i++){
            min[i] = Math.min(min[i-1],A.get(i));
        }


        int[] max = new int[A.size()];
        max[A.size()-1] = A.get(A.size()-1);
        for(int j=A.size()-2;j>=0;j--){
            max[j] = Math.max(max[j+1],A.get(j));
        }

        int i=0;
        int j=0;

        int maxGap = Integer.MIN_VALUE;
        while(i<A.size() && j< A.size()){
            if(min[i] <= max[j]){
                maxGap = Math.max(maxGap, j-i);
                j++;
            } else {
                i++;
            }
        }

        return maxGap;

    }

    /*
    public void mergeSort(int[] array){
        mergeSort(array,0,array.length-1);
    }

    public void mergeSort(int[] array, int l, int r){

        if(l<r) {

            int middle = (l + r) / 2;
            mergeSort(array, l, middle);
            mergeSort(array, middle + 1, r);
            merge(array, l, middle, r);
        }
    }

    public void merge(int[] array, int l, int m, int r){

        int[] leftArray = new int[m-l+1];
        int k =0;
        for(int i=l;i<=m;i++){
            leftArray[k++] = array[i];
        }

        int[] rightArray = new int[r-m];
        k =0;
        for(int i=m;i<=r;i++){
            rightArray[k++] = array[i];
        }

        int i=0, j=0, t=l;

        while (i<leftArray.length && j<rightArray.length) {
            if(leftArray[i] <= rightArray[j]){
                array[t++] = leftArray[i++];
            } else {
                array[t++] = rightArray[j++];
            }
        }

        while (i<leftArray.length){
            array[t++] = leftArray[i++];
        }

        while (i<rightArray.length){
            array[t++] = rightArray[j++];
        }
    }
    */

    public int maximumGap1(final List<Integer> A) {

        int maxDistance = Integer.MIN_VALUE;

        for(int i=0;i<A.size();i++) {

        	//optimising condition to terminate. We will not find better distance
            if(maxDistance > A.size() -i){ 
                break;
            }

            // This is also another optimisation.
            // If the previous number was less, and if there is a distance
            // we would have found earlier. So we can discard this number as 
            // it does not add any value now.
            if(i>1 && A.get(i-1) < A.get(i)){
                continue;
            }

            for(int j=A.size()-1;j>=i; j--){

                if(A.get(j)>=A.get(i)){
                    maxDistance = Math.max(maxDistance, j-i);
                    break;
                }
            }

        }
        return maxDistance;
    }



    public static void main(String[] args){
        //int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683, 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653, 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406, 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557, 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160, 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742  };
        //int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};
        int[] a = new int[] {1, 10};
        UtilityClass.print(a);

        ArrayList<Integer> A = new ArrayList<>(a.length);
        for (int i : a){
            A.add(i);
        }
        MaxDistance maxDistance = new MaxDistance();

        System.out.println("Max Distance="+maxDistance.maximumGap(A));
    }

}

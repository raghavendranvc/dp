package com.my.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class RotatedSortedArraySearch {

    /*
    Not found return -1;
     */
    public int search(final List<Integer> A, int B) {

        int count = A.size();
        int low = 0;
        int high = count-1;

        /***
         * l                            mid                         h
         * 0    1   2   3   4   5   6   7   8   9   10  11  12  13  14
         * 8    9   10  11  12  13  14  15  16  3   4   5   6   7   7
         *
         * Find 4
         *
         * mid = 15
         * mid = 16
         */

        while(low <= high){
            int mid = low + (high-low)/2;
            System.out.println("Starting :: A.get("+low+")="+A.get(low)+" A.get("+mid+")="+A.get(mid)+" A.get("+high+")="+A.get(high));

            if(A.get(mid) == B){
                System.out.println("returning mid="+mid);
                return mid;
            }

            if(A.get(mid) >= A.get(low)) { //First half of the array is sorted
                if(B <= A.get(mid) && B >= A.get(low)){ //Check if element is within the sorted array
                    high = mid - 1;
                    System.out.println("normal new high :: A.get("+low+")="+A.get(low)+" A.get("+mid+")="+A.get(mid)+" A.get("+high+")="+A.get(high));
                } else {
                    low = mid + 1;
                    System.out.println("Reveresed low :: A.get("+low+")="+A.get(low)+" A.get("+mid+")="+A.get(mid)+" A.get("+high+")="+A.get(high));
                }
            } else { //First half is unsorted. So Second half is sorted
                if( B >= A.get(mid) && B <= A.get(high)){ // Check if element is within the sorted array(2nd half)
                    low = mid+1;
                    System.out.println("normal new low :: A.get("+low+")="+A.get(low)+" A.get("+mid+")="+A.get(mid)+" A.get("+high+")="+A.get(high));
                } else {
                    high = mid-1;
                    System.out.println("Reveresed high :: A.get("+low+")="+A.get(low)+" A.get("+mid+")="+A.get(mid)+" A.get("+high+")="+A.get(high));
                }
            }
            System.out.println();
        }

        return -1;
    }

    public int searchRecurs(final List<Integer> A, int key, int l,int r) {

        if(l>r){
            return -1;
        }

        int mid = l + (r-l)/2;

        if(A.get(mid) == key){
            return mid;
        }

        if(A.get(l) <= A.get(mid)){ //Array from l...mid is sorted
            if(key >= A.get(l) && key <= A.get(mid)){ //Check if the key is in this Sorted array
                return searchRecurs(A,1,mid-1,key);
            } else {
                return searchRecurs(A,mid+1,r,key);
            }
        } else { // Array from 1...mid is not sorted. So the other half is Sorted
            if(key >= A.get(mid) && key <= A.get(r)){  //Check if the key is in the other Sorted arrya
                return searchRecurs(A,mid+1,r,key);
            } else {
                return searchRecurs(A, l, mid-1,key);
            }
        }
    }

    public static void main(String[] args){
        //int[] A =  new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        int[] A =  new int[]{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int B = 202;

        ArrayList<Integer> intList = new ArrayList<>(A.length);
        for (int i : A){
            intList.add(i);
        }
        System.out.println("Initial Array="+intList);

        RotatedSortedArraySearch rotatedSortedArraySearch = new RotatedSortedArraySearch();
        int index = rotatedSortedArraySearch.search(intList,B);

        System.out.println("Element="+B+" found at index="+index);
    }

}

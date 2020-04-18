package com.my.binarysearch;

public class BinarySearch {

    public int search(int[] A, int x){
        return searchRecur(A,0, A.length-1,x);
    }

    public int searchRecur(int[] A,int l, int r, int x){

        if(l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == x) {
                return mid;
            } else if (A[mid] > x) {
                return searchRecur(A, l, mid - 1, x);
            } else {
                return searchRecur(A, mid + 1, r, x);
            }
        }
        return -1;
    }

    //A ,   5, 20  25/2=12
    //A,    6, 20  26/2=13

    public int search(int[] A,int l, int r, int x){

        while(l <= r){
            int mid = (l+r)/2;
            if(A[mid]==x){
                return mid;
            } else if(A[mid] > x){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

}

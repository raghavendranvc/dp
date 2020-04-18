package com.my.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class ArrayMedian {

    public double findMedianSortedArraysNot(final List<Integer> a, final List<Integer> b) {
        int aSize = a.size();
        int bSize = b.size();

        int min = Math.min(a.get(0),b.get(0));
        int max = Math.max(a.get(aSize-1),b.get(bSize-1));

        while(min <= max){
            int mid = min + (max-min)/2;
            int count = numberOfSmallerElements(a, mid);
            count = count+numberOfSmallerElements(b, mid);
            if(count <= (aSize+bSize)/2){
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        boolean isOdd = ((aSize+bSize)%2 == 1);

        if(a.get(aSize-1) < min){
            return findFirstGreaterElement(b,max);
        } else if(b.get(bSize-1) < min){
            return findFirstGreaterElement(a,max);
        } else {
            int a1 = findFirstGreaterElement(a,max);
            int b1 = findFirstGreaterElement(b,max);
            return (a1+b1)/2;
        }
    }

    private int findFirstGreaterElement(final List<Integer> a, int number){
        return -1;
    }

    /*
    0       1       2       3       4       5       6       7       8       8       9      10       11                                                                                      11
    left                                                                                            right
    1       2       2       4       4       5       5       6       8       9       10      30      42


    number = 15
    left=0, right=11 , mid = 0 + (11-0)/2 = 5
    left=6  right=11,  mid = 6+5/2 = 8
    left=9  right=11   mid = 9+1 =10
    left=9  right=9    mid = 9

    number = 4
    left=0 right=11, mid = 5
    left=0 right=4  mid = 2
    left=3 right=4  mid = 3+1/2=3 (4 <=4)
    left=3 right=2

     */
    private int numberOfSmallerElements(final List<Integer> a, int number){
        int left = 0;
        int right = a.size()-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(number <= a.get(mid)){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int total = a.size() + b.size();
        if(total % 2 == 1) {
            return findKthSmallestNumber(a, 0 , b, 0 , total/2+1);
        } else {
            return (findKthSmallestNumber(a, 0 , b, 0 , total/2) + findKthSmallestNumber(a, 0 , b, 0 , total/2+1))/2.0;
        }
    }

    public int findKthSmallestNumber(List<Integer> A, int aIndex, List<Integer> B, int bIndex, int k){

        /*
         A is all finished searching for kth smallest Number. We reached the end of A
         In that case, kth smallest element is in B which is at location bIndex+k-1
         */
        if(aIndex >= A.size()){
            return B.get(bIndex+k-1);
        }

        if(bIndex>=B.size()){
            return A.get(aIndex+k-1);
        }

        /*
            When K == 1, is the lowest condition
            where we are looking for the smallest element in the current set of arrays.
            So just return the minimum of both the arrays at the current index
         */
        if(k==1){
            return Math.min(A.get(aIndex), B.get(bIndex));
        }


        /**
         * Get k/2 element smallest element in A.
         * k/2 smallest element in A is at aIndex+k/2-1
         * If not possible return Max Integer
         */
        int kBy2thSmallestElementInA = Integer.MAX_VALUE;
        int kBy2thSmallestElementInB = Integer.MAX_VALUE;

        if(aIndex + k/2 -1 < A.size()){
            kBy2thSmallestElementInA = A.get(aIndex+k/2-1);
        }

        if(bIndex + k/2 -1 < B.size()){
            kBy2thSmallestElementInB = B.get(bIndex+k/2-1);
        }

        /**
         * We now check which among is smaller and take that route to find the
         * smaller set
         */

        if(kBy2thSmallestElementInA  <  kBy2thSmallestElementInB){
            return findKthSmallestNumber(A, aIndex+k/2, B, bIndex, k-k/2);
        } else {
            return findKthSmallestNumber(A, aIndex, B, bIndex + k/2, k-k/2);
        }

    }

     /*
        Even    = len = 10+14 = 24/2 = 12,13    :: total/2, total/2+1
        Odd     = len = 10+13 = 23/2 = 11+1=12  :: total/2+1
         */
    public double findMedianSortedArraysCopied(final List<Integer> A, final List<Integer> B) {

        int len = A.size() + B.size();
        if(len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }

    public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
        if(A_start >= A.size())
            return B.get(B_start + k - 1);

        if(B_start >= B.size())
            return A.get(A_start + k - 1);

        if(k == 1)
            return Math.min(A.get(A_start), B.get(B_start));

        int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;

        int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;

        if(A_key < B_key){
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        }
        else
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }

}

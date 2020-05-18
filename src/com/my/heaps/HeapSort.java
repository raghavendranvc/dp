package com.my.heaps;

public class HeapSort {


    public void heapSort(int[] A){

        /**
         * We only need to sort the non-leaf nodes
         *
         * if last non-leaf node'x' is obtained from
         * n = 2x+1 or n=2x+2
         * x = (n-1)/2 or (n-2)/2
         * x = (n-1)/2 or n/2-1
         *
         * If n is odd n = 21
         * x = 20/2 or 21/2-1 => 10 or 10-1 => 10 or 9
         *
         * If n is even n = 22
         * x= 21/2 or 22/2-1 => 10 or 11-1 => 10 or 10
         *
         * So n/2-1 is always smaller than (n-1)/2;
         *
         */

        int n = A.length;

        for(int i=n/2-1;i>=0;i--){
            heapify(A,i,n); //We consider total elements here during the heapify
        }

        /*
        We know the first element is the highest element
        So we swap it to the last element. So the element is set in its place
        The heap structure to consider can be reduced by 1 and it becomes n-1
        We now reheap with '0' as the new parent till n-1

        Each itenation we reduce the n by 1.
        When the size is 1, we don't need to do anything. So we can stop at Size=2
         */

        for(int size=n-1;size>1;size--){
            swap(A,0,size); //element at the last of the index is swapped with the first
            heapify(A,0, size);
        }

    }


    public void heapify(int[] A, int parent, int n){
        int left = 2*parent+1;
        int right = 2*parent +2;
        int largest = parent;

        if(left < n && A[largest] < A[left]){
            largest = left;
        }

        if(right < n && A[largest] < A[right]){
            largest = right;
        }

        if (parent != largest){
            swap(A,parent,largest); //New largest came into the picture. So reheapify it.
            //Values are changed between parent and largest. largest now contains parent which is moved down the sub tree
            // So we need to reheapify to make sure that the orignal parent still holds that place or should be moved down further
            heapify(A,largest, n);
        }
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}

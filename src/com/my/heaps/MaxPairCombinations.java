package com.my.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxPairCombinations {

    //TODO practice this again with PriorityQueues


    public ArrayList<Integer> solveCopied(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
        int n=A.size();

        Queue<Integer> pq = new PriorityQueue<>();
      
        for(int i:A){
            for(int j:B){
                int sum = i+j;
                if (pq.size()<n){
                    pq.add(sum);
                } else {
                    if (sum>pq.peek()){
                        pq.poll();
                        pq.add(sum);
                    }else{
                        break;
                    }
                }
            }
        }

        ArrayList<Integer> ret = new ArrayList<>(pq);
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        int n = A.size();
        Queue<Integer> queue = new PriorityQueue<>();
        for(int aElement : A){
            for(int bElement : B) {
                int sum = aElement + bElement;
                if(queue.size() < n){
                    queue.add(sum);
                } else {
                    if(sum > queue.peek()) {
                        queue.poll();
                        queue.add(sum);
                    } else {
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> returnList = new ArrayList<>(queue);
        Collections.sort(returnList,Collections.reverseOrder());
        return returnList;
    }

    public ArrayList<Integer> solveNotRequired(ArrayList<Integer> A, ArrayList<Integer> B) {
        prepareMaxHeap(A);
        prepareMaxHeap(B);

        int n = A.size();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int size=n-1;size>=0;size--){
            int elementA = A.get(0);
            int elementB = A.get(0);
            arrayList.add(A.get(0)+B.get(0));

            swap(A,0,size);
            heapify(A,0,size);

            swap(B,0,size);
            heapify(B,0,size);
        }
        return arrayList;
    }

    private void prepareMaxHeap(ArrayList<Integer> A){
        int n = A.size();
        for(int i=n/2-1;i>=0;i--){
            heapify(A,i,n);
        }
    }

    private void heapify(ArrayList<Integer> A, int parent, int n){
        int left = 2*parent+1;
        int right = 2*parent+2;

        int largest = parent;

        if(left < n && A.get(largest) < A.get(left)){
            largest = left;
        }

        if(right < n && A.get(largest) < A.get(right)){
            largest = right;
        }

        if(parent != largest){
            swap(A,parent,largest);
            heapify(A,largest,n);
        }
    }

    private void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }

    /*

    4 3 2 2
    4 3 2 1

    4+4
    4+3 (4+3 vs 3+4) B decremented
    4+3 (3+4 vs 4+2)



     */

    public static void main(String[] args){
        int[] a={3, 2, 4, 2};
        int[] b ={4, 3, 1, 2};
        ArrayList<Integer> A = getList(a);
        ArrayList<Integer> B = getList(b);

        MaxPairCombinations maxPairCombinations = new MaxPairCombinations();
        System.out.println("Result="+maxPairCombinations.solve(A,B));

    }

    private static ArrayList<Integer> getList(int[] a){
        ArrayList<Integer> returnList = new ArrayList<>();
        for(int i : a){
            returnList.add(i);
        }
        return returnList;
    }

}

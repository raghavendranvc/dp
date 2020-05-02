package com.my.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ChocMagician {

    /*public int nchoc(int A, ArrayList<Integer> B) {

        ArrayList<Long> copyB = new ArrayList<>();
        for(Integer i : B) {
            copyB.add(new Long(i));
        }
        return (int)(nchocInt(A,copyB));
    }*/

    public int nchoc(int A, ArrayList<Integer> B) {
        long longMod = (long)Math.pow(10,9)+7;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(B);

        long sum = 0;
        for(int i=0;i<A;i++){
            Integer value = pq.poll();
            sum = (sum+value)%(longMod);
            pq.add(value/2);
        }
        return (int)sum%((int)longMod);
    }

    public int nchocIntLongConversionIssue(int A, ArrayList<Integer> B) {

        int n = B.size();
        for(int i = n/2-1; i>=0 ; i--){
            heapify(B,i,n);
        }

        long sum = 0;
        for(int i=0;i<A;i++){
            long value = B.get(0);
            B.set(0, (int)(value/2));
            heapify(B,0,n);
            sum = (sum+value)%((long)(Math.pow(10,9)+7));
        }
        return (int)sum%((int)(Math.pow(10,9)+7));
    }
    //2147483647
    //2000000014
    //2147483647


    //2147483647

    private void heapify(ArrayList<Integer> B, int parent, int n){
        int left = 2*parent+1;
        int right = 2*parent+2;

        int largest = parent;

        if(left < n && B.get(parent) < B.get(left)){
            largest = left;
        }

        if(right < n && B.get(parent) < B.get(right)){
            largest = right;
        }

        if(parent != largest){
            swap(B,largest,parent);
            heapify(B,largest,n);
        }

    }

    private void swap(ArrayList<Integer> A, int i, int j){
        Integer temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }


    public int nchocPQ(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<B.size();i++)
        {
            pq.add(B.get(i));
        }
        long ans=0;
        for(int i=0;i<A;i++)
        {
            int temp=pq.poll();
            ans=(ans+temp)%(long)(Math.pow(10,9)+7);
            pq.add(temp/2);
        }
        return (int)ans%(int)(Math.pow(10,9)+7);
    }

}

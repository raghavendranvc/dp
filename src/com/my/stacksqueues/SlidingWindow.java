package com.my.stacksqueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {

    /*
    B = 3
    N = 7 (size = 8)
    0   1   2   3   4   5   6   7
    1,  3,  -1, -3, 5,  3,  6,  7

    1   3   -1
        3   -1  -3
            -1  -3  5
                -3  5   3
                    5   3   6
                        3   6   7



     */

    public ArrayList<Integer> slidingMaximumBruteForce(final List<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<=A.size()-B;i++){
            int max = Integer.MIN_VALUE;
            for(int k=i;k<i+B;k++){
                max = Math.max(max, A.get(k));
            }
            result.add(max);
        }
        return result;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int i=0;

        for(i=0;i<B;i++){
            while(!deque.isEmpty() && (A.get(deque.getLast()) <= A.get(i))){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for(;i<A.size();i++){
            result.add(A.get(deque.getFirst()));

            while(!deque.isEmpty() && deque.getFirst() <= i-B){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && (A.get(deque.getLast()) <= A.get(i))){
                deque.removeLast();
            }

            deque.addLast(i);

        }
        result.add(A.get(deque.getFirst()));
        return result;
    }

    public ArrayList<Integer> slidingMaximumCopied(final List<Integer> A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {

            // Remove all elements smaller than the current one from the queue
            while (!deque.isEmpty() &&  A.get(deque.getLast()) <= A.get(i)) {
                deque.removeLast();
            }
            // Add the current element's index to the queue. It is important that we
            // store the indicies rather than the values.
            deque.add(i); //deque.addLast(i);
            // The first element of the queue is always the largest. If the index of
            // this number is smaller than the window's stating index then we remove it
            if (deque.getFirst() < (i + 1) - B) {
                deque.removeFirst();
            }
            // Ignores the first few interations
            if (i >= B - 1)
                result.add(A.get(deque.getFirst()));
        }
        return result;
    }

}

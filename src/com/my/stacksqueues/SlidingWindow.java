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
    
    //TODO, THe Trick is to store indexes rather than numbers in Dequeue
    // Since Deque orders, we will always know whether the index is 
    // outside the range of window
    // We always add last
    // We always make sure that deque contains the greatest element first
    
    /* 0  1  2    3  4  5  6  7
     * 1, 3, -1, -3, 5, 3, 6, 7
     * 
     * 1
     * 3 
     * 3 -1 (next input to process -3)
     * "At the end of first for loop", we take the frontElement
     * 
     * 3 -1 -3 (next to process 5) we take frontElement
     * 5 (nex to process 3) we take FrontElement
     * 5 (next to proess 3) we take FrontEement
     * 6 (next to process 7) we take Front
     * 7 
     */

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int i=0;

        /**
         * Remove elements from the queue that are smaller than the current element.
         * This is to discard unwanted items. They can never be the max once there
         * is a greater element like the current one.
         * 
         * Below loop is only for the first sliding window.
         */
        for(i=0;i<B;i++){
            while(!deque.isEmpty() && (A.get(deque.getLast()) <= A.get(i))){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for(;i<A.size();i++){
            result.add(A.get(deque.getFirst()));

            /**
             * Remove the elements that are outside the range of the sliding window
             */
            while(!deque.isEmpty() && deque.getFirst() <= i-B){
                deque.removeFirst();
            }
            
            /**
             * Remove elements from the queue that are smaller than the current element.
             * This is to discard unwanted items. They can never be the max once there
             * is a greater element like the current one.
             */

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

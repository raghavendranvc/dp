package com.my.stacksqueues;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

    /*

        9   5   6   9   2   3

        9   5   5   5   2   2


       -1  -1   5   6  -1   2

     */

    /*public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        int[] smallestSoFar = new int[A.size()];
        smallestSoFar[0] = A.get(0);
        for(int i=1;i<A.size();i++){
            smallestSoFar[i] = Math.min(smallestSoFar[i-1],A.get(i));
        }

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        for(int i=1;i<A.size();i++){
            if(A.get(i-1) < A.get(i)){
                integers.add(A.get(i-1));
            } else if (smallestSoFar[i-1] < A.get(i)){
                integers.add(Math.min(smallestSoFar[i-1],integers.get(i-1)));
            } else if(){
                integers.add(integers.get(i-1));
            } else {
                integers.add(-1);
            }
        }

        return integers;
    }*/

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> integers = new ArrayList<>();

        for(int i : A){
            while(!stack.isEmpty() && stack.peek()>=i) {
                stack.pop();
            }
            if(stack.isEmpty()){
                integers.add(-1);
            } else {
                integers.add(stack.peek());
            }
            stack.push(i);
        }
        return integers;
    }
}

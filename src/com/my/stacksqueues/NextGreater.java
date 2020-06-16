package com.my.stacksqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreater {

    /*

    4, 5, 2, 10
    5  10 10 -1

     */

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {

        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        Integer[] result = new Integer[n];
        //result[n-1] = -1;

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=A.get(i)){
                stack.pop();
            }
            if(stack.isEmpty() ) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(A.get(i));
        }

        return new ArrayList(Arrays.asList(result));
    }

}

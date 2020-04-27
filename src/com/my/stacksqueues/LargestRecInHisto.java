package com.my.stacksqueues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRecInHisto {

    public int largestRectangleArea(ArrayList<Integer> A) {

        int totalArea = 0;
        Stack<Integer> stack = new Stack<>();

        int i=0;
        while (i < A.size()){
            if(stack.isEmpty() || A.get(i) >= A.get(stack.peek())){
                stack.push(i++);
            } else {
                int top = stack.pop();
                int currentArea = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(totalArea < currentArea){
                    totalArea = currentArea;
                }
            }
        }

        while(!stack.empty()){
            int top = stack.pop();
            int currentArea = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if(totalArea < currentArea){
                totalArea = currentArea;
            }
        }

        return totalArea;

    }

}

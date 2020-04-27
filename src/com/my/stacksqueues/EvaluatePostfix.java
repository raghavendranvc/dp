package com.my.stacksqueues;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluatePostfix {
    /*
    "2", "1", "+", "3", "*"

     */

    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(int i=0; i<A.size();i++){
            String str = A.get(i);
            if(operators.contains(str)){
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();
                Integer value = getValue(str, op1, op2);
                stack.push(value);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();

    }

    public Integer getValue(String operator, Integer a, Integer b){
        switch(operator) {
            case "+": return (a+b);
            case "-": return (a-b);
            case "*": return (a*b);
            case "/": return (a/b);
        }
        return 0;
    }

}

package com.my.stacksqueues;

import java.util.*;

public class RedundantBraces {

    /*

    1. ((a + b))

    2. (a + (a + b))



     */

    public int braces(String A) {

        Stack<Character> stack = new Stack<>();
        Set<Character> operators  = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        for(char ch: A.toCharArray()) {
            //System.out.println("start char="+ch+" stack="+stack);
            if(ch == ')' ) {
                char top = stack.pop();
                boolean redundantBraces = true;

                while (top != '('){
                    System.out.print("Checking top="+top+" ");
                    if(operators.contains(top)){
                    	// If the pop contains operand before we see "(", then no redundant braces
                        System.out.print("  Not redudnant");
                        redundantBraces = false;
                    }
                    System.out.println();
                    top = stack.pop();//continue to pop, till you remove "("
                }
                System.out.println();
                if(redundantBraces){
                    return 1;
                }
            }else {
                stack.push(ch);
            }
            System.out.println("end char="+ch+" stack="+stack);

        }
        return 0; //No braces found - false
    }

    public static void main(String[] args){
        String str = "(a+(a+b))";
        RedundantBraces redundantBraces = new RedundantBraces();
        System.out.println("Redudant="+redundantBraces.braces(str));


    }


}

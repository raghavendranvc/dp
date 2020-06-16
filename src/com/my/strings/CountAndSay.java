package com.my.strings;

import java.util.LinkedList;

public class CountAndSay {

    // 111221
    // 1
    // 2
    // 2
    // 1
    // 1
    // 1
    // Pop till we get a different number
    // 3 1
    // 2 2
    // 1 1
    public String generasteNSequence(int A) {

        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(A%10 > 0){
            stack.push(A%10);
            A = A / 10;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        int count = 1;
        while(!stack.isEmpty()){
            int digit = stack.pop();
            if(stack.size() > 1 && digit == stack.peekLast()){
                count++;
            } else {
                queue.add(count);
                queue.add(digit);
                count = 1;
            }
        }

        long number = queue.get(0);

        while(!queue.isEmpty()){
            number = number*10 + queue.removeFirst();
        }

        return number+"";
    }

    public String countAndSay(int A) {
        String countSay = "1";
        

        while(A > 1){
            int count=1;
            int currentDigit = countSay.charAt(0)-'0';
            String nextSequence = "";
            //System.out.println("Checking currentDigit="+currentDigit);
            for(int i=1;i<countSay.length();i++){
                //System.out.println("countSay.charAt("+i+")="+countSay.charAt(i));
                if(currentDigit == countSay.charAt(i)-'0'){
                    count++;
                } else {
                    nextSequence += count + ""+ currentDigit +"";
                    //System.out.println("Forming sequence="+nextSequence+" count ="+count);
                    count=1;
                    currentDigit=countSay.charAt(i)-'0';
                    //System.out.println(" New currentDigit="+currentDigit);
                }
            }
            //System.out.println("End nextSequence sofar = "+nextSequence+" count ="+count+" currentDigit="+currentDigit);
            nextSequence += count + ""+ currentDigit +"";
            countSay = nextSequence;
            //System.out.println("-------A="+A+" Next Sequence="+countSay);
            A--;
        }

        return countSay;

    }

    public static void main(String[] args){
        int A = 4;
        CountAndSay countAndSay = new CountAndSay();
        System.out.println("Result="+countAndSay.countAndSay(A));

    }

}

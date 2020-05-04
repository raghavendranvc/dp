package com.my.math;

import java.util.ArrayList;

public class FuzzBizz {

    public ArrayList<String> fizzBuzz(int A) {

        ArrayList<String> resultList = new ArrayList<>(A);

        for(int i=1;i<=A;i++) {
            boolean three = false;
            if( i % 3 == 0){
                three = true;
            }
            boolean five = false;
            if( i% 5 == 0) {
                five = true;
            }

            if(!three && !five ) {
                resultList.add(i+"");
            } else if(three && five ) {
                resultList.add("FizzBuzz");
            } else if (three){
                resultList.add("Fizz");
            } else {
                resultList.add("Buzz");
            }

            /*StringBuilder sb = new StringBuilder();
            if( i % 3 == 0){
                sb.append("Fizz");
            }

            if( i% 5 == 0) {
                sb.append("Buzz");
            }*/
            //resultList.add(sb.toString());
        }
        return resultList;

    }


}

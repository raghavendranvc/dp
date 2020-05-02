package com.my.backtracking;

public class StringPermuation {

    //TODO revisit this
    //pairwiseHammingDistance.computePermutation(s, "");

    public void computePermutation(String str, String suffix) {
        if(str.length() == 0){
            System.out.println(suffix);
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String restOfTheString = str.substring(0,i) + str.substring(i+1);
            computePermutation(restOfTheString, suffix+ch);
        }

    }
}

package com.my.strings;

public class ReturnReverseString {
    /*
    "the sky is blue"

    blue is sky the




     */
	
	/*
	 * GOOD Approach
	 * First reverse each word and then reverse the whole string
	 */

    public String solve(String A) {
        A = A.trim();
        String[] words = A.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1;i>=0;i--){
            if(words[i].trim().length()>0){
                sb.append(words[i].trim()).append(" ");
            }
        }

        return sb.toString().trim();

    }
}

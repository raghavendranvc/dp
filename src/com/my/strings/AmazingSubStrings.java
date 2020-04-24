package com.my.strings;

import java.util.HashSet;
import java.util.Set;

public class AmazingSubStrings {


    //ABEC

    public int solveNonRegX(String A) {

        final char[] vowelChars = new char[] {'a','e','i','o','u','A','E','I','O','U'};
        final Set<Character> vowels = new HashSet<>();
        for(char ch: vowelChars){
            vowels.add(ch);
        }


        Set<String> allSubStrings = new HashSet<>();

        for(int i=0;i<=A.length();i++){
            if(vowels.contains(A.charAt(i))){
                for(int j=i+1;j<=A.length();j++){
                    allSubStrings.add(A.substring(i,j));
                }
            }
        }

        return allSubStrings.size();
    }

    public int solve(String A) {

        String regEx = "[AEIOUaeiou]+";

        Set<String> allSubStrings = new HashSet<>();


        for(int i=0;i<=A.length();i++){
            if(String.valueOf(A.charAt(i)).matches(regEx)){
                for(int j=i+1;j<=A.length();j++){
                    allSubStrings.add(A.substring(i,j));
                }
            }
        }

        return allSubStrings.size();
    }

    public int solveCopied(String A) {
        String vowels = "[aioueAEIOU]+";
        int i, len = 0;
        for(i=0; i<A.length(); i++){
            if(String.valueOf(A.charAt(i)).matches(vowels)){
                len = len+(A.length()-i);
            }
        }
        return(len%10003);
    }


}

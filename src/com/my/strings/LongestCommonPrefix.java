package com.my.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> A) {

        int maxPLengthPossible = A.get(0).length();
        for(int i=1;i<A.size();i++){
            maxPLengthPossible = Integer.min(maxPLengthPossible, A.get(i).length());
        }

        int i=0;
        for(;i<maxPLengthPossible;i++ ){
            for(int j=0;j<A.size()-1;j++){
                if(A.get(j).charAt(i) != A.get(j+1).charAt(i)){
                    return A.get(0).substring(0,i);
                }
            }
        }
        return A.get(0).substring(0,i);

    }

}

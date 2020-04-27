package com.my.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNoRepeat {

    public int lengthOfLongestSubstring(String A) {
        int maxLength = Integer.MIN_VALUE;

        int n = A.length();

        for(int i=0;i<n;i++){  // i is the startIndex

            Set<Character> chars= new HashSet<>();
            chars.add(A.charAt(i));
            for(int j=i+1;j<n;j++){
                if(chars.contains(A.charAt(j))){
                    break;
                } else {
                    chars.add(A.charAt(j));
                }
            }
            maxLength = Math.max(maxLength,chars.size());
        }
        return  maxLength;
    }
}

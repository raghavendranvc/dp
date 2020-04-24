package com.my.strings;

public class StrStr {


    /**
     *  1   2   3   4   5   6   7   8   9
     *  0   1   2   3   4   5   6   7   8
     *  8   9   10
     *
     * @param A
     * @param B
     * @return
     */
    public int strStr(final String A, final String B) {
        if(A.length() == 0 || B.length() == 0 || A.length()<B.length()){
            return -1;
        }

        if(A.equals(B)){
            return 1;
        }

        for(int i=0;i<A.length()-B.length();i++){
            if(A.substring(i,i+B.length()).equals(B)){
                return i;
            }
        }

        return -1;
    }
}

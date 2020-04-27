package com.my.hashing;

public class WindowString {

    //TODO more practice

    public String minWindowCopied(String A, String B) {
        int p[] = new int[256];
        int s[] = new int[256];

        String res = "";

        for (int i = 0; i < B.length(); i++)
            p[B.charAt(i)]++;

        int start = 0,  min = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < A.length(); j++){
            s[A.charAt(j)]++;

            if (s[A.charAt(j)] <= p[A.charAt(j)] )
                count++;

            if (count == B.length()){
                while ( s[A.charAt(start)] > p[A.charAt(start)]){
                    s[A.charAt(start)]--;
                    start++;
                }
                if(j - start + 1 < min){
                    min = j - start + 1;
                    res = A.substring(start, j+1);
                }
                min = Math.min(min, j - start + 1);
            }
        }
        return res;
    }

}

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

        for (int i = 0; i < A.length(); i++){
            s[A.charAt(i)]++;

            if (s[A.charAt(i)] <= p[A.charAt(i)] )
                count++;

            if (count == B.length()){
            	//Once we find all P chars, then we execute this block every time
                while ( s[A.charAt(start)] > p[A.charAt(start)]){
                    s[A.charAt(start)]--;
                    start++;
                }
                if(i - start + 1 < min){
                    min = i - start + 1;
                    res = A.substring(start, i+1);
                }
                //min = Math.min(min, i - start + 1);
            }
        }
        return res;
    }

}

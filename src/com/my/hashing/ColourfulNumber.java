package com.my.hashing;

import java.util.HashSet;
import java.util.Set;

public class ColourfulNumber {

    public int colorful(int A) {
        String strA = String.valueOf(A);

        /*
        3245

        3426


         */




        Set<Integer> resultNumbers = new HashSet<Integer>();
        for(int i=0;i<strA.length();i++){
            for(int j=i;j<strA.length();j++){
                int number = getMultipliedNumber(strA.substring(i,j+1)); //We should not be doing this //TODO
                if(resultNumbers.contains(number)) {
                    return 0;
                } else {
                    resultNumbers.add(number);
                    System.out.println("Updated Set="+resultNumbers);
                }
            }
        }
        return 1;
    }

    private int getMultipliedNumber(String str){
        int number = 1;
        for(int i=0;i<str.length();i++){
            number = number * (str.charAt(i) - '0');
        }
        return number;
    }

    //Reduces the multiplier by only one digit. //TODO check this
    public int colorfulCopied(int n) {

        int prod;

        String A=String.valueOf(n);

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<A.length();i++) {
            prod=1;
            for(int j=i;j<A.length();j++) {
                prod*=A.charAt(j)-'0';
                if(hs.contains(prod))
                    return 0;
                else
                    hs.add(prod);
            }
        }
        return 1;
    }

    public static void main(String[] args){
        int number = 3245;
        ColourfulNumber colourfulNumber = new ColourfulNumber();
        System.out.println("Result="+colourfulNumber.colorful(number));
    }
}

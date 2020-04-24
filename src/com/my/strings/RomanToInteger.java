package com.my.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {

    /**
     * "XIV"
     *
     * I
     * II
     * III
     * IV
     * V
     * VI
     * VII
     * VIII
     * IX
     * X
     * XI
     *
     *
     * "XX"
     *
     *
     * LI
     *
     *
     * C
     *
     * D
     *
     * M
     */

    /*
    3999
    MMM CM XC IX
    38888
    MMM DCCC LXXX VIII
    946
    CMXVI

    1000    100              10                 1
    M       "CM, DC, D, CD, C"   XC/LX/L/XL/X   IX/VI/V/IV/I
    M        C/D+M               X/L+C          I+V/X


     */

    public int romanToIntBruteForce(String A) {

        int thousands = 0;
        int i=0;
        while(i<A.length() && A.charAt(i) == 'M'){
            thousands++;
            i++;
        }

        A = A.substring(i);
        i=0;
        while(i<A.length() && (A.charAt(i) == 'C' || A.charAt(i) == 'D' || A.charAt(i) == 'M' )){
            i++; //Anything apart from C, D, M means end of Hundreds
        }
        String hundredStr = A.substring(0,i);

        A=A.substring(i);
        i=0;
        while(i<A.length() && (A.charAt(i) == 'X' || A.charAt(i) == 'L' || A.charAt(i) == 'C')){
            i++;  //Anything apart from X, L, C means end of Tens
        }
        String tensStr = A.substring(0,i);

        A=A.substring(i);
        System.out.println("thousands="+thousands+" hundredStr="+hundredStr+" tensStr="+tensStr+" digits="+A);

        return thousands*1000 + getHundred(hundredStr)*100+ getTens(tensStr)*10 + getDigits(A);
    }

    private int getHundred(String str) {

        switch(str) {
            case "CM" : return 9;
            case "DCCC" : return 8;
            case "DCC" : return 7;
            case "DC" : return 6;
            case "D" : return 5;
            case "CD" : return 4;
            case "CCC" : return 3;
            case "CC" : return 2;
            case "C" : return 1;
        }

        return 0;
    }

    private int getTens(String str){
        switch(str) {
            case "XC" : return 9;
            case "LXXX" : return 8;
            case "LXX" : return 7;
            case "LX" : return 6;
            case "L" : return 5;
            case "XL" : return 4;
            case "XXX" : return 3;
            case "XX" : return 2;
            case "X" : return 1;
        }

        return 0;
    }

    private int getDigits(String str){
        switch(str) {
            case "IX" : return 9;
            case "VIII" : return 8;
            case "VII" : return 7;
            case "VI" : return 6;
            case "V" : return 5;
            case "IV" : return 4;
            case "III" : return 3;
            case "II" : return 2;
            case "I" : return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        String roman = "MMMCDXLIV";
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println("Integer="+romanToInteger.romanToInt(roman));
    }

    public int romanToInt(String A) {

        Map<Character, Integer> ROMAN_MAPPING = new HashMap<>();
        ROMAN_MAPPING.put('I',1);
        ROMAN_MAPPING.put('V',5);
        ROMAN_MAPPING.put('X',10);
        ROMAN_MAPPING.put('L',50);
        ROMAN_MAPPING.put('C',100);
        ROMAN_MAPPING.put('D',500);
        ROMAN_MAPPING.put('M',1000);

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<A.length();i++){
            int value = ROMAN_MAPPING.get(A.charAt(i));
            if(!stack.isEmpty() && value > stack.peek()){
                value = value - stack.pop();
            }
            stack.push(value);
        }

        int value = 0;
        while(!stack.isEmpty()){
            value += stack.pop();
        }

        return value;

    }


}

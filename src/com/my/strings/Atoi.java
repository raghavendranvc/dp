package com.my.strings;

public class Atoi {

    public int atoiGeneric(final String A) {

        int firstDigitIndex = -1;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) >= '0' && A.charAt(i) <= '9'){
                firstDigitIndex=i;
                break;
            }
        }

        System.out.println("firstDigitIndex="+firstDigitIndex);

        int consecutiveDigits = 1;
        for(int i=firstDigitIndex+1;i<A.length();i++){
            if(A.charAt(i) >= '0' && A.charAt(i) <= '9'){
                consecutiveDigits++;
            } else {
                break;
            }
        }

        System.out.println("consecutiveDigits="+consecutiveDigits);

        boolean isNegative = false;
        if(firstDigitIndex>0){
            isNegative = (A.charAt(firstDigitIndex-1) == '-') ? true : false;
        }

        System.out.println("isNegative="+isNegative);

        double dNumber = getNumber(A.substring(firstDigitIndex,firstDigitIndex+consecutiveDigits));

        if(dNumber>Integer.MAX_VALUE){
            if(isNegative){
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if(isNegative){
            return -1*(int)dNumber;
        }  else {
            return (int)dNumber;
        }

    }

    /*
    0   1   2   3
    ==============
    1   2   3   4
    1   0   0   0   = 1 * 10 * (3-0)  //size-1-i
        2   0   0   = 2 * 10 * (3-1)
            2   0   = 3
                3   = 4

     */
    private final double getNumber(String str){

        System.out.println("str="+str);
        double number = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) ==0){
                continue;
            }
            number = number + (str.charAt(i)-'0') * Math.pow(10,str.length()-1-i);
        }

        System.out.println("number="+number);
        return number;

    }


    public int atoi(final String A) {

        int firstDigitIndex = -1;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) >= '0' && A.charAt(i) <= '9'){
                firstDigitIndex=i;
                break;
            }
        }

        System.out.println("firstDigitIndex="+firstDigitIndex);

        int consecutiveDigits = 1;
        for(int i=firstDigitIndex+1;i<A.length();i++){
            if(A.charAt(i) >= '0' && A.charAt(i) <= '9'){
                consecutiveDigits++;
            } else {
                break;
            }
        }

        System.out.println("consecutiveDigits="+consecutiveDigits);

        boolean isNegative = false;
        if(firstDigitIndex>0){
            isNegative = (A.charAt(firstDigitIndex-1) == '-') ? true : false;
        }

        System.out.println("isNegative="+isNegative);

        double dNumber = getNumber(A.substring(firstDigitIndex,firstDigitIndex+consecutiveDigits));

        if(dNumber>Integer.MAX_VALUE){
            if(isNegative){
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if(isNegative){
            return -1*(int)dNumber;
        }  else {
            return (int)dNumber;
        }

    }

    public static void  main(String[] args){
        String A = "absty  34 01-007 U 0 T7165 0128862 089 39 5";
        Atoi atoi = new Atoi();
        System.out.println("number="+atoi.atoi(A));
    }
}

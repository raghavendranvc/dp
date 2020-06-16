package com.my.bitmanipulation;

public class InvertBitsInNumebr {

    public int invertNumber(int num){

        int highestBitIndex = 0;
        while (num > 0){
            num = num >> 1;
            highestBitIndex++;
            System.out.println(" num="+num+" countHighestBitIndex="+highestBitIndex);
        }

        int maskBit = 1 << (highestBitIndex-1);
        System.out.println("HighestBitSetNumber="+maskBit);

        maskBit = maskBit | (maskBit-1);

        System.out.println("Mask with all 1's="+maskBit);
        return maskBit;

    }

    public static void main(String[] args){
        System.out.println("");
        InvertBitsInNumebr invertBitsInNumebr = new InvertBitsInNumebr();
        System.out.println("invertNumber="+invertBitsInNumebr.invertNumber(5));
    }

}

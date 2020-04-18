package com.my.bitmanipulation;

public class NumberOfOneBits {

    public int numSetBits(long a) {

        int numberOfOnes = 0;
        while(a > 0){
            System.out.println("num="+a+" numberOfBits="+numberOfOnes);
            numberOfOnes += a & 1;
            a = a >> 1;
        }
        System.out.println("num="+a+" numberOfBits="+numberOfOnes);
        return numberOfOnes;
    }

    public static void main(String[] args){
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        numberOfOneBits.numSetBits(3);
    }



}

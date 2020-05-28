package com.my.arrays;

import java.util.ArrayList;

public class AddOneToNumber {

    // 123 solved
    // 192 solved
    // 900 solved
    // 199 solved
    // 999
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        for(int i=A.size()-1; i>=0; i--){

            if(A.get(i) == 9) {
                A.set(i,0);
            } else { 
            	// We stop as soon was we find a non zero. Will increment it and send it
                A.set(i,A.get(i)+1);
                System.out.println("A1="+A);
                A = removeStartingZeroes(A);
                return A;
            }
        }

        shiftNumbersByOnePositionRight(A);
        A.set(0,1);
        return A;

    }

    //i = 0 1 2 3 4
    //Size = 5
    //A = 0 1 2 3 4 5
    //Size = 6
    private void shiftNumbersByOnePositionRight(ArrayList<Integer> A){
        int originalSize = A.size();
        A.add(A.get(originalSize-1)); //Add the last number
        for(int i=originalSize-1;i>0;i--){  //Size has increased by 1
            A.set(i,A.get(i-1));
        }

    }

    private ArrayList<Integer> removeStartingZeroes(ArrayList<Integer> A){
        System.out.println("finding nonzero element. Size="+A.size());
        int nonZeroElementIndex=0;
        while(nonZeroElementIndex< A.size()){
            System.out.println("A.get("+nonZeroElementIndex+")="+A.get(nonZeroElementIndex));
            if(A.get(nonZeroElementIndex) != 0) {
                break;
            }
            nonZeroElementIndex++;
        }
        System.out.println("nonZeroElement="+nonZeroElementIndex);
        if(nonZeroElementIndex < A.size()){
            return new ArrayList<>(A.subList(nonZeroElementIndex,A.size()));
        }
        else {
            return A;
        }
    }

    public static void  main(String[] args){

        AddOneToNumber a = new AddOneToNumber();
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(0);

        System.out.println("aList="+aList);

        System.out.println("End aList="+a.plusOne(aList));

    }


}

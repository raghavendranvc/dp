package com.my.twopointers;

import java.util.ArrayList;

public class KDiff {

    public int diffPossible(ArrayList<Integer> A, int B) {

        for(int i=0; i<A.size()-1;i++) {
            for(int j=i+1;j<A.size();j++) {
                int diff =  A.get(j) - A.get(i);
                if( diff == B){
                    return 1;
                } else if (diff > B) {
                    break;
                }
            }
        }


        //System.out.println("diff="+diff+" A.get("+j+")="+A.get(j)+" A.get("+i+")="+A.get(i));

        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 2, 2, 3, 4};
        int B = 0;
        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a) {
            intListA.add(i);
        }
        System.out.println("initlist=" + intListA);
        KDiff kDiff = new KDiff();
        kDiff.diffPossible(intListA,B);

    }

}

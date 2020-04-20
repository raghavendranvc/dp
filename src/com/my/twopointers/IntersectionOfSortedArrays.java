package com.my.twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersectRemvoedDuplicates(final List<Integer> A, final List<Integer> B) {

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0,j=0; i<A.size() && j<B.size();){
            System.out.println("A.get(i)="+A.get(i)+" i="+i+" B.get(j)="+B.get(j)+" j="+j);
            if(A.get(i).equals(B.get(j))) {
                System.out.println("same");
                if(result.size()==0 || result.get(result.size()-1) != A.get(i)) {
                    System.out.println("result="+result+" i="+i+" j="+j);
                    result.add(A.get(i));

                }
                i++;
                j++;
            } else if(A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
            System.out.println(" i="+i+" j="+j);
        }
        System.out.println(" result="+result);
        return result;

    }

    public static void main(String[] args){
        int[] a = {10000000};
        int[] b = {10000000};

        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a){
            intListA.add(i);
        }

        ArrayList<Integer> intListB = new ArrayList<>(a.length);
        for (int i : b){
            intListB.add(i);
        }

        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        intersectionOfSortedArrays.intersect(intListA,intListB);

    }

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0,j=0; i<A.size() && j<B.size();){
            //System.out.println("A.get(i)="+A.get(i)+" i="+i+" B.get(j)="+B.get(j)+" j="+j);
            if(A.get(i).equals(B.get(j))) {
                result.add(A.get(i));
                i++;
                j++;
            } else if(A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
            //System.out.println(" i="+i+" j="+j);
        }
        //System.out.println(" result="+result);
        return result;

    }

}

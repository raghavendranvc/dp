package com.my.twopointers;

import java.util.ArrayList;

public class DuplicateRemove {

    public int removeDuplicatesOriginal(ArrayList<Integer> a) {

        for(int i=a.size()-1;i>0;i--){
            if(a.get(i-1).equals(a.get(i))){
                a.remove(i);
            }
        }

        return a.size();
    }

    private void copyArray(ArrayList<Integer> a, int startIndex){
        for(int i=startIndex;i<a.size()-1;i++){
            a.set(i,a.get(i+1));
        }
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        for(int i=a.size()-1;i>1;i--){
            if(a.get(i-1).equals(a.get(i)) && a.get(i-1).equals(a.get(i-2))){
                a.remove(i);
            }
        }
        return a.size();
    }

    public static void main(String[] args){
        int[] a = new int[] {5000, 5000, 5000};


        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a){
            intListA.add(i);
        }

        System.out.println("a="+intListA);
        DuplicateRemove duplicateRemove = new DuplicateRemove();
        duplicateRemove.removeDuplicates(intListA);
        System.out.println("end="+intListA);

    }
}

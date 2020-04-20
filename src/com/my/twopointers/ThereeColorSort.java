package com.my.twopointers;

import java.util.ArrayList;

public class ThereeColorSort {
    /*
    1 2 0 0 1 2 2 1 2 0

    i=0 firstNonZeroIndex=0
    i=1 firstNonZeroIndex=0




     */
    public void sortColorsNonInPlaceSorting(ArrayList<Integer> a) {

        int[] colors = new int[3];

        for (int i = 0; i < a.size(); i++) {
            colors[a.get(i)]++;
        }

        a.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colors[i]; j++) {
                a.add(i);
            }
        }

    }

    public void sortColors(ArrayList<Integer> a) {

        int zero = 0;
        int one = 1;
        int two = a.size()-1;

        while(zero <= two && one <=two){
            int temp = a.get(one);
            if(temp == 0){
                swap(a,zero,one);
                zero++;
                if(zero == one){
                    one++;
                }
            } else if(temp ==1){
                one++;
            } else {
                swap(a,one,two);
                two--;
            }
        }

    }

    public void swap(ArrayList<Integer> a,int i, int j){
        int save = a.get(i);
        a.set(i,a.get(j));
        a.set(j,save);
    }

    public static void main(String[] args){
        int[] a = new int[]{0, 1, 2, 0, 1, 2};
        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a){
            intListA.add(i);
        }
        System.out.println("intListA ="+intListA);
        ThereeColorSort thereeColorSort = new ThereeColorSort();
        thereeColorSort.sortColors(intListA);
        System.out.println("sorted intListA ="+intListA);
    }

}

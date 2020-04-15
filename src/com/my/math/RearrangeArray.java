package com.my.math;

import com.my.arrays.MaxDistance;
import com.my.common.UtilityClass;

import java.util.ArrayList;

public class RearrangeArray {

    public void arrange(ArrayList<Integer> a) {

        int total = a.size();

        int[] parent = new int[total];
        for(int i=0;i<total;i++){
            parent[i] = a.get(a.get(i));
        }

        a.clear();
        for(int i=0;i<total;i++){
            a.add(parent[i]);
        }
    }

    public void arrangeCopied(int[] A) {
        int total = A.length;
        for (int i = 0; i < total; i++) {
            A[i]= A[i] + (A[A[i]] % total) * total;
            A[0] = A[0] + A[3%7]*7;
        }

        for (int i = 0; i < total; i++) {
            A[i]= A[i] / total;
            A[0] = A[0] / 7;
        }
    }

    //4, 1, 2, 7, 6, 5, 3, 0

    public void arrangeNot(ArrayList<Integer> a) {

            //  0   1   2   3   4   5   6   7   size = 8
            //  3   2   1   4   7   5   0   6                   i=0
            //  4                               j=3  (0<-4)     i=3     c=1
            //  4           7                   j=4  (3<-7)     i=4     c=2
            //  4           7   6               j=7  (6)    i=7     c=3
            //  4           7   6           0   j=0  (0)    i=0     c=4
            //  4           7   6           0   j=4  (0)    i=0     c=4

        int save = a.get(0);
        int i = 0;
        int count = 0;
        while (count < a.size()) {
            int j = a.get(i);
            a.set(i, a.get(a.get(i))); // (0,3)
            i = j;
            count++;
            System.out.println(a);
        }
        a.set(i,save);
        System.out.println(a);

    }




    public static void main(String[] args){
        int[] A = new int[] {3,2,1,4,7,5,0,6};

        ArrayList<Integer> intList = new ArrayList<>(A.length);
        for (int i : A){
            intList.add(i);
        }
        System.out.println(intList);
        RearrangeArray rearrangeArray = new RearrangeArray();
        rearrangeArray.arrange(intList);
        System.out.println(intList);
    }
}

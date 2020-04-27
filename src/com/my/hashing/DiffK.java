package com.my.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffK {
    /*

 1 5 3
 k : 2

 -1 3  3 7  1 5



  */
    public int diffPossible(final List<Integer> A, int B) {

        Set<Integer> lookUp = new HashSet<>();

        /*
            a[i] - y = B
            y = a[i] - B

            x - a[i] = B
            x = B + a[i]

         */
        for(int i=0;i<A.size();i++){
            int lookUpNum1 = A.get(i)-B;
            int lookUpNum2 = B + A.get(i);
            if(lookUp.contains(lookUpNum1) || lookUp.contains(lookUpNum2)){
                return 1;
            }

            lookUp.add(A.get(i));

        }

        return 0;
    }

    public int diffPossibleCopied(final List<Integer> a, int b) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (Integer number : a) {
            if (visited.contains(number + b) || visited.contains(number - b)) return 1;
            visited.add(number);
        }
        return 0;
    }


    public static void main(String[] args){
        int[] a = {77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0};
        ArrayList<Integer> A = new ArrayList<>(a.length);
        for (int i : a){
            A.add(i);
        }
        int B = 53;

        DiffK diffK = new DiffK();
        System.out.println(" Result="+diffK.diffPossible(A,B));


    }
}

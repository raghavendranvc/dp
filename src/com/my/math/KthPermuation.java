package com.my.math;

import com.my.binarysearch.KthSmallest;
import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class KthPermuation {

    /*

    1   1234  6*4 = 24 4!= 4*3*2*1 = 24
    2   1243
    3   1324
    4   1342
    5   1423
    6   1432

    7   2134
    8   2143

    9   2314
    10  2341

    11  2413
    12  2431

    13  3124
    14  3142

    15  3214  24/(4-3-1) = 12+(3) = 3/(4-1-1) = 2 + (1) = 1/(4-4-1) = 24/2 + 3/2 +
    16  3241    24/2 + 12/3 + 4/1 + 1/4 = 6+6 +

    0!   1!   2!   3!   4!   5!
    0    1    2    6    24   120

    3    2    4    1
    3!   2!   1!   0!
    6    2    1    1

    3241
    6*2+ 2*1  1*3  1*0 = 12+2+3=15
    15 - 12 (6*2) = 1+2
    3 -  2  (2*1) = 1+1
    1 -  1  (1*0) = 1+3
    0 -  0  (0*0) = 1+0


    17  3412
    18  3421

    19  4123
    20  4132

    21  4213
    22  4231
    22 = 6*3    +   2*1     +   1*1     +    1*1
         3          2           1               0

    23  4312
        = 6*3  +  2*2 + 1*1 + 1*1

    24  4321
        = 6*4 + 2*0 + 1*0 + 1*0

    1234
    6*(1-1)+ 2*(1-1) + 1*(2-2) + 1*(3-3) =0


     */


    public String getPermutationLC(int A, int B) {

        // initialize all numbers
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int i = 1; i <= A; i++) {
            integers.add(i);
        }

        // change k to be index
        B--;

        // set factorial of n
        int maxFacto = 1;
        for (int i = 1; i <= A; i++) {
            maxFacto = maxFacto * i;
        }

        StringBuilder StringBuilder = new StringBuilder();

        // find sequence
        for (int i = 0; i < A; i++) {
            maxFacto = maxFacto / (A - i);
            // find the right number(curIndex) of
            int curIndex = B / maxFacto;
            // update k
            B = B % maxFacto;

            // get number according to curIndex
            StringBuilder.append(integers.get(curIndex));
            // remove from list
            integers.remove(curIndex);
        }

        return StringBuilder.toString();
    }

    public String getPermutation(int A, int B) {
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i=1;i<=A;i++){
            integers.add(i);
        }

        B = B-1; //This will make sure that even if the decreasign seequence is given, we will be able to compute the permutation correctly

        int maxFacto = 1;
        for(int i=1;i<=A;i++){
            maxFacto = maxFacto*i;
        }

        if(B>maxFacto){
            return "";
        }

        StringBuilder StringBuilder = new StringBuilder();

        for(int i=0;i<A; i++){
            maxFacto = maxFacto/(A-i);

            int quotient = B / maxFacto;

            B = B % maxFacto; // Next iteration

            StringBuilder.append(integers.get(quotient)); //Get the index of this quotient
            integers.remove(quotient); //Then remove that number from the list
        }

        return StringBuilder.toString();

    }
    //We need to find the rank of 'k'

    public String getPermutationIB(int n,int k) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            list.add(i);
        }

        k=k-1;

        int xn = list.size();
        if(xn == 0)
            return "";

        int fact_n=fact(xn-1);
        int index=k/fact_n;
        int num=list.get(index);
        list.remove(index);
        k%=fact_n;
        //return "";
        return num+getPermutation(n,k);
    }

    int fact(int n)
    {
        if(n>12) return Integer.MAX_VALUE;

        int fact=1;
        for(int i=2;i<=n;i++)
        {
            fact*=i;
        }

        return fact;
    }

    public static void main(String[] args){
        KthPermuation kthPermuation = new KthPermuation();
        System.out.println("Result="+kthPermuation.getPermutation(3,6));

    }

}

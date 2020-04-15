package com.my.math;

import com.my.arrays.MaxDistance;
import com.my.common.UtilityClass;

import java.util.ArrayList;

public class NumbersLessThanLength {

    //TODO Incomplete

    /*
    0 1 4 5 7 9
    number of digits = N = 6

    4 (R)

    42623
    number of digits = 2

    all combinations of digits with length 1,2,3 (<4) (special care for 0) N,P,R = N!/(N-R)! = N * N-1 * .... * N-R+1

    =====
     smallerNumbers
    4 = 2 = 2*4! or 2*3!
    2 = 2 = 2*3!
    6 = 4 = 4*2!
    2 = 2 = 2*1!
    3 = 2 = 2*0!

    ======
    623
    position    x   = Number of digits less than x
    2           6   = 4                             = 4*(AllDigits)*(AllDigits)
    1           2   = 2                             = 2*(AllDigits)
    0           3   = 3                             = 3

                                                    = (Number of digits less than x)* (Alldigits)^position

    x = all numbers less than first digit 4. index of 4
    x* (length-1 numbers less than)  = x * N, P, (R-1)

     */

    private int getIndex(int number, ArrayList<Integer> A){
        for(int i=0;i<A.size();i++){
            if(A.get(i) >= number){
                return i;
            }
        }
        return A.size();
    }

    public int solve(ArrayList<Integer> A, int B, int C) {

        if(A.size() == 0){
            return 0;
        }

        int save = C;

        int numberOfDigits = 0;
        while (C > 0){
            C = C/10;
            numberOfDigits++;
        }

        C = save;
        System.out.println("numberOfDigits="+numberOfDigits);

        long totalSmallerNumberWithLesserLength = 0;
        int position = 0;
        while (C > 0 && position<B){
            int remainder = C % 10;
            int index = getIndex(remainder, A);
            System.out.println("C="+C+" remainder="+remainder+" index="+index);
            if(C/10 < 1 && numberOfDigits>1){
                index = index-1;
                System.out.println("For last discarding 0");
            }
            C = C/10;
            totalSmallerNumberWithLesserLength = totalSmallerNumberWithLesserLength + 1L* index * (long)Math.pow(A.size(),position);
            position++;

            System.out.println("totalSmallerNumberWithLesserLength="+totalSmallerNumberWithLesserLength);
        }

        return (int)totalSmallerNumberWithLesserLength;


        /*int lastNumber = A.get(A.size()-1);
        int[] fact = new int[lastNumber+1];
        fact[0] = fact[1] = 1;
        for(int i=2;i<=lastNumber;i++){
            fact[i] = i * fact[i-1];
        }

        UtilityClass.print(fact);
        int save = C;

        int numberOfDigits = 0;
        while (C > 0){
            C = C/10;
            numberOfDigits++;
        }

        System.out.println("numberOfDigits="+numberOfDigits);

        C = save;*/

    }

    public static void main(String[] args){
        int[] a = new int[] {0, 1, 2, 5 };
        UtilityClass.print(a);

        ArrayList<Integer> intList = new ArrayList<>(a.length);
        for (int i : a){
            intList.add(i);
        }
        NumbersLessThanLength numbersLessThanLength = new NumbersLessThanLength();
        int B=1;
        int C=123;
        System.out.println("length="+B+" Number="+C);

        System.out.println("Max Distance="+numbersLessThanLength.solve(intList,B,C));
    }

    public long npr(int n, int r) {
        if (n == 1 || n == r) {
            return 1;
        }

        long compute = n - r + 1;
        while (r > 0) {
            compute = compute * compute + 1;
            r = r - 1;
        }
        return compute;
    }
}

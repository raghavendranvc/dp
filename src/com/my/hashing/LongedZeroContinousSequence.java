package com.my.hashing;

import java.util.ArrayList;

public class LongedZeroContinousSequence {
    /*

    1 ,2 ,-2 ,4 ,-4

    sum - 5
    sum - 1

    sum  -5 -4
    sum  -5  -1
    sum      -1  -2

    sum  -5 -4 -3
         -5 -4  -1
         -5     -2 -2

         -5 -4 -3 -2
         -5 -4 -3  -1
             5      1
        4   5       1

    345



     */

    public ArrayList<Integer> lszeroBruteForce(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = A.size();

        for(int i=n;i>=1;i--){
            for(int j=0;j<=n-i;j++){
                int sum = 0;
                for(int k=j;k<j+i;k++) {
                    sum = sum + A.get(k);
                }
                if( sum == 0){
                    for(int k=j;k<j+i;k++) {
                        result.add(A.get(k));
                    }
                    return result;
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = A.size();

        int[] sumArray = new int[n+1];
        sumArray[0] = 0;
        for(int i=1;i<=n;i++){
            sumArray[i] = sumArray[i-1] + A.get(i-1);
        }

        for(int i=n;i>=1;i--) { // i = length of the sequence
            for (int j = 0; j <= n - i; j++) { // j = starting index of the sequence
                int sum = sumArray[j + i] - sumArray[j];
                if (sum == 0) {
                    for (int k = j; k < j + i; k++) {
                        result.add(A.get(k));
                    }
                    return result;
                }
            }
        }

        return result;

    }
}

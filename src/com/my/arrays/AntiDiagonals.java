package com.my.arrays;

import java.util.ArrayList;

public class AntiDiagonals {

    /*
    1   2   3   4   5   6
    7   8   9   10  11  12
    13  14  15  16  17  18
    19  20  21  22  23  24
    25  26  27  28  29  30
    31  32  33  34  35  36

    1                   (0,0)
    2   7               (0,1)   (1,0)
    3   8   13          (0,2)   (1,1)   (2,0)
    4   9   14  19      (0,3)   (1,2)   (2,1)   (3,0)

    12  17  22  27  32  (1,5)   (2,4)   (3,3)   (4,2)   (5,1)
    18  23  28  33      (2,5)   (3,4)   (4,3)   (5,2)

    */

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int j=i; j>=0 ; j--){
                tempList.add(A.get(i-j).get(j));
            }
            returnList.add(tempList);
        }

        for(int i=1;i<n;i++) {     //i=n-n+1, i=n-n+2
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int j=n-1; j>=i ; j--) {
                tempList.add(A.get(i+n-1-j).get(j)); //(1,n-1) (1,
            }
            returnList.add(tempList);
        }

        return returnList;

    }


    public ArrayList<ArrayList<Integer>> diagonal2(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int dimension = a.size();
        for (int i = 0; i < dimension*2-1; i++) {
            result.add(getDiagonal(i, a));
        }
        return result;
    }

    public ArrayList<Integer> getDiagonal(int layer, ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= layer; i++) {
            int j = layer-i;
            if (i < a.size() && j < a.size()) {
                result.add(a.get(i).get(j));
            }
        }
        return result;
    }
}

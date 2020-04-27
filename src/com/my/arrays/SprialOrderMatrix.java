package com.my.arrays;

import java.util.ArrayList;
import java.util.List;

public class SprialOrderMatrix {

    //TODO Need to work on.

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();

        return result;
    }

    public ArrayList<Integer> twinOrder(final List<ArrayList<Integer>> A) {

        int m = A.size();
        int n = A.get(0).size();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i%2 == 0){
                    arrayList.add(A.get(i).get(j));
                } else {
                    arrayList.add(A.get(i).get(n-1-j));
                }
            }

        }
        return arrayList;

    }
}

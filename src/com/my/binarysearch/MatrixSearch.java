package com.my.binarysearch;

import java.util.ArrayList;

public class MatrixSearch {

    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {

        int rows = A.size();
        int columns = A.get(0).size();

        int totalValues = rows*columns;

        System.out.println("rows="+rows+" columns="+columns);
        int l = 0;
        int h = totalValues-1;


        /*
        9 x 8 matrix
        66 Element
        r = 8th Row
        c= 2nd Column = 66-r(columns) = mid -r*columns

         */

        while( l <= h ){
            int mid = (l+h)/2;
            int r = mid/columns;
            int c = mid - r*columns;

            System.out.println("mid="+mid +" l="+l+" h="+h+" r="+r+" c="+c);

            if(B == A.get(r).get(c)){
                System.out.println("found at r="+r+" c="+c);
                return 1;
            }

            if(B < A.get(r).get(c)){
                System.out.println("new high");
                h = mid -1;
            }

            if(B > A.get(r).get(c)){
                System.out.println("new low");
                l = mid+1;
            }
            System.out.println();
        }
        System.out.println("not found");
        return 0;
    }

    public static void main(String[] args){
        /*int[][] A =  new int[][]{
                {3},
                {29},
                {36},
                {63},
                {67},
                {72},
                {74},
                {78},
                {85}
                };
        int B = 41;*/

        int[][] A = new int[][] {
                {5, 6, 6, 10, 11, 12, 12, 12, 15, 16},
                {18, 18, 19, 21, 21, 21, 22, 22, 23, 24},
                {29, 32, 32, 32, 33, 34, 34, 34, 35, 40},
                {40, 42, 42, 43, 44, 46, 46, 47, 47, 47},
                {48, 48, 48, 50, 51, 51, 51, 51, 51, 52},
                {53, 56, 57, 59, 59, 60, 61, 61, 61, 63},
                {63, 64, 64, 65, 65, 65, 67, 67, 67, 67},
                {70, 73, 74, 74, 74, 75, 75, 79, 79, 81},
                {82, 83, 83, 84, 84, 85, 86, 88, 89, 91},
                {91, 91, 95, 95, 96, 96, 97, 99, 100, 100}
        };

        int B = 96;


        ArrayList<ArrayList<Integer>> intList = new ArrayList<>();

        for(int i=0; i<A.length; i++){
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int j=0;j<A[0].length;j++){
                tempList.add(A[i][j]);
            }
            intList.add(tempList);
        }

        System.out.println("Initial Array="+intList);
        MatrixSearch matrixSearch = new MatrixSearch();
        System.out.println("Element="+B+" found ?"+matrixSearch.searchMatrix(intList,B));
    }
}

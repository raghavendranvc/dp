package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;

public class SetMatrixZero {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        int r = a.size();
        int c = a.get(0).size();
        int[] row = new int[r];
        int[] col = new int[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                row[i] += a.get(i).get(j);
                col[j] += a.get(i).get(j);
            }
        }

        UtilityClass.print(row);
        UtilityClass.print(col);

        System.out.println("r="+r+" c="+c);

        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                if(row[i] - c < 0 || col[j] - r < 0){
                    a.get(i).set(j,0);
                }
            }
        }

        System.out.println(a);

    }

    public static void main(String[] args){
        //int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683, 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653, 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406, 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557, 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160, 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742  };
        //int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};
        int[][] a = new int[][]{
                {  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {  1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        //UtilityClass.print(a);

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        int r = a.length;
        int c = a[0].length;
        for(int i=0;i<r;i++){
            ArrayList<Integer> innerList = new ArrayList<>();
            for(int j=0;j<c;j++){
                innerList.add(a[i][j]);
            }
            al.add(innerList);
        }

        SetMatrixZero setMatrixZero = new SetMatrixZero();

        setMatrixZero.setZeroes(al);
    }

}

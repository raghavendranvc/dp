package com.my.math;

public class GridUniquePaths {

    public int uniquePaths(int A, int B) {
        int[][] numberOfPaths = new int[A][B];

        for(int i=0;i<A;i++){
            numberOfPaths[i][0] = 1;
        }

        for(int i=0;i<B;i++){
            numberOfPaths[0][i] = 1;
        }

        for(int i=1;i<A;i++){
            for(int j=1;j<B;j++){
                numberOfPaths[i][j] = numberOfPaths[i-1][j]+numberOfPaths[i][j-1];
            }
        }

        return numberOfPaths[A-1][B-1];
    }
}

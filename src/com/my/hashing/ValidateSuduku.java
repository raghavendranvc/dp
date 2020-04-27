package com.my.hashing;

import java.util.List;

public class ValidateSuduku {

    public int isValidSudoku(final List<String> A) {

        boolean[][] checkRow = new boolean[9][9];
        boolean[][] checkCol = new boolean[9][9];
        boolean[][][] checkSub = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch1 = A.get(i).charAt(j);

                if (ch1 == '.') {
                    continue;
                }

                if (checkRow[i][ch1 - '1']) {
                    return 0;
                }
                checkRow[i][ch1 - '1'] = true;

                if (checkCol[ch1 - '1'][j]) {
                    return 0;
                }
                checkCol[ch1 - '1'][j] = true;

                if (checkSub[i/3][j/3][ch1 - '1']) {
                    return 0;
                }
                checkSub[i/3][j/3][ch1 - '1'] = true;

            }
        }

        return 1;
    }

    public int isValidSudokuLessSpace(final List<String> A) {

        for(int row=0;row<9;row++) {
            boolean[] rowCheck = new boolean[9];
            for (int col = 0; col < 9; col++) {

                char ch1 = A.get(row).charAt(col);

                if (ch1 == '.') {
                    continue;
                }

                if (rowCheck[ch1 - '1']) {
                    return 0;
                }

                rowCheck[ch1 - '1'] = true;
            }
        }

        for(int col=0;col<9;col++) {
            boolean[] colCheck = new boolean[9];
            for (int row = 0; row < 9; row++) {

                char ch2 = A.get(row).charAt(col);

                if (ch2 == '.') {
                    continue;
                }

                if (colCheck[ch2 - '1']) {
                    return 0;
                }

                colCheck[ch2 - '1'] = true;
            }
        }

        // 0    3   6
        // 27   30  33
        // 54   57  60
        //

        /*
        0   1   2       3   4   5       6   7   8
        9   10  12      12  13  14      15  16  17
        18  19  20      21  22  23      24  25  26




         */

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boolean[] subCheck = new boolean[9];
                for (int k = 0; k < 9; k++) {
                    char ch3 = A.get(i*3+k/3).charAt(j*3+k%3);

                    if (ch3 == '.') {
                        continue;
                    }

                    if (subCheck[ch3 - '1']) {
                        return 0;
                    }

                    subCheck[ch3 - '1'] = true;
                }
            }
        }

        return 1;

    }


    public static void main(String[] args){
        int[][] fill = new int[9][9];
        int count = 0;

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                fill[i][j]=count++;
                System.out.print(fill[i][j] + "\t");
            }
            System.out.println();
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boolean[] subCheck = new boolean[9];
                for (int k = 0; k < 9; k++) {
                    System.out.print(fill[i*3+k/3][j*3+k%3] + "\t");

                }
                System.out.println();
            }

        }


    }

}

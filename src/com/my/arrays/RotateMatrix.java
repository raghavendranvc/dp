package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;

public class RotateMatrix {

    /*
    j
    =
i=      0   1   2   3
    0   1   4   3   4
    1   5   6   7   8
    2   2   3   4   5
    3   6   7   9   7

        6   4   3   1
        5   6   7   8
        2   3   4   5
        7   7   9   4


     */

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();

        for(int i=0;i<n/2;i++){

            for(int j=i;j<n-i-1;j++){

                int temp = a.get(i).get(j);

                //n = 5

                //      0      '1'   2   3   4
                //      5       6   7   8   '9'
                //      10      11  12  13  14
                //      '15'    16  17  18  19
                //      20      21  22  '23'  24

                //(0,1) <- (3,0)
                //(3,0) <- (4,3)
                //(4,3) <- (1,4)
                //(1,4) <- (0,1)


                a.get(i).set(j,a.get(n-1-j).get(i));
                a.get(n-1-j).set(i,a.get(n-1-i).get(n-1-j));
                a.get(n-1-i).set(n-1-j,a.get(j).get(n-1-i));
                a.get(j).set(n-1-i,temp);

                //printMatrix(matrix,n);
            }

        }


    }

    public static void rotate90Clockwise(int[][] matrix,int n) {

    	//We make only n/2 rotations so that we reach the center. There are n/2 spirals
    	
        for(int i=0;i<n/2;i++){ 

            for(int j=i;j<n-i-1;j++){ //starts at (i) and ends at (n-1)-i. We make 

                int temp = matrix[i][j];  //(0,2) = 2

                matrix[i][j]          = matrix[n-1-j][i];  //(2,0)

                matrix[n-1-j][i]      = matrix[n-1-i][n-1-j];  //(3,2)

                matrix[n-1-i][n-1-j]  = matrix[j][n-1-i]; //(1,3)

                matrix[j][n-1-i]  = temp;

                UtilityClass.printArray(matrix);
            }

            System.out.println("Next Cycle");

        }


    }



    public static void main (String[] args)
    {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        UtilityClass.printArray(arr);
        rotate90Clockwise(arr,arr.length);
        UtilityClass.printArray(arr);
    }

}

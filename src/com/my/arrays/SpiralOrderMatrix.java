package com.my.arrays;


import java.util.ArrayList;

public class SpiralOrderMatrix {

	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {

		/*
		 * 0 1 2 3 4 5 6 '7' 8 9 '10' 11 (1,1) (1,4) 12 13 14 15 16 17 18 19 20 21 22 23
		 * 24 '25' 26 27 '28' 29 (4,1) (4,4) 30 31 32 33 34 35
		 * 
		 */

		int[][] elements = new int[A][A];

		for (int i = 0, count = 1; i <= A / 2; i++) { // A/2 is the spirals. So we loop as per spiral

			for (int j = i; j < A - i; j++) { // starts at (i,i) diagonal
				elements[i][j] = count++;
			}

			for (int j = i + 1; j < A - i; j++) {
				elements[j][A - 1 - i] = count++;
			}

			for (int j = i + 1; j < A - i; j++) {
				elements[A - 1 - i][A - 1 - j] = count++;
			}

			for (int j = i + 1; j < A - i - 1; j++) {
				elements[A - 1 - j][i] = count++;
			}

		}

		ArrayList<ArrayList<Integer>> returnList = new ArrayList<>(A);

		for (int i = 0; i < A; i++) {
			ArrayList<Integer> tempList = new ArrayList<>();
			for (int j = 0; j < A; j++) {
				tempList.add(elements[i][j]);
			}
			returnList.add(tempList);
		}

		return returnList;
	}

	public static int[][] genSpiral(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("N must be >0");
		}
		
		int[] dc = new int[] { 1, 0, -1, 0 };
		int[] dr = new int[] { 0, 1, 0, -1 };
		
		int dir = 0, val = 0, r = 0, c = 0, limit = n * n;
		
		int[][] matrix = new int[n][n];
		
		while (val++ < limit) {
			
			matrix[r][c] = val;
			
			r += dr[dir];
			c += dc[dir];
			
			if (isInvalid(matrix, r, c)) {
				r -= dr[dir];
				c -= dc[dir];
				dir = (dir + 1) % 4;
				r += dr[dir];
				c += dc[dir];
			}
		}
		return matrix;
	}

	private static boolean isInvalid(int[][] m, int r, int c) {
		return r < 0 || c < 0 || r >= m.length || c >= m.length || m[r][c] != 0;
	}

	public static void main(String[] args) {

		SpiralOrderMatrix.generateMatrix(5);

	}
}

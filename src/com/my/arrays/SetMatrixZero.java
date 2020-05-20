package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;

public class SetMatrixZero {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {

		int r = a.size();
		int c = a.get(0).size();

		/*
		 * Try to store the result of first row and first matrix in 2 flags Use the
		 * first row for row result Use the second row for row result. At the end
		 * process first row and first column
		 */
		int[] row = new int[r];
		int[] col = new int[c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				row[i] += a.get(i).get(j);
				col[j] += a.get(i).get(j);
			}
		}

		UtilityClass.print(row);
		UtilityClass.print(col);

		System.out.println("r=" + r + " c=" + c);

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (row[i] - c < 0 || col[j] - r < 0) {
					a.get(i).set(j, 0);
				}
			}
		}

		System.out.println(a);

	}

	public static void main(String[] args) {
		// int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683,
		// 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653,
		// 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406,
		// 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557,
		// 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160,
		// 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742 };
		// int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319,
		// 412};
		int[][] a = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		// UtilityClass.print(a);

		ArrayList<ArrayList<Integer>> al = new ArrayList<>();

		int r = a.length;
		int c = a[0].length;
		for (int i = 0; i < r; i++) {
			ArrayList<Integer> innerList = new ArrayList<>();
			for (int j = 0; j < c; j++) {
				innerList.add(a[i][j]);
			}
			al.add(innerList);
		}

		SetMatrixZero setMatrixZero = new SetMatrixZero();

		setMatrixZero.setZeroes(al);
	}

	public void setZeroesCopied(ArrayList<ArrayList<Integer>> matrix) {
		boolean firstRow = false;
		boolean firstCol = false;

		for (int i = 0; i < matrix.size(); i++) {
			if (matrix.get(i).get(0) == 0) { //Checking first column and see if it has to be zero
				firstCol = true;
				break;
			}
		}

		for (int i = 0; i < matrix.get(0).size(); i++) {
			if (matrix.get(0).get(i) == 0) { //Check first row and see if it has to be zero
				firstRow = true;
				break;
			}
		}

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(0).size(); j++) { 
				if (matrix.get(i).get(j) == 0) {
					matrix.get(i).set(0, 0); //Set First Col value as zero. Here 'j' is '0'
					matrix.get(0).set(j, 0); //Set First Row value as zero. here 'i' is '0'
				}
			}
		}

		for (int i = 1; i < matrix.size(); i++) {
			for (int j = 1; j < matrix.get(i).size(); j++) {//For each row & col >=1 
				if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) { //Set value based on first or first column
					matrix.get(i).set(j, 0);
				}
			}
		}

		//Fix first column
		
		if (firstCol) {
			for (int i = 0; i < matrix.size(); i++)
				matrix.get(i).set(0, 0);
		}
		
		//Fix first row

		if (firstRow) {
			for (int i = 0; i < matrix.get(0).size(); i++)
				matrix.get(0).set(i, 0);
		}
	}

}

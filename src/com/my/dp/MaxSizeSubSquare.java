package com.my.dp;

import com.my.common.UtilityClass;

public class MaxSizeSubSquare {

	static class SubSquare {
		int i;
		int j;
		int size;

		public SubSquare(int i, int j, int size) {
			this.i = i;
			this.j = j;
			this.size = size;
		}

		public String toString() {
			return "i=" + i + " j=" + j + " size=" + size;
		}

	}

	public void getMaxSizeSubSquare(int[][] m, SubSquare s) {

		int r = m.length;
		int c = m[0].length;

		int[][] sizeMatrix = new int[r][c];

		for (int i = 0; i < r; i++) { // For each row when column is '0'
			sizeMatrix[i] = new int[c];
			sizeMatrix[i][0] = m[i][0];
		}

		for (int j = 0; j < c; j++) { // For each column when row is '0'
			sizeMatrix[0][j] = m[0][j];
		}

		s.size = 0;
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (m[i][j] == 0) {
					sizeMatrix[i][j] = 0;
				} else {
					sizeMatrix[i][j] = 1 + getMin(sizeMatrix[i - 1][j - 1], sizeMatrix[i - 1][j], sizeMatrix[i][j - 1]);

					if (s.size < sizeMatrix[i][j]) {
						s.size = sizeMatrix[i][j];
						s.i = i - s.size + 1;
						s.j = j - s.size + 1;
					}
				}
			}
		}

		UtilityClass.printArray(sizeMatrix);

	}

	int getMin(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		SubSquare ss = new SubSquare(0, 0, 0);
		MaxSizeSubSquare ms = new MaxSizeSubSquare();
		ms.getMaxSizeSubSquare(m, ss);
		System.out.println(ss);

	}

}

package com.my.dp.ibit;

import java.util.ArrayList;
import com.my.common.UtilityClass;

public class MaximalRectangle {

	// TODO, the logic is very important

	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dpR = new int[m][n]; 
		//DP from right. 
		// For each column we evaluate the values from the right

		for (int r = 0; r < m; r++) {
			for (int c = n - 1; c >= 0; c--) {
				if (matrix[r][c] == '0') {
					dpR[r][c] = 0; //If value is zero, set to '0'
				} else if (c == n - 1) {
					dpR[r][c] = 1; //For last column
				} else {
					dpR[r][c] = dpR[r][c + 1] + 1; //For any other column is the value from next
				}
			}
		}

		UtilityClass.printArray(dpR);
		System.out.println();

		int[][] min = new int[m][n];//These are created only for demo purpose
		int[][] max = new int[m][n];
		int maxReturn = 0;
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (matrix[r][c] == '0') { // For '0' place, we just continue;
					continue;
				}
				min[r][c] = dpR[r][c];	//We take this as the min value for now.

				//We now loop for all rows from r to m till we see non zero. 
				//The moment we see a '0' we stop
				//At each place the minimum 
				//Max is calculated (k - r + 1) multiplied by column min 
				// It is like multiplying rows*columns
				for (int k = r; k < m && matrix[k][c] == '1'; k++) {
					min[r][c] = Math.min(min[r][c], dpR[k][c]); 
					max[r][c] = Math.max(max[r][c], (k - r + 1) * min[r][c]);
					maxReturn = Math.max(maxReturn, max[r][c]);
				}
			}
		}

		UtilityClass.printArray(min);
		System.out.println();

		UtilityClass.printArray(max);
		System.out.println();

		return maxReturn;
	}

	public int maximalRectangle(int[][] A) {
		int m = A.length;
		int n = A[0].length;

		int[][] dpR = new int[m][n];

		for (int r = 0; r < m; r++) {
			for (int c = n - 1; c >= 0; c--) {
				if (A[r][c] == 0) {
					dpR[r][c] = 0;
				} else if (c == n - 1) {
					dpR[r][c] = 1;
				} else {
					dpR[r][c] = dpR[r][c + 1] + 1;
				}
			}
		}

		int[][] min = new int[m][n];
		int[][] max = new int[m][n];
		int maxReturn = 0;
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (A[r][c] == 0) {
					continue;
				}
				min[r][c] = dpR[r][c];

				for (int k = r; k < m && A[k][c] == 1; k++) {
					min[r][c] = Math.min(min[r][c], dpR[k][c]);
					max[r][c] = Math.max(max[r][c], (k - r + 1) * min[r][c]);
					maxReturn = Math.max(maxReturn, max[r][c]);
				}
			}
		}

		return maxReturn;
	}

	public static void main(String[] args) {
		char[][] a = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		UtilityClass.printArray(a);
		System.out.println();
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		maximalRectangle.maximalRectangle(a);

	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {

		int m, n;
		m = a.size();
		n = a.get(0).size();

		int aux[][] = new int[m][n];
		fillAux(aux, a, m, n);
		int max = 0;
		int min;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a.get(i).get(j) == 1) {
					min = aux[i][j];

					for (int k = i; k < m && a.get(k).get(j) == 1; k++) {
						min = Math.min(min, aux[k][j]);
						max = Math.max(max, (k - i + 1) * min);
					}

				}
			}
		}
		return max;
	}

	void fillAux(int aux[][], ArrayList<ArrayList<Integer>> a, int m, int n) {
		for (int i = 0; i < m; i++) {
			if (a.get(i).get(n - 1) == 1)
				aux[i][n - 1] = 1;
			else
				aux[i][n - 1] = 0;
		}

		for (int i = 0; i < m; i++) {
			for (int j = n - 2; j >= 0; j--) {
				if (a.get(i).get(j) == 0)
					aux[i][j] = 0;
				else
					aux[i][j] = aux[i][j + 1] + 1;
			}
		}
	}

}

package com.my.arrays;

import java.util.ArrayList;

public class PascalsTriangle {

	/*
	 * 0 1 2 3 4 0 1 1
	 * 
	 * 1 - 1
	 * 
	 * 2 - 1 2 1
	 * 
	 * 3 - 1 3 3 1
	 * 
	 * 4 - 1 4 6 4 1
	 * 
	 * 
	 */
	public ArrayList<ArrayList<Integer>> solve(int A) {

		/*
		 * int[][] pascals = new int[A][A];
		 * 
		 * for(int i=0;i<A;i++){ pascals[i][0] = 1; pascals[i][i] = 1; }
		 * 
		 * for(int i=2;i<A;i++){ for(int j=1;j<i;j++){ pascals[i][j] =
		 * pascals[i-1][j-1]+ pascals[i-1][j]; } }
		 */

		ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();
		for (int i = 0; i < A; i++) {
			ArrayList<Integer> inList = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					inList = new ArrayList<>();
				}

				if (j == 0 || i == j) {
					inList.add(1);
				} else {
					inList.add(pascalsTriangle.get(i - 1).get(j - 1) + pascalsTriangle.get(i - 1).get(j));
				}
			}
			pascalsTriangle.add(inList);
		}

		return pascalsTriangle;
	}

	/*
	 * 
	 * 
	 * c(n,r) = n!/(n-r)!r! = n * (n-1) * ....* (n-r+1) / ...
	 * 
	 * c(n,r) = c(n,r-1) * (n-r+1)/r
	 * 
	 * c(n,r) = (n-r+1)/r * c(n,r-1)
	 * 
	 * 
	 * c(n,r) n- r + 1 ------ = -------- c(n-1,r) r
	 * 
	 * 
	 */

	public ArrayList<Integer> getRowUsingFormula(int A) {
		ArrayList<Integer> returnList = new ArrayList<>();
		for (int n = 1; n <= A; n++) {
			int C = 1;
			for (int r = 1; r <= n; r++) {
				returnList.add(n);
				// All values are precomputed
				C = C * (n - r) / r; // We are computing one extra at the ed

			}
		}

		return returnList;
	}

	public ArrayList<Integer> getRow(int A) {

		ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();

		for (int i = 0; i <= A; i++) {
			ArrayList<Integer> aList = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					aList.add(1);
				} else {
					aList.add(returnList.get(i - 1).get(j) + returnList.get(i - 1).get(j - 1));
				}
			}
			returnList.add(aList);
		}
		return returnList.get(A);
	}

}

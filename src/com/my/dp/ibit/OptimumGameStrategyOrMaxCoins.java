package com.my.dp.ibit;

import com.my.common.UtilityClass;

public class OptimumGameStrategyOrMaxCoins {

	public int getOptStrategey(int[] a) {
		return getOptStrategey(a, 0, a.length - 1);

	}

	public int getOptStrategey(int[] a, int i, int j) {
		if (i == j) {
			return a[i];
		}

		if (i + 1 == j) {
			return Math.max(a[i], a[j]);
		}

		return Math.max(a[i] + Math.min(getOptStrategey(a, i + 2, j), getOptStrategey(a, i + 1, j - 1)),
				a[j] + Math.min(getOptStrategey(a, i + 1, j - 1), getOptStrategey(a, i, j - 2)));

	}

	// TODO, get the trick here next time

	public int getOptStrategeyIter(int[] a) {

		int n = a.length;

		int[][] table = new int[n][n];

		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {

				/*
				 * Check for diagonal property. We are constructing diagonal with gap 0, 1, 2,
				 * 3, 4, ...n-1
				 */
				int x = (i + 2 <= j) ? table[i + 2][j] : 0;
				int y = (i + 1 <= j - 1) ? table[i + 1][j - 1] : 0;
				int z = (i <= j - 2) ? table[i][j - 2] : 0;

				table[i][j] = Math.max(a[i] + Math.min(x, y), a[j] + Math.min(y, z));

			}

		}

		return table[0][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1 = { 8, 15, 3, 7 };
		int[] a2 = { 2, 2, 2, 2 };
		int[] a3 = { 20, 30, 2, 2, 2, 10 };

		OptimumGameStrategyOrMaxCoins ogs = new OptimumGameStrategyOrMaxCoins();

		int val1 = ogs.getOptStrategey(a1);
		System.out.println("val1=" + val1);

		int val2 = ogs.getOptStrategey(a2);
		System.out.println("val2=" + val2);

		int val3 = ogs.getOptStrategey(a3);
		System.out.println("val3=" + val3);

		int val11 = ogs.getOptStrategeyIter(a1);
		System.out.println("val11=" + val11);

		int val21 = ogs.getOptStrategeyIter(a2);
		System.out.println("val21=" + val21);

		int val31 = ogs.getOptStrategeyIter(a3);
		System.out.println("val31=" + val31);

	}

	/***
	 * if (EVEN > ODD), start choosing from the right-hand corner and select all the
	 * even placed coins. if (EVEN < ODD), start choosing from the left-hand corner
	 * and select all the odd placed coins. if (EVEN == ODD), choosing only the
	 * odd-placed or only the even placed coins will throw a tie.
	 * 
	 * @param A
	 * @param fp
	 * @param ep
	 * @return
	 */

	/*
	 * public int maxcoin(int[] A) { int oddSum = A[0]; int evenSum = A[1];
	 * 
	 * for (int i = 2; i < A.length; i++) { if (i % 2 == 0) { oddSum += A[i]; } else
	 * { evenSum += A[i]; } }
	 * 
	 * if (oddSum > evenSum) { return oddSum; } else { return evenSum; }
	 * 
	 * }
	 */

	public int maxcoinRecur(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		return maxCoint(A, 0, A.length - 1);
	}

	public int maxCoint(int[] A, int fp, int ep) {
		if (fp == ep) {
			return A[fp];
		}
		if (fp + 1 == ep) {
			return Math.max(A[fp], A[ep]);
		}

		int fpProfit22 = maxCoint(A, fp + 2, ep);
		int fpProfit21 = maxCoint(A, fp + 1, ep - 1);

		int epProfit21 = maxCoint(A, fp, ep - 2);
		int epProfit22 = maxCoint(A, fp + 1, ep - 1);

		return Math.max(A[fp] + Math.min(fpProfit22, fpProfit21), A[ep] + Math.min(epProfit21, epProfit22)

		);
	}

	/*
	 * TODO check this logic This is also called Optimum GAME strategy
	 */
	public int maxcoin2(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int n = A.length;
		int sol[][] = new int[n][n];

		for (int length = 0; length < n; length++) {
			for (int i = 0, j = length; j < n; i++, j++) {// j-i is always length

				int x = (i + 2 <= j) ? sol[i + 2][j] : 0;
				int y = (j - 2 >= i) ? sol[i][j - 2] : 0;
				int z = (i + 1 <= j && j - 1 >= i) ? sol[i + 1][j - 1] : 0;

				sol[i][j] = Math.max(A[i] + Math.min(x, z), A[j] + Math.min(y, z));
			}
		}
		UtilityClass.printArray(sol);
		return sol[0][n - 1];
	}

	public static void main2(String[] args) {
		int A[] = { 26, 88, 57, 26, 65, 60, 55, 40 };
		OptimumGameStrategyOrMaxCoins maxCoins = new OptimumGameStrategyOrMaxCoins();
		System.out.println("Result=" + maxCoins.maxcoin2(A));
	}

	/*
	 * public int maxcoin(int[] A) { if (A == null || A.length == 0) { return 0; }
	 * 
	 * int n = A.length;
	 * 
	 * int fp = 0; int ep = n - 1;
	 * 
	 * int i = 0; int total = 0;
	 * 
	 * while (i < n && fp < ep) { i++; int val = 0; if (A[fp] >= A[ep]) { val =
	 * A[fp++]; } else { val = A[ep--]; }
	 * 
	 * if (i % 2 == 1) { total += val; } }
	 * 
	 * return total; }
	 */

}

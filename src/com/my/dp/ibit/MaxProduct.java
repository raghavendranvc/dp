package com.my.dp.ibit;

public class MaxProduct {

	public int maxProduct(final int[] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int n = A.length;

		int maxProduct = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int current = A[i];
			maxProduct = Math.max(maxProduct, current);
			for (int j = i + 1; j < n; j++) {
				current = current * A[j];
				maxProduct = Math.max(maxProduct, current);
			}
		}

		return maxProduct;
	}

	public int maxProductOOM(final int[] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int n = A.length;
		int[][] maxP = new int[n][n];

		int maxProduct = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					maxP[i][i] = A[i];
				} else {
					maxP[i][j] = maxP[i][j - 1] * A[j];
				}
				maxProduct = Math.max(maxProduct, maxP[i][j]);
			}
		}

		return maxProduct;
	}

	int maxProduct1(int[] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int n = A.length;

		int[] pProduct = new int[n];
		int[] nProduct = new int[n];
		int[] mProduct = new int[n];

		pProduct[0] = nProduct[0] = mProduct[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			int a = pProduct[i - 1] * A[i];
			int b = nProduct[i - 1] * A[i];

			pProduct[i] = Math.max(Math.max(a, b), A[i]); // maximum of a,b,A[i]
			nProduct[i] = Math.min(Math.min(a, b), A[i]); // minimum of a,b,A[i]

			mProduct[i] = Math.max(mProduct[i-1], pProduct[i]); // max of previous or maxPostive

		}

		return mProduct[n - 1];

	}

}

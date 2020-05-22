package com.my.dp;

public class BinomialCoefficient {

	// (n,0)/(n,n) = 1
	// (n,r) = (n-1,r-1) + (n-1,r)
	public int BinomialCoeffiecntRecur(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		}
		return BinomialCoeffiecntRecur(n - 1, r - 1) + BinomialCoeffiecntRecur(n - 1, r);
	}

	public int BinomialCoefficentIter(int n, int r) {
		int C[][] = new int[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			C[i][0] = 1;
		}

		for (int j = 0; j <= r; j++) {
			C[j][j] = 1;
		}
		// n c r = n-1 c r + n-1 c r-1
		// 1
		// 1 1
		// 1 2 1s
		// 1 3 3 1
		// 1 4 6 4 1
		// 1 5 10 10 5 1

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= Math.min(i, r); j++) {
				C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		return C[n][r];
	}

	// xc0 = xc0 = 1
	// 1c1 = 1
	// 5c1 = 4c0+4c1

	public static void main(String[] args) {
		int n = 15, r = 6;
		BinomialCoefficient bc = new BinomialCoefficient();
		int val1 = bc.BinomialCoeffiecntRecur(n, r);
		System.out.println("val1=" + val1);
		int val2 = bc.BinomialCoefficentIter(n, r);
		System.out.println("val2=" + val2);
	}

	/**************another recur *************************/
	
	static int binomialCoeff(int n, int k) {

		// Base Cases
		if (k == 0 || k == n)
			return 1;

		// Recur
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
	}
	
	/**************another opt *************************/

	static int binomialCoeffOpt(int n, int k) {
		int C[] = new int[k + 1];

		// nC0 is 1
		C[0] = 1;

		for (int i = 1; i <= n; i++) {
			// Compute next row of pascal
			// triangle using the previous row
			for (int j = Math.min(i, k); j > 0; j--) {
				C[j] = C[j] + C[j - 1];
			}
		}
		return C[k];
	}
	
	/**************another space efficient *************************/

	// Returns value of Binomial Coefficient C(n, k)
	static int binomialCoeffSpaceAndTimeEfficient(int n, int k) {
		int res = 1;

		// Since C(n, k) = C(n, n-k)
		if (k > n - k)
			k = n - k;

		// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}

}

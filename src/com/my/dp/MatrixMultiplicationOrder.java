package com.my.dp;

public class MatrixMultiplicationOrder {

	/*
	 * Eg : (order,1,4) for order (10,30,20,20,40) k=1 to 3 // closed parenthesis
	 * moves from position 1 to 4
	 * 
	 * 10*30*5*60 A = 20*30, B = 30*5, C =5*60
	 * 
	 * (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations A(BC) =
	 * (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
	 * 
	 */

	public int getMinMultiplications(int[] order, int i, int j) {

		if (i == j) {
			System.out.println("Equal=" + i);
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			System.out.println("i=" + i + " j=" + j + " k=" + k);
			int count = getMinMultiplications(order, i, k) + (order[i - 1] * order[k] * order[j])
					+ getMinMultiplications(order, k + 1, j);
			System.out.print("count=" + count);
			if (count < min) {
				System.out.print("  Selected for (" + i + "," + j + ")");
				min = count;
			}
			System.out.println();
		}

		return min;
	}

	public int getMatrixMulIter(int[] p, int n) {

		int[][] table = new int[n][n];
		System.out.println("n=" + n);

		/*
		 * Column 0 and Row 0 are not used at all
		 */

		for (int i = 1; i < n; i++) {
			table[i][i] = 0;
		}

		for (int chainLength = 2; chainLength < n; chainLength++) {

			System.out.println("chainLength=" + chainLength);

//			for(int i=1,j=chainLength;i<=(n-chainLength);i++,j++){

			for (int i = 1, j = chainLength; j < n; i++, j++) {

				System.out.println("\ti=" + i + " j=" + j);
				table[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {

					System.out.print("\t\tk=" + k + " [" + i + "][" + k + "]=" + table[i][k] + "   " + p[i - 1] + "*"
							+ p[k] + "*" + p[j] + "    [" + (k + 1) + "][" + j + "]=" + table[k + 1][j]);

					int val = table[i][k] + p[i - 1] * p[k] * p[j] + table[k + 1][j];

					table[i][j] = Math.min(table[i][j], val);
					if (val < table[i][j]) {
						table[i][j] = val;
					}
					System.out.println("   [" + i + "][" + j + "]=" + table[i][j]);
				}
			}

		}

		return table[1][n - 1]; // Like calling the recursive function (1,n-1)

	}

	/*
	 * Not correct. Needs to be enhanced
	 * 
	 * (AB)C or A(BC) = 2 ways (AB)CD or A(BC)D or AB(CD) = 3 ways (AB)CDE or
	 * A(BC)DE or AB(CD)E or ABC(DE) = 4 ways
	 */

	public int getMinMultiplications1(int[] order, int i, int j) {

		if (i == j || i < j) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		/*
		 * if(i<j){ return min; }
		 */
		for (int k = i; k <= j; k++) {
			int count = getMinMultiplications(order, i, k - 2) + (order[k - 1] * order[k])
					+ getMinMultiplications(order, k + 1, j);

			if (count < min) {
				min = count;
			}

		}
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] order = { 40, 20, 30, 10, 30 };

		MatrixMultiplicationOrder mp = new MatrixMultiplicationOrder();

		// 1 implies position of closed parenthesis for n = 4 then (0,1) (1,2) (1,3)
		// (1,4)
		// So it movies from 1 to n-1
		/*
		 * int val1 = mp.getMinMultiplications(order, 1, order.length-1);
		 * System.out.println("Min Value="+val1);
		 * 
		 * int val2 = mp.getMinMultiplications1(order, 1, order.length-1);
		 * System.out.println("Min Value2="+val2);
		 */

		int val3 = mp.getMatrixMulIter(order, order.length);
		System.out.println("Min Value3=" + val3);

	}

}

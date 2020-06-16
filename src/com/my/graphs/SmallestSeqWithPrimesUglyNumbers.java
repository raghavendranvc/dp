package com.my.graphs;

import java.util.ArrayList;

import com.my.common.UtilityClass;

public class SmallestSeqWithPrimesUglyNumbers {

	// 2 3 5

	// This problem is similar to Ugly Numbers
	/*
	 * 5 3 2 2 3 5
	 * 
	 * 2 3 4 5 6 10 2 3 4 5 6 9 10 15 2 3 4 5 7 9 10 15 25
	 * 
	 * 
	 */
	// 4 6 8 2 3 4 5 6 8
	// 6 9 15 4 6 8 9 15
	// 10 15 25 4 6 8 9 10 15 25
	public ArrayList<Integer> solve(int A, int B, int C, int D) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int multipleOf2 = 2;
		int multipleOf3 = 3;
		int multipleOf5 = 5;

		int index2 = -1, index3 = -1, index5 = -1;

		int count = 1;
		while (count <= D) {

			int currentNumber = Math.min(multipleOf2, Math.min(multipleOf3, multipleOf5));

			result.add(currentNumber);

			if (currentNumber == multipleOf2) {
				index2++;
				multipleOf2 = result.get(index2) * 2;
			}

			if (currentNumber == multipleOf3) {
				index3++;
				multipleOf3 = result.get(index3) * 3;
			}

			if (currentNumber == multipleOf5) {
				index5++;
				multipleOf5 = result.get(index5) * 5;
			}
			count++;
		}

		return result;

	}

	public ArrayList<Integer> solveSimpler(int A, int B, int C, int D) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);

		int indexA = 0;
		int indexB = 0;
		int indexC = 0;

		int count = 0;

		while (count < D) {

			int currentNumber = Math.min(result.get(indexA) * A,
					Math.min(result.get(indexB) * B, result.get(indexC) * C));
			result.add(currentNumber);

			if (currentNumber == result.get(indexA) * A) {
				indexA++;
			}

			if (currentNumber == result.get(indexB) * B) {
				indexB++;
			}

			if (currentNumber == result.get(indexC) * C) {
				indexC++;
			}

			count++;

		}

		return new ArrayList<Integer>(result.subList(1, result.size()));

	}

	public int getUglyNumber(int u) {

		if (u == 0) {
			return 0;
		}

		int[] un = new int[u];

		int index_2 = 0;
		int index_3 = 0;
		int index_5 = 0;

		un[0] = 1;
		for (int i = 1; i < u; i++) {
			int m2 = un[index_2] * 2;
			int m3 = un[index_3] * 3;
			int m5 = un[index_5] * 5;

			un[i] = Math.min(m2, Math.min(m3, m5));
			if (un[i] == m2) {
				index_2++;
				System.out.print(" " + un[i] + "=Incremented index_2=" + index_2);
			}

			if (un[i] == m3) {
				index_3++;
				System.out.print(" " + un[i] + "=Incremented index_3=" + index_3);
			}

			if (un[i] == m5) {
				index_5++;
				System.out.print(" " + un[i] + "=Incremented index_5=" + index_5);
			}
			System.out.println();
		}
		System.out.println("index_2=" + index_2 + " index_3=" + index_3 + " index_5=" + index_5);

		UtilityClass.print(un);

		return un[u - 1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SmallestSeqWithPrimesUglyNumbers uNum = new SmallestSeqWithPrimesUglyNumbers();
		int val1 = uNum.getUglyNumber(30);
		System.out.println("val1=" + val1);

	}

}

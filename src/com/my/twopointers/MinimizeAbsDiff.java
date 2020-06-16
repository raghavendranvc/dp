package com.my.twopointers;

import java.util.ArrayList;
import java.util.List;

public class MinimizeAbsDiff {

	public int solveE(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int i = 0, j = 0, k = 0;
		int ans = Integer.MAX_VALUE;

		int max, min;

		while (i < A.size() && j < B.size() && k < C.size()) {

			max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
			min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

			ans = Math.min(ans, max - min);
			if (ans == 0)
				break;// best answer possible

			if (A.get(i) == min)
				i++;
			else if (B.get(j) == min)
				j++;
			else
				k++;
		}

		return ans;
	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int i = 0, j = 0, k = 0;

		int minimumAbsDiff = Integer.MAX_VALUE;
		while (i < A.size() && j < B.size() && k < C.size()) {

			minimumAbsDiff = Math.min(minimumAbsDiff, getMinAbsDiff(A.get(i), B.get(j), C.get(k)));
			System.out.println(" minimumAbsDiff=" + minimumAbsDiff);

			if (A.get(i) <= B.get(j) && A.get(i) <= C.get(k) && i < A.size()) {
				i++;
			} else if (B.get(j) <= A.get(i) && B.get(j) <= C.get(k) && j < B.size()) {
				j++;
			} else if (C.get(k) <= A.get(i) && C.get(k) <= B.get(j) && k < C.size()) {
				k++;
			}
			System.out.println();
		}
		System.out.println("Return  minimAbsDiff=" + minimumAbsDiff);
		return minimumAbsDiff;
	}

	public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

		int i = 0, j = 0, k = 0;

		int minimumAbsDiff = Integer.MAX_VALUE;
		while (i < A.size() && j < B.size() && k < C.size()) {
			minimumAbsDiff = Math.min(minimumAbsDiff, getAbsDifference(A.get(i), B.get(j), C.get(k)));

			if (A.get(i) <= B.get(j) && A.get(i) <= C.get(k)) {
				i++;
			} else if (B.get(j) <= A.get(i) && B.get(j) <= C.get(k)) {
				j++;
			} else if (C.get(k) <= A.get(i) && C.get(k) <= B.get(j)) {
				k++;
			}
		}

		return minimumAbsDiff;

	}

	public int getAbsDifference(int a, int b, int c) {
		return Math.max(Math.abs(a - b), Math.max(Math.abs(a - c), Math.abs(b - c)));
	}

	private int getMinAbsDiff(int a, int b, int c) {
		System.out.println("a=" + a + " b=" + b + " c=" + c);
		return Math.max(Math.abs(a - b), Math.max(Math.abs(a - c), Math.abs(b - c)));
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 4, 5, 8, 10 };
		int[] b = new int[] { 6, 9, 15 };
		int[] c = new int[] { 2, 3, 6, 6 };

		/*
		 * int[] a = new int[] {-1}; int[] b = new int[] {-2}; int[] c = new int[] {-3};
		 */

		ArrayList<Integer> intListA = new ArrayList<>(a.length);
		for (int i : a) {
			intListA.add(i);
		}

		ArrayList<Integer> intListB = new ArrayList<>(a.length);
		for (int i : b) {
			intListB.add(i);
		}

		ArrayList<Integer> intListC = new ArrayList<>(a.length);
		for (int i : c) {
			intListC.add(i);
		}

		System.out.println("a=" + intListA);
		System.out.println("b=" + intListB);
		System.out.println("b=" + intListC);
		MinimizeAbsDiff minimizeAbsDiff = new MinimizeAbsDiff();

		System.out.println("minimizeAbsDiff=" + minimizeAbsDiff.solve(intListA, intListB, intListC));
	}

}

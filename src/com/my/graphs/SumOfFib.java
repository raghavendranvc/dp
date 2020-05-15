package com.my.graphs;

import java.util.ArrayList;

public class SumOfFib {

	public int fibsum(int A) {
		if (A <= 3) {
			return 1;
		}
		ArrayList<Integer> fibSeries = generateFib(A);
		System.out.println("fibSeries=" + fibSeries);
		int n = fibSeries.size();

		int minCount = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			int currentSum = fibSeries.get(i);
			int currentCount = 1;
			if (currentSum == A) {
				return 1;
			}
			for (int j = i - 1; j >= 0; j--) {

				if (currentSum + fibSeries.get(j) == A) {
					System.out.println("for =" + fibSeries.get(i) + " ended at " + fibSeries.get(j) + " count="
							+ (currentCount + 1));
					currentCount++;
					minCount = Math.min(minCount, currentCount);
					break;
				}
				if (currentSum + fibSeries.get(j) < A) {
					currentSum = currentSum + fibSeries.get(j);
					currentCount++;
				}

				if (currentCount > minCount) {
					break;
				}
			}
		}
		return minCount;
	}

	private ArrayList<Integer> generateFib(int A) {
		ArrayList<Integer> fibSeries = new ArrayList<>();
		fibSeries.add(1);
		fibSeries.add(1);

		int pre = 1;
		int next = 1;
		while (pre + next <= A) {
			fibSeries.add(pre + next);
			next = pre + next;
			pre = next - pre;
		}
		return fibSeries;
	}

	public static void main(String[] args) {
		SumOfFib sumOfFib = new SumOfFib();
		System.out.println("Result=" + sumOfFib.fibsum(5));
	}

}

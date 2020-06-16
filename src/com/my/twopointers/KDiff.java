package com.my.twopointers;

import java.util.ArrayList;

public class KDiff {

	public int diffPossible(ArrayList<Integer> A, int B) {
		int i = 0;
		int j = 1;
		while (j < A.size() && i < A.size()) {

			int diff = (A.get(j) - A.get(i));

			if (diff == B && i != j)
				return 1;

			if (diff < B)
				j++;
			else
				i++;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 2, 3, 4 };
		int B = 0;
		ArrayList<Integer> intListA = new ArrayList<>(a.length);
		for (int i : a) {
			intListA.add(i);
		}
		System.out.println("initlist=" + intListA);
		KDiff kDiff = new KDiff();
		kDiff.diffPossible(intListA, B);

	}

}

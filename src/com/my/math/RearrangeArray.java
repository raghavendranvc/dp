package com.my.math;

import com.my.arrays.MaxDistance;
import com.my.common.UtilityClass;

import java.util.ArrayList;

public class RearrangeArray {

	/**
	 * TODO Idea to do this is very important
	 * 
	 * @param a
	 */

	public void arrange(ArrayList<Integer> a) {

		int total = a.size();

		int[] parent = new int[total];
		for (int i = 0; i < total; i++) {
			parent[i] = a.get(a.get(i));
		}

		a.clear();
		for (int i = 0; i < total; i++) {
			a.add(parent[i]);
		}
	}

	public void arrangeCopied(int[] A) {
		int total = A.length;
		for (int i = 0; i < total; i++) {
			A[i] = A[i] + (A[A[i]] % total) * total;
			A[0] = A[0] + A[3 % 7] * 7;
		}

		for (int i = 0; i < total; i++) {
			A[i] = A[i] / total;
			A[0] = A[0] / 7;
		}
	}

	public void arrange3(ArrayList<Integer> A) {
		int n = A.size();

		for (int i = 0; i < n; i++) {
			A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n); //child + parent*n
		}

		for (int i = 0; i < n; i++) {
			A.set(i, A.get(i) / n);  // (child/n + parent)
		}
	}

	// 4, 1, 2, 7, 6, 5, 3, 0

	public void arrangeCopied(ArrayList<Integer> a) {
		
		int n = a.size();

		for (int i = 0; i < n; i++) {

			int index = a.get(i);
			int val = a.get(index)%n + 1;
			a.set(i, a.get(i) + n*val);
		}
		
		for (int i = 0; i < n; i++) {
			
			int val = a.get(i);
			val = val/n - 1;
			a.set(i, val);
		}

	}

	public static void main(String[] args) {
		int[] A = new int[] { 3, 2, 1, 4, 7, 5, 0, 6 };

		ArrayList<Integer> intList = new ArrayList<>(A.length);
		for (int i : A) {
			intList.add(i);
		}
		System.out.println(intList);
		RearrangeArray rearrangeArray = new RearrangeArray();
		rearrangeArray.arrange(intList);
		System.out.println(intList);
	}
}

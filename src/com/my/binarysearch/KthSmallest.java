package com.my.binarysearch;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallest {

	public int kthsmallest(final List<Integer> A, int B) {
		Integer[] array = A.toArray(new Integer[A.size()]);
		Arrays.sort(array);
		return array[B - 1];
	}

	public int kthsmallestBruteForce(final List<Integer> A, int B) {

		int smallerElements = 0;
		int equalElements = 1;
		for (int i = 0; i < A.size(); i++) {
			smallerElements = 0;
			equalElements = 0;
			for (int j = 0; j < A.size(); j++) {
				if (i == j) {
					continue;
				}
				if (A.get(i) == A.get(j)) {
					equalElements++;
				} else if (A.get(i) > A.get(j)) {
					smallerElements++;
				}

				if (smallerElements > B) {
					break;
				}
			}
			System.out.println(
					"Element=" + A.get(i) + " equalElements=" + equalElements + " smallerElements=" + smallerElements);
			if (smallerElements == B - 1 || (smallerElements < B - 1 && smallerElements + equalElements >= B - 1)) {
				return A.get(i);
			}
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int[] a = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91,
				36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : a) {
			list.add(i);
		}
		int K = 9;
		Arrays.sort(a);
		UtilityClass.print(a);

		KthSmallest kthSmallest = new KthSmallest();
		kthSmallest.kthsmallest(list, K);

	}

	public int kthsmallestQuickSort(final List<Integer> A, int B) {
		return kthSmallest(A, B, 0, A.size() - 1);
	}

	/*
	 * k 0 1 2 3 4 5 6 7 8 9 10 4 6 9 10 12 l p r
	 * 
	 */
	public int kthSmallest(final List<Integer> A, int k, int left, int right) {
		if (k > 0 && k <= right - left + 1) {
			int pivotPost = randomPartition(A, left, right);

			if (pivotPost - left == k - 1) {
				return A.get(pivotPost);
			} else if (pivotPost - left > k - 1) {
				return kthSmallest(A, k, left, pivotPost - 1);
			} else {
				return kthSmallest(A, k - (pivotPost - left) - 1, pivotPost + 1, right);
			}
		}

		return Integer.MAX_VALUE;
	}

	private final int randomPartition(final List<Integer> A, int left, int right) {
		int pivot = (int) (Math.random() % (right - left + 1));
		swap(A, left + pivot, right);
		return partition(A, left, right);
	}

	private final int partition(final List<Integer> A, int left, int right) {

		/**
		 * A[right] is considered pivot element Move all elements which are less than
		 * pivot to the left At the end 'i' should point to the first element greater
		 * than pivot
		 *
		 * the pivot is placed in the ith position All elements < pivot are towards its
		 * left All elements > pivot are towards its right
		 *
		 */
		int pivot = A.get(right), i = left;
		for (int j = left; j < right; j++) {
			if (A.get(j) <= pivot) {
				swap(A, i, j);
				i++;
			}
		}
		swap(A, i, right);
		return i;
		// is the right position of the pivot. It used to had the first greater element
		// from left side.
	}

	private final void swap(final List<Integer> A, int i, int j) {
		int save = A.get(i);
		A.set(i, A.get(j));
		A.set(j, save);
	}

}

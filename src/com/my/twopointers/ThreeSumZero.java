package com.my.twopointers;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {

	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

		Integer[] sortedA = A.toArray(new Integer[A.size()]);
		Arrays.sort(sortedA);

		System.out.println(("Sorted Set="));
		UtilityClass.print(sortedA);
		ArrayList<ArrayList<Integer>> solutionSet = new ArrayList<>();

		for (int i = 0; i < sortedA.length; i++) {
			if (i > 0 && sortedA[i] == sortedA[i - 1]) {
				continue;
			}
			for (int start = i + 1, end = sortedA.length - 1; start < end;) {
				if (start > i + 1 && sortedA[start] == sortedA[start - 1]) {
					start++;
					continue;
				}

				if (end < sortedA.length - 1 && sortedA[end] == sortedA[end + 1]) {
					end--;
					continue;
				}

				System.out.println("i=" + i + " start=" + start + " end=" + end);
				long sum = sortedA[i] + sortedA[start] + sortedA[end];
				if (sum == 0) {
					ArrayList<Integer> tempArrayList = new ArrayList<>();
					tempArrayList.add(sortedA[i]);
					tempArrayList.add(sortedA[start]);
					tempArrayList.add(sortedA[end]);
					solutionSet.add(tempArrayList);
					start++;
					end--;
				} else if (sum > 0) {
					end--;
				} else {
					start++;
				}
			}
		}

		System.out.println("solutionSet=" + solutionSet);

		return solutionSet;
	}

	public ArrayList<ArrayList<Integer>> threeSumE(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if (A.size() < 3)
			return res;
		
		Collections.sort(A);
		
		int i = 0;
		while (i < A.size()) {
			int j = i + 1, k = A.size() - 1;
			while (j < k) {
				long sum = (long) A.get(i) + (long) A.get(j) + (long) A.get(k);
				if (sum == 0) {
					ArrayList<Integer> a = new ArrayList<Integer>();
					a.add(A.get(i));
					a.add(A.get(j));
					a.add(A.get(k));
					if (!res.contains(a))
						res.add(a);
				}
				if (sum > 0)
					k--;
				else
					j++;
			}
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
		int B = 0;
		ArrayList<Integer> intListA = new ArrayList<>(a.length);
		for (int i : a) {
			intListA.add(i);
		}
		System.out.println("initlist=" + intListA);
		ThreeSumZero threeSumZero = new ThreeSumZero();
		threeSumZero.threeSum(intListA);
	}

}

package com.my.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.my.common.UtilityClass;
//import com.my.sorting.BinarySearch;

public class LongestIncreasingSubsequnce {

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public int longestIncreasingSubsequnce(int[] a, int seqLength) {
		if (seqLength == 1) {
			return 1;
		}

		int max = 1;

		/*
		 * We get the max values sequntially from 1 .... seqLength-1
		 * 
		 */

		for (int i = 1; i < seqLength; i++) {
			int subMax = longestIncreasingSubsequnce(a, i);
			if (a[i - 1] < a[seqLength - 1] && max < (subMax + 1)) {
				max = subMax + 1;
			}
		}

		return max;
	}

	public int lis(int[] A) {
		int n = A.length;

		int[] lcs = new int[n];

		// 2 3 6 4 2 3 6 7 8
		Arrays.fill(lcs, 1);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					lcs[i] = Math.max(lcs[i], lcs[j] + 1);
					max = Math.max(max, lcs[i]);
				}
			}
		}
		return max;
	}

	public int lisIterative(int[] a, int seqLength) {
		if (seqLength == 1) {
			return 1;
		}

		int[] lcsLengths = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			lcsLengths[i] = 1;
		}

		for (int i = 1; i < seqLength; i++) { // For each sequence length from 1 to seqLength-1
			for (int j = 0; j < i; j++) {
				System.out.print("Check::a[" + i + "]=" + a[i] + ", a[" + j + "]=" + a[j]);
				if (a[j] < a[i]) { // a[1],a[2],a[3] ..... a[n-1] for each check if all elements before it are less
									// than it.
					lcsLengths[i] = Math.max(lcsLengths[i], lcsLengths[j] + 1);
				}
				System.out.println();
			}
			System.out.print("LCS Array=");
			printArray(lcsLengths);
		}

		int max = lcsLengths[0];
		for (int i = 1; i < a.length; i++) {
			if (max < lcsLengths[i]) {
				max = lcsLengths[i];
			}
		}

		return max;
	}

	public int lisListIterative(int[] a, int seqLength) {
		if (seqLength == 1) {
			return 1;
		}

		List<List<Integer>> lcsLists = new ArrayList<List<Integer>>();
		int[] lcsLengths = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			List<Integer> iList = new ArrayList<Integer>();
			iList.add(a[i]);
			lcsLists.add(iList);
			lcsLengths[i] = 1;
		}

		for (int i = 1; i < seqLength; i++) { // a[1],a[2],a[3] ..... a[n-1] for each check if all elements before it
												// are less than it.
			for (int j = 0; j < i; j++) {
				System.out.print("Check::a[" + i + "]=" + a[i] + ", a[" + j + "]=" + a[j]);
				if (a[j] < a[i]) {
					if (lcsLengths[i] < (lcsLengths[j] + 1)) {
						List<Integer> jList = lcsLists.get(j);
						List<Integer> iList = lcsLists.get(i);
						iList.clear();
						iList.addAll(jList);
						iList.add(a[i]);
						lcsLengths[i] = lcsLengths[j] + 1;
						System.out.print(" New length=" + lcsLengths[i]);
					}
				}
				System.out.println();
			}
			System.out.print("LCS Array=");
			printArray(lcsLengths);
		}
		System.out.print("LCS Array=");
		printArray(lcsLengths);

		int max = lcsLengths[0];
		int maxIndex = 0;
		for (int i = 1; i < a.length; i++) {
			if (max < lcsLengths[i]) {
				max = lcsLengths[i];
				maxIndex = i;
			}
		}
		System.out.println("LCS List=" + lcsLists.get(maxIndex));
		System.out.print("LCS Array=");
		printArray(a);
		printList(lcsLists);
		return max;
	}

	public static void printList(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private int lcsNlogNAlgo(int[] a) {
		int totalSize = a.length;
		int[] listOfTailElements = new int[totalSize + 1];

		int len = 0;
		listOfTailElements[len] = a[0]; // First element is added as length=1 list
		UtilityClass.print(listOfTailElements, len + 1);
		for (int i = 1; i < totalSize; i++) {
			System.out.print("a[" + i + "]=" + a[i]);
			if (a[i] < listOfTailElements[0]) { // New element is less than the base list of length=1
				System.out.print(" First Element - listOfTailElements[0]=" + listOfTailElements[0]);
				listOfTailElements[0] = a[i];
			} else if (a[i] > listOfTailElements[len]) {
				/*
				 * New Element is greater than all elements. (We clone the last list and add the
				 * new element to that cloned list)
				 */
				len++;
				listOfTailElements[len] = a[i];
				System.out.print(" Last Element - listOfTailElements[" + len + "]=" + listOfTailElements[len]);
			} else {
				/*
				 * New Element replaces the first greater element in the list.
				 */
				System.out.print(" len=" + len);
				int newIndex = 1;// BinarySearch.equalElementOrFirstGreaterElement(listOfTailElements,0,len,a[i]);
				listOfTailElements[newIndex] = a[i];
				System.out.print(
						" Between Element - listOfTailElements[" + newIndex + "]=" + listOfTailElements[newIndex]);
			}
			System.out.println();
			UtilityClass.print(listOfTailElements, len + 1);
		}

		return len + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestIncreasingSubsequnce lis = new LongestIncreasingSubsequnce();
		int[] a = { 8, 22, 9, 33, 21, 24, 32, 34, 50, 41, 60, 80, 56, 58, 64, 62, 67, 55, 68, 70, 74, 43, 79, };
//		int[] a = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
//		int val = lis.longestIncreasingSubsequnce(a, a.length);
		/*
		 * int val = lis.lisIterative(a, a.length);
		 * System.out.println("Longest ICS Length="+val);
		 */

		/*
		 * int val = lis.lisListIterative(a, a.length);
		 * System.out.println("Longest ICS Length="+val);
		 */

		UtilityClass.print(a);
		System.out.println();
		int val2 = lis.lcsNlogNAlgo(a);
		System.out.println("Longest ICS Length NlogN=" + val2);

	}

}

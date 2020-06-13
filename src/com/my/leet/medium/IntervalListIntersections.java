package com.my.leet.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<List<Integer>> intersection = new ArrayList<>();

		int m = A.length;
		int n = B.length;

		for (int i = 0, j = 0; i < m && j < n;) {
			if (A[i][1] < B[j][0]) {
				i++;
				continue;
			}

			if (B[j][1] < A[i][0]) {
				j++;
				continue;
			}

			List<Integer> newList = new ArrayList<>();
			newList.add(Math.max(A[i][0], B[j][0]));

			if (A[i][1] <= B[j][1]) {
				newList.add(A[i++][1]);
			} else {
				newList.add(B[j++][1]);
			}
			intersection.add(newList);
		}

		int[][] result = new int[intersection.size()][2];
		int k = 0;
		for (List<Integer> list : intersection) {
			result[k][0] = list.get(0);
			result[k][1] = list.get(1);
			k++;
		}

		return result;
	}

}

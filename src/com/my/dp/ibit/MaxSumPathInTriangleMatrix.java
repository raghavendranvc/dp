package com.my.dp.ibit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumPathInTriangleMatrix {

	int maxPathSum(int tri[][], int m, int n) {

		// https://www.geeksforgeeks.org/maximum-path-sum-triangle/

		/**
		 * We will do bottom up. For i,j , we need to check i+1,j & i+1,j+1 below and
		 * below-right
		 */

		for (int i = m - 2; i >= 0; i--) { // m-2 because, we leave the leaf nodes/end row
			for (int j = 0; j <= i; j++) { // matrix is a triangle. So j will be <= i
				tri[i][j] += Math.max(tri[i + 1][j], tri[i + 1][j + 1]);

			}
		}

		return tri[0][0];
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int n = triangle.size();
		List<Integer> sumList = new ArrayList<>();

		sumList.add(triangle.get(0).get(0));

		for (int i = 1; i < triangle.size(); i++) {

			List<Integer> newList = new ArrayList<>();
			newList.add(triangle.get(i).get(0) + sumList.get(0));

			for (int j = 1; j < triangle.get(i).size(); j++) {
				int currentNum = triangle.get(i).get(j);
				int min = sumList.get(j - 1);
				if (j < sumList.size()) {
					min = Math.min(min, sumList.get(j));
				}
				newList.add(currentNum + min);
			}
			sumList = newList;
		}

		return Collections.min(sumList);
	}

}

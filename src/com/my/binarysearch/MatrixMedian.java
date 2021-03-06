package com.my.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedian {

	// TODO - Didn't do, copied GIVEN UP After a while

	public int findMedian2(ArrayList<ArrayList<Integer>> A) {

		int rowCount = A.size();
		int columnCount = A.get(0).size();
		int total = rowCount * columnCount;

		int min = A.get(0).get(0);
		int max = A.get(0).get(columnCount - 1);
		for (int i = 1; i < rowCount; i++) {
			min = Math.min(min, A.get(i).get(0));// Min is present in the first column
			max = Math.max(max, A.get(i).get(columnCount - 1));// max is present in the last column
		}

		/*
		 * Since rows are sorted Min is the minimum of all first elements in each row
		 * Max is the maximum of all last elements in each row
		 * 
		 * 
		 */

		while (min <= max) {
			int mid = min + (max - min) / 2; // mid is the number between min and max
			int smallCount = getSmallerCountInMatrix(A, mid);
			if (smallCount > total / 2) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return max;
	}

	public int getSmallerCountInMatrix(ArrayList<ArrayList<Integer>> A, int number) {
		int total = 0;
		for (int i = 0; i < A.size(); i++) {
			total = total + getSmallerCountInRow(A.get(i), number);
		}
		return total;
	}

	public int getSmallerCountInRow(ArrayList<Integer> row, int number) {

		int left = 0;
		int right = row.size() - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (number <= row.get(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
		// left will have moved over right. So the order will be 0,...right,left,...n
		// So left will the number of elements greater than mid and "left-1" index
		// is the place where the last smaller element will be presnt
		// at "left" index, we have the first greater value.

	}

}

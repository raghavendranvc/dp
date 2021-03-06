package com.my.binarysearch;

public class MinElementInRotatedSortedArray {

	int findMinCopied(int arr[], int l, int h) // with duplicates
	{
		while (l < h) {
			int m = (l + h) / 2;
			if (arr[m] == arr[h]) // Since duplicates are allowed. So we reduce h by 1
				h--;

			else if (arr[m] > arr[h]) // arr[m] < arr[l]
				// Right part of array is not sorted. So minimum is in the Right side
				// So check in the right side
				l = m + 1;
			else
				// Right part of array is sorted. So minimum is at-most 'm'.
				// So check only left side include 'm'
				h = m;
		}
		return arr[h]; // h shall contain the min element as we exit when l >= h
	}

	public int findMin(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		while (i <= j) {

			// handle cases like [3, 1, 3]
			while (nums[i] == nums[j] && i != j) {
				i++;
			}

			if (nums[i] <= nums[j]) {
				return nums[i];
			}

			int m = (i + j) / 2;
			if (nums[m] >= nums[i]) {
				i = m + 1;
			} else {
				j = m;
			}
		}

		return -1;
	}

	// Non-duplicates
	public int findMin1(int[] num) {
		return findMin1(num, 0, num.length - 1);
	}

	public int findMin1(int[] num, int left, int right) {
		if (right == left) {
			return num[left];
		}
		if (right == left + 1) {
			return Math.min(num[left], num[right]);
		}
		// 3 3 1 3 3 3

		// already sorted
		if (num[right] > num[left]) {
			return num[left];
		}

		int middle = (right - left) / 2 + left;

		// We now sure that array is rotated

		// right shift one
		if (num[right] == num[left]) {
			return findMin1(num, left + 1, right); // go right

		} else if (num[middle] >= num[left]) {
			// meaning left is sorted. So min is in the other half
			// arrays is rotated as first condition is ruled out sorted manner.
			// So this works for non-duplicates

			return findMin1(num, middle, right);
			// go left
		} else {
			return findMin1(num, left, middle);
		}
	}

}

package com.my.leet.medium;

public class SortTransformedArray {

	// https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleMedium/360.html
	// http://shibaili.blogspot.com/2018/09/360-sort-transformed-array.html
	
	// The idea is to evaluate first and last and then move accordingly
	

	/*
	 * Given a sorted array of integers nums and integer values a, b and c. Apply a
	 * function of the form f(x) = ax2 + bx + c to each element x in the array. The
	 * returned array must be in sorted order. Expected time complexity: O(n)
	 * Example: nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
	 * 
	 * Result: [3, 9, 15, 33]
	 * 
	 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5 Result: [-23, -5, 1, 7]
	 */

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if (nums == null || nums.length == 0)
			return nums;
		if (nums.length == 1) {
			nums[0] = eval(nums[0], a, b, c);
			return nums;
		}

		int l = 0;
		int r = nums.length - 1;
		int[] res = new int[nums.length];
		int k = 0;
		while (l <= r) { // need to equal to get the final number.
			int v1 = eval(nums[l], a, b, c);
			int v2 = eval(nums[r], a, b, c);

			if (a > 0) { //value of a is very critical. 
				//If it is positive and negative, we need to traverse accordingly
				res[k++] = v1 > v2 ? v1 : v2;
				if (v1 > v2)
					l++;
				else
					r--;
			} else {
				res[k++] = v1 > v2 ? v2 : v1;
				if (v1 > v2)
					r--;
				else
					l++;
			}
		}

		if (a > 0) {
			// We are reversing the array to get the sorted array.
			// As of now, the array is reverse sorted
			int left = 0;
			int right = res.length - 1;
			while (left < right) {
				swap(res,left, right);
				left++;
				right--;
			}
		}

		return res;
	}
	
	private void swap(int[] res, int left, int right) {
		int tmp = res[left];
		res[left] = res[right];
		res[right] = tmp;
	}

	private int eval(int n, int a, int b, int c) {
		return a * n * n + b * n + c;
	}
}

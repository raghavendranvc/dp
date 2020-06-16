package com.my.stacksqueues;

import java.util.List;

public class RainWaterTrapped {

	// TODO Practice this again. We can also do in a different way

	public int trapSimple(final List<Integer> A) {
		int left = 0;
		int right = A.size() - 1;

		int max = 0;
		int leftmax = 0;
		int rightmax = 0;

		while (left <= right) {
			leftmax = Math.max(leftmax, A.get(left));
			rightmax = Math.max(rightmax, A.get(right));

			if (leftmax < rightmax) {
				max += (leftmax - A.get(left));
				// leftmax is smaller than rightmax,
				// so the (leftmax-A[a]) water can be stored
				left++;
			} else {
				max += (rightmax - A.get(right));
				right--;
			}
		}
		return max;

	}

	public int trapE(final List<Integer> A) {
		int len = A.size();
		if (len < 3) {
			return 0;
		}
		int sum = 0, i = 1, j = len - 1;
		int lmax = A.get(0), rmax = A.get(len - 1);
		while (i <= j) {
			lmax = Math.max(lmax, A.get(i));
			rmax = Math.max(rmax, A.get(j));
			if (lmax <= rmax) {
				sum += (lmax - A.get(i));
				i += 1;
			} else {
				sum += (rmax - A.get(j));
				j -= 1;
			}
		}
		return sum;
	}

	public int trap(final List<Integer> A) {

		int n = A.size();
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = A.get(0);
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], A.get(i));
		}

		rightMax[n - 1] = A.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
		}

		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			result = result + Math.min(rightMax[i], leftMax[i]) - A.get(i);
		}

		return result;

	}

}

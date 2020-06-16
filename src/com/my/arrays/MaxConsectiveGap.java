package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.*;

public class MaxConsectiveGap {

	// http://buttercola.blogspot.com/2015/08/leetcode-maximum-gap.html
	// https://www.programcreek.com/2014/03/leetcode-maximum-gap-java/

	// Size = 9
	// 10 20 24 5 8 34 19 22 16
	// 5 8 10 16 19 20 22 24 34

	// TODO Not done. Need to be revised. GIVEN UP AFTER A WHILE

	/*
	 * In the sorted form, it is 1 3 4 7, and the maximum gap is between 4 and 7,
	 * which is 3.
	 * 
	 * Since the problem asks for O(n) time and space solution, we need to think of
	 * using a bucket sorting.
	 * 
	 * -- Step 1: Calculate the ave. interval. We calculate the min and max of the
	 * array A[], and the maximum gap should be in the upper bound of (max - min) /
	 * (N - 1). For example, for the example shown above, if the number is uniformly
	 * distributed, the gap is (7 - 1) / 3 = 2, i.e, the array should be 1 3 5 7.
	 * Since now the number may not be uniformly distributed, the maximum gap might
	 * be greater than 2.
	 * 
	 * -- Step 2: Determine the number of buckets, which should be (max - min) /
	 * interval + 1. The number of buckets should be equal to the range of numbers /
	 * range per bucket.
	 * 
	 * -- Step 3: Determine which number is in which bucket, which equals to (A[i] -
	 * min) / interval. e.g. (7 - 1) / 2 = 3, in bucket[3].
	 * 
	 * -- Step 4: We only need to maintain the min and max value for each bucket.
	 * The maximum gap must between two adj. buckets instead of within a bucket.
	 * That is because the maximum gap inside of a bucket is interval - 1. However,
	 * in the step 1 we have already known that the the maximal gap must be greater
	 * than interval. -- Step 5. After we calculated the min and max value in each
	 * bucket, we then iterate through the buckets and get the maximal gap between
	 * buckets. Be very careful that buckets might be empty.
	 */

	public int maximumGap(final List<Integer> A) {

		if (A.size() <= 2) {
			return 0;
		}

		int maxElement = Integer.MIN_VALUE;
		int minElement = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			maxElement = Math.max(maxElement, A.get(i));
			minElement = Math.min(minElement, A.get(i));
		}

		int difference = maxElement - minElement; // 29
		int bucketSize = difference / (A.size()); // (29+8)/9 = 4 or 29/3=4

		int[] verification = new int[bucketSize * 2];
		// bucket stores min and max of the bucket
		System.out.println("bucketSize=" + bucketSize + " difference=" + difference);

		for (int i = 0; i < A.size(); i++) {

			int element = A.get(i);
			int bucket = element / bucketSize;
			System.out.println("i=" + i + " element=" + element + " bucket=" + bucket);
			if (verification[2 * bucket] == 0 || element < verification[2 * bucket + 1]) {
				verification[2 * bucket] = element;//min of bucket
			}

			if (verification[2 * bucket] == 0 || element > verification[2 * bucket + 1]) {
				verification[2 * bucket + 1] = element;//max of bucket
			}

		}

		int maxGap = 0;
		for (int i = 0; i < verification.length - 1; i++) {
			maxGap = Math.max(maxGap, (verification[i + 1] - verification[i]));
		}

		return maxGap;
//        for(int i=0;i<verification.length;i++)

	}

	/*
	 * We can use a bucket-sort like algorithm to solve this problem in time of O(n)
	 * and space O(n). The basic idea is to project each element of the array to an
	 * array of buckets. Each bucket tracks the maximum and minimum elements.
	 * Finally, scanning the bucket list, we can get the maximum gap.
	 */

	public int maxSortedAdjacentDiff(int[] arr, int n) {
		// Find maximum and minimum in arr[]
		int maxVal = arr[0];
		int minVal = arr[0];
		for (int i = 1; i < n; i++) {
			maxVal = Math.max(maxVal, arr[i]);
			minVal = Math.min(minVal, arr[i]);
		}

		// Arrays to store maximum and minimum values
		// in n-1 buckets of differences.
		int maxBucket[] = new int[n - 1];
		int minBucket[] = new int[n - 1];
		Arrays.fill(maxBucket, 0, n - 1, Integer.MIN_VALUE);
		Arrays.fill(minBucket, 0, n - 1, Integer.MAX_VALUE);

		// Expected gap for every bucket.
		float delta = (float) (maxVal - minVal) / (float) (n - 1);

		// Traversing through array elements and
		// filling in appropriate bucket if bucket
		// is empty. Else updating bucket values.
		for (int i = 0; i < n; i++) {
			if (arr[i] == maxVal || arr[i] == minVal) {
				continue;
			}

			// Finding index of bucket.
			int index = (int) (Math.round((arr[i] - minVal) / delta));

			// Filling/Updating maximum value of bucket
			if (maxBucket[index] == Integer.MIN_VALUE) {
				maxBucket[index] = arr[i];
			} else {
				maxBucket[index] = Math.max(maxBucket[index], arr[i]);
			}

			// Filling/Updating minimum value of bucket
			if (minBucket[index] == Integer.MAX_VALUE) {
				minBucket[index] = arr[i];
			} else {
				minBucket[index] = Math.min(minBucket[index], arr[i]);
			}
		}

		// Finding maximum difference between maximum value
		// of previous bucket minus minimum of current bucket.
		int prev_val = minVal;
		int max_gap = 0;
		for (int i = 0; i < n - 1; i++) {
			if (minBucket[i] == Integer.MAX_VALUE) {
				continue;
			}
			max_gap = Math.max(max_gap, minBucket[i] - prev_val);
			prev_val = maxBucket[i];
		}
		max_gap = Math.max(max_gap, maxVal - prev_val);

		return max_gap;
	}

	public static void main(String[] args) {
		// int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683,
		// 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653,
		// 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406,
		// 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557,
		// 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160,
		// 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742 };
		// int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319,
		// 412};
		int[] a = new int[] { 1, 10, 5 };
		UtilityClass.print(a);

		ArrayList<Integer> intList = new ArrayList<>(a.length);
		for (int i : a) {
			intList.add(i);
		}
		MaxConsectiveGap maxConsectiveGap = new MaxConsectiveGap();

		System.out.println("Max Distance=" + maxConsectiveGap.maximumGap(intList));
	}
}

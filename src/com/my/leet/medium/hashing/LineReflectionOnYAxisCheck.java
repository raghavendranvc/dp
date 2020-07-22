package com.my.leet.medium.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LineReflectionOnYAxisCheck {

	// https://www.programcreek.com/2014/08/leetcode-line-reflection-java/
	//

	/*
	 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
	 * that reflect the given points.
	 * 
	 * Example 1:
	 * 
	 * Input: [[1,1],[-1,1]] Output: true Example 2:
	 * 
	 * Input: [[1,1],[-1,-1]] Output: false Follow up:
	 * 
	 * Could you do better than O(n2) ?
	 */

	/*
	 * For this problem, we first find the smallest and largest x-value for all
	 * points and get the line's x-axis is (minX + maxX) / 2, then for each point,
	 * check if each point has a reflection points in the set.
	 *
	 * Like 2Sum, we put all points into a set, and find the corresponding point for
	 * each point in the set. The x value for a point and its corresponding point
	 * sums to a fixed value, which can be obtained by summing the min and max of x
	 * value.
	 */

	public boolean isReflected(int[][] points) {
		if (points == null || points.length < 2)
			return true;

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// All reflections points have the same sum which is min+max

		for (int[] arr : points) {
			min = Math.min(min, arr[0]);
			max = Math.max(max, arr[0]);

			HashSet<Integer> set = map.get(arr[0]);
			if (set == null) {
				set = new HashSet<Integer>();
				map.put(arr[0], set);
			}

			set.add(arr[1]);

		}

		int y = min + max; //This is the reflect y-axis line

		for (int[] arr : points) {
			int left = arr[0];
			int right = y - left;
			if (map.get(right) == null || !map.get(right).contains(arr[1])) {
				return false;
			}
		}

		return true;
	}

}

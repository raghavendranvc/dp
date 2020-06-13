package com.my.leet.medium;

public class MinimumMovesToEqualArray {

	/*
	 * Given a non-empty integer array of size n, find the minimum number of moves
	 * required to make all array elements equal, where a move is incrementing n -1
	 * elements by 1.
	 */

	/*
	 * An array which has n elements. Each move will increase n - 1 elements by 1.
	 * 
	 * This also means that each move will decrease 1 element by 1. Therefore, we
	 * only need to know how many moves of each element to be decreased by 1 will
	 * equal the min number and sum them up. Do some math and the ans will be
	 * sum-min * length
	 */

	int minMoves(int[] nums) {
		int sum = 0;
		int minNum = 2147483647;

		// > calculate the sum and find the min value
		for (int n : nums) {
			sum += n;
			if (n < minNum) {
				minNum = n;
			}
		}

		return (sum - minNum * nums.length);
	}

	public int MinMoves(int[] nums) {
		int sum = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; sum += nums[i++]) {
			min = (nums[i] < min) ? nums[i] : min;
		}
		return sum - nums.length * min;
	}

}

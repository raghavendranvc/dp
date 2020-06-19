package com.my.leet.medium;

public class FindDuplicateInArray {

	/*
	 * The following shows how fast and slow pointers solution works. It basically
	 * contains 2 steps: 1) find the meeting point 2) start from the beginning and
	 * the meeting point respectively and find the intersection point.
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];//Remember
		} while (slow != fast);

		int find = 0;

		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}

	/*
	 * If we can assume there is only one duplicate number, it can be easily solved
	 * by using the sum of the array.
	 */
	public int findDuplicateOnlyOne(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		int n = nums.length;
		return sum - ((n - 1) * n) / 2;
	}
}

package com.my.leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {

	/*
	 * Suppose you have a random list of people standing in a queue. Each person is
	 * described by a pair of integers (h, k), where h is the height of the person
	 * and k is the number of people in front of this person who have a height
	 * greater than or equal to h. Write an algorithm to reconstruct the queue.
	 * Note: The number of people is less than 1,100.
	 */

	public int[][] reconstructQueue2(int[][] people) {
		int[][] result = new int[people.length][];
		// if a - b = -1, a is smaller than b. Increasing order
		// if b - a = -1, b is smaller than a, Decreasing order
		// if b - a = 1, b is greater than a, Decreasing order

		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return b[0] - a[0]; // Comparing heights. Max height person at front of array
				} else {//If heights are same, the person with higher k should come later
					return a[1] - b[1]; // Comparing how many people are there before
										//increasing order
				}
			}
		});

		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], people[i]);
			// At place/index people[i][1], we place the guy as he sees only that many
			// people before him

			// By making sure that we replace the existing one with smaller one,
			// we make sure that the number of people they see remain the same as the higher
			// height people behind the newly inserted guy will not see this guys as this
			// guys' height is less than them
		}

		for (int i = 0; i < people.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}

}

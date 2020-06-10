package com.my.arrays;

import java.util.ArrayList;

public class FindPermDOrI {

	// 1 2 3 4 5 6 7 8 9

	// D D D D D I D I I
	// 5 4 3 2 1 6 7 8 9
	// D 5 4 3 2 1 7 6 8 9

	// 0 1 2 3 4 5 6 7 8
	// D D D I I D D D I
	// 3 2 1 4 5 6 7 8 9
	// 3 2 1 4 5 8 7 6 9
	// 3 2 1 4
	// 3 2 1 4 8 7 6 5 9

	// at 3 (-1, 2)
	// at 4 (3, 3)
	// at 6 (4, 7)
	// at last (8, -)

	// I I I I I D D D D
	// 1 2 3 4 5 6 7 8 9
	// 1 2 3 4 5

	public ArrayList<Integer> findPermCopied(final String A, int B) {

		int smallest = 1;
		int largest = B;
		ArrayList<Integer> op = new ArrayList<Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'D') {
				op.add(largest);
				largest = largest - 1;
			} else {
				op.add(smallest);
				smallest = smallest + 1;
			}
		}

		op.add(smallest);
		return op;
	}

	public ArrayList<Integer> findPerm(final String A, int B) {

		ArrayList<Integer> trackingList = new ArrayList<>(B);

		for (int i = 0; i < B; i++) {
			trackingList.add(i + 1);
		}

		System.out.println("Init=" + trackingList);

		ArrayList<Integer> returnList = new ArrayList<>(B);

		int increasingTracker = 0;
		int decreasingTracker = trackingList.size() - 1;

		for (int i = 0; i < A.length(); i++) {
			if ('I' == A.charAt(i)) {
				returnList.add(trackingList.get(increasingTracker++));
			} else if ('D' == A.charAt(i)) {
				returnList.add(trackingList.get(decreasingTracker--));
			}
		}

		System.out.println("first=" + returnList);

		System.out.println("increasingTracker=" + increasingTracker + " decreasingTracker=" + decreasingTracker);

		for (int i = increasingTracker; i <= decreasingTracker; i++) {
			returnList.add(trackingList.get(i));
		}

		return returnList;
	}

}

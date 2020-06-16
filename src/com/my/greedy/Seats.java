package com.my.greedy;

public class Seats {

	/*
	 * 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 . . . . x . . x x . . . x . .
	 * 
	 * Total = 4
	 * 
	 * count=0 0 0 0 0 1 - - 2 3 - - - 4 0 0 (count again from left) 4 4 4 4 3 3 3 2
	 * 1 1 1 1 0 (Total--) 1 1 1 1 1 T (moves = min(totalRemaining,leftCount))
	 * 
	 * 
	 */

	// TODO practice this again and remember this approach

	private static final char OCCUPIED = 'x';
	private static final long MODULO = 10000003;

	public int seats(String A) {

		int numberOfOccupied = 0;

		for (char c : A.toCharArray()) {
			if (c == OCCUPIED) {
				numberOfOccupied++;
			}
		}

		int rightMoves = numberOfOccupied;
		long movesNeeded = 0;
		int leftMoves = 0;

		for (char c : A.toCharArray()) {
			if (numberOfOccupied == 0) {
				break;
			} else if (c == OCCUPIED) {
				/*
				 * When leftMoves == numberOfOccupied then, it is the median, and this is the
				 * right place all lefts and rights moves towards this position.
				 */
				leftMoves++;
				rightMoves--; //
			} else {
				movesNeeded += Math.min(leftMoves, rightMoves);
				// min means either people on left or people on right move towards median.
				// whichever side is min, they move one position towards median
				// initially leftMoves = 1 (rightMoves=8), then that guys moves to this vacant
				// position
				// when leftMoves = 2 (rightMoves=7), then the left 2 guys moves one position
				// each towards center/median

				// when leftMoves = 5 (rightMoves=4), then the right 4 guys moves one position
				// each towards center/median
			}
		}
		return (int) (movesNeeded % MODULO);
	}
}

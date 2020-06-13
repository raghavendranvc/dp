package com.my.leet.medium;

public class EliminationProblem {

	/*
	 * Every run, it reduces the search space by half. We keep track of the first
	 * and last number. If odd number of numbers are eliminated, we adjust both
	 * first and last number; otherwise, only the “first” number in each direction
	 * is adjusted. We loop until first and last number are the same.
	 */

	/*
	 * example: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 Let
	 * us start with head = 1, left = true, step = 1 (times 2 each turn), remaining
	 * = n(24)
	 * 
	 * we first move from left, we definitely need to move head to next position.
	 * (head = head + step)
	 * 
	 * So after first loop we will have:
	 * 
	 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 - > 2 4 6 8 10
	 * 12 14 16 18 20 22 24 head = 2, left = false, step = 1 * 2 = 2, remaining =
	 * remaining / 2 = 12
	 * 
	 * second loop, we move from right, in what situation we need to move head? only
	 * if the remaining % 2 == 1, in this case we have 12 % 2 == 0, we don't touch
	 * head.
	 * 
	 * so after this second loop we will have:F
	 * 
	 * 2 4 6 8 10 12 14 16 18 20 22 24 - > 2 6 10 14 18 22 head = 2, left = true,
	 * step = 2 * 2 = 4, remaining = remaining / 2 = 6
	 * 
	 * third loop, we move from left, move head to next position
	 * 
	 * after third loop we will have:
	 * 
	 * 2 6 10 14 18 22 - > 6 14 22 head = 6, left = false, step = 4 * 2 = 8,
	 * remaining = remaining / 2 = 3
	 * 
	 * fourth loop, we move from right, NOTICE HERE: we have remaining(3) % 2 == 1,
	 * so we know we need to move head to next position
	 * 
	 * after this loop, we will have
	 * 
	 * 6 14 22 - > 14 head = 14, left = true, step = 8 * 2 = 16, remaining =
	 * remaining / 2 = 1 while loop end, return head
	 */

	// https://leetcode.com/problems/elimination-game/
	// https://massivealgorithms.blogspot.com/2016/08/leetcode-elimination-game.html
	// https://baihuqian.github.io/2018-09-03-elimination-game/

	public int lastRemaining(int n) {
		if (n == 1)
			return 1;

		int first = 1, last = n;

		int count = n;

		for (int step = 1, digit = 1; first != last; step <<= 1, digit++) {
			if (digit % 2 == 1) {
				first += step;
				if (count % 2 == 1)
					last -= step;
			} else {
				last -= step;
				if (count % 2 == 1)
					first += step;
			}
			count /= 2;
		}
		return first;
	}

}

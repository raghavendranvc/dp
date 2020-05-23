package com.my.dp.ibit;

import java.util.ArrayList;
import java.util.Collections;

import com.my.common.UtilityClass;

public class BirthdayKicks {

	
	public static void main(String[] args) {
		int A = 26;
		int[] b = { 8, 8, 6, 5, 4 };
		ArrayList<Integer> B = UtilityClass.getList(b);

		BirthdayKicks birthdayKicks = new BirthdayKicks();
		ArrayList<Integer> result = birthdayKicks.solve(A, b);
		System.out.println("Result=" + result);
	}

	/*
	 * TODO
	 * Rework on this again. It is more greedy and tricky
	 */

	public ArrayList<Integer> solve(int A, int[] B) {
		int n = B.length;
		ArrayList<Integer> bumpArray = new ArrayList<Integer>();

		if (A == 0) {
			return bumpArray;
		}
		/*
		 * If a guy wants to give only one bump, then let's everyone give one so that
		 * length is maximum.
		 * 
		 * Similar is the case when with min values of all the friends. Now we know that
		 * even if Birthday boy can take more than
		 * 
		 * numberofFrinds*min , we have covered everyone and is the maximum length of
		 * array possible.
		 * 
		 */
		int min = 3;// Arrays.min(B);

		/*
		 * IF let's say everyone gives something and the remainder is still available
		 * 
		 * of if i persons's kick , then we are left with few more kicks, then we
		 * distribute the available to all so that everyone gets something.
		 * 
		 * 
		 * 
		 */

		int available = A % min;
		int howManyMaxFriendsCanBeatWithMaxOfMinBeats = A / min;

		int i = 0;
		while (howManyMaxFriendsCanBeatWithMaxOfMinBeats > bumpArray.size()) {
			// Anone greate than min for now is skipped
			if (B[i] - min > available) {
				i++;
			} else {
				available -= (B[i] - min); // He gives all his bumps
				bumpArray.add(i); // so we add him to the list
			}
		}

		return bumpArray;
	}

}

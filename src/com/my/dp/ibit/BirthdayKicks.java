package com.my.dp.ibit;

import java.util.ArrayList;
import java.util.Collections;

import com.my.common.UtilityClass;

public class BirthdayKicks {

	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		solveRecur(A, B, 0, result);
		Collections.reverse(result);
		return result;
	}

	public boolean solveRecur(int A, ArrayList<Integer> B, int currentIndex, ArrayList<Integer> result) {
		if (A == 0) {
			return true;
		}

		if (currentIndex == B.size()) {
			return false;
		}

		if (A < 0) {
			return false;
		}

		for (int i = currentIndex; i < B.size(); i++) {
			int repeats = A / B.get(i);

			for (int j = repeats; j >= 0; j--) {
				System.out.println("currentInde=" + i + " repeats=" + j + " Sum=" + A);
				if (solveRecur(A - j * B.get(i), B, currentIndex + 1, result)) {
					System.out.println("Completed");
					populateResultArray(result, i, j);
					return true;
				}
			}
		}

		return false;

	}

	private void populateResultArray(ArrayList<Integer> result, int index, int repeats) {
		for (int i = 0; i < repeats; i++) {
			result.add(index);
		}
	}

	public static void main(String[] args) {
		int A = 12;
		int[] b = { 8, 8, 6, 5, 4 };
		ArrayList<Integer> B = UtilityClass.getList(b);

		BirthdayKicks birthdayKicks = new BirthdayKicks();
		ArrayList<Integer> result = birthdayKicks.solve(A, B);
		System.out.println("Result=" + result);
	}

	/**
	 * Follow this approach
	 * 
	 * @param A
	 * @param B
	 * @return
	 */

	public ArrayList<Integer> solveCopied(int A, ArrayList<Integer> B) {

		ArrayList<Integer> resp = new ArrayList<>();
		int min = Collections.min(B);
		
		//We make sure that 
		int available = A % min; 

		int i = 0;
		while (resp.size() < A / min) {
			// B.get(i) <= available + min
			if (B.get(i) - min <= available) {
				available -= (B.get(i) - min);
				resp.add(i);
			} else {
				i++;
			}
		}
		return resp;
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

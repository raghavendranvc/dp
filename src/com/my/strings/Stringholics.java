package com.my.strings;

import java.util.ArrayList;

public class Stringholics {

	// KMP Algoirthm
	// https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
	/*
	 * Searches for occurrences of a "word" W within a main "text string" S by
	 * employing the observation that when a mismatch occurs, the word itself
	 * embodies sufficient information to determine where the next match could
	 * begin, thus bypassing re-examination of previously matched characters.
	 * 
	 */

	public int solve(ArrayList<String> A) {

		ArrayList<String> originalStrings = (ArrayList<String>) A.clone();

		int maxRotatedStrong = Integer.MIN_VALUE;

		long rotate = 1;
		while (maxRotatedStrong < originalStrings.size()) {
			System.out.println("****rotate=" + rotate);
			int countSameStrings = 0;

			for (int i = 0; i < originalStrings.size(); i++) {
				String rotatedString = rotateString(A.get(i), rotate);
				System.out.println("String[" + i + "]=" + A.get(i) + " rotatedString " + rotatedString + " after "
						+ rotate + " rotations");
				if (rotatedString.equals(originalStrings.get(i))) {
					countSameStrings++;
					maxRotatedStrong = Math.max(maxRotatedStrong, countSameStrings);
					System.out
							.println("countSameStrings=" + countSameStrings + " maxRotatedStrong=" + maxRotatedStrong);
				}
				A.set(i, rotatedString);
			}
			rotate++;
			if (maxRotatedStrong == originalStrings.size()) {
				rotate = rotate % 1000000007;
				return (int) rotate;
			}
		}

		return Integer.MAX_VALUE;

	}

	public String rotateString(String str, long rotations) {

		long i = rotations % str.length();
		if (i == 0) {
			return str;
		} else {
			return str.substring((int) i) + str.substring(0, (int) i);
		}
	}

	public static void main(String[] args) {
		String[] strings = new String[] { "a", "ababa", "aba" };

		ArrayList<String> examples = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			examples.add(strings[i]);
		}
		System.out.println("given=" + examples);
		Stringholics stringholics = new Stringholics();
		System.out.println("Min Rotations=" + stringholics.solve(examples));

	}

}

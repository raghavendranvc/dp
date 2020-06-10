package com.my.math;

import com.my.common.UtilityClass;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedPermutationRank {

	// TODO recheck this whole thing again

	public static int findRankRepeats(String perm) {
		BigInteger rank = BigInteger.ONE;
		BigInteger suffixPermCount = BigInteger.ONE;

		Map<Character, Integer> charCounts = new HashMap<>();

		for (int i = perm.length() - 1; i > -1; i--) {
			char x = perm.charAt(i);
			int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
			charCounts.put(x, xCount);
			for (Map.Entry<Character, Integer> e : charCounts.entrySet()) {
				if (e.getKey() < x) {
					rank = rank.add((suffixPermCount.multiply(BigInteger.valueOf(e.getValue())))
							.divide(BigInteger.valueOf(xCount)));
				}
			}
			suffixPermCount = suffixPermCount.multiply(BigInteger.valueOf(perm.length() - i))
					.divide(BigInteger.valueOf(xCount));
		}

		return rank.remainder(BigInteger.valueOf(1000003)).intValue();
	}

	final int m = 1000003;

	public int[] getFactorialArray(int n) {

		final int[] array = new int[n + 1];
		array[0] = array[1] = 1;
		for (int i = 2; i <= n; i++) {
			array[i] = i * array[i - 1];
			array[i] %= m; // This is for overflow (not a logic)
		}
		return array;
	}

	// Repeats are allowed
	//TODO 
	public int findRankNonDistinctCopied(String s) {
		final int n = s.length();
		int[] f = getFactorialArray(n); // Get all factorials till n

		int rank = 0;

		final SortedSet<Character> set = new TreeSet<>();

		for (int i = n - 1; i >= 0; i--) { // We have to do it in the reverse
			final char c = s.charAt(i);
			final int less = set.headSet(c).size(); 
			// get the number of characters <=c so far. 
			// Since the array is in sorted form, 
			// it will return all elements from head to this value exclusive

			rank += less * f[n - 1 - i];
			rank %= m; //(ignore this, This is only to limit overflow)

			set.add(c); // add char to the set so that further/earlier chars can take it into
						// consideration
		}

		return rank + 1; //because ranking starts from 1
	}

	public int findRankNonDuplicate(String A) {

		int[] smallerCharsCountsAfterCurrentChar = new int[A.length()];
		for (int i = 0; i < A.length(); i++) {

			for (int j = i + 1; j < A.length(); j++) {
				if (A.charAt(i) > A.charAt(j)) {
					smallerCharsCountsAfterCurrentChar[i]++;
				}
			}
		}
		int[] memory = new int[A.length() + 1];

		Long rank = 0L;
		for (int i = 0; i < A.length(); i++) {
			if (smallerCharsCountsAfterCurrentChar[i] == 0) {
				continue;
			} 

			int fact = factorial(A.length() - 1 - i, memory); // Size of the rest of the substring. Get that factorial
			rank += 1L * smallerCharsCountsAfterCurrentChar[i] * fact;
			rank %= m;
		}
		return rank.intValue() + 1;
	}

	public int factorial(int n, int[] memory) {
		if (memory[n] != 0) {
			return memory[n] %= m;
		}

		if (n == 0 || n == 1) {
			memory[n] = 1;
		} else {
			memory[n] = n * factorial(n - 1, memory);
		}

		return memory[n] %= m;
	}

	public int findRank(String A) {

		int[] smallerCharsCounts = new int[A.length()];
		int[] duplicates = new int[A.length()];
		for (int i = 0; i < A.length(); i++) {

			for (int j = i + 1; j < A.length(); j++) {
				if (A.charAt(i) > A.charAt(j)) {
					smallerCharsCounts[i]++;
				} else if (A.charAt(i) == A.charAt(j)) {
					duplicates[i]++;
				}
			}
		}
		UtilityClass.print(smallerCharsCounts);
		UtilityClass.print(duplicates);

		int[] memory = new int[A.length() + 1];

		Long rank = 0L;
		for (int i = 0; i < A.length(); i++) {
			if (smallerCharsCounts[i] == 0) {
				continue;
			}

			int fact = factorial(A.length() - 1 - i, memory); // Size of the rest of the substring. Get that factorial
			long value = 1L * smallerCharsCounts[i] * fact;
			rank += value;

		}
		return rank.intValue() + 1;
	}

	public static void main(String[] args) {
		String str = "baa";
		// String str = "gtrins";
		// String str = "DTNGJPURFHYEW";
		System.out.println(str);
		SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();
		System.out.println("rank=" + sortedPermutationRank.findRankNonDistinctCopied(str));

	}

	/**
	 * Practice
	 * 
	 * b		b		b		b		a		a		a		a
	 * 
	 * 1 		1		1		1		0		0		0		0
	 * 7		6		5		4		3		2		1		0
	 * 
	 * 1*7!		1*6!	1*5!	1*4!   0*3!		0*2!	0*1!	0*0! (ValueWhenDistinct)
	 * 4!*4!	3!4!	2!4!	1!4!	4!		3!		2!		1!   (Repeats divisor)
	 * 
	 * Overall = ValueWhenDistinct/RepeatsDevisor
	 */
	
	// We need to remove the repeatitions

	final int m2 = 1000003;

	public int findRankpp(String A) {

		int n = A.length();
		int fact[] = getFactorialArray1(n - 1);
		SortedSet<Character> chars = new TreeSet<>();
		int rank = 0;
		for (int i = n - 1; i >= 0; i--) {
			Character c = A.charAt(i);
			rank = rank + fact[n - 1 - i] * chars.headSet(c).size();
			rank %= m;
			chars.add(c);
		}
		return rank + 1;
	}

	int[] getFactorialArray1(final int A) {
		final int[] fact = new int[A + 1];
		fact[0] = 1;
		for (int i = 1; i <= A; i++) {
			fact[i] = i * fact[i - 1];
			fact[i] %= m;
		}
		return fact;
	}
}

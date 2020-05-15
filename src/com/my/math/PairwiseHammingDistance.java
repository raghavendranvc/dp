package com.my.math;

import com.my.common.UtilityClass;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

public class PairwiseHammingDistance {

	/*
	 * public int hammingDistance(final List<Integer> A) {
	 * 
	 * ArrayList<ArrayList> aList = new ArrayList<>(); for(int i=0;i<A.size();i++){
	 * aList.add(A.get(i)); }
	 * 
	 * for(int i=0;i<A.size();i++){ aList.add(A.get(i)); }
	 * 
	 * 
	 * }
	 */

	// TODO - Just compiled. Still need to check
	public int hammingDistance(final List<Integer> A) {
		int n = A.size();
		int dist = 0;
		for (int i = 0; i < 31; i++) {
			int oneCount = 0;
			for (int j = 0; j < n; j++) {
				int num = A.get(j);
				oneCount += (num & 1 << i) != 0 ? 1 : 0;
			}
			int zeroCount = n - oneCount;
			dist += (2L * oneCount * zeroCount) % 1000000007;
			dist = dist % 1000000007;
		}
		return dist;
	}

	public void computePermutation(String str, String suffix) {
		if (str.length() == 0) {
			System.out.println(suffix);
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String restOfTheString = str.substring(0, i) + str.substring(i + 1);
			computePermutation(restOfTheString, suffix + ch);
		}

	}

	public void computePermutationDistinct(String str, String suffix) {
		boolean[] exists = new boolean[26];
		computePermutationDistinct(str, suffix, exists);
	}

	public void computePermutationDistinct(String str, String suffix, boolean[] exists) {
		if (str.length() == 0) {
			System.out.println(suffix);
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String restOfTheString = str.substring(0, i) + str.substring(i + 1);

			// UtilityClass.print(exists);
			if (!exists[ch - 'a']) { // Only for distinct chars do permutation
				computePermutationDistinct(restOfTheString, suffix + ch);
			}
			exists[ch - 'a'] = true;
		}
	}

	public static void main(String[] args) {
		String s = "abdd";
		PairwiseHammingDistance pairwiseHammingDistance = new PairwiseHammingDistance();
		// pairwiseHammingDistance.computePermutation(s, "");
		pairwiseHammingDistance.computePermutationDistinct(s, "");
	}

	static int hammingDistance(int n1, int n2) {
		int x = n1 ^ n2; // XOR operation. Will show all unique 1's and 0's between the two
							// they add up to the humming distance
		int setBits = 0;

		while (x > 0) {
			setBits += x & 1; // We now count the 1 in the result of XOR value
			x >>= 1;
		}

		return setBits;
	}

	/***
	 * The idea is to count differences at individual bit positions. We traverse
	 * from 0 to 31 and count numbers with i’th bit set. Let this count be ‘count’.
	 * There would be “n-count” numbers with i’th bit not set. So count of
	 * differences at i’th bit would be “count * (n-count) * 2”, the reason for this
	 * formula is as every pair having one element which has set bit at i’th
	 * position and second element having unset bit at i’th position contributes
	 * exactly 1 to sum, therefore total permutation count will be count*(n-count)
	 * and multiply by 2 is due to one more repetition of all this type of pair as
	 * per given condition for making pair 1<=i,j<=N.
	 */

	public int hammingDistanceCopied(final List<Integer> A) {
		int n = A.size();

		int dist = 0;
		for (int i = 0; i < 31; i++) { // at each bit position we count number of 1's and 0's
			int oneCount = 0;
			for (int j = 0; j < n; j++) {
				// Loop for all numbers to get the count of number of 1's at ith position
				int num = A.get(j);
				oneCount += (getBitValueAtPosition(num, i) != 0) ? 1 : 0;
			}

			int zeroCount = n - oneCount;
			// obviously out of n numbers if 1 are oneCount, 0's will be n-oneCount

			// This is due to the question.
			// Humming distance of every pair. Total of n(n-1)/2 pairs
			// So a1a1,a1a2,a1a3 ...a1an, a2a1,a2a2, a2a3, a2a4,...a2an,....anan-1,anan
			// where a1,a2,...an are the numbers
			
			dist += (2L * oneCount * zeroCount) % 1000000007;

			dist = dist % 1000000007;
		}
		return dist;
	}

	private int getBitValueAtPosition(int number, int position) {
		// We first need to right push 1 by 'poistion' times 1 << position
		// This the the max to get that bit in the number
		// bitAtPosition = number & mask
		return (number & (1 << position));
	}

}

package com.my.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestZeroContinousSequence {
	/*
	 * 
	 * 1 ,2 ,-2 ,4 ,-4
	 * 
	 * sum - 5 sum - 1
	 * 
	 * sum -5 -4 sum -5 -1 sum -1 -2
	 * 
	 * sum -5 -4 -3 -5 -4 -1 -5 -2 -2
	 * 
	 * -5 -4 -3 -2 -5 -4 -3 -1 5 1 4 5 1
	 * 
	 * 345
	 * 
	 * 
	 * 
	 */

	public ArrayList<Integer> lszeroBruteForce(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();

		int n = A.size();

		for (int i = n; i >= 1; i--) {
			for (int j = 0; j <= n - i; j++) {
				int sum = 0;
				for (int k = j; k < j + i; k++) {
					sum = sum + A.get(k);
				}
				if (sum == 0) {
					for (int k = j; k < j + i; k++) {
						result.add(A.get(k));
					}
					return result;
				}
			}
		}

		return result;
	}

	/**
	 * Idea is to use Hashing Store SUM as key and index as Value.
	 * 
	 * 1) build up cumulative sum table 2) Check whether there is already a sum
	 * exists 3) if yes then calculate length and see if its largest
	 * 
	 * we could have done this serially first by calculating the cumulative sums in
	 * an array.
	 * 
	 * We can use hash map thereafter
	 * 
	 * 
	 * @param A
	 * @return
	 */
	// TODO idea!!

	public ArrayList<Integer> lszeroMap(ArrayList<Integer> a) {
		int start = 0, end = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
			if (map.containsKey(sum)) {
				int currStart = map.get(sum);
				int currEnd = i;

				if (currEnd - currStart + 1 > end - start + 1) {
					start = currStart;
					end = currEnd;
				}
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		// System.out.println(map);

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = start + 1; i <= end; i++) {
			result.add(a.get(i));
		}
		return result;
	}

	/*
	 * There are two steps: 1. Create cumulative sum array where ith index in this
	 * array represents total sum from 1 to ith index element. 2. Iterate all
	 * elements of cumulative sum array and use hashing to find two elements where
	 * value at ith index == value at jth index but i != j. 3. IF element is not
	 * present in hash in fill hash table with current element.
	 * 
	 */

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<>();

		int n = A.size();

		int[] sumArray = new int[n + 1];
		sumArray[0] = 0;
		for (int i = 1; i <= n; i++) {
			sumArray[i] = sumArray[i - 1] + A.get(i - 1);
		}

		for (int i = n; i >= 1; i--) { // i = length of the sequence
			for (int j = 0; j <= n - i; j++) { // j = starting index of the sequence
				int sum = sumArray[j + i] - sumArray[j];
				if (sum == 0) {
					for (int k = j; k < j + i; k++) {
						result.add(A.get(k));
					}
					return result;
				}
			}
		}

		return result;

	}
}

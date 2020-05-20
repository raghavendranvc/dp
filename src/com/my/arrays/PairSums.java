package com.my.arrays;

import java.util.*;
// Add any extra import statements you may need here

class PairSums {

	// Add any helper functions you may need here

	int numberOfWays1(int[] arr, int k) {
		// Write your code here
		if (arr == null || arr.length == 0) {
			return 0;
		}

		Arrays.sort(arr);
		int numOfPairs = 0;

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			if (arr[i] + arr[j] == k) {

				int numberOfJ = 1;
				while (arr[j] == arr[j - 1]) {
					numberOfJ++;
					j--;
				}

				int numberOfI = 1;
				while (arr[i] == arr[i + 1]) {
					numberOfI++;
					i++;
				}

				numOfPairs += numberOfJ * numberOfI;

			} else if (arr[i] + arr[j] < k) {
				i++;
			} else {
				j--;
			}
		}

		return numOfPairs;

	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {
		int k_1 = 6;
		int[] arr_1 = { 1, 2, 3, 4, 3 };
		int expected_1 = 2;
		int output_1 = numberOfWays(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 6;
		int[] arr_2 = { 1, 5, 3, 3, 3 };
		int expected_2 = 4;
		int output_2 = numberOfWays(arr_2, k_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new PairSums().run();
	}

	int countSum(int n){
	    return n*(n-1)/2;
	  }

	int numberOfWays(int[] arr, int k) {
		// Write your code here
		if (arr == null || arr.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int count = map.getOrDefault(arr[i], 0);
			map.put(arr[i], count + 1);
		}

		int numOfPairs = 0;
		System.out.println("count map="+map);

		Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> pair = iterator.next();
			int key = pair.getKey();
			int count = pair.getValue();

			if (map.containsKey(k - key)) {
				if (2 * key == k) {
					numOfPairs += countSum(count);
				} else {
					numOfPairs += count * map.get(k - key);
				}
				System.out.println("numOfPairs="+numOfPairs+" key="+key+" count="+count+" key2="+(k-key)+" count2="+map.get(k - key));
				iterator.remove();
			}
		}

		return numOfPairs;

	}
}

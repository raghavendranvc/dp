package com.my.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermuation {

	public String getPermutation(int A, int B) {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for (int i = 1; i <= A; i++) {
			integers.add(i);
		}

		// change k to be index
		B--;

		// set factorial of n
		int maxFacto = 1;
		for (int i = 1; i <= A; i++) {
			maxFacto = maxFacto * i;
		}

		if (B > maxFacto) {
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();

		// find sequence
		for (int i = 0; i < A; i++) {
			maxFacto = maxFacto / (A - i);
			// find the right number(curIndex) of
			int curIndex = B / maxFacto;
			// update k
			B = B % maxFacto;

			// get number according to curIndex
			stringBuffer.append(integers.get(curIndex));
			// remove from list
			integers.remove(curIndex);
		}

		return stringBuffer.toString();
	}

	// ------------------Another Way- Copied----------------------

	public String getPermutation1(int n, int k) {
		if (k > fact(n))
			return "";
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		return getPermutation(list, k - 1);

	}

	public String getPermutation(ArrayList<Integer> list, int k) {
		int n = list.size();
		if (n == 0)
			return "";

		int fact_n = fact(n - 1);
		int index = k / fact_n;
		int num = list.get(index);
		list.remove(index);
		// since index is "int", it remove index. If index is "Integer", it will remove
		// object
		k %= fact_n;
		return num + getPermutation(list, k);
	}

	int fact(int n) {
		if (n > 12)
			return Integer.MAX_VALUE;

		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}

		return fact;
	}

	// --------------------Practice----------------------------------
	String getPermutationPractice(int n, int k) {
		if (n == 0) {
			return "";
		}

		if (k > fact2(n)) {
			return "";
		}

		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			digits.add(i + 1);
		}

		k--;

		return getPermutation(digits, k);

	}

	String getPermutation(List<Integer> digits, int k) {
		if (digits.isEmpty()) {
			return "";
		}
		int n = digits.size();
		int factN = fact2(n - 1);
		int index = k / factN;
		int digit = digits.get(index);

		digits.remove(index); // Remove the item at index
		k = k % factN;
		return digit + getPermutation(digits, k);
	}

	int fact2(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	// ---------------------------Using Iteration--------------------

	static public void findPermutation(int n, int k) {
		int[] numbers = new int[n];
		int[] indices = new int[n];

		// initialise the numbers 1, 2, 3...
		for (int i = 0; i < n; i++)
			numbers[i] = i + 1;

		int divisor = 1;
		for (int place = 1; place <= n; place++) {
			if ((k / divisor) == 0)
				break; // all the remaining indices will be zero

			// compute the index at that place:
			indices[n - place] = (k / divisor) % place;
			divisor *= place;
		}

		// print out the indices:
		// System.out.println(Arrays.toString(indices));

		// permute the numbers array according to the indices:
		for (int i = 0; i < n; i++) {
			int index = indices[i] + i;

			// take the element at index and place it at i, moving the rest up
			if (index != i) {
				int temp = numbers[index];
				for (int j = index; j > i; j--)
					numbers[j] = numbers[j - 1];
				numbers[i] = temp;
			}
		}

		// print out the permutation:
		System.out.println(Arrays.toString(numbers));
	}

}

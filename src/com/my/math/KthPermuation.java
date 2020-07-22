package com.my.math;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermuation {

	/*
	 * 
	 * 1 1234 6*4 = 24 4!= 4*3*2*1 = 24 2 1243 3 1324 4 1342 5 1423 6 1432
	 * 
	 * 7 2134 8 2143
	 * 
	 * 9 2314 10 2341
	 * 
	 * 11 2413 12 2431
	 * 
	 * 13 3124 14 3142
	 * 
	 * 15 3214 24/(4-3-1) = 12+(3) = 3/(4-1-1) = 2 + (1) = 1/(4-4-1) = 24/2 + 3/2 +
	 * 16 3241 24/2 + 12/3 + 4/1 + 1/4 = 6+6 +
	 * 
	 * 0! 1! 2! 3! 4! 5! 0 1 2 6 24 120
	 * 
	 * 3 2 4 1 3! 2! 1! 0! 6 2 1 1
	 * 
	 * 3241 6*2+ 2*1 1*3 1*0 = 12+2+3=15 15 - 12 (6*2) = 1+2 3 - 2 (2*1) = 1+1 1 - 1
	 * (1*0) = 1+3 0 - 0 (0*0) = 1+0
	 * 
	 * 
	 * 17 3412 18 3421
	 * 
	 * 19 4123 20 4132
	 * 
	 * 21 4213 22 4231 22 = 6*3 + 2*1 + 1*1 + 1*1 3 2 1 0
	 * 
	 * 23 4312 = 6*3 + 2*2 + 1*1 + 1*1
	 * 
	 * 24 4321 = 6*4 + 2*0 + 1*0 + 1*0
	 * 
	 * 1234 6*(1-1)+ 2*(1-1) + 1*(2-2) + 1*(3-3) =0
	 * 
	 * 
	 */

	public String getPermutationLC(int A, int B) {

		// initialize all numbers
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

		StringBuilder StringBuilder = new StringBuilder();

		// find sequence
		for (int i = 0; i < A; i++) {
			maxFacto = maxFacto / (A - i);
			// find the right number(curIndex) of
			int curIndex = B / maxFacto;
			// update k
			B = B % maxFacto;

			// get number according to curIndex
			StringBuilder.append(integers.get(curIndex));
			// remove from list
			integers.remove(curIndex);
		}

		return StringBuilder.toString();
	}

	public String getPermutation(int A, int B) {
		ArrayList<Integer> integers = new ArrayList<>();
		for (int i = 1; i <= A; i++) {
			integers.add(i);
		}

		B = B - 1; // This will make sure that even if the decreasign seequence is given, we will
					// be able to compute the permutation correctly

		int maxFacto = 1;
		for (int i = 1; i <= A; i++) {
			maxFacto = maxFacto * i;
		}

		if (B > maxFacto) {
			return "";
		}

		StringBuilder StringBuilder = new StringBuilder();

		for (int i = 0; i < A; i++) {
			maxFacto = maxFacto / (A - i);

			int quotient = B / maxFacto;

			B = B % maxFacto; // Next iteration

			StringBuilder.append(integers.get(quotient)); // Get the index of this quotient
			integers.remove(quotient); // Then remove that number from the list
		}

		return StringBuilder.toString();

	}
	// We need to find the rank of 'k'

	public String getPermutationIB(int n, int k) {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		k = k - 1;

		int xn = list.size();// n-1
		if (xn == 0)
			return "";

		int fact_n = fact(xn - 1);

		int index = k / fact_n;
		int num = list.get(index);
		list.remove(index);// TODO removal is important too

		k %= fact_n;
		// return "";
		return num + getPermutationIB(n, k);
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

	public static void main(String[] args) {
		KthPermuation kthPermuation = new KthPermuation();
		System.out.println("Result=" + kthPermuation.getPermutation(3, 6));

	}

	/*************One way**********************/
	//TODO use this
	
	public String getPermutationLeet(int n, int k) {

		List<Integer> digits = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			digits.add(i);
		}

		return getPerm(n, k - 1, getFactorial(n), digits);

	}

	private String getPerm(int n, int k, int[] fact, List<Integer> digits) {
		if (digits.isEmpty()) {
			return "";
		}
		int quotient = k / fact[n - 1];
		int num = digits.get(quotient);
		digits.remove(quotient);//Important
		k = k % fact[n - 1];

		return num + getPerm(n - 1, k, fact, digits);

	}

	private int[] getFactorial(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = f[i - 1] * i;
		}
		return f;
	}
	
	//------------------------------------------------------------
	
	public String getPermutationFromBT(int A, int B) {
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

	int fact3(int n) {
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
	
	//TODO check Math. KthPermuation

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

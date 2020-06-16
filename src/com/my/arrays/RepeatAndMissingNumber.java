package com.my.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatAndMissingNumber {
	// 0 1 2 3 4 5
	// [6 3 1 2 5 3]
	// [3 3 1 2 5 6]
	// [1 3 3 2 5 6]
	// [1 2 3 3 5 6]

	// [ 3 6]

	public ArrayList<Integer> repeatedNumber1(final List<Integer> A) {

		ArrayList<Integer> returnList = new ArrayList<>();

		int[] tempList = new int[A.size()];

		for (int i = 0; i < A.size(); i++) {

			int arrayValue = A.get(i);

			if (tempList[arrayValue - 1] == arrayValue) {
				returnList.add(arrayValue); // Repeated Number
			} else {
				tempList[arrayValue - 1] = arrayValue;
			}
		}

		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i] == 0) {
				returnList.add(i + 1);
				break;
			}
		}
		return returnList;

	}

	// ---Another way----------------------

	public ArrayList<Integer> repeatedNumber2(final List<Integer> A) {

		ArrayList<Integer> out = new ArrayList<Integer>();
		double l = A.size();
		double sum = (l * (l + 1)) / 2; //Summation from 1 to l/n is n(n+1)/2 
		long sumA = 0;
		int a = 0;
		HashSet<Integer> ASet = new HashSet<Integer>();
		for (int i = 0; i < A.size(); i++) {
			if (ASet.contains(A.get(i))) {
				a = A.get(i);
			}
			ASet.add(A.get(i));
			sumA = sumA + A.get(i);
		}
		double diff = sumA - sum;
		int b = a - (int) diff;
		out.add(a);
		out.add(b);
		return out;

	}

	public static void main(String[] args) {

		RepeatAndMissingNumber repeatAndMissingNumber = new RepeatAndMissingNumber();

	}

}

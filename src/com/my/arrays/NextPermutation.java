package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

	

	// 5 4 3 1
	// reverse

	// 5 4 '1' 3
	// 5 4 3 1

	// 5 4 '6' 7
	// 6 4 5 7

	// 6 4 5 7

	// 1 '2' 3 4 5
	// 2 1 3 4 5

	// 3 2 1 5 '4'
	// 4 1 2 3 5

	// 3 3 2 2 4
	// 3 3 2 4 2

	/*
	 * 
	 * 3 2 1 4 8 7 6 5 7 8 9 dE
	 * 
	 * 3 2 1 4 8 7 9 5 7 9 8
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 0 1 2 5 3 3 0 DE 0 1 2 5 3 3 0 DE FG
	 * 
	 * FG(rightmost greater element compared to DE-1) Swap DE1- and FG 0 1 3 5 3 2 0
	 * - - // Now sort letter between DE and end 0 1 3 0 2 3 5
	 */
	
	//https://stackoverflow.com/questions/1622532/algorithm-to-find-next-greater-permutation-of-a-given-string

	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {

		// finds the first integer 'i' such that thereafter everything is decreasing
		// order
		// So do the reverse check
		int decreasingSequenceEnd = A.size() - 1;

		//has to be samller element, then only stop
		while (decreasingSequenceEnd > 0 && A.get(decreasingSequenceEnd - 1) >= A.get(decreasingSequenceEnd)) {
			decreasingSequenceEnd--;
		}

		//0 ... decreasingSequenceEnd-1, decreasingSequenceEnd, ..firstGreaterElementThanDSE-1,...,n-1
		
		// the number which we need to swap will be at 'decreasingSequenceEnd'

		System.out.println("decreasingSequenceEnd=" + decreasingSequenceEnd);

		if (decreasingSequenceEnd <= 0) {
			reverseList(A, 0, A.size() - 1);
			return A;
		}

		// Within the decreasing sequence, find the last digit which is greater than the
		// one at 'decreasingSequenceEnd'
		// has to be greater element, then stop

		int lastGreaterElement = A.size() - 1;
		while (A.get(lastGreaterElement) <= A.get(decreasingSequenceEnd - 1)) {
			lastGreaterElement--;
		}

		System.out.println("lastGreaterElement=" + lastGreaterElement);

		swap(A, decreasingSequenceEnd - 1, lastGreaterElement);

		// Reverse the list starting from decreasingSequenceEnd (decreasingSequenceEnd,n)

		reverseList(A, decreasingSequenceEnd, A.size() - 1);

		return A;

	}

	private void reverseList(ArrayList<Integer> list, int i, int j) {
		// System.out.println("reversing between "+i+" & "+j);
		for (int f = i, k = j; f < k; f++, k--) {
			swap(list, f, k);
		}
	}

	private void swap(ArrayList<Integer> returnList, int i, int j) {
		int save = returnList.get(i);
		returnList.set(i, returnList.get(j));
		returnList.set(j, save);
	}

	public static void main(String[] args) {
		// int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683,
		// 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653,
		// 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406,
		// 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557,
		// 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160,
		// 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742 };
		// int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319,
		// 412};
		/*
		 * String str = "ID"; System.out.println("str="+str);
		 * 
		 * NextPermutation nextPermutation = new NextPermutation();
		 * System.out.println(nextPermutation.findPerm(str,str.length()+1));
		 */

		int[] a = new int[] { 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 };
		ArrayList<Integer> intList = new ArrayList<>(a.length);
		for (int i : a) {
			intList.add(i);
		}
		UtilityClass.print(a);
		NextPermutation nextPermutation = new NextPermutation();
		System.out.println(nextPermutation.nextPermutation(intList));
	}

}

package com.my.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

	// TODO practice again

	public ArrayList<ArrayList<Integer>> subsetsUsingPowerOf2(ArrayList<Integer> A) {

		Collections.sort(A);
		int total = (int) Math.pow(2, A.size());
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 0; i < total; i++) {

			ArrayList<Integer> arrayList = new ArrayList<>();
			for (int j = 0; j < A.size(); j++) {
				if ((i & (1 << j)) != 0) { // "j"th bit in "i'
					arrayList.add(A.get(j));
				}
			}
			result.add(arrayList);
		}
		return result;

		/*
		 * for(int startIndex=0;startIndex<A.size();startIndex++){ for(int
		 * length=1;length<=A.size()-startIndex;length++) { ArrayList<Integer> arrayList
		 * = new ArrayList<>(); for (int i = startIndex; i < startIndex + length; i++) {
		 * arrayList.add(A.get(i)); } result.add(arrayList); } } return result;
		 */
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		ArrayList<Integer> A = new ArrayList<>(a.length);
		for (int i : a) {
			A.add(i);
		}

		Subset s = new Subset();
		s.subsets(A);

	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>()); // First add the empty List;
		if (A.size() == 0) {
			return result;
		}
		Collections.sort(A);
		subsetsRecur(A, 0, result, new ArrayList<>());
		return result;

	}

	public void subsetsRecur(ArrayList<Integer> A, int startIndex, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> tempArray) {

		for (int i = startIndex; i < A.size(); i++) {
			tempArray.add(A.get(i));
			result.add(new ArrayList<>(tempArray)); //Immediately add it
			System.out.println("Before temp (" + i + ") =" + tempArray);
			subsetsRecur(A, i + 1, result, tempArray);
			tempArray.remove(tempArray.size() - 1);
		}
	}
	
	//---------------------------------------------

	public ArrayList<ArrayList<Integer>> subsetsCopied(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		output.add(new ArrayList<>());
		if (a.size() == 0) {
			return output;
		}
		Collections.sort(a);
		generate(a, output, new ArrayList<>(), 0);
		return output;
	}

	public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp,
			int index) {
		for (int i = index; i < a.size(); i++) {
			temp.add(a.get(i)); // Adding the first one
			output.add(new ArrayList<Integer>(temp));
			System.out.println("Before temp (" + i + ") =" + temp);
			generate(a, output, temp, i + 1);
			// System.out.println("After recursion temp ("+i+") ="+temp);
			temp.remove(temp.size() - 1); // This generally remove the one that got added in the earlier array
		}
	}

}

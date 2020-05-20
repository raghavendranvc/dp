package com.my.backtracking;

import java.util.ArrayList;

public class Permuation {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A == null || A.isEmpty()) {
			return result;
		}
		permute(A, result, 0);
		return result;
	}
	/*
	 * We modify A in each way and add it to the result list. So we permute A and
	 * simply add the permutation to result.
	 */

	private void permute(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, int startIndex) {
		if (startIndex == A.size()) {
			System.out.println("Added result=" + A);
			result.add(new ArrayList<>(A));
			return;
		}

		for (int k = startIndex; k < A.size(); k++) {
			System.out.println("New startIndex=" + startIndex + " k=" + k + " A=" + A);
			swap(A, startIndex, k);
			permute(A, result, startIndex + 1);
			swap(A, startIndex, k);
			System.out.println("Backtrack startIndex=" + startIndex + " k=" + k + " A=" + A);
			// System.out.println("k="+k+" startIndex="+startIndex +" new
			// tempArray="+tempArray);
		}
	}

	private void swap(ArrayList<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		ArrayList<Integer> A = new ArrayList<>();
		for (int i : a) {
			A.add(i);
		}
		Permuation permuation = new Permuation();
		System.out.println("Result=" + permuation.permute1(A));
	}

	// ================Trying Combination way. But didn't work==============

	public ArrayList<ArrayList<Integer>> permute1(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A == null || A.isEmpty()) {
			return result;
		}
		permute1(A, result, 0, new ArrayList<>());
		return result;

	}

	public void permute1(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, int curentIndex,
			ArrayList<Integer> currentPerm) {
		if (currentPerm.size() == curentIndex) {
			result.add(new ArrayList<>(currentPerm));
			return;
		}

		for (int i = curentIndex; i < A.size(); i++) {
			currentPerm.add(A.get(i));
			permute1(A, result, curentIndex + 1, currentPerm);
			currentPerm.remove(currentPerm.size() - 1);
		}
	}

}

package com.my.graphs;

import java.util.ArrayList;

public class WordSearch {

	public int exist(ArrayList<String> A, String B) {

		if (A == null) {
			if (B == null) {
				return 1;
			} else {
				return 0;
			}
		}

		if (B.isEmpty()) {
			return 1;
		}

		if (A.size() == 0 || A.get(0).isEmpty()) {
			return 0;
		}

		int rows = A.size();
		int col = A.get(0).length();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				if (isWordFound(A, B, i, j, 0, rows, col)) {
					return 1;
				}
			}
		}
		return 0;
	}

	boolean isWordFound(ArrayList<String> A, String B, int i, int j, int currentWordIndex, int rows, int col) {
		if (i < 0 || j < 0 || i >= rows || j >= col) {
			return false;
		}

		if (A.get(i).charAt(j) != B.charAt(currentWordIndex)) {
			return false;
		}

		currentWordIndex++;
		// matches. So check if this is the end
		//here same letter can be used.
		if (currentWordIndex == B.length()) {
			return true;
		}

		if (isWordFound(A, B, i - 1, j, currentWordIndex, rows, col)) {
			return true;
		}

		if (isWordFound(A, B, i + 1, j, currentWordIndex, rows, col)) {
			return true;
		}
		if (isWordFound(A, B, i, j - 1, currentWordIndex, rows, col)) {
			return true;
		}
		if (isWordFound(A, B, i, j + 1, currentWordIndex, rows, col)) {
			return true;
		}
		return false;
	}

}

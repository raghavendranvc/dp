package com.my.graphs;

import java.util.ArrayList;

import com.my.common.UtilityClass;

public class NumberOfBlacks {

	public int black(ArrayList<String> A) {

		if (A == null || A.isEmpty() || A.get(0).isEmpty()) {
			return 0;
		}

		int rows = A.size();
		int col = A.get(0).length();
		boolean[][] visited = new boolean[rows][col];

		int returnCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				if (A.get(i).charAt(j) == 'O') {
					continue;
				}

				if (visited[i][j]) {
					continue;
				}
				
				System.out.println("i="+i+" j="+j);

				returnCount++;
				markVisited(rows, col, i, j, visited, A);
				UtilityClass.printArray(visited);

			}
		}
		return returnCount;
	}

	/*
	 * t l x r b
	 */

	void markVisited(int rows, int col, int i, int j, boolean[][] visited, ArrayList<String> A) {
		if (i >= 0 && i < rows && j >= 0 && j < col) {
			if (visited[i][j] || A.get(i).charAt(j) == 'O') {
				return;
			}
			visited[i][j] = true;
			markVisited(rows, col, i + 1, j, visited, A);
			markVisited(rows, col, i - 1, j, visited, A);
			markVisited(rows, col, i, j + 1, visited, A);
			markVisited(rows, col, i, j - 1, visited, A);
		}
	}
	
	public static void main(String[] args) {
		String[] a = { "OOOXOOO", "OOXXOXO", "OXOOOXO" };
		
		ArrayList<String> A = new ArrayList<String>();
		for(String s : a) {
			A.add(s);
		}
		NumberOfBlacks n = new NumberOfBlacks();
		int count = n.black(A);
		System.out.println("count="+count);
	}

}

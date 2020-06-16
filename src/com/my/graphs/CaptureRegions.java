package com.my.graphs;

import java.util.ArrayList;
import java.util.Stack;

import com.my.common.UtilityClass;

public class CaptureRegions {

	final static char OCCUPIER = 'X';
	final static char OCCUPIEE = 'O';

	class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			Pair otherP = (Pair) o;
			return (this.x == otherP.x && this.y == otherP.y);
		}

		public String toString() {
			return "x=" + x + " y=" + y;
		}
	}

	public void solve(ArrayList<ArrayList<Character>> a) {

		int m = a.size();
		int n = a.get(0).size();

		if (m < 3 || n < 3) {
			return;
		}

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == m - 1 || j == 0 || j == n - 1 || a.get(i).get(j) == OCCUPIER) {
					visited[i][j] = true;
				}
			}
		}

		UtilityClass.printArray(visited);

		Stack<Pair> zeroP = new Stack<Pair>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {

					if (a.get(i).get(j) == OCCUPIEE) {
						System.out.println("Verifying[" + i + "," + j + "]");
						if (i + 1 < m && !visited[i + 1][j] && a.get(i + 1).get(j) == OCCUPIEE) {
							zeroP.push(new Pair(i + 1, j));
						}
						if (j + 1 < m && !visited[i][j + 1] && a.get(i).get(j + 1) == OCCUPIEE) {
							zeroP.push(new Pair(i, j + 1));
						}
						if (i - 1 >= 0 && !visited[i - 1][j] && a.get(i - 1).get(j) == OCCUPIEE) {
							zeroP.push(new Pair(i - 1, j));
						}
						if (j - 1 >= 0 && !visited[i][j - 1] && a.get(i).get(j - 1) == OCCUPIEE) {
							zeroP.push(new Pair(i, j - 1));
						}
					}
				}
			}
		}

		System.out.println("Prepared initial Stack=" + zeroP);

		markVisited(a, m, n, visited, zeroP);
		System.out.println("After marking visted=" + zeroP);

		for (int i = 1; i < m - 1; i++) { // We don't need to check last row and last column
			for (int j = 1; j < n - 1; j++) {
				if (!visited[i][j]) {
					a.get(i).set(j, OCCUPIER);
				}
			}
		}

	}

	private void markVisited(ArrayList<ArrayList<Character>> a, int m, int n, boolean[][] visited, Stack<Pair> zeroP) {
		while (!zeroP.isEmpty()) {
			Pair cp = zeroP.pop();
			int i = cp.x;
			int j = cp.y;

			if (i < m && i >= 0 && j < n && j >= 0 && !visited[i][j] && a.get(i).get(j) == OCCUPIEE) {
				visited[i][j] = true;

				if (i + 1 < m && !visited[i + 1][j] && a.get(i + 1).get(j) == OCCUPIEE) {
					zeroP.push(new Pair(i + 1, j));
				}
				if (j + 1 < n && !visited[i][j + 1] && a.get(i).get(j + 1) == OCCUPIEE) {
					zeroP.push(new Pair(i, j + 1));
				}
				if (i - 1 >= 0 && !visited[i - 1][j] && a.get(i - 1).get(j) == OCCUPIEE) {
					zeroP.push(new Pair(i - 1, j));
				}
				if (j - 1 >= 0 && !visited[i][j - 1] && a.get(i).get(j - 1) == OCCUPIEE) {
					zeroP.push(new Pair(i, j - 1));
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] a = { "XOXXXXOOXX", "XOOOOXOOXX", "OXXOOXXXOO", "OXOXOOOXXO", "OXOOXXOOXX", "OXXXOXXOXO",
				"OOXXXXOXOO" };
		// Character[][] a = { { 'X', 'O', 'X' }, { 'X', 'O', 'X' }, { 'X', 'O', 'X' }
		// };
		ArrayList<ArrayList<Character>> A = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			A.add(new ArrayList<Character>());
			for (int j = 0; j < a[0].length(); j++) {
				A.get(i).add(a[i].charAt(j));
			}
		}

		System.out.println("Given=" + A);

		CaptureRegions captureRegions = new CaptureRegions();
		captureRegions.solve(A);
		System.out.println("Result" + A);

	}

	// --------------------Coped way-------------------

	void dfs(ArrayList<ArrayList<Character>> a, int i, int j, char x, char y) {
		
		if (i < 0 || j < 0 || i >= a.size() || j >= a.get(i).size())
			return;
		
		if (a.get(i).get(j) != x)
			return;
		
		a.get(i).set(j, y);
		dfs(a, i + 1, j, x, y);
		dfs(a, i - 1, j, x, y);
		dfs(a, i, j - 1, x, y);
		dfs(a, i, j + 1, x, y);

	}

	public void solveCopied(ArrayList<ArrayList<Character>> a) {
		
		int m = a.size();
		int n = a.get(0).size();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a.get(i).get(j) == 'O')
					a.get(i).set(j, '-');
			}
		}
		for (int i = 0; i < n; i++) {
			if (a.get(0).get(i) == '-') {
				dfs(a, 0, i, '-', 'O');
			}
		}
		for (int i = 0; i < n; i++) {
			if (a.get(m - 1).get(i) == '-') {
				dfs(a, m - 1, i, '-', 'O');
			}
		}
		for (int i = 0; i < m; i++) {
			if (a.get(i).get(0) == '-') {
				dfs(a, i, 0, '-', 'O');
			}
		}
		for (int i = 0; i < m; i++) {
			if (a.get(i).get(n - 1) == '-') {
				dfs(a, i, n - 1, '-', 'O');
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a.get(i).get(j) == '-')
					a.get(i).set(j, 'X');
			}
		}
	}

}

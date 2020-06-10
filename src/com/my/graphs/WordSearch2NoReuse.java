package com.my.graphs;

public class WordSearch2NoReuse {

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		int m = board.length;
		int n = board[0].length;
		// Same same letter cell cannot be reused more than once,
		// so for each verification, we need to have visited map

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isFound(board, word, i, j, 0, visited.clone(), m, n)) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * ["C","A","A"], ["A","A","A"], ["B","C","D"]]
	 */

	private boolean isFound(char[][] board, String word, int r, int c, int wordIndex, boolean[][] visited, int m,
			int n) {

		if (!isValid(r, c, m, n, visited) || board[r][c] != word.charAt(wordIndex)) {
			return false;
		}

		wordIndex++;

		if (word.length() == wordIndex) {
			return true;
		}

		visited[r][c] = true;

		if (isFound(board, word, r + 1, c, wordIndex, visited.clone(), m, n)) {
			return true;
		}

		if (isFound(board, word, r - 1, c, wordIndex, visited.clone(), m, n)) {
			return true;
		}

		if (isFound(board, word, r, c + 1, wordIndex, visited.clone(), m, n)) {
			return true;
		}

		if (isFound(board, word, r, c - 1, wordIndex, visited.clone(), m, n)) {
			return true;
		}

		return false;
	}

	private boolean isValid(int r, int c, int m, int n, boolean[][] visited) {
		return (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]);
	}

}

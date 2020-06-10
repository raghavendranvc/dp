package com.my.leet.hard;

public class LongestIncreasingSequenceInMatrix {

	// https://www.geeksforgeeks.org/longest-increasing-path-matrix/
	// https://www.programcreek.com/2014/05/leetcode-longest-increasing-path-in-a-matrix-java/

	// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

	// Use memoization to improve the algorithm
	
	int max = 0;
	public int longestIncreasingPath(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(matrix, i, j, 1);
			}
		}
		return max;
	}
	
	

	public void dfs(int[][] matrix, int i, int j, int len) {
		max = Math.max(max, len);

		int m = matrix.length;
		int n = matrix[0].length;

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (isValid(m,n,x,y) && matrix[x][y] > matrix[i][j]) {
				dfs(matrix, x, y, len + 1);
			}
		}
	}
	
	public boolean isValid(int m, int n, int x, int y) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}

}

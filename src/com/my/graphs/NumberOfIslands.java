package com.my.graphs;

public class NumberOfIslands {

	static int LAND = 1;
	static int WATER = 0;

	public int numberOfIslands(int[][] map) {

		int m = map.length;
		int n = map[0].length;

		boolean[][] visited = new boolean[m][n];
		int islandCount = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == WATER || visited[i][j]) {
					continue;
				}
				visited[i][j] = true;
				doDFS(map, i, j, visited, m, n);
				islandCount++;
			}
			
		}
		return islandCount;
	}

	// -1,-1 -1,0 -1,1
	// 0,-1 0,0 0,1
	// 1,-1 1,0 1,1

	private boolean rightPair(int r, int c, int m, int n) {
		return (r >= 0 && r < m && c >= 0 && c < n);
	}

	int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };

	private void doDFS(int[][] map, int r, int c, boolean[][] visited, int m, int n) {
		
		for (int i = 0; i < row.length; i++) {
			int x = r + row[i];
			int y = c + col[i];
			if (rightPair(x, y, m, n) && map[x][y] != WATER && !visited[x][y]) {
				visited[x][y] = true;
				doDFS(map, x, y, visited, m, n);
			}
		}
	}

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		NumberOfIslands I = new NumberOfIslands();
		System.out.println("Number of islands is: " + I.numberOfIslands(M));
	}

}

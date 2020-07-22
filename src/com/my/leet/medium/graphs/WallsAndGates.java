package com.my.leet.medium.graphs;

public class WallsAndGates {
	// https://github.com/grandyang/leetcode/issues/286
	/*
	 * 
	 * You are given a m x n 2D grid initialized with these three possible values.
	 * 
	 * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room.
	 * We use the value 2 31 - 1 = 2147483647 to represent INF as you may assume
	 * that the distance to a gate is less than 2147483647. Fill each empty room
	 * with the distance to its nearest gate. If it is impossible to reach a gate,
	 * it should be filled with INF.
	 * 
	 * 
	 */

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
			return;

		int m = rooms.length;
		int n = rooms[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {//Find a gate
					fill(rooms, i, j, 0);
				}
			}
		}
	}

	public void fill(int[][] rooms, int i, int j, int distance) {
		int m = rooms.length;
		int n = rooms[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < distance) {
			return;
		}

		rooms[i][j] = distance;

		fill(rooms, i - 1, j, distance + 1);
		fill(rooms, i, j + 1, distance + 1);
		fill(rooms, i + 1, j, distance + 1);
		fill(rooms, i, j - 1, distance + 1);
	}

}

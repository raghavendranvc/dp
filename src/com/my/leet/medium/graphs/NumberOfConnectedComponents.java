package com.my.leet.medium.graphs;

public class NumberOfConnectedComponents {

	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
	 * edge is a pair of nodes), write a function to find the number of connected
	 * components in an undirected graph.
	 *
	 */
	
	//TODO do this

	public int countComponents(int n, int[][] edges) {
		int count = n;

		int[] parent = new int[n];
		// initialize each node is an island
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			int xRoot = getRoot(parent, x);
			int yRoot = getRoot(parent, y);

			if (xRoot != yRoot) {//the edge[i] connects 2 components. So we reduce
				count--;
				parent[xRoot] = yRoot;
			}

		}

		return count;
	}

	public int getRoot(int[] parent, int i) {
		while (parent[i] != i) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		return i;
	}
}

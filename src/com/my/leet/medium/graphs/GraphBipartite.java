package com.my.leet.medium.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {

	// -----------------DFS Approach-----------------------

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];//visited. 

		for (int i = 0; i < n; i++) {
			if (colors[i] == 0 && !isValid(graph, colors, i, 1)) {
				return false;
			}
		}

		return true;
	}

	public boolean isValid(int[][] graph, int[] colors, int src, int currentColor) {
		if (colors[src] != 0) {
			return (colors[src] == currentColor); //Important terminating condition
		}

		colors[src] = currentColor;

		for (int neighbour : graph[src]) {
			if (!isValid(graph, colors, neighbour, -currentColor)) {
				return false;
			}
		}

		return true;
	}

	// ---------------------BFS Approach -------------------------------

	public boolean isBipartiteBFS(int[][] graph) {
		int len = graph.length;
		int[] colors = new int[len];

		for (int i = 0; i < len; i++) {

			if (colors[i] != 0)
				continue;

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);

			colors[i] = 1; // Blue: 1; Red: -1.

			while (!queue.isEmpty()) {
				int cur = queue.poll();

				for (int next : graph[cur]) {
					if (colors[next] == 0) { // If this node hasn't been colored;
						colors[next] = -colors[cur]; // Color it with a different color;
						queue.offer(next);
					} else if (colors[next] != -colors[cur]) { // If it is colored and its color is different, return
																// false;
						return false;
					}
				}
			}
		}

		return true;

	}

}

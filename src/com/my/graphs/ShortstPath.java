package com.my.graphs;

public class ShortstPath {

	// BellmanFord from Source Vertex To all Vertices

	public void shortestPath(int[][] graph, int src) {

		int V = graph.length;
		int[] distance = new int[V];

		boolean[] included = new boolean[V];

		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
			included[i] = false;
		}

		distance[src] = 0;

		for (int i = 0; i < V-1; i++) { //Repeat only V-1 times. 
			int minIndex = getMinDistVertx(distance, included);
			included[minIndex] = true;

			if (distance[minIndex] == Integer.MAX_VALUE) {
				continue;
			}

			for (int j = 0; j < V; j++) {
				if (included[j]) {
					continue;
				}
				distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
			}
		}
		//distance is the solution Set
	}

	private int getMinDistVertx(int[] distance, boolean[] included) {
		int minIndex = -1;
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			if (included[i]) {
				continue;
			}
			if (distance[i] <= minDistance) {
				minDistance = distance[i];
				minIndex = i;
			}

		}
		return minIndex;
	}
	
	
	

}

package com.my.graphs;

public class ShortstPath {
	
	// Dijkstra Minimum distance to all vertices
	// O(V^2)

	public void shortestPath(int[][] graph, int src) {

		int V = graph.length;
		int[] distance = new int[V]; //Is the solution set

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
				//We can even break as none of the other vertices are not reachable
			}

			//Let's recalculate other vertices distances as we now included new "minIndex"
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
	
	//TODO
	// For negative edges, use Bellman Ford. https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
	// Same as the above, except that there will a check to find a loop	
	
	
	

}

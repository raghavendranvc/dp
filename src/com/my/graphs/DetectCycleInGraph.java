package com.my.graphs;

import java.util.LinkedList;
import java.util.List;

public class DetectCycleInGraph {

	/*
	 * class GraphNode{ int v; List<GraphNode> adjList; }
	 */

	class Graph {
		int numOfVertices;
		List<Integer>[] adjList;

		Graph(int v) {
			this.numOfVertices = v;
			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<>();
			}
		}

		void addEdge(int u, int v) {
			adjList[u].add(v);
		}
	}

	enum Color {
		WHITE, BLACK, GREY;
	}

	public boolean detectCycle(Graph g) {
		Color[] visited = new Color[g.numOfVertices];

		for (int i = 0; i < g.numOfVertices; i++) {
			visited[i] = Color.WHITE;
		}

		for (int i = 0; i < g.numOfVertices; i++) {
			if (visited[i] == Color.WHITE && isThereACycle(g, visited, i)) {
				return true;
			}
		}

		return false;
	}

	public boolean isThereACycle(Graph G, Color[] visited, int start) {
		visited[start] = Color.GREY;

		for (int i : G.adjList[start]) {
			if (visited[i] == Color.GREY) {
				return true;
			}

			if (visited[i] == Color.WHITE && isThereACycle(G, visited, i)) {
				return true;
			}

		}
		visited[start] = Color.BLACK;
		return false;
	}

	/*************** Below is another approach - Union Find (Parent detect)**************************/

	public boolean cycleDetectUsingParent(Graph g, int v, boolean[] visited, int parent) {

		visited[v] = true;

		for (int u : g.adjList[v]) {

			if (u == parent) {
				continue; //back edge to the parent. This should be ok in undirected graph.
			}

			if (visited[u]) {
				return true; //But if we reach a vertex which is already visited - there is a cycle
			}

			if (cycleDetectUsingParent(g, u, visited, v)) {
				return true;
			}

		}
		return false;
	}

	public boolean cyclic(Graph G) {

		boolean[] visited = new boolean[G.numOfVertices];
		for (int v = 0; v < G.numOfVertices; v++) {
			if (visited[v]) {
				continue;
			}
			if (cycleDetectUsingParent(G, v, visited, -1)) {
				return true;
			}
		}

		return false;
	}

}

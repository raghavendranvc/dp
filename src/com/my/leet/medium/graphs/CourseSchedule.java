 package com.my.leet.medium.graphs;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

	class Graph {
		int v;
		List<Integer>[] adjList;

		Graph(int v) {
			this.v = v;
			this.adjList = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<>();
			}
		}

		void addEdge(int u, int v) {
			adjList[u].add(v);
		}
	}
	/*
	 * 1->0 2->0,1
	 */

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites.length == 0) {
			return true;
		}

		Graph g = new Graph(numCourses);

		for (int i = 0; i < prerequisites.length; i++) {
			g.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}

		boolean[] visited = new boolean[numCourses];
		boolean[] currentPath = new boolean[numCourses];

		for (int i = 0; i < g.v; i++) {
			if (!visited[i] && detectCycle(g, i, visited, currentPath)) {
				return false;
			}
		}
		return true;
	}

	public boolean detectCycle(Graph g, int v, boolean[] visited, boolean[] currentPath) {

		if (visited[v]) {
			return false;
		}

		visited[v] = currentPath[v] = true;

		for (int u : g.adjList[v]) {
			if (currentPath[u] || detectCycle(g, u, visited, currentPath)) {
				return true;
			}
		}
		currentPath[v] = false;
		return false;
	}

}

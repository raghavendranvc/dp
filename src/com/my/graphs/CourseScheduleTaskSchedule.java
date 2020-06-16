package com.my.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleTaskSchedule {

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
		
		/*
		 * Visited is for the DFS so that we will not revisit it as
		 * we have already proceeded it
		 * 
		 * currentPath is used to detect cycle. If we visit any on the
		 * path again, we have a cycle
		 * This is like GREY COLOR
		 */

		boolean[] visited = new boolean[numCourses];
		boolean[] currentPath = new boolean[numCourses]; // TODO
		// Remember to have this. This one is important to validate.
		// visited can only be useful in connected graph

		for (int i = 0; i < g.v; i++) {
			if (!visited[i] && detectCycle(g, i, visited, currentPath)) {
				return false;
			}
		}
		return true;
	}

	public boolean detectCycle(Graph g, int v, boolean[] visited, boolean[] currentPath) {

		// if we see an already visited vertix, means there cannot be deadlock 
		if (visited[v]) { //remember this is not on the current path
			//we could also write this as (visited[v] && !currentPth[v])
			return false;
		}

		visited[v] = currentPath[v] = true;

		for (int u : g.adjList[v]) {
			if (currentPath[u] || detectCycle(g, u, visited, currentPath)) {
				return true;
			}
		}
		currentPath[v] = false;//backtrack 
		return false;
	}

	/******************* Get the schedule - Task Order************************/

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		if (numCourses == 0 || prerequisites.length == 0) {
			int[] result = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				result[i] = i;
			}
			return result;
		}

		Graph g = new Graph(numCourses);

		for (int i = 0; i < prerequisites.length; i++) {
			g.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}

		boolean[] visited = new boolean[numCourses]; //visited is for whole
		boolean[] currentPath = new boolean[numCourses]; 
		//Remember this. Very important. Needed for disconnected graph

		boolean canFinish = true;
		for (int i = 0; i < g.v; i++) {
			if (!visited[i] && detectCycle(g, i, visited, currentPath)) {
				canFinish = false;
				break;
			}
		}

		if (!canFinish) {
			return new int[0];
		}

		visited = new boolean[numCourses];
		Stack<Integer> schduleStack = new Stack<>();

		for (int i = 0; i < g.v; i++) {
			if (visited[i]) {
				continue;
			}
			dfs(g, i, visited, schduleStack);
		}

		if (schduleStack.size() < g.v) {
			return new int[1];
		} else {
			int i = 0;
			int[] result = new int[numCourses];
			while (!schduleStack.isEmpty()) {
				result[i++] = schduleStack.pop();
			}
			return result;
		}
	}

	public void dfs(Graph g, int v, boolean[] visited, Stack<Integer> schduleStack) {

		visited[v] = true;

		for (int u : g.adjList[v]) {
			if (visited[u]) {
				continue;
			}
			dfs(g, u, visited, schduleStack);
		}
		schduleStack.add(v);
	}

}

package com.my.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FinishCourses {

	enum Color {
		WHITE, GREY, BLACK;
	}

	class Graph {
		// Remember to use HashMap for this kind of nodes
		Map<Integer, Set<Integer>> graph = new HashMap<>();// Adjacency List

		void addDependency(int course, int dependent) {
			if (!graph.containsKey(course)) {
				Set<Integer> dependents = new HashSet<>();
				dependents.add(dependent);
				graph.put(course, dependents);
			} else {
				graph.get(course).add(dependent);
			}
		}
	}

	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {

		Map<Integer, Color> visited = new HashMap<Integer, Color>();

		Graph g = new Graph();
		for (int i = 0; i < B.size(); i++) {
			g.addDependency(B.get(i), C.get(i));
			visited.put(B.get(i), Color.WHITE);
			visited.put(C.get(i), Color.WHITE);
		}

		int possible = 1;

		Iterator<Integer> iter = g.graph.keySet().iterator();
		while (iter.hasNext()) {
			int currentCourse = iter.next();
			if (visited.get(currentCourse) == Color.WHITE && checkCycle(visited, g, currentCourse)) {
				possible = 0; // if cycle is present then it is not possible
				break;
			}
		}

		return possible;
	}

	public boolean checkCycle(Map<Integer, Color> visited, Graph g, int currentCourse) {

		visited.put(currentCourse, Color.GREY);

		if (g.graph.containsKey(currentCourse)) {
			for (Integer dependent : g.graph.get(currentCourse)) {
				if (visited.get(dependent) == Color.GREY) {
					return true;
				}

				if (visited.get(dependent) == Color.WHITE && checkCycle(visited, g, dependent)) {
					return true;
				}
			}
		}
		visited.put(currentCourse, Color.BLACK);
		return false;
	}
}

package com.my.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import com.my.common.UtilityClass;

public class TopologicalSort {

	/*
	 * If T5 is needed for T4 and T3, there is an edge from T5->T4 and T5->T3 It
	 * means T5 has to occur before T4 and T3. Meaning T5 has to complete between T4
	 * and T3. So at the end T5 should be printed before T4 and T3
	 * 
	 * TODO// Most importantly donot use Stack for DFS traversal. User Recursive DFS
	 * for traversal
	 * 
	 */

	class Graph {
		int v;
		LinkedList<Integer>[] adjList;

		public Graph(int v) {
			this.v = v;
			this.adjList = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int src, int dest) {
			adjList[src].add(dest);
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < v; i++) {
				sb.append(" AdjList[" + i + "]=").append(adjList[i]);
			}
			return "v=" + v + " adList=" + sb.toString();
		}
	}

	public void dfsTraverse(Graph g, boolean[] visited, int src, Stack<Integer> stack) {

		visited[src] = true;
		for (int v : g.adjList[src]) {
			if (visited[v]) {
				continue; 
			}
			dfsTraverse(g, visited, v, stack);
		}
		stack.push(src);
	}

	public ArrayList<Integer> getLexOrder(Graph g) {

		Stack<Integer> stack = new Stack<Integer>();

		boolean[] visited = new boolean[g.v]; 
		//assumption here is there is no deadlock in the given edges

		for (int i = 0; i < g.v; i++) {
			if (visited[i]) {
				continue;
			}
			dfsTraverse(g, visited, i, stack);
		}
		return getResult(stack);
	}

	private ArrayList<Integer> getResult(Stack<Integer> rStack) {
		ArrayList<Integer> tList = new ArrayList<Integer>();
		while (!rStack.isEmpty()) {
			tList.add(rStack.pop());
		}
		return tList;
	}

	public static void main(String[] args) {

		TopologicalSort ts = new TopologicalSort();

		TopologicalSort.Graph g = ts.new Graph(6);

		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Given=" + g);

		System.out.println("Result=" + ts.getLexOrder(g));

	}

}

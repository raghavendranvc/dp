package com.my.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TaskOrder {
	/*
	 * Similar to topological sort.  Task 1
	 * depends on Task 0 There is an edge from Task1->Task0 So Task0 is at the front
	 * of the list to be printed
	 * 
	 * 
	 * 
	 * The edges in this are in reversed order compared to Topological Sort
	 * 
	 * Here if T1 has to be after T0, then there is an edge from T1->T0
	 * 
	 *  //TODO// Most importantly donot use Stack for DFS traversal. User Recursive DFS
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

	public ArrayList<Integer> getTaskOrder(Graph g){
		boolean[] visited = new boolean[g.v];
		Stack<Integer> result = new Stack<Integer>();
		
		for(int i=0;i<g.v;i++) {
			if(visited[i]) {
				continue;
			}
			dfs(visited,i,g,result);
		}
		
		return getResult(result);
	}
	
	private void dfs(boolean[] visited,int src, Graph g, Stack<Integer> result) {
		visited[src] = true;
		
		for(int v: g.adjList[src]) {
			if(visited[v]) {
				continue;
			}
			dfs(visited,src,g,result);
		}
		result.push(src);
		
	}
	
	private ArrayList<Integer> getResult(Stack<Integer> rStack) {
		ArrayList<Integer> tList = new ArrayList<Integer>();
		while (!rStack.isEmpty()) {
			tList.add(rStack.pop());
		}
		return tList;
	}

	public static void main(String[] args) {

		TaskOrder ts = new TaskOrder();

		TaskOrder.Graph g = ts.new Graph(4);

		//[1,0] means 1 depends on 0. So 0 should be printed before 1
		g.addEdge(1, 0); // 1 should be finished before 0. 1 is printed before 0
		g.addEdge(1, 2); // 1 should be finished before 2. 1 is printed before 2
		g.addEdge(3, 2); // 3 should be finished before 2. 3 is printed before 2

		System.out.println("Given=" + g);

		System.out.println("Result=" + ts.getTaskOrder(g));

	}
}

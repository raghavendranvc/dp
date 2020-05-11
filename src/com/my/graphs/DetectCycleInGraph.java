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
		
		Graph (int v){
			this.numOfVertices = v;
			for(int i=0;i<v;i++) {
				adjList[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v){
			adjList[u].add(v);
		}
	}
	
	enum Color{
		WHITE, BLACK, GREY;
	}
	
	
	public boolean detectCycle(Graph g) {
		Color[] visited = new Color[g.numOfVertices];
		
		for(int i=0;i<g.numOfVertices;i++) {
			visited[i] = Color.WHITE;
		}
		
		for(int i=0;i<g.numOfVertices;i++) {
			if(visited[i] == Color.WHITE && isThereACycle(g, visited, i)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean isThereACycle(Graph G, Color[] visited, int start) {
		visited[start] = Color.GREY;
		
		for(int i : G.adjList[start]) {
			if(visited[i] == Color.GREY) {
				return true;
			}
			
			if(visited[i] == Color.WHITE && isThereACycle(G, visited, i)){
				return true;
			}
			
		}
		visited[start] = Color.BLACK;
		return false;
	}

}

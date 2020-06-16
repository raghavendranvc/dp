package com.my.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphTraversals {
	
	int vertices;
	LinkedList<Integer> adjacencyList[];
	
	public GraphTraversals(int vertices) {
		this.vertices = vertices;
		for(int i=0;i< this.vertices;i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}
	
	public void BFS(int source) {
		
		boolean[] visited = new boolean[this.vertices];
		
		LinkedList<Integer> toBeProcessed = new LinkedList<>();
		
		visited[source] = true; //When you see a node for the first time mark it as visited
		toBeProcessed.add(source);
		
		LinkedList<Integer> processedList = new LinkedList<Integer>();
		
		while(!toBeProcessed.isEmpty()) {
			
			int processVertex = toBeProcessed.removeFirst(); 
			//toBeProcessed.poll() // this also works.
			processedList.add(processVertex);
			
			Iterator<Integer> listIterator = adjacencyList[processVertex].iterator();
			while(listIterator.hasNext()) {
				int nextVertex = listIterator.next();
				if(!visited[nextVertex]) { 
					visited[nextVertex] = true; // mark it as visited if this is the first sight of it.
					//toBeProcessed contains vertexes which are already visited. So no need to check them for visit value
					toBeProcessed.add(nextVertex); // add to queue only when it is not visited. 
				}
			}
			
		}
		
		//print processedList . This contains BFS Order
	}
	
	public void DFSIter(int source) {
		Stack<Integer> toBeProcessedStack = new Stack<>();
		
		List<Integer> processedList = new LinkedList<>();
		
		boolean[] visited = new boolean[this.vertices];
		visited[source] = true; 
		toBeProcessedStack.push(source); //We are adding to the stack only those which are visited
		processedList.add(source);
		
		while(!toBeProcessedStack.isEmpty()) {
			int processingVertex = toBeProcessedStack.pop(); 
			
			Iterator<Integer> iterator = adjacencyList[processingVertex].iterator();
			while(iterator.hasNext()) {
				int nVertex = iterator.next();
				if(!visited[nVertex]) {
					toBeProcessedStack.push(nVertex); //newly visited vertex
					visited[nVertex] = true; //Since we saw it we are marking it as visited.
				}
			}	
		}
		
	}
	
	List<Integer> processedList = new LinkedList<Integer>();
	boolean[] visited = new boolean[this.vertices];
	//Call this DFS for all unvisited nodes
	public void DFS(int source) {
		
		visited[source] = true; 
		processedList.add(source);
		
		Iterator<Integer> iterator = this.adjacencyList[source].iterator();
		while(iterator.hasNext()) {
			int nVertex = iterator.next();
			if(!visited[nVertex]) {
				//visited[nVertex] = true;
				DFS(nVertex);
			}		
		}
		
	}
	
}

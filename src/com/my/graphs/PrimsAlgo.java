package com.my.graphs;

import java.util.LinkedList;
import java.util.TreeSet;

public class PrimsAlgo {
	

	/***************VLogV algorithm**************
	 * 
	 */
	
	/*
	 * class Graph{ int v; LinkedList<Integer> adjList[] = null;
	 * 
	 * Graph (int v){ this.v = v; adjList = new LinkedList[v]; for(int i=0;i<v;i++)
	 * { adjList[i] = new LinkedList<Integer>(); } }
	 * 
	 * }
	 */
	
	class EdgeNode {
		int dest;
		int weight;
		EdgeNode(int dest, int weight){
			this.dest = dest;
			this.weight = weight;
			
		}
	}
	
	class Graph{
		int V;
		LinkedList<EdgeNode>[] adjList;
		Graph(int v){
			this.V = v;
			adjList = new LinkedList[v];
			for(int i=0;i<V;i++) {
				adjList[i] = new LinkedList<EdgeNode>();
			}
		}
		
		public void addEdge(int src, int dest, int weight) {
			EdgeNode newNode = new EdgeNode(dest, weight); //If directed only one edge
			adjList[src].add(newNode);
			
			// If undirected graph then create srcNode and add it to dest's adjList
		}
		
	}
	
	class PNode implements Comparable<PNode>{
		int vertex;
		int currentKey;
		
		public int compareTo(PNode a) {
			return (this.currentKey - a.currentKey);
		}	
	}
	
	public int minCost(Graph g) {
		boolean[] includedInPQ = new boolean[g.V]; //initially none are included
		PNode[] pNode = new PNode[g.V];
		
		int[] parent = new int[g.V];
		
		/*
		 * 
		 */
		
		for(int i=0;i<g.V;i++) { pNode[i] = new PNode(); pNode[i].currentKey =
			Integer.MAX_VALUE; pNode[i].vertex=i; 
			parent[i] = -1; //assuming everyone is root initially 	
		}
		
		// Let's include firstNode
		
		pNode[0].currentKey = 0; // When we remove the lowest from PQ, this needs to be extracted first
		
		TreeSet<PNode> pQueue = new TreeSet<PNode>();
		
		PNode firstNode = new PNode();
		firstNode.currentKey = 0;
		firstNode.vertex = 0;
		pQueue.add(firstNode);
		
		includedInPQ[0] = true;
		
		parent[0] = -1;
		
		for(int i=1;i<g.V;i++) {
			//We can also construct everything here
			PNode newNode = new PNode();
			newNode.currentKey = Integer.MAX_VALUE;
			newNode.vertex=i;
			pQueue.add(newNode);
			parent[i] = -1;
		}
		
		while(!pQueue.isEmpty()) {
			PNode minNode = pQueue.pollFirst();
			includedInPQ[minNode.vertex] = true;
			
			for(EdgeNode neighbour : g.adjList[minNode.vertex]) {
				PNode destNodePNode = pNode[neighbour.dest];
				if(!includedInPQ[neighbour.dest] && destNodePNode.currentKey > neighbour.weight) {
					// Removing, resetting the key and adding back: This will do re-heapify and will update the heap accordingly
					// We do not have an operation to-re heapify from the node where we changed the value
					pQueue.remove(destNodePNode);	
					destNodePNode.currentKey = neighbour.weight;
					pQueue.add(destNodePNode);	
					
					parent[destNodePNode.vertex] = minNode.vertex;
				}	
			}
		}
		
		int minCost=0;
		for(int i=1;i<parent.length;i++) {
			minCost += g.adjList[parent[i]].get(i).weight;
		}
		
		return minCost;
		
	}
	
	
	
	/****************V^2 algorithm****************
	 *  
	 *  For all vertices that are not included , keep a set where we 
	 *  will compute the min distance reachable from the computed graph
	 *  
	 *  Means that if a vertex is included in the graph, the value
	 *  of it will be 0
	 */
	
	private int getMinCostVertexFromTheGraph(int[] minCostComputedForVertices, boolean[] verticesAlreadyVisited) {
		int minVertex = -1;
		int minCost = Integer.MAX_VALUE;
		
		for(int i=0;i<minCostComputedForVertices.length;i++) {
			if(verticesAlreadyVisited[i]) {
				continue;
			}
			
			if(minCost > minCostComputedForVertices[i]) {
				minCost = minCostComputedForVertices[i];
				minVertex = i;
			}
		}
		return minVertex;
	}
	
	public int findMinCostTreeAdjMatrixOptimised(int[][] costMatrix) {
		int numOfVertices = costMatrix.length;
		
		int[] minCostComputedForVertices = new int[numOfVertices];
		int[] parent = new int[numOfVertices];
		
		boolean[] verticesAlreadyVisited = new boolean[numOfVertices];
		
		for(int i=0;i<numOfVertices;i++) {
			minCostComputedForVertices[i] = Integer.MAX_VALUE;
		}
		
		//Pick the first vertex
		// And since this is the first vertex included, it's cost becomes zero
		parent[0] = -1; //parent of first vertex is always -1;
		
		//making this value 0 will force us to pick this vertix as the first vertix to
		// be included
		minCostComputedForVertices[0] = 0;
		
		for(int edge=0;edge<numOfVertices-1;edge++) {
			
			/**
			 * The  below always tries to find the next vertex 
			 * The function makes sure that the vertex was not already included
			 * The function also makes sure that this vertx is the minimum cost vertex
			 * reachable from the prepared graph of already selected vertices
			 * It is included in the graph.
			 */
			
			int minCostVertex = getMinCostVertexFromTheGraph(minCostComputedForVertices, verticesAlreadyVisited);
			
			verticesAlreadyVisited[0]=true;
			
			/*
			 * We now will try to re-compute the information needed 
			 * Since we have included the vertex in the graph, we
			 * will have to recompute the minCost reachable from the existing MST to
			 * each of the vertex
			 */
			
			for(int j=0;j<numOfVertices;j++) {
				/**
				 * The vertex should not be the same vertex
				 * The vertex should be reachable meaning cost is not MAX_INT
				 * The vertex cost should then 
				 */
				if(minCostVertex != j && costMatrix[minCostVertex][j] < Integer.MAX_VALUE // This check that there is an edge
						&& !verticesAlreadyVisited[j]  //vertex is a new vertex
								&& costMatrix[minCostVertex][j] < minCostComputedForVertices[j]) { // there is a new computation
					minCostComputedForVertices[j] = costMatrix[minCostVertex][j];
					parent[j] = minCostVertex; //now this becomes the parent as we computed it
				}
				
			}
				
		}
		
		int minCost=0;
		for(int i=1;i<parent.length;i++) {
			minCost += costMatrix[parent[i]][i];
		}
		
		return minCost;
		
	}
	
	
	/*******************V^3 algorithm*****
		Below is based on Adjacency Matrix.
		Runs in V^3 algorithm
	 */
	
	public boolean isValidEdge(int i, int j, boolean[] verticesIncluded) {
		if( i == j) {
			return false;
		}
		
		if(verticesIncluded[i] && verticesIncluded[j]) {
			return false;
		}
		
		if(!verticesIncluded[i] && !verticesIncluded[j]) {
			return false;
		}
		return true;
	}
	
	
	public int findMinCostTreeAdjMatrix(int[][] costMatrix) {
		int numOfVertices = costMatrix.length;
		boolean[] verticesIncluded = new boolean[numOfVertices];
		
		int edgeCount = 0;
		int minCost = 0;
		
		while (edgeCount < numOfVertices-1) {
			
			int minCostFound = Integer.MAX_VALUE;
			int start = -1, end = -1;
			for(int i=0;i<numOfVertices;i++) {
				for(int j=0;j<numOfVertices;j++) {
					if(costMatrix[i][j] < minCostFound) {
						 if(isValidEdge(i,j,verticesIncluded)) {
							 minCostFound = costMatrix[i][j];
							 start = i;
							 end = j;
						 }	
					}
				}
				
			}
			
			if(start != -1 && end != -1) {
				verticesIncluded[start] = true;
				verticesIncluded[end] = true;
				minCost += minCostFound;
			}
			
		}
		
		return minCost;
		
	}
	

}

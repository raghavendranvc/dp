package com.my.graphs;

public class ShortestPathBellmonFord {
	
	private static final int MAXV = 100;
	private static final int MAX_INT = 99999;
	
	/*class EdgeNode{
		int y;
		int weight;
		EdgeNode next; 
	}
	
	class Graph{
		int numOfVertices;
		int numOfEdges;
		
		EdgeNode[] edges = new EdgeNode[MAXV];
		
	}
	
	public void getShortestPath(Graph g,int start){
		int[] dist = new int[g.numOfVertices];
		boolean[] traversed = new boolean[g.numOfVertices];
		
		for(int i=0;i<g.numOfEdges;i++){
			dist[i] = MAX_INT;
			traversed[i]=false;
		}
		
		dist[start] = 0;
		traversed[start] = true;
		
		int v = start;
		
		while(!traversed[v]){
			traversed[v] = true;
			
			EdgeNode p = g.edges[v];
			
		}
		
		
	}*/
	
	class Edge{
		int src;
		int dest;
		int weight;
	}
	
	class Graph{
		int numOfVertices;
		int numOfEdges;
		Edge[] edges = new Edge[MAXV];
	}
	
	public void getShortestPath(Graph g,int start){
		int[] dist = new int[g.numOfVertices];
//		boolean[] traversed = new boolean[g.numOfVertices];
		
		for(int i=0;i<g.numOfVertices;i++){
			dist[i] = MAX_INT;
		//	traversed[i] = false;
		}
		
		dist[start] = 0;
		
		for(int i=0;i<g.numOfVertices;i++){
			for(int j=0;j<g.numOfEdges;j++){
				Edge tmpEdge = g.edges[j];
				int tmpDist = dist[tmpEdge.src]+tmpEdge.weight;
				if(dist[tmpEdge.dest] > tmpDist){
					dist[i] = tmpDist;
				}
			}
		}
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

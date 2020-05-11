package com.my.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import com.my.common.UtilityClass;

public class IslandsBridges {
	
	class BridgeNode {
		int dest;
		int cost;
		BridgeNode(int dest, int cost){
			this.dest = dest;
			this.cost = cost;
		}
		public String toString() {
			return "dest="+dest+" weight="+cost;
		}
	}
	
	class Graph {
		int V;
		LinkedList<BridgeNode>[] edges = null;
		Graph(int v){
			this.V = v;
			edges = new LinkedList[v];
			for(int i=0;i<v;i++) {
				edges[i] = new LinkedList<BridgeNode>();
			}
		}
		
		void addEdge(int src, int dest, int weight) {
			edges[src].add(new BridgeNode(dest, weight));
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<edges.length;i++) {
				sb.append(i).append("=").append(edges[i]);
			}
			return "V="+V+" edgesList="+sb.toString();
		}
	}
	
	class PNode implements Comparable<PNode>{
		int vertex;
		int value;
		public int compareTo(PNode p) {
			return this.value-p.value;
		}
	}
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		//System.out.println("Array graph="+B);
		int v = A;
		Graph g = new Graph(v);
		for(int i=0;i<v;i++) {
			ArrayList<Integer> aList = B.get(i);
			g.addEdge(aList.get(0)-1, aList.get(1)-1, aList.get(2));
		}
		
		System.out.println("Given graph="+g);
		PNode[] pNode = new PNode[v];
		int[] parent = new int[v];
		
		for(int i=0;i<v;i++) {
			pNode[i] = new PNode();
			pNode[i].vertex = i;
			pNode[i].value = Integer.MAX_VALUE;
			parent[i] = -1;
			
		}
		
		pNode[0].vertex = 0;
		parent[0] = -1;
		
		TreeSet<PNode> pQueue = new TreeSet<PNode>();
		for(int i=0;i<v;i++) {
			pQueue.add(pNode[i]);
		}
		
		boolean[] toBeProcessed = new boolean[v];
		
		
		while(!pQueue.isEmpty()) {
			PNode minNode = pQueue.pollFirst();
			
			toBeProcessed[minNode.vertex]=true;
			
			for(BridgeNode edge : g.edges[minNode.vertex]) {
				
				/*
				 * if(pNode.length >= edge.dest ) { break; }
				 */
				
				PNode destNode = pNode[edge.dest-1];
				
				if(!toBeProcessed[edge.dest-1] && destNode.value > edge.cost) {
					
					pQueue.remove(destNode);
					destNode.value = edge.cost; 
					pQueue.add(destNode);
					
					parent[destNode.vertex] = minNode.vertex;	
				}
			}
			
		}
		
		//UtilityClass.print(parent);
		
		int minCost = 0;
		for(int i=0;i<v;i++) {
			if(parent[i] == -1 ) {
				continue;
			}
			LinkedList<BridgeNode> adjList = g.edges[parent[i]];
			for(BridgeNode b : adjList) {
				if(b.dest == i) {
					minCost += b.cost;
					break;
				}
			}
		}
		
		return minCost;
	}
	
	public static void main(String[] args) {
		
		/*
		 * int[][] matrix = { {1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3} };
		 */
		
		int[][] matrix = { {1,2,5}};
		
		ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
		for(int i=0;i<matrix.length;i++) {
			ArrayList<Integer> edge = new ArrayList<Integer>();
			edge.add(matrix[i][0]);
			edge.add(matrix[i][1]);
			edge.add(matrix[i][2]);
			aList.add(edge);
		}
		
		IslandsBridges islandsBridges = new IslandsBridges();
		System.out.println("minCost="+islandsBridges.solve(matrix.length, aList));
		
	}
	
	
	class Bridge implements Comparable<Bridge>{
		int start;
		int end;
		int cost;
		public Bridge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override 
		public int compareTo(Bridge bridge) {
			return this.cost - bridge.cost;
		}
		
	}
	
	public int solveNotDone(int A, ArrayList<ArrayList<Integer>> B) {
		/*
		 * A is islands
		 * B[i] contains bridge1 connected between islands of B[i][0] <-> B[i][1] with cost B[i][2]
		 */
		
		/*
		 * We shall use Prim's algorithm
		 */
		
		/*
		 * prepare the list of edges with minimum cost
		 * Priority Queue will be the right DS
		 * 
		 */
		
		/*
		 * 2 Disjoint sets coveredVertices, unCoveredVertices
		 * 
		 */
		
		
		
		PriorityQueue<Bridge> pList = new PriorityQueue<Bridge>();
		Set<Integer> coveredVertices = new HashSet<Integer>();
		
		for(ArrayList<Integer> bridge : B) {
			pList.add(new Bridge(bridge.get(0), bridge.get(1), bridge.get(2)));
			//coveredVertices.add(bridge.get(0));
			//coveredVertices.add(bridge.get(1));
		}
		
		
		int minimumCost = 0;
		while(!pList.isEmpty()) {
			
			Bridge b = pList.poll();
			/*
			 * If both vertices are covered, then any new edge between them creates a circle
			 * So we will discard it
			 */
			if(coveredVertices.contains(b.start) && coveredVertices.contains(b.end)) {
				continue;
			}
			
			/**
			 * We now safely add both.
			 */
			if(!coveredVertices.contains(b.start)) {
				coveredVertices.add(b.start);
			}
			
			if(coveredVertices.add(b.end)) {
				coveredVertices.add(b.end);
			}
			
			minimumCost = minimumCost+b.cost;
			
			if(coveredVertices.size() == A) {
				break;
			}
			
			
			
		}
		
		return minimumCost;
		
    }

}

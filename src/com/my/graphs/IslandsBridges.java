package com.my.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import com.my.common.UtilityClass;

public class IslandsBridges {

	/*
	 * 
	 * class Graph { int V; LinkedList<BridgeNode>[] edges = null;
	 * 
	 * Graph(int v) { this.V = v; edges = new LinkedList[v]; for (int i = 0; i < v;
	 * i++) { edges[i] = new LinkedList<BridgeNode>(); } }
	 * 
	 * void addEdge(int src, int dest, int weight) { edges[src].add(new
	 * BridgeNode(dest, weight)); }
	 * 
	 * public String toString() { StringBuilder sb = new StringBuilder(); for (int i
	 * = 0; i < edges.length; i++) { sb.append(i).append("=").append(edges[i]); }
	 * return "V=" + V + " edgesList=" + sb.toString(); } }
	 * 
	 * class PNode implements Comparable<PNode> { int vertex; int value;
	 * 
	 * public int compareTo(PNode p) { return this.value - p.value; } }
	 * 
	 * public int solve(int A, ArrayList<ArrayList<Integer>> B) { //
	 * System.out.println("Array graph="+B); int v = A; Graph g = new Graph(v); for
	 * (int i = 0; i < v; i++) { ArrayList<Integer> aList = B.get(i);
	 * g.addEdge(aList.get(0) - 1, aList.get(1) - 1, aList.get(2)); }
	 * 
	 * System.out.println("Given graph=" + g); PNode[] pNode = new PNode[v]; int[]
	 * parent = new int[v];
	 * 
	 * for (int i = 0; i < v; i++) { pNode[i] = new PNode(); pNode[i].vertex = i;
	 * pNode[i].value = Integer.MAX_VALUE; parent[i] = -1;
	 * 
	 * }
	 * 
	 * pNode[0].vertex = 0; parent[0] = -1;
	 * 
	 * TreeSet<PNode> pQueue = new TreeSet<PNode>(); for (int i = 0; i < v; i++) {
	 * pQueue.add(pNode[i]); }
	 * 
	 * boolean[] toBeProcessed = new boolean[v];
	 * 
	 * while (!pQueue.isEmpty()) { PNode minNode = pQueue.pollFirst();
	 * 
	 * toBeProcessed[minNode.vertex] = true;
	 * 
	 * for (BridgeNode edge : g.edges[minNode.vertex]) {
	 * 
	 * //if(pNode.length >= edge.dest ) { break; }
	 * 
	 * 
	 * PNode destNode = pNode[edge.dest - 1];
	 * 
	 * if (!toBeProcessed[edge.dest - 1] && destNode.value > edge.cost) {
	 * 
	 * pQueue.remove(destNode); destNode.value = edge.cost; pQueue.add(destNode);
	 * 
	 * parent[destNode.vertex] = minNode.vertex; } }
	 * 
	 * }
	 * 
	 * // UtilityClass.print(parent);
	 * 
	 * int minCost = 0; for (int i = 0; i < v; i++) { if (parent[i] == -1) {
	 * continue; } LinkedList<BridgeNode> adjList = g.edges[parent[i]]; for
	 * (BridgeNode b : adjList) { if (b.dest == i) { minCost += b.cost; break; } } }
	 * 
	 * return minCost; }
	 */

	public static void main(String[] args) {

		/* int[][] matrix = { { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 4 }, { 1, 4, 3 } }; */

		int[][] matrix = { { 1, 2, 10 }, { 2, 3, 5 }, { 1, 3, 9 } };

		// 0 1 10
		// 0 2 5
		// 1 2 9

		/* int[][] matrix = { { 1, 2, 5 } }; */

		ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			ArrayList<Integer> edge = new ArrayList<Integer>();
			edge.add(matrix[i][0]);
			edge.add(matrix[i][1]);
			edge.add(matrix[i][2]);
			aList.add(edge);
		}

		IslandsBridges islandsBridges = new IslandsBridges();
		System.out.println("minCost=" + islandsBridges.solve(matrix.length, matrix));

	}

	class Bridge implements Comparable<Bridge> {
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
		 * A is islands B[i] contains bridge1 connected between islands of B[i][0] <->
		 * B[i][1] with cost B[i][2]
		 */

		/*
		 * We shall use Prim's algorithm
		 */

		/*
		 * prepare the list of edges with minimum cost Priority Queue will be the right
		 * DS
		 * 
		 */

		/*
		 * 2 Disjoint sets coveredVertices, unCoveredVertices
		 * 
		 */

		PriorityQueue<Bridge> pList = new PriorityQueue<Bridge>();
		Set<Integer> coveredVertices = new HashSet<Integer>();

		for (ArrayList<Integer> bridge : B) {
			pList.add(new Bridge(bridge.get(0), bridge.get(1), bridge.get(2)));
			// coveredVertices.add(bridge.get(0));
			// coveredVertices.add(bridge.get(1));
		}

		int minimumCost = 0;
		while (!pList.isEmpty()) {

			Bridge b = pList.poll();
			/*
			 * If both vertices are covered, then any new edge between them creates a circle
			 * So we will discard it
			 */
			if (coveredVertices.contains(b.start) && coveredVertices.contains(b.end)) {
				continue;
			}

			/**
			 * We now safely add both.
			 */
			if (!coveredVertices.contains(b.start)) {
				coveredVertices.add(b.start);
			}

			if (coveredVertices.add(b.end)) {
				coveredVertices.add(b.end);
			}

			minimumCost = minimumCost + b.cost;

			if (coveredVertices.size() == A) {
				break;
			}

		}

		return minimumCost;

	}

	/*
	 * // A islands // B is the cost matric of the bridge between 2 islands
	 * 
	 * 1.
	 * 
	 * Prepare all adjacencyList src List<Bridge(dest,cost)>
	 * 
	 * 2. We shall employ MST
	 * 
	 * 3. We shall prepare a PQ that contains the distances of all verties which are
	 * not in MST from any node is MST 1) All vertices are added to priorityQueue
	 * with distance as MAX So we end up preparing a temporayNode that contain
	 * vertex distnaceFromMST 2) We shall have a visisted array intialised to false
	 * for all 3) We shall have parent array initialised to -1 for all
	 * 
	 * 1) We shall remove the
	 * 
	 * lowest one (it might pick anyone for the first time) 2) So we mark this as
	 * visited for each Bridge of src we update the PQ with the new distance if we
	 * find that the distance is updated, then we shall updated the parent to this
	 * lowest node 3) Loop until PQ is empty
	 * 
	 * 4. We shall loop for all edges We know the parentNode for each Node . for for
	 * each src = parentNode and dest = node then minMSTCost is incremented
	 * 
	 * return minMSTCost
	 */

	public class BridgeNode {
		int dest;
		int cost;

		BridgeNode(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		public String toString() {
			return "dest=" + dest + " weight=" + cost;
		}
	}

	public class IBGraph {
		int numOfIslands;
		LinkedList<BridgeNode> islands[] = null;

		IBGraph(int v) {
			this.numOfIslands = v;
			islands = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				islands[i] = new LinkedList<BridgeNode>();
			}
		}

		void addEdge(int src, int dest, int cost) {
			islands[src - 1].add(new BridgeNode(dest - 1, cost));
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < islands.length; i++) {
				sb.append(i).append("=").append(islands[i]);
			}
			return "numOfIslands=" + numOfIslands + " edgesList=" + sb.toString();
		}
	}

	public class PNode { // implements Comparable<PNode> {
		int vertex;
		int distanceFromMST;

		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			PNode otherPNode = (PNode) o;
			return (this.vertex == otherPNode.vertex);

		}

		/*
		 * public int compareTo(PNode other) { return (this.distanceFromMST -
		 * other.distanceFromMST); }
		 */

		public String toString() {
			return "{vertex=" + vertex + " distanceFromMST=" + distanceFromMST + "}";
		}

	}

	class PNodeComparator implements Comparator<PNode> {

		@Override
		public int compare(PNode node0, PNode node1) {
			return node0.distanceFromMST - node1.distanceFromMST;
		}
	}

	public int solve(int A, int[][] B) {
		if (A <= 0 || B == null || B == null || B[0].length == 0) {
			return -1;
		}

		/*
		 * int minCostBridge = Integer.MAX_VALUE; int minCostBridgeSrc = -1;
		 */
		IBGraph g = new IBGraph(A);
		for (int i = 0; i < B.length; i++) {
			g.addEdge(B[i][0], B[i][1], B[i][2]);
			g.addEdge(B[i][1], B[i][0], B[i][2]);
			/*
			 * if (minCostBridge > B[i][2]) { minCostBridge = B[i][2]; minCostBridgeSrc =
			 * B[i][0] - 1; }
			 */
		}

		//System.out.println("Given graph=" + g);

		int[] parent = new int[A];
		boolean[] visited = new boolean[A];

		PNode[] pNodes = new PNode[A];
		for (int i = 0; i < A; i++) {
			parent[i] = -1;
			pNodes[i] = new PNode();
			pNodes[i].vertex = i;
			pNodes[i].distanceFromMST = Integer.MAX_VALUE;
		}
		//UtilityClass.print(parent);
		/*
		 * for (PNode p : pNodes) { System.out.println("pNode=" + p); }
		 */

		pNodes[0].distanceFromMST = 0; // This forces to pick up first brirdge src vertex
		// pNodes[minCostBridgeSrc].distanceFromMST = 0;

		PriorityQueue<PNode> pq = new PriorityQueue<PNode>(new PNodeComparator());
		for (int i = 0; i < A; i++) {
			//System.out.println("Adding Node=" + pNodes[i]);
			pq.add(pNodes[i]);
		}
		//System.out.println("All Nodes=" + pq);

		while (!pq.isEmpty()) {
			PNode nearestNode = pq.poll();
			//System.out.println("NearestNode=" + nearestNode);
			visited[nearestNode.vertex] = true;
			//UtilityClass.print(visited);

			for (BridgeNode d : g.islands[nearestNode.vertex]) {
				// We shall update d.dest cost
				//System.out.println("Considering bridge:" + d);
				if (visited[d.dest]) {
					continue;
				}

				if (pNodes[d.dest].distanceFromMST <= d.cost) {
					continue;
				}
				// We need to set the new cost
				// First remove and set it. If we set it directly, PQ will not be updated

				pq.remove(pNodes[d.dest]);
				pNodes[d.dest].distanceFromMST = d.cost;
				pq.add(pNodes[d.dest]);

				parent[d.dest] = nearestNode.vertex;

				/*
				 * for (PNode p : pNodes) { System.out.println("pNode=" + p); }
				 */

			}
			//UtilityClass.print(parent);
			//System.out.println("---------------------");
		}

		int minCost = 0;
		for (int i = 0; i < A; i++) {
			if (parent[i] == -1) {
				continue;
			}
			for (BridgeNode dest : g.islands[parent[i]]) {
				if (dest.dest == i) {
					minCost += dest.cost;
					break;
				}
			}
		}

		return minCost;

	}

}

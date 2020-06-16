package com.my.graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class IslandsBridges {

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
		if (A <= 0 || B == null || B.length == 0 || B[0].length == 0) {
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

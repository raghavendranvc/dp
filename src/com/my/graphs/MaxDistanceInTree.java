package com.my.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.my.common.UtilityClass;

public class MaxDistanceInTree {
	
	//---------------------One way--------------------------------------------

	class Node {
		int val;
		List<Node> children;
		int height;
		int dist;

		Node(int val) {
			this.val = val;
			this.height = -1;
			children = new LinkedList<>();
			this.dist = -1;
		}

		void addChild(Node childNode) {
			children.add(childNode);
		}

		public String toString() {
			return "val=" + val + " {children=" + children + "}";
		}
	}

	private Node prepareTree(ArrayList<Integer> A) {
		Map<Integer, Node> map = new HashMap<>();
		Node root = null;
		int n = A.size();
		for (int i = 0; i < n; i++) {
			if (A.get(i) == -1) {
				root = new Node(i);
				map.put(i, root);
			} else {
				Node parentNode = map.get(A.get(i));
				Node tempNode = new Node(i);
				parentNode.addChild(tempNode);
				map.put(i, tempNode);
			}
		}
		System.out.println("Root::" + root);
		return root;
	}

	public int solve(ArrayList<Integer> A) {
		Node root = prepareTree(A);
		return maxDist(root);
	}

	public int maxDist(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.dist != -1) {
			return root.dist;
		}

		if (root.children.isEmpty()) {
			root.dist = 0;
			return 0;
		}

		List<Integer> heights = new ArrayList<Integer>();
		for (Node c : root.children) {
			heights.add(height(c));
		}
		Collections.sort(heights, Collections.reverseOrder());

		int maxEdges = heights.get(0);
		if (heights.size() > 1) {
			maxEdges += heights.get(1);
		}

		System.out.println("heights=" + heights + " Max Distance at " + root.val + " with depths alone =" + maxEdges);

		for (Node n : root.children) {
			maxEdges = Math.max(maxEdges, maxDist(n));
		}
		System.out.println("Final Max Distance at " + root.val + " is =" + maxEdges);

		root.dist = maxEdges;
		// return (maxDepth-root.depth) - (secondDepth-root.depth);
		return maxEdges;
	}

	public int height(Node n) {

		if (n.height != -1) {
			return n.height;
		}

		if (n.children.isEmpty()) {
			n.height = 1;
		} else {
			int ht = 0;
			for (Node c : n.children) {
				ht = Math.max(ht, height(c));
			}
			n.height = ht + 1;
		}
		return n.height;
	}

	
	//---------------------One way But needs to be understood well-------------------------------------------
	
	public int solveSimple(ArrayList<Integer> A) {
		List<int[]> arr = new ArrayList<>();
		for (int i = 0; i < A.size(); ++i) {
			arr.add(new int[2]);
		}
		int maxDistance = 0;
		for (int i = A.size() - 1; i > 0; --i) {
			int element = A.get(i);
			int[] parent = arr.get(element);
			int currentLength = arr.get(i)[0] + 1;

			parent[1] = Math.max(parent[1], currentLength + parent[0]);

			parent[0] = Math.max(parent[0], currentLength);

			maxDistance = Math.max(maxDistance, parent[1]);
		}
		return maxDistance == 0 ? 0 : maxDistance;
	}
	
	
	//---------------------One way--------------------------------------------

	public int solveUsingDFS(ArrayList<Integer> A) {
		int n = A.size();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int root = -1;
		for (int i = 0; i < n; i++) {
			int num = A.get(i);
			if (num == -1) {
				root = i;
				continue;
			}
			graph.get(i).add(num);//Edge between both parent and child
			graph.get(num).add(i);
		}
		// Find the node which is farthest from root node using BFS
		int node = bfs(graph, n, root);
		// Find the maximum distance from farthest node using modified DFS
		return dfs(graph, n, node);
	}

	public int bfs(ArrayList<ArrayList<Integer>> graph, int n, int u) {
		boolean[] vis = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while (!q.isEmpty()) {
			// stores the farthest node from root node
			u = q.remove();
			if (!vis[u]) {
				vis[u] = true;
				for (Integer v : graph.get(u)) {
					if (!vis[v]) {
						q.add(v);
					}
				}
			}
		}
		return u;
	}

	public int dfs(ArrayList<ArrayList<Integer>> graph, int n, int u) {
		int max = 0;
		Stack<Integer> node = new Stack<Integer>();
		Stack<Integer> dist = new Stack<Integer>();
		boolean[] vis = new boolean[n];
		node.push(u);
		dist.push(0);
		while (!node.isEmpty()) {
			u = node.pop();
			int d = dist.pop();
			if (!vis[u]) {
				vis[u] = true;
				for (Integer v : graph.get(u)) {
					if (!vis[v]) {
						max = Math.max(max, d + 1);
						node.push(v);
						dist.push(d + 1);
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = { -1, 0, 0, 0, 3 };
		ArrayList<Integer> A = UtilityClass.getList(a);
		MaxDistanceInTree maxDistanceInTree = new MaxDistanceInTree();
		System.out.println("value=" + maxDistanceInTree.solve(A));
	}
	
	//---------------------Practice of DFS and BFS--------------------------------------------

	public int solve(int[] A) {

		int n = A.length;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		int root = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == -1) {
				root = i;
			} else {
				graph.get(A[i]).add(i); //parent to child (child is added as adjacentNode to parent)
				graph.get(i).add(A[i]); // backNode so that it is undirected graph
				// and we can do dfs to get to the deepest node
			}
		}

		int v = bfsToGetFarthestNodeFromRoot(graph, n, root);
		int u = dfsToGetLongestDistance(graph, n, v);

		return u;
	}

	private int bfsToGetFarthestNodeFromRoot(ArrayList<ArrayList<Integer>> graph, int n, int root) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[root] = true;
		queue.add(root);

		int p = -1;
		while (!queue.isEmpty()) {
			p = queue.remove();

			for (int neighbour : graph.get(p)) {
				if (visited[neighbour]) {
					continue;
				}
				visited[neighbour] = true;
				queue.add(neighbour);
			}
		}
		return p; // which will the last node
	}

	private int dfsToGetLongestDistance(ArrayList<ArrayList<Integer>> graph, int n, int root) {
		boolean[] visited = new boolean[n];
		int max = 0;

		//We can use one single stack with Node and distance as pair
		// 'n' node is the farthest node from root.
		// a dfs from 'n' will find the farthest node from it. 
		// This distance will be the largest distance
		Stack<Integer> nodesStack = new Stack<Integer>();
		Stack<Integer> distance = new Stack<Integer>();

		visited[root] = true;
		nodesStack.add(root);
		distance.add(0);

		while (!nodesStack.isEmpty()) {
			int u = nodesStack.pop();
			int d = distance.pop();
			
			for (int neighbour : graph.get(u)) {
				if (visited[neighbour]) {
					continue;
				}
				visited[neighbour] = true;
				max = Math.max(max, d + 1);
				nodesStack.push(neighbour);
				distance.push(d + 1);
			}
		}
		return max;
	}

}

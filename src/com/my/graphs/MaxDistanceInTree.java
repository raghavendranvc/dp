package com.my.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.my.common.UtilityClass;

public class MaxDistanceInTree {

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
			return "val="+val+" {children="+children+"}";
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
		System.out.println("Root::"+root);
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
		
		if(root.dist != -1) {
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
		if(heights.size()>1) {
			maxEdges += heights.get(1);
		}
		
		System.out.println("heights="+heights+" Max Distance at "+ root.val +" with depths alone ="+maxEdges);
		
		for(Node n: root.children) {
			maxEdges = Math.max(maxEdges, maxDist(n));
		}
		System.out.println("Final Max Distance at "+ root.val +" is ="+maxEdges);
		
		root.dist=maxEdges;
		// return (maxDepth-root.depth) - (secondDepth-root.depth);
		return maxEdges;
	}
	
	public int height(Node n) {
		
		if(n.height != -1) {
			return n.height;
		}
		
		if(n.children.isEmpty()) {
			n.height=1;
		} else {
			int ht = 0;
			for(Node c : n.children) {
				ht = Math.max(ht, height(c));
			}
			n.height=ht+1;
		}
		return n.height;
	}

	public static void main(String[] args) {
		int[] a = {-1, 0, 0, 0, 3};
		ArrayList<Integer> A = UtilityClass.getList(a);
		MaxDistanceInTree maxDistanceInTree = new MaxDistanceInTree();
		System.out.println("value="+maxDistanceInTree.solve(A));
	}
	
}

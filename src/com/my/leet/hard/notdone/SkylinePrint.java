package com.my.leet.hard.notdone;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SkylinePrint {

	// https://leetcode.com/problems/the-skyline-problem/
	// https://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/
	/*
	 * This problem is essentially a problem of processing 2*n edges. Each edge has
	 * a x-axis value and a height value. The key part is how to use the height heap
	 * to process each edge.
	 */

	// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/218-the-skyline-problem.html

	private class Node implements Comparable<Node> {
		private int x;
		private int height;

		public Node(int x, int height) {
			this.x = x;
			this.height = height;
		}

		public int compareTo(Node n) {
			if (this.x != n.x) {
				return this.x - n.x;
			} else {
				return n.height - this.height;
			}
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> result = new LinkedList<int[]>();
		if (buildings == null || buildings.length == 0) {
			return result;
		}

		List<Node> bds = new LinkedList<Node>();
		for (int i = 0; i < buildings.length; i++) {
			bds.add(new Node(buildings[i][0], buildings[i][2]));
			bds.add(new Node(buildings[i][1], -buildings[i][2])); // ??
		}
		Collections.sort(bds);

		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		q.add(0);

		int preHeight = 0;
		for (Node w : bds) {
			if (w.height > 0) {
				q.add(w.height);
			} else {
				q.remove((Integer) (-w.height));
			}
			int maxHeight = q.peek();
			if (preHeight != maxHeight) {
				result.add(new int[] { w.x, maxHeight });
			}
			preHeight = maxHeight;
		}
		return result;
	}

}

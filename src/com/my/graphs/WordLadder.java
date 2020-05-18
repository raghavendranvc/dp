package com.my.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.my.common.UtilityClass;

public class WordLadder {

	class WordNode {
		String word;
		List<WordNode> neighbours;

		WordNode(String word) {
			this.word = word;
			neighbours = new ArrayList<WordNode>();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (WordNode w : neighbours) {
				sb.append(w.word + " ");
			}
			return word + "=#" + sb.toString() + "#";
		}
	}

	public int solve(String A, String B, ArrayList<String> C) {

		if (A == null || B == null) {
			return 0;
		}

		if (A.equals(B)) {
			return 0;
		}

		if (C == null || C.isEmpty() || C.size() < 2) {
			return -1;
		}

		C.add(A);
		C.add(B);

		int V = C.size();
		Map<String, WordNode> wordsMap = new HashMap<>();

		for (String s : C) {
			wordsMap.put(s, new WordNode(s));
		}

		formEdges(V, wordsMap, C);
		System.out.println("Map=" + wordsMap);

		return getShortestPath(wordsMap.get(A), wordsMap.get(B));
	}

	private int getShortestPath(WordNode src, WordNode dest) {

		// BFS would work?

		Set<WordNode> visited = new HashSet<WordNode>();
		Queue<WordNode> queue = new LinkedList<WordNode>();

		int dist = 0;
		queue.add(src);

		while (!queue.isEmpty()) {

			WordNode s = queue.remove();
			dist++;
			for (WordNode neigh : s.neighbours) {

				// same reference object will return true. This should suffice for us
				if (neigh.equals(dest)) {
					System.out.println("found at dist=" + dist);
					return dist;
				}
				if (visited.contains(neigh)) {
					continue;
				}
				visited.add(neigh);
				queue.add(neigh);
			}

			System.out.println("Level" + dist + " Next Queue=" + queue);
		}

		return -1;
	}

	private void formEdges(int V, Map<String, WordNode> wordsMap, ArrayList<String> C) {
		for (int i = 0; i < V; i++) {
			for (int j = i + 1; j < V; j++) {
				if (isThereEdge(C.get(i), C.get(j))) {
					WordNode s1 = wordsMap.get(C.get(i));
					WordNode s2 = wordsMap.get(C.get(j));
					s1.neighbours.add(s2);
					s2.neighbours.add(s1);
				}
			}
		}
	}

	private boolean isThereEdge(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		/*
		 * String A ="hit"; String B = "log"; String[] s = {"hot", "dot", "dog", "lot",
		 * "cog"};
		 */

		/*
		 * String A ="ymain"; String B = "oecij"; String[] s = {"ymann", "yycrj",
		 * "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj",
		 * "ymain"};
		 */

		String A = "sgtra";
		String B = "plvgf";
		String[] s = { "pjvgf", "pgtra", "pglga", "pgwra", "pgggf", "pglra", "ppggf", "ppvgf", "pggga", "sgtra",
				"plvgf" };

		ArrayList<String> C = UtilityClass.getList(s);
		WordLadder wordLadder = new WordLadder();
		System.out.println("shortestPath=" + wordLadder.solve(A, B, C));

	}


}

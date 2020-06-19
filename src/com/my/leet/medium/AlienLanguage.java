package com.my.leet.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienLanguage {

	/*
	 * There is a new alien language which uses the latin alphabet. However, the
	 * order among letters are unknown to you. You receive a list of words from the
	 * dictionary, where words are sorted lexicographically by the rules of this new
	 * language. Derive the order of letters in this language.
	 * 
	 * 
	 * For example, Given the following words in dictionary,
	 * 
	 * 
	 * [ "wrt", "wrf", "er", "ett", "rftt" ]
	 * 
	 * w r t f e
	 * 
	 * 
	 * 
	 * The correct order is: "wertf".
	 * 
	 * Note:
	 * 
	 * You may assume all letters are in lowercase.
	 * 
	 * If the order is invalid, return an empty string.
	 * 
	 * There may be multiple valid order of letters, return any one of them is fine.
	 */

	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		Map<Character, Integer> indegrees = new HashMap<>();

		buildGraph(words, graph, indegrees);
		String order = getLexicographicOrder(indegrees, graph);

		if (order.length() == graph.size()) {
			return order;
		} else {
			return ""; // INVALID
		}

	}

	private void buildGraph(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegrees) {
		for (String s : words) {
			for (char c : s.toCharArray()) {
				if (!graph.containsKey(c)) {
					graph.put(c, new HashSet<>());
				}
			}
		}

		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1];
			String second = words[i];

			int length = Math.min(first.length(), second.length());

			for (int j = 0; j < length; j++) {
				if (first.charAt(j) == second.charAt(j)) {
					continue;
				}
				// it's a set, it shouldn't matter another addition
				graph.get(first.charAt(j)).add(second.charAt(j));
				int secondIndegree = indegrees.getOrDefault(second.charAt(j), 0);
				indegrees.put(second.charAt(j), secondIndegree + 1);
			}
		}
	}

	private String getLexicographicOrder(Map<Character, Integer> indegrees, Map<Character, Set<Character>> graph) {

		Queue<Character> queue = new LinkedList<>();
		for (Map.Entry<Character, Integer> entry : indegrees.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Character current = queue.remove();
			sb.append(current);
			for (Character neighbour : graph.get(current)) {
				indegrees.put(neighbour, indegrees.get(neighbour) - 1);
				if (indegrees.get(neighbour) == 0) {
					queue.offer(neighbour);
				}

			}
		}
		return sb.toString();
	}

}

package com.my.leet.medium.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	// https://leetcode.com/problems/reconstruct-itinerary/
	/*
	 * Given a list of airline tickets represented by pairs of departure and arrival
	 * airports [from, to], reconstruct the itinerary in order. All of the tickets
	 * belong to a man who departs from JFK. Thus, the itinerary must begin with
	 * JFK.
	 * 
	 * Note:
	 * 
	 * If there are multiple valid itineraries, you should return the itinerary that
	 * has the smallest lexical order when read as a single string. For example, the
	 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
	 * airports are represented by three capital letters (IATA code). You may assume
	 * all tickets form at least one valid itinerary. Example 1:
	 * 
	 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"] Example 2:
	 * 
	 * Input:
	 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible
	 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
	 * lexical order.
	 * 
	 * 
	 */

	// https://www.programcreek.com/2015/03/leetcode-reconstruct-itinerary-java/

	// Use dfs, but no visits. Rather than visits, remove edgeNodes (in adjList).
	// Use PQ (not tree set) to sort based on Lexicographic order as duplicates are allowed

	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	
	LinkedList<String> result = new LinkedList<String>();

	public List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				PriorityQueue<String> q = new PriorityQueue<String>();
				map.put(ticket[0], q);
			}
			map.get(ticket[0]).offer(ticket[1]);
		}

		dfs("JFK");
		return result;
	}

	public void dfs(String s) {
		PriorityQueue<String> q = map.get(s);

		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}

		result.addFirst(s);
		//Topological sorting type . But adding at first solves the need for stack
	}

}

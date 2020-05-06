package com.my.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class IslandsBridges {
	
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
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
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

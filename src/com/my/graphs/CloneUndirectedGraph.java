package com.my.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CloneUndirectedGraph {
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	
		if(node == null) {
			return null;
		}
		
		Set<Integer> visited = new HashSet<Integer>();
		Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
		
		
		visited.add(node.label); // visit the first
		stack.push(node); //push only visited ones
		
		//created node, when visited
		UndirectedGraphNode returnNode = new UndirectedGraphNode(node.label); 
		Stack<UndirectedGraphNode> cloneStack = new Stack<UndirectedGraphNode>();
		cloneStack.push(returnNode); 
		
		Map<Integer,UndirectedGraphNode> map = new HashMap<>();
		map.put(node.label, returnNode);
		
		while(!stack.isEmpty()) {
			UndirectedGraphNode tempNode = stack.pop();
			UndirectedGraphNode tempSNode = cloneStack.pop();
			//Before processing print the node
			
			for(UndirectedGraphNode neigh: tempNode.neighbors) {
				if(visited.contains(neigh.label)) {
					tempSNode.neighbors.add(map.get(neigh.label));
					continue;
				}
				UndirectedGraphNode tempNeigh = new UndirectedGraphNode(neigh.label);
				map.put(neigh.label, tempNeigh);
				tempSNode.neighbors.add(tempNeigh);
				visited.add(neigh.label);
				stack.push(neigh);
				cloneStack.push(tempNeigh);
			}
		}
		
		return returnNode;
	}
	
	
	

}

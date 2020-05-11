package com.my.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FinishCourses {
	
	enum Color {
		WHITE, GREY, BLACK;
	}
	
	class Graph {
		int v;
		Map<Integer,Set<Integer>> dependentCourses = new HashMap<>();
	
		Graph(int v){
			this.v = v;
		}
	
		void addDependency(int course, int dependent) {
			if(!dependentCourses.containsKey(course)) {
				Set<Integer> dependents = new HashSet<>();
				dependents.add(dependent);
				dependentCourses.put(course, dependents);
			} else {
				dependentCourses.get(course).add(dependent);
			}
		}
	}
	
	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		
		Map<Integer,Color> visited = new HashMap<Integer,Color>();
		
		Graph g = new Graph(A);
		for(int i=0;i<B.size();i++) {
			g.addDependency(B.get(i),C.get(i));
			visited.put(B.get(i),Color.WHITE);
			visited.put(C.get(i),Color.WHITE);
		}
	   
		int possible = 1;
	   
		Iterator<Integer> iter = g.dependentCourses.keySet().iterator();
		while(iter.hasNext()) {
		   int currentCourse = iter.next();
		   if(visited.get(currentCourse) == Color.WHITE && checkCycle(visited, g, currentCourse)) {
			   possible = 0; //if cycle is present then it is not possible
			   break;
		   }
		}
		   
		return possible;
	}

	
	public boolean checkCycle(Map<Integer,Color> visited, Graph g, int currentCourse) {
		
		visited.put(currentCourse,Color.GREY);
		
		if(g.dependentCourses.get(currentCourse) != null) {
			for(Integer dependent : g.dependentCourses.get(currentCourse)) {
				if(visited.get(dependent) == Color.GREY) {
					return true;
				}
				
				if(visited.get(dependent) == Color.WHITE && checkCycle(visited,g,dependent)) {
					return true;
				}
			}
		}
		visited.put(currentCourse, Color.BLACK);   
		return false;	   
	}
}

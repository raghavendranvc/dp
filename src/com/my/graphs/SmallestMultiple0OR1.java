package com.my.graphs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestMultiple0OR1 {
	
	//TODO, the solutions is copied. GIVEN UP. Check this again
	
	// 33 66 99 132 165 198 
	
	// 10, 100, 110, 
	// Odd numbers never be needed
	// 3  11 101 1001 1011 1111
	
	// Given 111001, 7
	//	1		1			1			0		0		1
	// 1/7		(10+1)/7	(40+1)/7	60/7	40/7	51/7		2
	
	//1585
	
	//	
	
	public int getMod(String s, int n) {
		int mod = 0;
		for(char ch : s.toCharArray()) {
			mod = mod * 10 + (ch-'0');
			mod %= n;
		}
		return mod;
	}
	
	public String multiple(int A) {
		Deque<String> queue = new LinkedList<String>();
		queue.add("1"); //First value is anyway 1.
		
		//To remember previous obtained mod. If we got the same remainder, 
		// we don't need to add such string again as we have already processed
		// a smaller string that resulted in the same mod
		Set<Integer> visitedSet = new HashSet<>(); 
		
		
		while(!queue.isEmpty()) {
			String t = queue.removeFirst();
			
			int mod = getMod(t,A);
			
			if(mod == 0) {
				return t;
			}
			
			if(!visitedSet.contains(mod)) {
				queue.add(t+"0");	//First time it will be 10
				queue.add(t+"1");	//First time it will be 11
			}
			
		}
		
		return "";
    }
	
	
	public String multipleNotOpt(int A) {
		Deque<String> queue = new LinkedList<String>();
		queue.add("1"); //First value is anyway 1.
		
		while(!queue.isEmpty()) {
			String t = queue.removeFirst();
			
			int mod = getMod(t,A);
			
			if(mod == 0) {
				return t;
			}
			
			queue.add(t+"0");	//First time it will be 10
			queue.add(t+"1");	//First time it will be 11
			
		}
		
		return "";
    }

}

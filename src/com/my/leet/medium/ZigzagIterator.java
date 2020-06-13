package com.my.leet.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
	// https://medium.com/@rebeccahezhang/leetcode-281-zigzag-iterator-a5ee60dd20ea
	/*
	 * Given two 1d vectors, implement an iterator to return their elements
	 * alternately.For example, given two 1d vectors: v1 = [1, 2] v2 = [3, 4, 5, 6]
	 * 
	 * By calling next repeatedly until hasNext returns false, the order of elements
	 * returned by next should be: [1, 3, 2, 4, 5, 6].
	 */

	Queue<Integer> queue;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	    
		queue = new LinkedList<Integer>();
	    int i = 0;
	    for (i = 0; i < Math.min(v1.size(), v2.size()); i++){
	        queue.add(v1.get(i));
	        queue.add(v2.get(i));
	    }
	    if (v1.size() == v2.size()) {
	        return;
	    } else if (i == v1.size()) {
	        queue.addAll(v2.subList(v1.size(), v2.size()));
	        return;
	    } else {
	        queue.addAll(v1.subList(v2.size(), v1.size()));
	        return;
	    }
	}

	public int next() {
		return queue.remove();
	}

	public boolean hasNext() {
		if (queue.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}

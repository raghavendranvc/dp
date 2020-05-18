package com.my.dp.ibit;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinaryTrees {

	/*
	 * 		1 is root 	2 is root here 		n is root here 
	 * f(n) = f(0)f(n-1) + f(1)f(n-2) .... + f(n-1)f(0)
	 */
	//TODO remeber the base cases. 
	public int numTrees(int A) {
		if(A == 0) {
			return 1; // With zero nodes only 1 BST possible
		}
		if(A == 1) {
			return 1; // With one nodes only 1 BST possible
		}
		
		int[] value = new int[A + 1];
		value[0] = 1; //
		value[1] = 1; // With just one node 1
		/*
		 * 		
		 * f(3)=f(0)f(2)+f(1)*f(1)+f(2)*f(0);
		 */
		
		for(int i=2;i<=A;i++) {
			for(int j=0;j<i;j++) {
				value[i] += value[j]*value[i-j-1];
			}
		}
		return value[A];
	}

	public int numTreesAnalyseNotWokring(int A) {
		return numTreesRecursion(1, A, new HashMap<Integer, Integer>());
	}

	/*
	 * BST count = (2n)!/(n+1)!n! BT count = n! * BST count => (2n)!/(n+1)!
	 */

	private int numTreesRecursion(int left, int right, Map<Integer, Integer> map) {

		/*
		 * 1 2 3 4 5
		 * 
		 */

		if (left > right) {
			return 0;
		}

		if (left == right) {
			return 1;
		}
		
		if(left+1 == right) {
		    return 2;
		}

		if (map.containsKey(right - left)) {
			map.get(right - left);
		}

		int totalTrees = 0;
		for (int i = left; i <= right; i++) {
			//System.out.println("Root=" + i + " Tree(" + left + "," + right + ")");
			int lTotal = numTreesRecursion(left, i - 1, map); // i is the root here
			int rTotal = numTreesRecursion(i + 1, right, map);
			//System.out.println(
			//		"Root=" + i + " Tree(" + left + "," + right + ") Produced counts (" + lTotal + "," + rTotal + ")");
			totalTrees += (lTotal * rTotal);
		}

		map.put(right - left, totalTrees);
		return totalTrees;

	}

	/*
	 * (1,2) (1,0), 1 (2,2) (1,1), 2 (3,2)
	 * 
	 */

	public static void main(String[] args) {
		UniqueBinaryTrees uniqueBinaryTrees = new UniqueBinaryTrees();
		System.out.println("value=" + uniqueBinaryTrees.numTrees(3));

	}

}

package com.my.leet.hard;

public class PaintHouses3MinCost {

	// https://zhuhan0.blogspot.com/2017/08/265-paint-house-ii.html
	// http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html
	/*
	 * There are a row of n houses, each house can be painted with one of the k
	 * colors. The cost of painting each house with a certain color is different.
	 * You have to paint all the houses such that no two adjacent houses have the
	 * same color.
	 * 
	 * The cost of painting each house with a certain color is represented by a n x
	 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
	 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
	 * on... Find the minimum cost to paint all houses.
	 * 
	 * Note: All costs are positive integers.
	 * 
	 * Follow up: Could you solve it in O(nk) runtime?
	 */

	/*
	 * Understand the problem: This is a classic back pack problem.
	 * 
	 * -- Define dp[n][k], where dp[i][j] means for house i with color j the minimum
	 * cost.
	 * 
	 * -- Initial value: dp[0][j] = costs[0][j]. For others, dp[i][j] =
	 * Integer.MAX_VALUE;, i >= 1
	 * 
	 * -- Transit function: dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] +
	 * cost[i][j]), where k != j.
	 * 
	 * -- Final state: Min(dp[n - 1][k]).
	 */

	public int minCostIIBasic(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int n = costs.length;
		int k = costs[0].length;

		// dp[i][j] means the min cost painting for house i, with color j
		int[][] dp = new int[n][k];

		// Initialization
		for (int i = 0; i < k; i++) {
			dp[0][i] = costs[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int m = 0; m < k; m++) {
					if (m != j) {
						dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
					}
				}
			}
		}

		// Final state
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			minCost = Math.min(minCost, dp[n - 1][i]);
		}

		return minCost;
	}

	// --------------------Better way--------------------

	public int minCostII(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}

		int first = -1;
		int second = -1;
		for (int i = 0; i < costs.length; i++) {
			int previous1 = first;
			int previous2 = second;
			first = -1;
			second = -1;

			for (int j = 0; j < costs[i].length; j++) {
				if (j == previous1) {
					costs[i][j] += previous2 < 0 ? 0 : costs[i - 1][previous2];
				} else {
					costs[i][j] += previous1 < 0 ? 0 : costs[i - 1][previous1];
				}

				if (first < 0 || costs[i][j] < costs[i][first]) {
					second = first;
					first = j;
				} else if (second < 0 || costs[i][j] < costs[i][second]) {
					second = j;
				}
			}
		}
		return costs[costs.length - 1][first];
	}

	// ------------------------Another similar solution

	public int minCostIIAnother(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int preMin = 0;
		int preSecond = 0;
		int preIndex = -1;

		for (int i = 0; i < costs.length; i++) {
			int currMin = Integer.MAX_VALUE;
			int currSecond = Integer.MAX_VALUE;
			int currIndex = 0;

			for (int j = 0; j < costs[0].length; j++) {
				if (preIndex == j) {
					costs[i][j] += preSecond;
				} else {
					costs[i][j] += preMin;
				}

				if (currMin > costs[i][j]) {
					currSecond = currMin;
					currMin = costs[i][j];
					currIndex = j;
				} else if (currSecond > costs[i][j]) {
					currSecond = costs[i][j];
				}
			}

			preMin = currMin;
			preSecond = currSecond;
			preIndex = currIndex;
		}

		int result = Integer.MAX_VALUE;
		for (int j = 0; j < costs[0].length; j++) {
			if (result > costs[costs.length - 1][j]) {
				result = costs[costs.length - 1][j];
			}
		}
		return result;
	}

}

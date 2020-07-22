package com.my.leet.medium.dp;

public class PredictTheWinner {

	/*
	 * The dp[i][j] saves how much more scores that the first-in-action player will
	 * get from i to j than the second player. First-in-action means whomever moves
	 * first.
	 * 
	 * Given an array of scores that are non-negative integers. Player 1 picks one
	 * of the numbers from either end of the array followed by the player 2 and then
	 * player 1 and so on. Each time a player picks a number, that number will not
	 * be available for the next player. This continues until all the scores have
	 * been chosen. The player with the maximum score wins.
	 * 
	 * Given an array of scores, predict whether player 1 is the winner. You can
	 * assume each player plays to maximize his score.
	 */

	public boolean PredictTheWinnerNormal(int[] nums) {
		int n = nums.length, sum = 0;
		if (n % 2 == 0)
			return true;
		
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = nums[i];
			sum += nums[i];
		}

		for (int j = 0; j < n; j++) {
			for (int i = j - 1; i >= 0; i--) {
				int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
				
				int b = (i + 2 < n) ? dp[i + 2][j] : 0;
				
				int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;
				
				dp[i][j] = Math.max(Math.min(a, b) + nums[i], Math.min(a, c) + nums[j]);
			}
		}

		return dp[0][n - 1] * 2 >= sum;
	}

	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = nums[i]; //
		}

		for (int len = 1; len < n; len++) {
			for (int i = 0; i < n - len; i++) {
				int j = i + len;
				dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
			}
		}
		return dp[0][n - 1] >= 0;
	}

	public boolean PredictTheWinnerWithONSpace(int[] nums) {
		if (nums == null) {
			return true;
		}

		int n = nums.length;
		if ((n & 1) == 0) { // For even's it is always possible ?
			return true;
		} // Improved with hot13399's comment.

		int[] dp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					dp[i] = nums[i];
				} else {
					dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
				}
			}
		}
		return dp[n - 1] >= 0;
	}

}

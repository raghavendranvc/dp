package com.my.leet.medium;

public class GuessNumber2MaxFinePossible {
	//https://hbisheng.gitbooks.io/leetcode-google/content/375-guess-number-higher-or-lower-ii.html
	//https://harunscorner.wordpress.com/2016/09/04/leetcode-guess-number-higher-or-lower-ii-solution/
	//https://baihuqian.github.io/2018-08-21-guess-number-higher-or-lower-ii/
	

	//https://leetcode.com/problems/guess-number-higher-or-lower-ii/
	
	//TODO DP Problem
	
	/*
	 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
	 */
	
	public int getMoneyAmount(int n) {
        if(n <= 1) return 0;
        int dp[][] = new int[n+1][n+1];

        return getMoney(1, n, dp);
    }

    public int getMoney(int start, int end, int[][] dp) {
        if(start > end) return 0;
        if(start == end) return 0;
        if(end - start == 1) return start;
        if(dp[start][end] != 0) return dp[start][end];

        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++) {
            int cost = i + Integer.max(getMoney(start, i-1, dp), getMoney(i+1,end,dp));
            min = Integer.min(min, cost);
        }

        dp[start][end] = min;
        return min;
    }

}

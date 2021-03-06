package com.my.leet.medium.dp;

public class MaxProfitWithCoolDown {

	/*
	 * http://buttercola.blogspot.com/2016/01/leetcode-best-time-to-buy-and-sell.
	 * html
	 * https://twchen.gitbook.io/leetcode/dynamic-programming/best-time-to-buy-and-
	 * sell-stock-with-cooldown
	 * 
	 * Say you have an array for which the ith element is the price of a given stock
	 * on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times) with the following restrictions:
	 * 
	 * You may not engage in multiple transactions at the same time (ie, you must
	 * sell the stock before you buy again). After you sell your stock, you cannot
	 * buy stock on next day. (ie, cooldown 1 day) Example:
	 * 
	 * Input: [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell,
	 * cooldown, buy, sell]
	 */

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int prevHold = -prices[0];
		int prevSold = 0;
		int prevRest = 0;

		for (int i = 1; i < prices.length; i++) {
			int currHold = Math.max(prevRest - prices[i], prevHold);
			int currSold = prevHold + prices[i];
			int currRest = Math.max(prevRest, prevSold);

			prevHold = currHold;
			prevSold = currSold;
			prevRest = currRest;
		}

		return Math.max(prevSold, prevRest);
	}
}

package com.my.dp.ibit;

import java.util.List;

public class ShareMaxProfit {

	/**
	 * Single Share any number of times
	 */

	public int maxProfit(final List<Integer> A) {

		int n = A.size();

		int profit = 0;

		int i = 0;

		while (i < n - 1) { // We do this for buying and we don't buy last day

			// Find First buy date. We buy when we see first bump. Same price is ignored
			while (i + 1 < n && A.get(i) >= A.get(i + 1)) {
				i++;
			}

			if (i == n - 1) {
				break; // we reached end and we found all decreasing value of shares
			}

			int buyPrice = A.get(i);
			i++; // we need to move forward for sell price

			// Traverse till the point where the share value dips.
			// No point in buy and selling every day. We loose
			while (i + 1 < n && A.get(i) <= A.get(i + 1)) {
				i++;
			}

			int sellPrice = A.get(i);
			i++; // we need to move forward for the next buy

			// Count profit and loop
			profit += sellPrice - buyPrice;

		}

		return profit;
	}

	/*
	 * Single share only 2 times
	 */

	public int maxProfitElegant(final int[] A) {

		if (A == null || A.length < 2) {
			return 0;
		}

		int n = A.length;

		/***
		 * 
		 * (0...i) (i+1....n-1) If we can get two paritions whose sum is largest
		 * 
		 * First focusing on getting max profit
		 * 
		 * For each day i, if we buy stock, what is the profit of selling in the rest
		 * i+1 to n days.
		 * 
		 * In that case profit[i] = maxPrice(i+1...n)-price[i]
		 * 
		 * Let's do it from end. We cannot buy on last day. So no profit as there is no
		 * sell date
		 * 
		 */

		int[] profitRight = new int[n];
		int[] maxProfitRight = new int[n];

		profitRight[n - 1] = 0;
		maxProfitRight[n - 1] = 0;
		int maxPrice = A[n - 1]; // initial max Price is lastDay's price

		for (int i = n - 2; i >= 0; i--) {
			/*
			 * //if the current day i becomes maxPrice. //Then profit is '0' for that day.
			 */

			if (A[i] > maxPrice) {
				maxPrice = A[i];
			}

			profitRight[i] = maxPrice - A[i]; // buying at i, selling at max between(i+1 to n)
			/*
			 * Either that day's profit or the next day's maxProfit is the current day's
			 * maxProfit
			 */
			maxProfitRight[i] = Math.max(maxProfitRight[i + 1], profitRight[i]);

		}

		/*
		 * for each i, we now need to find the maxProfit from 0 to i-1. We know the
		 * maxProfit possible from i to n-1 To get maxProfit at each day i, we need to
		 * find the profit at each day To find profit at each day i, if we sell at i,
		 * then we need to find min price to buy between 0 ... i-1 Meaning we need to
		 * find the minPrice between 0 to i-1
		 * 
		 * We can't sell on 1st day. So profit[0] = 0
		 * 
		 */

		int[] profitLeft = new int[n];
		int[] maxProfitLeft = new int[n];

		profitLeft[0] = 0;
		maxProfitLeft[0] = 0;
		int minPrice = A[0];

		for (int i = 1; i < n; i++) {
			if (minPrice > A[i]) {
				minPrice = A[i];
			}

			profitLeft[i] = A[i] - minPrice; // selling at i and buying between 0 to i-1

			maxProfitLeft[i] = Math.max(maxProfitLeft[i - 1], profitLeft[i]);

		}

		int max = maxProfitRight[0] + maxProfitLeft[0];
		for (int i = 0; i < n; i++) {
			max = Math.max(max, maxProfitRight[i] + maxProfitLeft[i]);
		}

		// We can remove profitLeft, profitRight easily
		// We can club maxProfitRight, maxProfitLeft to one and
		// in the later for loop, we need to club the earlier before calculating the max
		// at each i like below
		// maxProfit[i] = Math.max(maxProfit[i - 1], maxProfit[i]+ (A[i] - minPrice));

		return max;

	}

	/***
	 * One single transaction
	 */

	public int maxProfit(final int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}

		int maxProfit = 0;
		// We can't sell on day 0
		int minPriceSoFar = A[0];
		// We are going to sell on day i and check our profit from the minimum
		// of all the prices between 0 to i-1
		for (int i = 1; i < A.length; i++) {
			if (minPriceSoFar > A[i]) {
				minPriceSoFar = A[i];
			}
			maxProfit = Math.max(maxProfit, A[i] - minPriceSoFar);
		}
		return maxProfit;
	}

	/***
	 * Do at atmost k transations
	 */

	
	
	
	/*
	 * Anu number of transactions, one share at a time
	 */
	public int maxProfitRecur(final int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}
		return maxProfit(A, 0, A.length - 1);
	}

	public int maxProfit(final int[] A, int start, int end) {
		if (end <= start) {
			return 0;
		}

		int profit = 0;
		for (int i = start; i < end - 1; i++) {
			for (int j = i + 1; j < end; j++) {
				if (A[j] > A[i]) {
					int currentProfit = A[j] - A[i] + maxProfit(A, start, i - 1) + maxProfit(A, i + 1, end);
					profit = Math.max(profit, currentProfit);
				}
			}
		}
		return profit;
	}

}

package com.my.leet.medium.dp;

public class PartitionEqualSubsetSum {

	// Returns true if arr[] can be partitioned in two
	// subsets of equal sum, otherwise false
	public boolean findPartition(int arr[], int n) {
		// Calculate sum of the elements in array
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		// If sum is odd, there cannot be two subsets
		// with equal sum
		if (sum % 2 != 0)
			return false;

		// Find if there is subset with sum equal to half
		// of total sum
		return isSubsetSum(arr, n, sum / 2);
	}

	public boolean isSubsetSum(int arr[], int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;

		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than sum, then ignore it
		if (arr[n - 1] > sum)
			return isSubsetSum(arr, n - 1, sum);

		/*
		 * else, check if sum can be obtained by any of the following
		 * 
		 * (a) including the last element
		 * 
		 * (b) excluding the last element
		 */
		return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
	}

	// -----------------DP Way--------------------------------------

	// Returns true if arr[] can be partitioned in two subsets of
	// equal sum, otherwise false
	boolean findPartitionDP(int arr[], int n) {

		int sum = 0;
		int i, j;

		// Calculate sum of all elements
		for (i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		boolean part[][] = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (i = 0; i <= n; i++)
			part[0][i] = true; // first row is '0'

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;// first column is '0'

		// Fill the partition table in bottom up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1]; // ignoring it
				if (i >= arr[j - 1]) // See if we can include it (include j-1)
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
			}
		}

		/*
		 * // uncomment this part to print table for (i = 0; i <= sum/2; i++) { for (j =
		 * 0; j <= n; j++) printf ("%4d", part[i][j]); printf("\n"); }
		 */

		return part[sum / 2][n];
	}

}

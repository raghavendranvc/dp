package com.my.dp;

public class KnapSack01 {

	/*
	 * This does for each permuations
	 */
	public int maxValue(int[] values, int[] weights, int capacity) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < weights.length; i++) {
			swapValues(values, weights, 0, i);
			int value = maxValue(values, weights, capacity, 0, 0);
			System.out.println("i=" + i + " Max value got =" + value);
			if (max < value) {
				max = value;
			}
			swapValues(values, weights, 0, i);
		}
		return max;
	}

	public int maxValue(int[] values, int[] weights, int capacity, int selectedWeight, int currentValue) {

		/*
		 * We have searched all the weights. So return the current value
		 */
		if (selectedWeight > weights.length - 1) {
			return currentValue;
		}

		/*
		 * If - When the weight is selection Else - When the weight is not selected
		 */

		if ((capacity - weights[selectedWeight]) >= 0) {
			/*
			 * So we need to include the weight. Increase the value.
			 */
			int value = maxValue(values, weights, capacity - weights[selectedWeight], selectedWeight + 1,
					currentValue + values[selectedWeight]);
			if (currentValue < value) {
				currentValue = value;
			}
		} else {
			/*
			 * We discard the weight. No change in value.
			 */
			int value = maxValue(values, weights, capacity, selectedWeight + 1, currentValue);
			if (currentValue < value) {
				currentValue = value;
			}
		}
		return currentValue;
	}

	private void swapValues(int[] values, int[] weights, int i, int j) {
		swapValues(values, i, j);
		swapValues(weights, i, j);
	}

	private void swapValues(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private int SimpleKnapSackRecus(int[] values, int[] weights, int capacity, int i) {
		if (capacity == 0 || i == 0) {
			return 0;
		}

		/*
		 * If the weight of nth time is more than the capacity then discard it
		 */
		if (weights[i - 1] > capacity) {
			return SimpleKnapSackRecus(values, weights, capacity, i - 1);
		} else {
			/*
			 * Include it or
			 */
			return Math.max(values[i - 1] + SimpleKnapSackRecus(values, weights, capacity - weights[i - 1], i - 1),
					SimpleKnapSackRecus(values, weights, capacity, i - 1));

		}
	}

	/*
	 * Not correct. Something is wrong. Check again
	 */
	private int SimpleKnapSackReverseRecus(int[] values, int[] weights, int capacity, int selectedWeight) {

		if (capacity == 0 || selectedWeight == weights.length) {
			return 0;
		}

		/*
		 * If the weight of nth time is more than the capacity then discard it
		 */
		if (weights[selectedWeight] > capacity) {
			return SimpleKnapSackReverseRecus(values, weights, capacity, selectedWeight + 1);
		} else {
			/*
			 * Include it or
			 */
			return Math.max(
					values[selectedWeight] + SimpleKnapSackReverseRecus(values, weights,
							capacity - weights[selectedWeight], selectedWeight + 1),
					SimpleKnapSackReverseRecus(values, weights, capacity, selectedWeight + 1));

		}
	}

	private int KnapSnackIter(int[] values, int[] weights, int capacity) {
		int table[][] = new int[weights.length + 1][capacity + 1];

		for (int i = 0; i <= weights.length; i++) {
			for (int currentWeight = 0; currentWeight <= capacity; currentWeight++) {
				if (i == 0 || currentWeight == 0) {
					table[i][currentWeight] = 0;
				} else if (weights[i - 1] > currentWeight) { // If weight is more 
					table[i][currentWeight] = table[i - 1][currentWeight];
				} else { // If weight is within the boundary. Then use it or don't use it
					table[i][currentWeight] = Math.max(values[i - 1] + table[i - 1][currentWeight - weights[i - 1]],
							table[i - 1][currentWeight]);
				}
			}

		}
		return table[weights.length][capacity];

	}

	private int KnapSnackIterPractice(int[] values, int[] weights, int capacity) {
		int solution[][] = new int[weights.length][capacity];

		for (int i = 0; i < weights.length; i++) {
			// For each of the weights we do the below
			for (int curentWeight = 0; curentWeight <= capacity; curentWeight++) {
				// For each currentWeight we do the below
				// Either no Weights are selected or for zero weight
				if (i == 0 || curentWeight == 0) {
					solution[i][curentWeight] = 0;// first row and first column will be 0
				} else if (curentWeight + weights[i] > capacity) {

					// If we include the weight and it exceeds the capacity
					// then we need to discard the weight. We have only
					// this choice
					// So value is same as solution of [i-1][currentWight]
					solution[i][curentWeight] = solution[i - 1][curentWeight];
				} else {
					// we have 2 choices here and the max value of both is the choice
					// Either we select the weight[i-1] and add value[i-1]
					// Either we discard it
					solution[i][curentWeight] = Math.max(solution[i - 1][curentWeight],
							values[i - 1] + solution[i - 1][curentWeight - weights[i - 1]]);
				}
			}
		}
		return solution[weights.length][capacity];
	}

	public static void main(String[] args) {
		KnapSack01 ks = new KnapSack01();
		int values[] = { 60, 100, 120, 400 };
		int weights[] = { 10, 20, 30, 60 };
		int capacity = 50;
		int val1 = ks.maxValue(values, weights, capacity);
		System.out.println("Val1=" + val1);

		int val2 = ks.SimpleKnapSackRecus(values, weights, capacity, values.length);
		System.out.println("Val2=" + val2);

		/*
		 * int val3 = ks.SimpleKnapSackReverseRecus(values, weights, capacity,0);
		 * System.out.println("Val3="+val3);
		 */

		int val4 = ks.KnapSnackIter(values, weights, capacity);
		System.out.println("Val4=" + val4);

	}

}

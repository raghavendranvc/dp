package com.my.math;

public class Rand10 {

	private int rand7() {
		return (int) (Math.random() * 7);
	}

	public int rand10() {

		int index = Integer.MAX_VALUE;

		while (index >= 40) {
			index = 7 * (rand7() - 1) + (rand7() - 1);
			// Distributes values equally between 0 to 48
		}

		return index % 10 + 1;	

	}

	private int rand5() {
		return (int) (Math.random() * 5);
	}

	public int getRand7() {
		int index = Integer.MAX_VALUE;

		while (index >= 21) {
			index = 5 * (rand5() - 1) + (rand5() - 1);
			// Distributes values equally between 0 to 24
		}

		return index % 7 + 1;
	}

}

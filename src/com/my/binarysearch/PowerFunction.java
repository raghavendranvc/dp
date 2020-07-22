package com.my.binarysearch;

public class PowerFunction {

	// x x2 x4 x8
	// 13
	// 1101
	// 2^0*1 + 2^1*0 + 2^2*0 + 2^3*1
	// 5^13

	// 5^1 * 5^4 * 5^8

	// Implement pow(x, n) % d.

	public int pow(int x, int n, int d) {

		if (x == 0 && n == 0) {
			if (d != 1)
				return 1;
			else
				return 0;
		}
		if (x == 0)
			return 0;

		long value = 1;
		long save = x;

		while (n > 0) {
			// For Odd
			if ((n & 1) == 1) {
				value = (value * save);
			}

			// For Negative numbers
			if (value < 0)
				value = d - (-1 * x) % d;
			else
				value = value % d;

			n = n >> 1; // n = n/2;
			save = (save * save) % d;
		}

		return (int) value;
	}
	
	//TODO use this
	public double myPow(double x, int n) {

		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			return 1 / myPow(x, -n);
		}

		double v = myPow(x, n / 2);

		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}

	}

	public static void main(String[] args) {
		// int x = 3, n = 7, d = 4;
		int x = -1, n = 1, d = 20;
		PowerFunction p = new PowerFunction();
		System.out.println(p.pow(x, n, d));
	}

	// 81*27
}

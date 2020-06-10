package com.my.math;

public class PowerOfIntegers {

	/*
	 * 1 is true 0 is false
	 */
	public int isPower1(int A) {

		if (A == 2) {
			return 0;
		}

		int i = 2;

		boolean isOdd = false;
		if (A % 2 != 0) {
			isOdd = true;
			i = 3;
		}

		while (i * i < A) {
			int power = i;
			while (power < A) {
				power = power * i;
			}
			if (power == A) {
				return 1;
			}
			i++;
			if (isOdd) {
				i++;
			}
		}

		if (i * i == A) {
			return 1;
		}

		return 0;
	}

	public boolean isPowerBkp(int a) {
		if (a == 1) {
			return true;
		}

		for (int i = 2; i * i <= a; i++) {
			int power = a;
			while (power % i == 0) {
				power /= i;
			}
			if (power == 1) {
				return true;
			}
		}
		return false;

	}

	public boolean isPower(int a) {
		if (a == 1) {
			return true;
		}

		for (int i = 2; i * i <= a; i++) {
			int power = a;
			while (power % i == 0) {
				power = power / i;
			}
			if (power == 1) {
				return true;
			}
		}
		return false;

	}
	// https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/

	int power(int x, int y) {
		int res = 1; // Initialize result

		while (y > 0) {
			// If y is odd, multiply x with result
			if ((y & 1) == 1) {
				res = res * x;
			}

			// y must be even now
			y = y >> 1; // y is halved y/2
			x = x * x; // So Change x to x^2
		}
		return res;
	}

	float power(float x, int y) {
		float temp;
		if (y == 0)
			return 1;

		temp = power(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
	
	//TODO give this solution. It is elegant
	/**
	 *
	 * @param x
	 * @param n
	 * @return
	 */

	public double myPow(double x, int n) {
		if (n == 0)
			return 1;

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

	int powerMod(int x, int y, int p) {
		int res = 1;

		x = x % p;

		if (x == 0) {
			return 0;
		}

		while (y > 0) {
			if ((y & 1) == 1) {
				res = (res * x) % p;
			}

			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	public static void main(String[] args) {
		PowerOfIntegers powerOfIntegers = new PowerOfIntegers();
		System.out.println(powerOfIntegers.isPower(1024000000));
	}
}

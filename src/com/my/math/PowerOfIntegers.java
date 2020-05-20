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

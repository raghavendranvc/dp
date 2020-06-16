 package com.my.math;

import com.my.common.UtilityClass;

import java.util.ArrayList;

public class NumbersLessThanLength {

	// TODO Incomplete

	/*
	 * 0 1 4 5 7 9 number of digits = N = 6
	 * 
	 * 4 (R)
	 * 
	 * 42623 number of digits = 2
	 * 
	 * all combinations of digits with length 1,2,3 (<4) (special care for 0) N,P,R
	 * = N!/(N-R)! = N * N-1 * .... * N-R+1
	 * 
	 * ===== smallerNumbers 4 = 2 = 2*4! or 2*3! 2 = 2 = 2*3! 6 = 4 = 4*2! 2 = 2 =
	 * 2*1! 3 = 2 = 2*0!
	 * 
	 * ====== 623 position x = Number of digits less than x 2 6 = 4 =
	 * 4*(AllDigits)*(AllDigits) 1 2 = 2 = 2*(AllDigits) 0 3 = 3 = 3
	 * 
	 * = (Number of digits less than x)* (Alldigits)^position
	 * 
	 * x = all numbers less than first digit 4. index of 4 x* (length-1 numbers less
	 * than) = x * N, P, (R-1)
	 * 
	 */

	private int getIndex(int number, ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= number) {
				return i;
			}
		}
		return A.size();
	}

	public int solve(ArrayList<Integer> A, int B, int C) {

		if (A.size() == 0) {
			return 0;
		}

		int save = C;

		int numberOfDigits = 0;
		while (C > 0) {
			C = C / 10;
			numberOfDigits++;
		}

		C = save;
		System.out.println("numberOfDigits=" + numberOfDigits);

		long totalSmallerNumberWithLesserLength = 0;
		int position = 0;
		while (C > 0 && position < B) {
			int remainder = C % 10;
			int index = getIndex(remainder, A);
			System.out.println("C=" + C + " remainder=" + remainder + " index=" + index);
			if (C / 10 < 1 && numberOfDigits > 1) {
				index = index - 1;
				System.out.println("For last discarding 0");
			}
			C = C / 10;
			totalSmallerNumberWithLesserLength = totalSmallerNumberWithLesserLength
					+ 1L * index * (long) Math.pow(A.size(), position);
			position++;

			System.out.println("totalSmallerNumberWithLesserLength=" + totalSmallerNumberWithLesserLength);
		}

		return (int) totalSmallerNumberWithLesserLength;

		/*
		 * int lastNumber = A.get(A.size()-1); int[] fact = new int[lastNumber+1];
		 * fact[0] = fact[1] = 1; for(int i=2;i<=lastNumber;i++){ fact[i] = i *
		 * fact[i-1]; }
		 * 
		 * UtilityClass.print(fact); int save = C;
		 * 
		 * int numberOfDigits = 0; while (C > 0){ C = C/10; numberOfDigits++; }
		 * 
		 * System.out.println("numberOfDigits="+numberOfDigits);
		 * 
		 * C = save;
		 */

	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 2, 5 };
		UtilityClass.print(a);

		ArrayList<Integer> intList = new ArrayList<>(a.length);
		for (int i : a) {
			intList.add(i);
		}
		NumbersLessThanLength numbersLessThanLength = new NumbersLessThanLength();
		int B = 1;
		int C = 123;
		System.out.println("length=" + B + " Number=" + C);

		System.out.println("Max Distance=" + numbersLessThanLength.solve(intList, B, C));
	}

	public long npr(int n, int r) {
		if (n == 1 || n == r) {
			return 1;
		}

		long compute = n - r + 1;
		while (r > 0) {
			compute = compute * compute + 1;
			r = r - 1;
		}
		return compute;
	}

	public int solveCopied2(ArrayList<Integer> A, int B, int C) {
		String str = Integer.toString(C);
		int cl = str.length();
		int size = A.size();
		int d = size, d2;
		if (B > cl || C == 0 || size == 0)
			return 0;
		int zeros = A.lastIndexOf(0) - A.indexOf(0) + 1;
		boolean zero = A.contains(0);
		int ans = 0;
		if (B < cl) {
			if (zero && B != 1)
				ans += size - 1;
			else
				ans = size;
			for (int i = 1; i < B; i++)
				ans *= size;
			return ans;
		}

		int dp[] = new int[B + 1];
		int lower[] = new int[11];

		if (B == cl) {

			for (int i = 0; i <= B; i++)
				dp[i] = 0;
			for (int i = 0; i <= 10; i++)
				lower[i] = 0;
			for (int i = 0; i < d; i++)
				lower[A.get(i) + 1] = 1;

			for (int i = 1; i <= 10; i++)
				lower[i] = lower[i - 1] + lower[i];

			boolean flag = true;
			dp[0] = 0;
			for (int i = 1; i <= B; i++) {
				int digit = str.charAt(i - 1) - '0';
				d2 = lower[digit];
				dp[i] = dp[i - 1] * d;

				// For first index we can't use 0
				if (i == 1 && A.get(0) == 0 && B != 1)
					d2 = d2 - 1;

				// Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
				if (flag)
					dp[i] += d2;
				// Is digit[i - 1] present in A ?
				flag = flag & (lower[digit + 1] == lower[digit] + 1);
			}
			return dp[B];

		}
		return 0;

	}

	public int solveCopied(ArrayList<Integer> A, int B, int C) {
		int cSize = (int) Math.log10(C) + 1;
		int n = A.size();
		if (cSize < B || n == 0)
			return 0;
		boolean hasZero = A.get(0) == 0;
		if (cSize > B)
			return (B > 1 && hasZero ? n - 1 : n) * (int) Math.pow(n, B - 1);
		// B == cSize
		int pow10 = (int) Math.pow(10, B - 1), count = 0;
		for (int i = B; i > 0; i--) {
			int target = C / pow10, j;
			C %= pow10;
			pow10 /= 10;
			for (j = 0; j < n; j++) {
				if (A.get(j) >= target)
					break;
			}
			count += (B > 1 && i == B && hasZero ? j - 1 : j) * (int) Math.pow(n, i - 1);
			if (j == n || A.get(j) > target)
				break;
		}
		return count;
	}
}

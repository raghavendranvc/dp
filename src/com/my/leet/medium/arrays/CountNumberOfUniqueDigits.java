package com.my.leet.medium.arrays;

public class CountNumberOfUniqueDigits {

	/*
	 * https://leetcode.com/problems/count-numbers-with-unique-digits/
	 * https://zxi.mytechroad.com/blog/math/leetcode-357-count-numbers-with-unique-
	 * digits/
	 * 
	 * f(0) = 1 (0)
	 * 
	 * f(1) = 10 (0 – 9)
	 * 
	 * f(2) = 9 * 9 (1-9 * (0 ~ 9 exclude the one from first digit))
	 * 
	 * f(3) = 9 * 9 * 8
	 * 
	 * f(4) = 9 * 9 * 8 * 7
	 * 
	 * …
	 * 
	 * f(x) = 0 if x >= 10
	 * 
	 * ans = sum(f[1] ~ f[n])
	 */

	int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		int[] f = new int[11];
		f[1] = 10;
		f[2] = 9 * 9;
		
		for (int i = 3; i <= 10; ++i)
			f[i] = f[i - 1] * (10 - i + 1);
		
		int ans = 0;
		for (int i = 0; i <= Math.min(10, n); ++i)
			ans += f[i];
		
		return ans;
	}

}

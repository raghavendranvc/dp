package com.my.leet.hard.notdone;

public class CountNumberOfOneDigit {

	// https://leetcode.com/problems/number-of-digit-one/
	// https://www.cnblogs.com/grandyang/p/4629032.html

	/*
	 * We can easily identify the pattern. Let's say count 1 in tens position, we
	 * set factor =10, and nextFactor=factor*10=100
	 * 
	 * int num=n/nextFactor;
	 * 
	 * int mod=n%nextFactor;
	 * 
	 * The count will be in the following 3 cases:
	 * 
	 * if (mod<factor) the count = num*factor eg.109, count=10 : 10,11...18.19
	 * 
	 * if(mod>=factor*2) the count=(num+1)*factor eg.120, count= 20 :
	 * 10,11,...18,19, 110,111...118,119
	 * 
	 * if(mod>=factor && < factor*2) in between the count= num*factor+ mod-factor+1.
	 * eg. 115, count =16, 10,11....18,19,110,111,112,113,114,115.
	 * 
	 * We can do the same thing for all digits positions and sum up to get the total
	 * counts.
	 */

	public int countDigitOne(int n) {
		long factor = 1;
		int count = 0;
		while (n / factor != 0) {

			long com = factor * 10;
			long num = n / com;
			long mod = n % com;

			if (mod < factor)
				count += num * factor;
			else if (mod >= factor * 2)
				count += (num + 1) * factor;
			else
				count += (num * factor) + mod - factor + 1;

			factor = com;
		}
		return count;
	}

	int countDigitOne1(int n) {
		int res = 0, a = 1, b = 1;
		while (n > 0) {
			res += (n + 8) / 10 * a + ((n % 10 == 1) ? 1 : 0) * b;
			b += n % 10 * a;
			a *= 10;
			n /= 10;
		}
		return res;
	}

}

package com.my.leet.medium;

public class SuperMod {

	// Your task is to calculate ab mod 1337 where a is a positive integer and b is
	// an extremely large positive integer given in the form of an array.

	// https://leetcode.com/problems/super-pow/
	// https://baihuqian.github.io/2018-08-20-super-pow/

	/*
	 * a^(x+y)=a^x × a^y ; a^(xy)=(a^x)^y; (ab)%k=((a%k)(b%k))%k; Thus, we have
	 * 
	 * a^(10x+y)%k=(((a^x % k)^10 % k)×(a^y % k))%k.
	 */
	
	private static final int MOD = 1337;
	
    public int superPow(int a, int[] b) {
        a = a % MOD;
        if (a == 0) return a;
        
        if (b.length == 0) return 1;
        
        int res = powMod(a, b[0]);
        
        for(int i = 1; i < b.length; i++)
            res = (powMod(res, 10) * powMod(a, b[i])) % MOD;
        
        return res;
    }

    private int powMod(int a, int b) {
        if(b == 0) return 1;
        a = a % MOD;
        int res = a;
       
        for(int i = 1; i < b; i++)
            res = res * a % MOD;
        
        return res;
    }

}

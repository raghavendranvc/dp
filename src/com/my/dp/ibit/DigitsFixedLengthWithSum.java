package com.my.dp.ibit;

import java.util.Arrays;

public class DigitsFixedLengthWithSum {
	
	int[][] lookupTable = null;
	public int solve(int A, int B) {
		lookupTable = new int[A+1][B+1];
		for(int i=0;i<A;i++) {
			lookupTable[i] = new int[B+1];
			Arrays.fill(lookupTable[i], -1);
		}
		
		
		int count=0;
		for(int i=1;i<=9;i++) {
			if(B-i >= 0) {
				int value = solveRecur(A-1,B-i);
				System.out.println("Starting with "+i+" Received count="+value);
				count += value;
				count %= 1000000007;
			}
		}
		
		return count;
		
	}
	
	/*
	 * A is number of digits
	 * B is sum of digits
	 * 
	 */
	public int solveRecur(int A, int B) {
		
		if(A ==0 && B == 0) {
			return 1;
		}
		
		if(A ==0 ) {
			return 0;
		}
		
		System.out.println("A="+A+" B="+B);
	
		if(A < 1 || B < 0) {
			return 0;
		}
		
		// All 9's. But still sum doesn't add up to B
		if(A*9 < B) {
			return 0;
		}
		
		if(lookupTable[A][B] != -1) {
			return lookupTable[A][B];
		}
		
		
		int count=0;
		for(int i=0;i<=9;i++) {
			if(B-i >=0) {
				count += (solveRecur(A-1,B-i))%1000000007;
				count %= 1000000007;
			}
		}
		
		lookupTable[A][B]=count;
		System.out.println("Updated lookup table for A="+A+" B="+B+" count="+count);
		return count;
	}
	
	
	public int solveIter(int A, int B) {
		
        int[][] l = new int[A+1][B+1];
        
        for(int j = 1; j <= 9 && j <= B; j++){
            l[1][j] = 1;
        }
        
        for(int i = 2; i <= A; i++){
            for(int j = 1; j <= B; j++){
                int x = j-10;
                long val = (long)l[i][j-1] + (long)l[i-1][j];
                if(x > 0)
                    val -= (long)l[i-1][x];
                if(val < 0)
                    val += 1000000007;
                l[i][j] = (int)(val%(long)1000000007);
            }
        }
        return l[A][B];
    }
	
	
	
	
	public int solverTricky(int A, int B) {
		//A digit number
		/*
		 * If A = 2, min number = 10 (10^(2-1)), max number = 99 (10^(3-1))
		 * If A = 3, min number = 100 and max is 999
		 * 
		 */
		
		long min = (long)Math.pow(10,A-1);
		long max = (long)Math.pow(10, A)-1;
		System.out.println("min="+min+" max="+max);
		long count=0;
		for(long i=min;i<=max;i++) {
			if(getDigitSum(i) == B) {
				System.out.println("Matched number="+i);
				count++;
			}
		}
		return (int)count%1000000007;
    }
	
	/*
	 * 	4398
	 *  8 
	 *  9
	 *  3
	 *  4
	 *  
	 */
	private int getDigitSum(long number) {
		int count = 0;
		while(number/10 > 0) {
			count += number%10;
			number = number/10;
		}
		return count+= number%10;
	}
	
	public static void main(String[] args) {
		DigitsFixedLengthWithSum digitsFixedLengthWithSum = new DigitsFixedLengthWithSum();
		System.out.println("Result="+digitsFixedLengthWithSum.solve(2, 2));
		
	}
}

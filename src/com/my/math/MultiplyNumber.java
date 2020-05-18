package com.my.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyNumber {
	
	/*	4  3  2 * 56
	 * 
	 * 	2	3	4 * 56
	 * 112	168 224
	 */
	List<Integer> multiple(List<Integer> result, int number) {
		int n = result.size();
		
		List<Integer> returnVal = new ArrayList<Integer>();
		int carry = 0;
		for(int i=0;i<n;i++) {
			int multiply = carry+result.get(i)*number;
			returnVal.add(multiply%10);	
			carry = multiply/10;
			//System.out.println("multiply="+multiply+" remainder="+remainder+" carry="+carry+" returnVal="+returnVal);
		}
		
		while(carry > 0) {
			returnVal.add(carry%10);
			carry = carry/10;
		}
		
		return returnVal;
	}
	
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int power = 10;
		
		MultiplyNumber m = new MultiplyNumber();
		while(power>0) {
			//print(new ArrayList<>(result));
			result = m.multiple(result, 56);
			power--;
		}
		print(new ArrayList<>(result));
		
	}
	
	private static void print(List<Integer> result) {
		StringBuilder sb = new StringBuilder();
		Collections.reverse(result);
		for(Integer i : result) {
			sb.append(i);
		}
		
		System.out.println("Result="+sb.toString());
	}
	
	private ArrayList<Integer> convertNumberToDigits(int number) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(number > 0) {
			result.add(number%10);
			number = number/10;	
		}
		return result; 
	}

}

package com.my.leet.medium.notdone;

public class OneEditDistance {

	// https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.9.html

	// Given two strings S and T, determine if they are both one edit distance apart

	// O(n) runtime, O(1) space – Simple one-pass

	/*
	 * public boolean isOneEditDistance(String s, String t) { int m = s.length(), n
	 * = t.length(); if (m > n) return isOneEditDistance(t, s);
	 * 
	 * if (n - m > 1) return false;
	 * 
	 * int i = 0, shift = n - m;
	 * 
	 * while (i < m && s.charAt(i) == t.charAt(i)) i++;
	 * 
	 * if (i == m) return shift > 0;// case 1 when n>m
	 * 
	 * if (shift == 0) // case 2 when n == m i++;
	 * 
	 * while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
	 * 
	 * return i == m; }
	 */
}

package com.my.leet.medium.arrays;

public class WaterAndJug {

	// https://leetcode.com/problems/water-and-jug-problem/
	// https://baihuqian.github.io/2018-08-13-water-and-jug-problem/
	// https://massivealgorithms.blogspot.com/2016/06/leetcode-water-and-jug-problem.html

	public boolean canMeasureWater(int x, int y, int z) {
		// limit brought by the statement that water is finallly in one or both buckets
		if (x + y < z)
			return false;
		// case x or y is zero
		
		if (x == z || y == z || x + y == z)
			return true;

		// get GCD, then we can use the property of Bézout's identity
		return z % GCD(x, y) == 0;
	}

	public int GCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}

package com.my.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointsOnLine {

	static class Slope {
		int yDiff;
		int xDiff;

		Slope(int yDiff, int xDiff) {
			int gcdVal = gcdIter(yDiff, xDiff);

			this.yDiff = yDiff / gcdVal;
			this.xDiff = xDiff / gcdVal;
		}

		int gcd(int a, int b) {
			if (b == 0) {
				return a;
			} else {
				return gcd(b, a % b);
			}
		}

		int gcdIter(int a, int b) {
			while (b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Slope slope = (Slope) o;

			if (yDiff != slope.yDiff)
				return false;
			return xDiff == slope.xDiff;
		}

		@Override
		public int hashCode() {
			int result = yDiff;
			result = 31 * result + xDiff;
			return result;
		}

		public String toString() {
			return "{yDiff=" + yDiff + " xDiff=" + xDiff + "}";
		}
	}

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {

		int n = a.size();
		if (n < 2) {
			return a.size();
		}

		int maxPoints = 0;
		for (int i = 0; i < n; i++) {

			int samePoint = 0;
			int sameVerticalLine = 0;
			Map<Slope, Integer> mappings = new HashMap<>();
			int currentMaxPoints = 0;

			for (int j = i + 1; j < n; j++) {

				System.out.println("Handling points " + i + " & " + j);

				/*
				 * Check if it is the same point
				 */

				if (a.get(i) == a.get(j) && b.get(i) == b.get(j)) { // Same Point
					System.out.println("samePoint");
					samePoint++;
				} else if (a.get(i) == a.get(j)) { // Same x-axis. These form vertical line
					System.out.println("sameVerticalLine");
					sameVerticalLine++;
				} else {
					Slope p = new Slope(b.get(j) - b.get(i), a.get(j) - a.get(i));
					int count = mappings.getOrDefault(p, 0);
					mappings.put(p, count + 1);
					System.out.println("Slope Mappings=" + mappings);
					currentMaxPoints = Math.max(currentMaxPoints, count + 1);
				}
				currentMaxPoints = Math.max(currentMaxPoints, sameVerticalLine);
				// This is like max of vertical lines or non-vertical lines
			}

			System.out.println("samePoint=" + samePoint + " sameVerticalLine=" + sameVerticalLine);

			maxPoints = Math.max(maxPoints, samePoint + 1 + currentMaxPoints);
			// one here denotes the current point
			// Same point starts with '0'. If 3 same points are found, then along with the
			// current, it will be 4
		}

		return maxPoints;

	}

	public int maxPointsCopied(ArrayList<Integer> x, ArrayList<Integer> y) {
		if (x.isEmpty()) {
			return 0;
		}
		HashMap<String, Integer> slope = new HashMap<String, Integer>();
		int max = 0;
		for (int i = 0; i < x.size(); i++) {
			int x1 = x.get(i);
			int y1 = y.get(i);
			int duplicates = 0;

			int localMax = 0;
			slope.clear();

			for (int j = i + 1; j < x.size(); j++) {

				String slp = "";
				int x2 = x.get(j);
				int y2 = y.get(j);
				if (x1 == x2 && y1 == y2) {
					duplicates++;
					continue;
				} else if (x1 == x2) {
					slp = "Vertical";
				} else if (y1 == y2) {
					slp = "Horizontal";
				} else {
					slp = String.valueOf((1.0) * (y2 - y1) / (x2 - x1));
				}
				int count = slope.getOrDefault(slp, 0);
				slope.put(slp, count + 1);
				localMax = Math.max(localMax, count + 1);
			}
			localMax += duplicates;
			max = Math.max(localMax, max);
		}
		return max + 1;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, -1 };
		int[] b = { 0, 1, -1 };

		/*
		 * int[] a = {-6, 5, -18, 2, 5, -2}; int[] b = {-17, 16, -17, -4, -13, 20};
		 */

		/*
		 * int[] a = {-2, -9, 4, -7, 5, 10, 1}; int[] b = {-17, -19, -12, -15, -3, 11,
		 * 4};
		 */
		// 7 -2 -17 -9 -19 4 -12 -7 -15 5 -3 10 11 1 4

		// 7
		//
		ArrayList<Integer> A = new ArrayList<>(a.length);
		for (int i : a) {
			A.add(i);
		}

		ArrayList<Integer> B = new ArrayList<>(a.length);
		for (int i : b) {
			B.add(i);
		}

		PointsOnLine pointsOnLine = new PointsOnLine();
		System.out.println("pointsOnLine=" + pointsOnLine.maxPoints(A, B));

	}

	// -6 -17 5 -16 -18 -17 2 -4 5 -13 -2 20

}

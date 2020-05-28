package com.my.hashing;

import java.util.*;

public class TwoSum {

	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {

		ArrayList<Integer> result = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			if (map.containsKey(new Integer(B - A.get(i)))) {
				if (i < map.get(B - A.get(i))) {
					result.add(i + 1);
					result.add(map.get(B - A.get(i)) + 1);
				} else {
					result.add(map.get(B - A.get(i)) + 1);
					result.add(i + 1);
				}
				return result;
			} else {
				if (!map.containsKey(A.get(i))) {
					map.put(A.get(i), i);// We don't overwrite because, first one is preferred in solution compared to
											// the second
				}
			}
		}
		return result;
	}
}

package com.my.twopointers;

import java.util.ArrayList;

public class RemoveInstances {

	public int removeElement(ArrayList<Integer> a, int b) {
		int n = a.size();
		int i, j;

		for (i = 0, j = 0; j < n; j++) {
			if (a.get(j) != b) {
				a.set(i, a.get(j));
				i++;
			}
		}

		return i;
	}
}

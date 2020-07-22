package com.my.leet.medium.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortCharsByFrequency {

	public String frequencySort(String s) {
		int[][] count = new int[256][2];

		for (char c : s.toCharArray()) {
			count[c][0] = c; //stores the char
			count[c][1]++;  // stores the frequency
		}

		Arrays.sort(count, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] == b[1] ? 0 : (a[1] < b[1] ? 1 : -1);
			}
		});
		
		Arrays.sort(count, new Comparator<int[]>() {
		  public int compare(int[] a, int[] b) {
		      return b[1] - a[1];
		  }

		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			if (count[i][1] > 0) {
				for (int j = 0; j < count[i][1]; j++) {
					sb.append((char) count[i][0]);
				}
			}
		}

		return sb.toString();
	}

}

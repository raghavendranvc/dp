package com.my.leet.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

	// https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/435.%20Non-overlapping%20Intervals.md
	// Sort + greedy

	public int eraseOverlapIntervals(int[][] intervals) {
		int len = intervals.length;
		if (len == 0)
			return 0;
		Arrays.sort(intervals, (a, b) -> {
			return a[1] - b[1];
		});

		int end = intervals[0][1];
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (intervals[i][0] >= end) {
				end = intervals[i][1];
				count++;
			}
		}
		return len - count;
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length < 2) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		int end = intervals[0].end;
		int min = 0;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < end) {
				end = Math.min(end, intervals[i].end);
				min++;
			} else {
				end = intervals[i].end;
			}
		}

		return min;
	}

}

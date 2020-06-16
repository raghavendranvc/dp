package com.my.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {

	public static class Interval {
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

		public String toString() {
			return "start=" + start + " end=" + end;
		}
	}

	public class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start) {
				return -1;
			} else if (i2.start < i1.start) {
				return 1;
			} else {
				if (i1.end <= i2.end) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());

		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		System.out.println(intervals);

		ArrayList<Interval> resultSet = new ArrayList<>();

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); i++) {
			if (end >= intervals.get(i).start) {
				end = Math.max(end, intervals.get(i).end);
			} else {
				Interval interval = new Interval(start, end);
				resultSet.add(interval);
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}

		Interval interval = new Interval(start, end);
		resultSet.add(interval);

		/*
		 * int start = -1; int end = -1; for(int i=0;i<intervals.size();i++){ if(start
		 * == -1){ start = intervals.get(i).start; end = intervals.get(i).end; continue;
		 * }
		 * 
		 * if(intervals.get(i-1).end > intervals.get(i).start){ continue; } else { end =
		 * Math.max(end,intervals.get(i).end); Interval interval = new
		 * Interval(start,end); resultSet.add(interval); start = -1; } }
		 */
		System.out.println(resultSet);
		return resultSet;
	}

	public static void main(String[] args) {

		// A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]
		ArrayList<Interval> arrayList = new ArrayList<>();
		/*
		 * arrayList.add(new Interval(1,10)); arrayList.add(new Interval(2,9));
		 * arrayList.add(new Interval(3,8)); arrayList.add(new Interval(4,7));
		 * arrayList.add(new Interval(5,6)); arrayList.add(new Interval(6,6));
		 */

		arrayList.add(new Interval(47, 76));
		arrayList.add(new Interval(51, 99));
		arrayList.add(new Interval(28, 78));
		arrayList.add(new Interval(54, 94));
		arrayList.add(new Interval(12, 72));
		arrayList.add(new Interval(31, 72));
		arrayList.add(new Interval(12, 55));
		arrayList.add(new Interval(24, 40));
		arrayList.add(new Interval(59, 79));
		arrayList.add(new Interval(41, 100));
		arrayList.add(new Interval(46, 99));
		arrayList.add(new Interval(5, 27));
		arrayList.add(new Interval(13, 23));
		arrayList.add(new Interval(9, 69));
		arrayList.add(new Interval(39, 75));
		arrayList.add(new Interval(51, 53));
		arrayList.add(new Interval(81, 98));
		arrayList.add(new Interval(14, 14));
		arrayList.add(new Interval(27, 89));
		arrayList.add(new Interval(73, 78));
		arrayList.add(new Interval(28, 35));
		arrayList.add(new Interval(19, 30));
		arrayList.add(new Interval(39, 87));
		arrayList.add(new Interval(4, 4));
		// arrayList.add(new Interval (60, 94), (71, 90), (9, 44), (56, 79), (58, 70),
		// (25, 76), (18, 46), (14, 96), (43, 95), (70, 77), (13, 59), (52, 91), (47,
		// 56), (63, 67), (28, 39), (51, 92), (30, 66), (4, 4), (29, 92), (58, 90), (6,
		// 20), (31, 93), (52, 75), (41, 41), (64, 89), (64, 66), (24, 90), (25, 46),
		// (39, 49), (15, 99), (50, 99), (9, 34), (58, 96), (85, 86), (13, 68), (45,
		// 57), (55, 56), (60, 74), (89, 98), (23, 79), (16, 59), (56, 57), (54, 85),
		// (16, 29), (72, 86), (10, 45), (6, 25), (19, 55), (21, 21), (17, 83), (49,
		// 86), (67, 84), (8, 48), (63, 85), (5, 31), (43, 48), (57, 62), (22, 68), (48,
		// 92), (36, 77), (27, 63), (39, 83), (38, 54), (31, 69), (36, 65), (52, 68) ]

		MergeInterval mergeInterval = new MergeInterval();

		mergeInterval.merge(arrayList);
	}

	public ArrayList<Interval> insertCopied(ArrayList<Interval> intervals, Interval newInterval) {
		Interval current = newInterval;
		int i = 0;

		while (i < intervals.size()) {
			Interval in = intervals.get(i);
			if (in.end < current.start) {
				i++;
			} else if (in.start > current.end) {
				// This happens when CI, IN does not overlap
				// This is a non overlapping addition
				// in.end is greater than current.start
				// does in.start is also greater than current.start?
				intervals.add(i, current);
				break;
			} else {
				// We form the new Interval and will remove the existing one
				current.start = Math.min(in.start, current.start);
				current.end = Math.max(in.end, current.end);
				intervals.remove(i);
				// We don't add it immediately. We allow the new interval to get
				// added appropriately and so will continue to loop
			}
		}
		if (i == intervals.size()) {
			intervals.add(current);
		}
		return intervals;
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		/*
		 * Interval[] intervalArray = intervals.toArray(new Interval[intervals.size()]);
		 * 
		 * intervals = Arrays.sort(intervals.toArray(new Interval[intervals.size()]),
		 * (i1,i2) -> {
		 * 
		 * return 0; });
		 */

		int originalSize = intervals.size();
		int i = 0;
		for (; i < originalSize; i++) {
			if (intervals.get(i).start < newInterval.start) {
				continue;
			} else {
				if (intervals.get(i).start == newInterval.start) {
					if (intervals.get(i).end <= newInterval.end) {
						continue;
					}
				}
			}
			// System.out.println("i="+i+" int="+intervals.get(i)+"
			// newInterval="+newInterval);
			break;
		}

		// System.out.println(intervals);

		if (i == originalSize) {
			intervals.add(newInterval);
		} else {
			// i+1, i+2, i+3 .... n
			// i+1(x), i+2, i+3 .... n, n+1
			intervals.add(intervals.get(originalSize - 1)); // Move 1 to the right
			for (int j = originalSize - 1; j > i; j--) {
				intervals.set(j, intervals.get(j - 1));
			}
			intervals.set(i, newInterval);
		}

		// System.out.println("After Insertion");
		// System.out.println(intervals);

		ArrayList<Interval> returnList = new ArrayList<>();

		returnList.add(intervals.get(0));

		for (i = 1; i < intervals.size(); i++) {

			Interval i1 = returnList.get(returnList.size() - 1);
			Interval i2 = intervals.get(i);
			// System.out.println("interation="+i+ " Checking i1="+i1+" i2"+i2);
			if (overlaps(i1, i2)) {
				returnList.set(returnList.size() - 1, getMergedInterval(i1, i2));
			} else {
				returnList.add(i2);
			}

			// System.out.println(returnList);
		}

		System.out.println(returnList);
		return returnList;
	}

	public Interval getMergedInterval(Interval i1, Interval i2) {
		Interval interval = new Interval();
		if (i1.start <= i2.start) {
			interval.start = i1.start;
		} else {
			interval.start = i2.start;
		}

		if (i1.end <= i2.end) {
			interval.end = i2.end;
		} else {
			interval.end = i1.end;
		}

		return interval;
	}

	public boolean overlaps(Interval i1, Interval i2) {

		if (i1.start < i2.start) {
			if (i1.end > i2.start) {
				return true;
			}
		} else if (i1.start > i2.start) {
			if (i2.end > i1.start) {
				return true;
			}
		} else {
			return true;
		}

		return false;
	}

	public static void main1(String[] args) {
		ArrayList<Interval> A = new ArrayList<>();
		A.add(new Interval(6037774, 6198243));
		A.add(new Interval(6726550, 7004541));
		A.add(new Interval(8842554, 10866536));
		A.add(new Interval(11027721, 11341296));
		A.add(new Interval(11972532, 14746848));
		A.add(new Interval(16374805, 16706396));
		A.add(new Interval(17557262, 20518214));
		A.add(new Interval(22139780, 22379559));
		A.add(new Interval(27212352, 28404611));
		A.add(new Interval(28921768, 29621583));
		A.add(new Interval(29823256, 32060921));
		A.add(new Interval(33950165, 36418956));
		A.add(new Interval(37225039, 37785557));
		A.add(new Interval(40087908, 41184444));
		A.add(new Interval(41922814, 45297414));
		A.add(new Interval(48142402, 48244133));
		A.add(new Interval(48622983, 50443163));
		A.add(new Interval(50898369, 55612831));
		A.add(new Interval(57030757, 58120901));
		A.add(new Interval(59772759, 59943999));
		A.add(new Interval(61141939, 64859907));
		A.add(new Interval(65277782, 65296274));
		A.add(new Interval(67497842, 68386607));
		A.add(new Interval(70414085, 73339545));
		A.add(new Interval(73896106, 75605861));
		A.add(new Interval(79672668, 84539434));
		A.add(new Interval(84821550, 86558001));
		A.add(new Interval(91116470, 92198054));
		A.add(new Interval(96147808, 98979097));

		Interval B = new Interval(36210193, 61984219);

		MergeInterval mergeIntervals = new MergeInterval();
		mergeIntervals.insert(A, B);

	}

}

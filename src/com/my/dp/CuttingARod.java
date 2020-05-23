package com.my.dp;

public class CuttingARod {
	
	/********************One way********************************************/
	

	public int maxValueByCutting(int[] lengths, int[] values, int start, int end) {

		/*
		 * Given a rod, we have 2 choices. Either cut it or don't cut it.
		 */

		/*
		 * Case 1: No cut. So value is the rod length ::(end-start)
		 */

		int currentMax = values[end - start - 1];

		/*
		 * Case 2: Cut it at position k (start<k<end). Have the max of both the
		 * positions
		 * 
		 * 
		 */

		for (int k = start + 1; k < end; k++) {
//			System.out.println("start="+start+" End="+end+" k="+k +" currentMax="+currentMax);
			int value = maxValueByCutting(lengths, values, start, k) + maxValueByCutting(lengths, values, k, end);
			if (currentMax < value) {
//				System.out.println("New value selected="+value);
				currentMax = value;
			}
//			currentMax = Math.max(currentMax,maxValueByCutting(lengths, values,start,k)+maxValueByCutting(lengths, values,k,end));
		}
		return currentMax;
	}
	
	/********************One way********************************************/

	public int maxValueSimpleRecu(int[] values, int size) {
		if (size <= 0) {
			return 0;
		}

		int maxValue = Integer.MIN_VALUE;
		/*
		 * i=0 means size = 1 so it moves from 0 to size-1 when i=size-1 then no cut is
		 * made.
		 */
		for (int i = 0; i < size; i++) {
			maxValue = Math.max(maxValue, values[i] + maxValueSimpleRecu(values, size - (i + 1)));
		}
		return maxValue;
	}
	
	/********************Iter way********************************************/

	public int maxValueIter(int[] values, int size) {
		int[] tables = new int[size + 1];

		/*
		 * For 0. The value is 0 
		 * For size, the values is values[size-1]
		 */
		tables[0] = 0;
		tables[size - 1] = values[size - 1];

		/*
		 * From each i from 1 to size (for all sizes) For rod size 1 : we calculate what
		 * is the max we get by cutting it For rod size 2 : we calculate what is the max
		 * we get by cutting it
		 */
		for (int i = 1; i <= size; i++) {
			System.out.println("------" + i);
			tables[i] = Integer.MIN_VALUE;
			// When j=0 we are cutting at length 1 for rod of size i
			// When j=1 we are cutting at length 2 for rod of size i
			for (int j = 0; j < i; j++) {
				int valGot = values[j] + tables[i - j - 1];
				System.out.println("j=" + j + " value=" + values[j] + " tables[" + (i - j - 1) + "]="
						+ tables[i - j - 1] + " valGot=" + valGot);
				tables[i] = Math.max(tables[i], values[j] + tables[i - j - 1]);
			}
			System.out.println("tables[" + i + "]=" + tables[i]);
		}
		return tables[size];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] lengths = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] values =  { 1, 5, 8, 9, 10, 17, 17, 20 };

		/*
		 * int[] lengths = {1,2,3,4,5,6,7,8}; int[] values = {3,5,8,9,10,17,17,20};
		 */

		int start = 0;
		int end = lengths.length;

		CuttingARod cr = new CuttingARod();
		int val1 = cr.maxValueByCutting(lengths, values, start, end);
		System.out.println("val1=" + val1);

		int val2 = cr.maxValueSimpleRecu(values, end);
		System.out.println("val2=" + val2);

		int val3 = cr.maxValueIter(values, end);
		System.out.println("val3=" + val3);

	}

}

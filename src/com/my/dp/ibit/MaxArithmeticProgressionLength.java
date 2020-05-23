package com.my.dp.ibit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxArithmeticProgressionLength {
	
	//TODO the mapping creation and updation needs to be carefully practiced

	public int solve(final List<Integer> A) {
		if (A == null) { 
			return 0;
		}

		if (A.size() == 1) {
			return 1;
		}

		int n = A.size();
		int max = 2; // minimum number of values are 2 , so possible AP length is 2

		/**
		 * At each i, we will have a map The map contains all possible AP lengths till
		 * that point
		 * 
		 * Below numbers are indexes, not the actual numbers.
		 * 
		 * At i = 1 Map(1) contains 1-0
		 * 
		 * At i = 2 Map(2) contains 2-0, 2-1
		 * 
		 * At i = 3 Map(3) contains all possible differences and their counts like 3-0,
		 * 3-1, 3-2
		 * 
		 * At i = 4 Map(4) contains all possible differences like 4-0(a), 4-1(b),
		 * 4-2(c), 4-3(d) Then map will have <a,1> <b,1> <c,1> <d,1> if a,b,c,d are
		 * distinct
		 * 
		 * For Map(4), 4-2 (4,2 are indexes) differences is 'c' which is an AP of length
		 * 1, We check if 'c' is already present for Map(2). If yes, then get it's value
		 * using Map(2,c)=x and then update Map(4,c) with x+1
		 * 
		 * 
		 */

		ArrayList<Map<Integer, Integer>> mapList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			mapList.add(new HashMap<Integer, Integer>());
		}

		for (int i = 1; i < n; i++) {

			Map<Integer, Integer> updateCounts = mapList.get(i);

			for (int j = 0; j < i; j++) {

				int diffKey = A.get(i) - A.get(j); // value does not matter, but we need to stick with this particular
													// ordering always

				int countIfThereWasEarlierAPWithJIndexForTheSameDiff = mapList.get(j).getOrDefault(diffKey, 0);
				if (countIfThereWasEarlierAPWithJIndexForTheSameDiff > 0) {
					// We only increment by 1, because j was already included in the earlier AP
					updateCounts.put(diffKey, countIfThereWasEarlierAPWithJIndexForTheSameDiff + 1);
					max = Math.max(max, countIfThereWasEarlierAPWithJIndexForTheSameDiff + 1); // Update
				} else {
					updateCounts.put(diffKey, 2);
				}
			}
		}
		
		return max;

	}
	
	
	//TODO practice gain

	public int solveCopied(final List<Integer> A) {

		int n = A.size();
		int max = 1;
		if (n > 1) {
			max = 2;
		}
		ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<HashMap<Integer, Integer>>();
		for (int i = 0; i < n; i++) {
			dp.add(new HashMap<Integer, Integer>());
		}
		for (int i = 1; i < A.size(); i++) {
			HashMap<Integer, Integer> hmi = dp.get(i);
			for (int j = 0; j < i; j++) {
				HashMap<Integer, Integer> hmj = dp.get(j);
				if (hmj.containsKey(A.get(i) - A.get(j))) {

					hmi.put(A.get(i) - A.get(j), hmj.get(A.get(i) - A.get(j)) + 1);
					max = Math.max(hmi.get(A.get(i) - A.get(j)), max);
				} else {
					// System.out.println("*");
					hmi.put(A.get(i) - A.get(j), 2);
				}
			}
		}
		return max;
	}

	
	public boolean is3LengthAPExsits(int[] a){
		int n = a.length;
		if(n<3){
			return false;
		}
		
		/*
		 *  for 1,2,3, ..... n-2 (leaving 0 and n-1) do the below
		 *  
		 */
		for(int i=1;i<n-1;i++){
			int j=i-1;
			int k=i+1;
			
			while(j>=0 && k <=n-1){
				if(2*a[i] == a[j]+a[k]){
					return true;
				}
				
				
				if(2*a[i] > a[j]+a[k]){
					k++;
				}else {
					j--;
				}
				
			}
		}
		
		return false;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] set1 = {1, 7, 10, 13, 14, 19};
		int[] set2 = {1, 7, 10, 15, 27, 29};
		int[] set3 = {2, 4, 6, 8, 10};
		int[] set4 = {2, 5, 10, 19, 30, 42, 60};
		
		MaxArithmeticProgressionLength lapSeries = new MaxArithmeticProgressionLength();
		boolean val1 = lapSeries.is3LengthAPExsits(set1);
		System.out.println("val1="+val1);
		boolean val2 = lapSeries.is3LengthAPExsits(set2);
		System.out.println("val2="+val2);
		boolean val3 = lapSeries.is3LengthAPExsits(set3);
		System.out.println("val3="+val3);
		boolean val4 = lapSeries.is3LengthAPExsits(set4);
		System.out.println("val1="+val4);

	}
}

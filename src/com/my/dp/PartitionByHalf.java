package com.my.dp;

import java.util.Arrays;

import com.my.common.UtilityClass;

public class PartitionByHalf {
	
	
	public boolean partition(int[] a){
		int sum = 0;
		for(int i=0;i<a.length;i++){
			sum += a[i];
		}
		
		/*
		 * If sum is odd then we cannot partition into 2 equal subsets
		 */
		if(sum % 2 != 0){  
			return false;
		}
		
		return findCombinationRever(a,sum/2,a.length-1);
	}

	//findCombination(a,sum/2,0)
	public boolean findCombination(int[] a,int targetSum,int index){
		
		
		if(targetSum == 0){
			return true;
		} else if(targetSum < 0){
			return false;
		} else if(targetSum > 0 && index == a.length){
			return false;
		}
		
		return (findCombination(a, targetSum-a[index], index+1) || findCombination(a, targetSum, index+1));
		
	}
	
	//findCombination(a,sum/2,a.length-1)
	public boolean findCombinationRever(int[] a,int targetSum,int index){
		
		
		if(targetSum == 0){
			return true;
		} else if(targetSum < 0){
			return false;
		} else if(targetSum > 0 && index == 0){
			return false;
		}
		
		return (findCombinationRever(a, targetSum-a[index], index-1) || findCombinationRever(a, targetSum, index-1));
		
	}
	
	/*
	 * Not implemented. Needs to improvde
	 */
	
	public boolean partitionIter(int[] a){
		int size = a.length;
		int[][] sumTable = new int[size+1][size];
		
		/*
		 * sumTable[0] contains cumulative sums
 		 */
		sumTable[0][0] = a[0];
		for(int i=1;i<size;i++){
			sumTable[0][i] = sumTable[0][i-1] + a[i];
		}
		
		/*
		 * Check whether sum is even. If add return false
		 */
		if(sumTable[0][size-1]%2 !=0){
			return false;
		}
		
		/*
		 * Get the target value
		 */
		int targetSum = sumTable[0][size-1]/2;
		
		/*
		 * Search for the targetSum in sumTable[0]
		 */
		for(int i=0;i<size;i++){
			Arrays.binarySearch(sumTable[0], targetSum);
		}
		
		boolean result = false;
		
		/*
		 * Now calculate all possible sums
		 */
		
		for(int i=1;i<size+1;i++){
			for(int j=0;j<size;j++){
				if(j > i+1){
					sumTable[i][j] = sumTable[0][j]-a[i-1];
				} else {
					sumTable[i][j] = sumTable[0][j];
				}
				if(sumTable[i][j] == targetSum){
					result = true;
				}
				
			}
		}
		
		UtilityClass.printArray(sumTable);
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PartitionByHalf ph = new PartitionByHalf();
//		int[] a = {1, 5, 11, 5};
		int[] a = {3, 1, 5, 9, 12};
//		int[] a = {3, 3, 5, 9, 12};
		
		UtilityClass.print(a);
		
		boolean canPart1 = ph.partition(a);
		System.out.println("canPart="+canPart1);
		
//		boolean canPart2 = ph.partitionIter(a);
//		System.out.println("canPart2="+canPart2);

	}

}

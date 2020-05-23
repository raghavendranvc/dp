package com.my.dp;

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
		} else if(targetSum < 0){ //assumption here is we only have positive numbers
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

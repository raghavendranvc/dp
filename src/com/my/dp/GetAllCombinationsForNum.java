package com.my.dp;

import com.my.common.UtilityClass;

public class GetAllCombinationsForNum {
	
	public void getAllCombinations(int sum){
		getAllCombinations(new int[sum],0, sum ,sum);
		
	}
	
	public boolean getAllCombinations(int[] a,int index, int currentSum,int num){
		
//		System.out.println("index="+index+" currentSum="+currentSum+" num="+num);
		
		if(currentSum == 0){
			UtilityClass.print(a, index);
			return true;
		}
		
		if(currentSum < 0){
			return false;  
		}
		
		for(int i=num;i>0;i--){
			a[index++] = i;
			getAllCombinations(a, index, currentSum-i, i);
			index--;
		}
		
		return true;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GetAllCombinationsForNum gac = new GetAllCombinationsForNum();
		gac.getAllCombinations(9);

	}

}

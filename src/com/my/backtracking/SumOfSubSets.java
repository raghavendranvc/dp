package com.my.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubSets {
	
	List<List<Integer>> allList = new ArrayList<List<Integer>>();
	
	
	public void GetAllCombinationsOfValue(int N){
		
		//TODO, this preparation of this table is very important
		int[] allDenom = new int[N-1];
		for(int i=0;i<N-1;i++){
			allDenom[i] = i+1;
		}
		
		GetAllCombinationsRecursively(N,N-1,allDenom,new ArrayList<Integer>());  // Including 1 && Excluding 1
		
	}
	
	public void GetAllCombinationsRecursively(int N,int currentDenom,int[] allDenominations, List<Integer> combination ){
		
		System.out.println("RECUR N="+N+" currentDenom="+currentDenom+" combination="+combination);
		
		if(N == 0){
			System.out.println("ADDED:: currentDenom="+currentDenom+" combination="+combination);
			allList.add(combination);
			return;
		}
		
		if(N  < 0){
			System.out.println("currentDenom="+currentDenom+" N="+N+" combination="+combination+" N<0");
			return;
		}
		
		if(currentDenom<=0 && N>0){
			System.out.println("currentDenom="+currentDenom+" N="+N+" combination="+combination+" N>0");
			return;
		}
		
		//We ignore here
		GetAllCombinationsRecursively(N,currentDenom-1,allDenominations,new ArrayList<Integer>(combination));
		
		combination.add(currentDenom); //Including and repeating to use it again in the subset combination
		//We use the denomination here
		GetAllCombinationsRecursively(N-allDenominations[currentDenom-1],currentDenom,allDenominations,combination);
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 6;
		SumOfSubSets ss = new SumOfSubSets();
		ss.GetAllCombinationsOfValue(N);
		System.out.println(ss.allList);

	}

}

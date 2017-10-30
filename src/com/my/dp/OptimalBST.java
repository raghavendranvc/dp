package com.my.dp;

import java.util.ArrayList;
import java.util.List;

import com.my.common.UtilityClass;

public class OptimalBST {
	
	public int getCostForOBST(int[] keys,int[] freq){
		int n = keys.length;
		return getMinOBST(freq, 0, n-1);
	}
	
	public int getMinOBST(int[] freq,int i,int j){
		
		if(j<i){
			return 0;
		}
		
		if(j==i){
			return freq[i];
		}
		
		int minVal = Integer.MAX_VALUE;
		int sumVal = getSum(freq,i,j);
		
		for(int k=i;k<=j;k++){
			int getVal = sumVal + getMinOBST(freq, i, k-1) + getMinOBST(freq, k+1, j);
			minVal = Math.min(minVal, getVal);
		}
		return minVal;
	}
	
	public List<Integer> getPathForOBST(int[] keys,int[] freq){
		int n = keys.length;
		List<Integer> minPathList = new ArrayList<Integer>();
		getMinPathOBST(freq, 0, n-1,minPathList);
		return minPathList;
	}
	
	public int getMinOBSTIter(int[] keys,int[] freq){
		int n = keys.length;
		
		int[][] table = new int[n][n];
		
		for(int i=0;i<n;i++){
			table[i][i] = freq[i];
		}
		
		UtilityClass.printArray(table);
		System.out.println();
		
		for(int len=2;len<=n;len++){
			for(int i=0;i<n-len+1;i++){
				
				int minVal = Integer.MAX_VALUE;
				int j = i+len-1; //endIndex
				int sumVal = getSum(freq,i,j);
				
				for(int k=i;k<i+len;k++){
					System.out.println("len="+len+" i="+i+" j="+j+ "  sumVal="+sumVal+" k="+k);
					int getVal = sumVal + 
							(k>i ? table[i][k-1]:0) + 
							(k<j ? table[k+1][j]:0);
					if(minVal > getVal){
						minVal = getVal;
					}
				}
				table[i][j] = minVal;
						
			}
			UtilityClass.printArray(table);
			System.out.println();
		}
		
		
		return table[0][n-1];
		
	}
	
	/*
	 * Not fully implemented
	 */
	public int getMinPathOBST(int[] freq,int i,int j,List<Integer> minPathList){
		
		System.out.print("i="+i+" j="+j+" minPathList="+minPathList+" ");
		if(j<i){
			System.out.println();
			return 0;
		}
		
		if(j==i){
			System.out.println("(i==j)="+freq[i]+" ");
			minPathList.add(new Integer(i));
			return freq[i];
		}
		
		int minVal = Integer.MAX_VALUE;
		int sumVal = getSum(freq,i,j);
		System.out.print(" sumVal="+sumVal);
		for(int k=i;k<=j;k++){
			System.out.print(" k="+k +" ");
			List<Integer> subList = new ArrayList<Integer>();
			int getVal = sumVal + getMinPathOBST(freq, i, k-1,subList) + getMinPathOBST(freq, k+1, j,subList);
			if(minVal > getVal){
				minVal = getVal;
				minPathList.add(new Integer(k));
				minPathList.addAll(subList);
			} else {
				minPathList.clear();
			}
			System.out.println("   minVal="+minVal+" subList="+subList+" minPathList="+minPathList);
		}
		return minVal;
	}
	
	public int getSum(int[] freq,int i,int j){
		int sum = freq[i];
		for(int k=i+1;k<=j;k++){
			sum += freq[k];
		}
		return sum;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OptimalBST obst = new OptimalBST();
		/*
		 * Keys will be in ascending order
		 */
		int[] keys = {10, 12, 20};  
		
	    int[] freq = {34, 8, 50}; // Min=142 : Path=2,0,1
	    
	    int val1 = obst.getCostForOBST(keys, freq);
	    System.out.println("val1="+val1);
	    
	    int val2 = obst.getMinOBSTIter(keys, freq);
	    System.out.println("val2="+val2);
	    
	    /*List<Integer> list = obst.getPathForOBST(keys, freq);
	    System.out.println("list="+list);*/
	    
	}

}

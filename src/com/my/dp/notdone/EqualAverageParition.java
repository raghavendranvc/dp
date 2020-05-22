package com.my.dp.notdone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EqualAverageParition {
	
	//TODO NOT DONE
	
	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {

		  ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();
		  if(A == null || A.isEmpty()){
		    return returnList;
		  }
		  Collections.sort(A);
		  int n = A.size();
		  int[] p = new int[n];
		  p[0] = A.get(0);

		  for(int i=1;i<n;i++){
		    p[i] = p[i-1] + A.get(i);
		  }

		  return returnList;
		  
		  
		}

		// 23 11 24 12 8 9 14 15
		// 23+12+8+15 = 24+11+9+14

		// 8+12+15+23 = 9+11+14+24

		/*
		 * Average%2 == 0 else not possible
		 * 
		 * c[i,j] = c[j]-c[i-1]; i<=j c[i,i] = A[i]; i==j
		 * 
		 * dp[0,i]/(i-0) = dp[i+1,n]/(n-i+1)
		 */




}

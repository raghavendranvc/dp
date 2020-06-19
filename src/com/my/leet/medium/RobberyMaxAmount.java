package com.my.leet.medium;

public class RobberyMaxAmount {
	
	/***ALl houses in a line***********/
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        
        if(n == 1){
            return nums[0];
        }
        
        if(n == 2){
            return Math.max(nums[0],nums[1]); 
        }
        
        int[] sol = new int[n];
        
        sol[0] = nums[0];
        sol[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<n;i++){
            sol[i] = Math.max(nums[i] + sol[i-2], sol[i-1]);
        }
        
        return sol[n-1];        
    }
	
	// houses in a circle--------------------------------------
	
	public int rob2(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        
        if(n == 1){
            return nums[0];
        }
        
       
        //Here, we shall rob the first house and not the last one
        int[] solWithFirst = new int[n+1];
        
        solWithFirst[0] = 0;
        solWithFirst[1] = nums[0];
        
        for(int i=2;i<n;i++){
        	solWithFirst[i] = Math.max(
        			solWithFirst[i-1], //Either the previous value
        			nums[i-1] + solWithFirst[i-2]); //Considering this house
        }
        solWithFirst[n] = solWithFirst[n-1]; //ignoring the last one
        
        //Here, we will not rob the first house, but we may rob the last one
        int[] solWithLast = new int[n+1];
        
        solWithLast[0] = 0;
        solWithLast[1] = 0;
        
        for(int i=2;i<n+1;i++) {
        	solWithLast[i] = Math.max(
        			solWithLast[i-1], 
        			solWithLast[i-2]+nums[i-1]);
        }
        
        return Math.max(solWithFirst[n], solWithLast[n]);    
	}
	
}

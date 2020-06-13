package com.my.leet;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
        int i = 0;
        int nonZero = 0;
        
        while(i < nums.length){
            if(nums[i] != 0){
                nums[nonZero++] = nums[i]; 
            }
            i++;
        }
        
        while(nonZero<nums.length){
            nums[nonZero++] = 0;
        }
        
    }

}

package com.my.stacksqueues;

import java.util.List;

public class RainWaterTrapped {

	//TODO Pracice this again. We can also do in a different way
	
    public int trap(final List<Integer> A) {

        int n = A.size();
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = A.get(0);
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],A.get(i));
        }

        rightMax[n-1] = A.get(n-1);
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],A.get(i));
        }

        int result = 0;
        for(int i=0;i<n-1;i++){
            result = result + Math.min(rightMax[i],leftMax[i]) - A.get(i);
        }

        return result;

    }

    public int trapWithSimpleVar(final List<Integer> A) {

        int n = A.size();

        int count = 0;

        int leftMax = 0;
        int rightMax = 0;

        int left=0;
        int right=n-1;

        while(left <= right){
            if(A.get(left) < A.get(right)){
                if(A.get(left) > leftMax){
                    leftMax = A.get(left);
                } else {
                    count += leftMax - (A.get(left));
                }
                left++;
            } else {
                if(A.get(right) > rightMax){
                    rightMax = A.get(right);
                } else {
                    count += rightMax - (A.get(right));
                }
                right++;
            }
        }

        return count;
    }
}

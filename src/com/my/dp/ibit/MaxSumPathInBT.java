package com.my.dp.ibit;

public class MaxSumPathInBT {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// This does not work as expected. We need to find the bug
	
	int countMax = Integer.MIN_VALUE;
	public int maxPathSumRecur(TreeNode A) {
		if(A == null) {
			return 0;
		}
		
		int l = maxPathSum(A.left);
		int r = maxPathSum(A.right);
		
		int valueAtTree = Math.max(A.val,Math.max(l,r)+A.val);
		
		int mVal = Math.max(valueAtTree, A.val+l+r );
		
		countMax = Math.max(countMax, mVal);
		return valueAtTree;
    }
	
	//TODO //We need to understand the logic will
	
	public int maxPathSum1(TreeNode A) {
		maxPathSumRecur(A);
		return countMax;
    }
	
	public int maxPathSum(TreeNode A) {
		maxPathSumHelper(A);
		return countMax;
    }
	
	private int maxPathSumHelper(TreeNode A) {
        if (A == null)
            return 0;
        
        int sumL = Math.max(maxPathSumHelper(A.left), 0);// 0, x
        int sumR = Math.max(maxPathSumHelper(A.right), 0); // 0, y
        
        countMax = Math.max(countMax, A.val + sumL + sumR);  // A.val+x+y
        
        return A.val + Math.max(sumL, sumR);
    }
	
    
}

package com.my.dp;

public class MinInsertionsForPalindrome {
	
	/********************One way********************************************/
	
	public int getMinInsertionsNeeded(String str){
		return getMinInsertionsNeeded(str,0,str.length()-1);
	}
	
	public int getMinInsertionsNeeded(String str,int l,int h){
		/*
		 * When boundary conditions are not proper
		 */
		if(l>h){
			return Integer.MAX_VALUE;
		}
		
		/*
		 * For string of length=1
		 */
		
		if(l==h){
			return 0;
		}
		
		/*
		 * For string of length=2
		 */
		
		if(l+1 == h){
			if(str.charAt(l) == str.charAt(h)){
				return 0;
			}else {
				return 1;
			}
		}
		
		/*
		 * For all other string lengths
		 */
		if(str.charAt(l) == str.charAt(h)){
			return getMinInsertionsNeeded(str,l+1,h-1);
		} else {
			return 1 + Math.min(getMinInsertionsNeeded(str,l+1,h),getMinInsertionsNeeded(str,l,h-1));
		}
	}
	
	/********************One way********************************************/
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "geeks";
		//String str = "programming";
		MinInsertionsForPalindrome mPal = new MinInsertionsForPalindrome();
		int val1 = mPal.getMinInsertionsNeeded(str);
		System.out.println("str="+str+" val1="+val1);
		
		//int val2 = mPal.getMinInsertionsNeededIter(str);
		//System.out.println("str="+str+" val2="+val2);

	}

}

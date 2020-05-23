package com.my.dp;


public class MaximumProductCutting {
	
	/********************One way********************************************/
	
	public int getMaxProductCutVal(int l){
		
//		System.out.println(l+" --In");
		/*
		 * l=0 should not be called. If called we return 0
		 * l=1 max product using length 1 is 1. No further cuts.
		 */
		if(l < 2) {
			return 0;
		}
		
		int maxProd = 0;
		for(int i=1;i<=l/2;i++){
			maxProd = Math.max(maxProd,
					Math.max(i,getMaxProductCutVal(i)) * Math.max(l-i,getMaxProductCutVal(l-i))
					);
		}
//		System.out.println(l+" --Out="+maxProd);
		return maxProd;
	}
	
	/********************Iter way********************************************/
	
	public int getMaxProductCutValIter(int l){
		int[] table = new int[l+1];

		if(l < 2){
			return 0;
		}
		
		table[0] = 0;
		table[1] = 0;
		
		table[l] = 0;
		
		for(int i=1;i<=l;i++){
			int maxProd = 0;
			for(int j=1;j<=i/2;j++){
				maxProd = Math.max(maxProd, Math.max(j,table[j])*Math.max(i-j, table[i-j]));
			}
			
			table[i] = maxProd;
		}
		
		return table[l];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumProductCutting mpc = new MaximumProductCutting();
		
		for(int i=0;i<=20;i++){
			int val = mpc.getMaxProductCutVal(i);
			System.out.println("For "+i+" ="+val);
		}
		
		System.out.println("----");
		
		for(int i=2;i<=20;i++){
			int val = mpc.getMaxProductCutValIter(i);
			System.out.println("For "+i+" ="+val);
		}
		

	}

}

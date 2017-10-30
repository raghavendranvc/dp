package com.my.dp;

public class MaxChainOfPairs {
	
	static class Pair{
		int a,b;
		Pair(int a,int b){
			this.a = a;
			this.b = b;
		}
	}
	
	/*
	 * Pair is an array of Pair sorted as per the Pair.a 
	 */
	public int getMaxLength(Pair[] a){
		int numOfPairs = a.length;
		
		int[] table = new int[numOfPairs];
		
		/*
		 * Initializing the table. For each pair starting and ending with itself, the length is 1
		 */
		for(int i=0;i<numOfPairs;i++){
			table[i]=1;
		}
		
		
		for(int i=1;i<numOfPairs;i++){
			for(int j=0;j<i;j++){
				if(a[j].b < a[i].a){
					table[i] = Math.max(table[i], 1+table[j]);
				}
			}
		}
		
		int maxLength = table[0];
		for(int i=0;i<numOfPairs;i++){
			maxLength = Math.max(maxLength, table[i]);
		}
		return maxLength;
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pair[] a = { 
				new Pair(5, 24), 
				new Pair(15, 25),
				new Pair(27, 40), 
				new Pair(50, 60) };
		MaxChainOfPairs mcp = new MaxChainOfPairs();
		int length = mcp.getMaxLength(a);
		System.out.println("length="+length);

	}

}

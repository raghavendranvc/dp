package com.my.dp;

public class FibinooriceSeries {
	
	/********************One way********************************************/
	
	public int fibinocciRecur(int i){
		if(i==0){
			return 0;
		}else if(i==1){
			return 1;
		} else {
			return (fibinocciRecur(i-2)+fibinocciRecur(i-1));
		}
	}
	
	/********************One way********************************************/
	
	public int fibinocciTabulation(int i){
		int[] table = new int[i+2];
		table[0]=0;
		table[1]=1;
		
		for(int k=2;k<=i;k++){
			table[k] = table[k-2] + table[k-1];
		}
		return table[i];
	}
	
	/********************One way********************************************/
	
	public int fibinocciSimpleVariables(int i){
		if(i==0){
			return 0;
		}else if(i==1){
			return 1;
		}
		
		int a = 0;
		int b = 1;
		
		for(int k=2;k<=i;k++){
			int next = a + b;
			a = b;
			b = next;
		}
		return b;
	}

	/********************One way********************************************/
	
	public int fibinocciSimpleVar(int i){
		if(i==0){
			return 0;
		}else if(i==1){
			return 1;
		}
		           //         a b
		int a = 0; // 0 1 1 2 3 5 8
		int b = 1;
		
		for(int k=2;k<=i;k++){
			b = a + b;
			a = b - a;
		}
		return b;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibinooriceSeries fb = new FibinooriceSeries();
		int[] test = {1,2,3,4,5,6,7,8};
		
		for(int i=0;i<test.length;i++){
			System.out.print(i+"=");
			System.out.print(fb.fibinocciRecur(i)+"  ");
			System.out.print(fb.fibinocciTabulation(i)+"  ");
			System.out.println(fb.fibinocciSimpleVariables(i)+"  ");
		}
		

	}

}

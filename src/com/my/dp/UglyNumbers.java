package com.my.dp;

import com.my.common.UtilityClass;

public class UglyNumbers {
	
	public int getUglyNumber(int u){
		
		if(u==0){
			return 0;
		}
		
		int[] un = new int[u];
		
		int index_2 = 0;
		int index_3 = 0;
		int index_5 = 0;
				
		un[0]=1;
		for(int i=1;i<u;i++){
			int m2 = un[index_2]*2;
			int m3 = un[index_3]*3;
			int m5 = un[index_5]*5;
			
			un[i] = Math.min( m2, Math.min(m3,m5) ); 
			if(un[i] == m2){
				index_2++;
				System.out.print(" "+un[i]+"=Incremented index_2="+index_2);
			}
			
			if(un[i] == m3){
				index_3++;
				System.out.print(" "+un[i]+"=Incremented index_3="+index_3);
			}
			
			if(un[i] == m5){
				index_5++;
				System.out.print(" "+un[i]+"=Incremented index_5="+index_5);
			}
			System.out.println();
		}
		System.out.println("index_2="+index_2+" index_3="+index_3+" index_5="+index_5);
		
		UtilityClass.print(un);
		
		return un[u-1];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UglyNumbers uNum = new UglyNumbers();
		int val1 = uNum.getUglyNumber(30);
		System.out.println("val1="+val1);

	}

}

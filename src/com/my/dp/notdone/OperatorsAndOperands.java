package com.my.dp.notdone;

import java.util.HashSet;
import java.util.Set;

import com.my.common.UtilityClass;

/*
 * Not implemented. Implement fully later
 */

public class OperatorsAndOperands {
	
	public enum OPERATOR{
		SUM, MINUS, MUL, DIV;
	}
	
	public int getVal(int i,int j,OPERATOR oper){
		switch(oper){
		case DIV: return i/j;
			
		case MINUS: return i-j;
			
		case MUL: return i*j;
			
		case SUM: return i+j;
		
		}
		
		return 0;
	}
	
	public Set<Integer> getOperands(int a,int b,int[] counterArray){
		Set<Integer> values = new HashSet<Integer>();
		values.add(a+b); counterArray[a+b]+=2;
		values.add(a-b); counterArray[a-b]+=1;
		values.add(a*b); counterArray[a*b]+=2;
		values.add(a/b); counterArray[a/b]+=1;
		values.add(b-a); counterArray[b-a]+=1;
		values.add(b/a); counterArray[b/a]+=1;
		return values;
	}
	
	/*
	
	public int getNumberOfWaysRecur(int[] operands,OPERATOR[] operations, int numOfOperands, int destVal,int operandIndex,int operatorIndex){
		if(numOfOperands == 0){
			return 0;
		}
		if(numOfOperands == 1){
			if(operands[operandIndex] == destVal){
				return 1;
			}
		}
		
		for(int k=0;k<operands.length;k++){
			UtilityClass.swap(operands,0,k);
			for(int i=0;i<operands.length-1;i++){
				for(int j=0;j<operations.length;j++){
					int val = getVal(i,i+1,operations[j]);
				}
			}
			UtilityClass.swap(operands,0,k);
		}
			
	}
	
	*/
	
	
	
	/*
	 * If operands[] = 1 5 9 10 13, then number of operands = 5
	 * Then number of values = 5!4!+4!3!+3!2!+2!1!+1!0! 
	 * operands!*(operands-1)! + (operands-1)!*(operands-2)! + .....1|0|
	 */
	public int getNumberOfWays(Set<Integer> operands, OPERATOR[] operations, int destVal, int currentVal,int[] counterArray){
		
		int n = operands.size();
		if(n == 1){
			return counterArray[destVal];
		}
		
		if(n==2){
			
		}
		
		/*int count = 0;
		if(destVal == operands[currentVal]){
			count++;
		}
		
		int n = operands.length;
		
		if(currentVal == n){
			return count;
		}
		
		for(int i=currentVal)
		
		
		if(n == 1){
			if(n == currentVal){
		}
			return 0;
		}
		
		if(n == 1){
			
		}*/
		
		
		
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

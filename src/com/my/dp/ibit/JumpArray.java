package com.my.dp.ibit;

import java.util.ArrayList;

import com.my.common.UtilityClass;

public class JumpArray {
	
	public int canJump(ArrayList<Integer> A) {
		if(canJump(A,0)) {
			return 1;
		}
		return 0;
    }
	
	
	public boolean canJump(ArrayList<Integer> A, int currentIndex) {
		
		if(currentIndex == A.size()-1) {
			return true;
		}
		
		if(currentIndex	 >= A.size()) {
			return false;
		}
		
		for(int i=currentIndex;i<A.size();i++) {
			int jumpsPossible = A.get(i);
			if(jumpsPossible == 0) {
				return false;
			}
			for(int j=1;j<=jumpsPossible;j++) {
				if(canJump(A,currentIndex+j)) {
					return true;
				}
			}
		}
		
		return false;
		
		
	}
	
	public int canJumpIter(ArrayList<Integer> A) {
		
		int n = A.size();
		boolean[] jumpMatrix = new boolean[n];
		
		jumpMatrix[n-1] = true;
		
		
		for(int i=n-2;i>=0;i--) {
			int jumpsPossible = A.get(i);
			System.out.println("Processing i="+i+" with jumps="+jumpsPossible);
			for(int j=1;j<=jumpsPossible;j++) {
				if(jumpMatrix[i+j]) {
					System.out.println("jumpsPossible = "+j+" Processing at i="+i);
					jumpMatrix[i] = true;
					break;
				}
			}
			
			UtilityClass.print(jumpMatrix,i,n-1);
			
		}
		
		if(jumpMatrix[0]) {
			return 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] a = { 8, 4, 0, 0, 0, 0, 0, 0, 20, 17, 0, 7, 0, 0, 6, 0, 0, 0, 0, 1, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 28, 0, 0, 0, 26, 0, 0, 16, 6, 0, 0, 27, 11, 0, 0, 0, 0, 23, 0, 0, 0, 10, 0, 0, 1, 24, 1, 0, 0, 0, 0, 17, 0, 2, 0, 9, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 0, 2, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 17, 0, 9, 0, 23, 13, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 26, 29, 0, 1, 25, 17, 3, 0, 0, 5, 0, 0, 0, 0, 0, 21, 0, 0, 0, 0, 1, 0, 7, 0, 10, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 17, 0, 20, 22, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 12, 5, 0, 0, 0, 0, 15, 0, 29, 0, 7, 23, 0, 0, 0, 0, 0, 0, 11, 21, 5, 0, 0, 0, 0, 18, 14, 0, 0, 0, 0, 23, 11, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 20, 12, 28, 1, 0, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, 2, 12, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 6, 0, 0, 0, 0, 0, 26, 23, 0, 0, 0, 11, 20, 0, 0, 16, 24, 0, 0, 0, 0, 13, 4, 0, 0, 6, 0, 28, 0, 17, 0, 0, 5, 0, 0, 0, 0, 0, 0, 20, 0, 1, 0, 30, 0, 0, 0, 2, 0, 0, 11, 0, 0, 26, 22, 0, 0, 0, 0, 0, 0, 0, 22, 1, 0, 0, 18, 10, 0, 1, 0, 0, 0, 9, 0, 0, 28, 0, 0, 0, 0, 0, 23, 3, 0, 0, 29, 0, 0, 0, 8, 0, 0, 25, 0, 0, 28, 0, 0, 0, 0, 9, 15, 0, 0, 9, 0, 28, 26, 0, 0, 0, 0, 23, 0, 0, 0, 28, 0, 0, 17, 0, 1, 0, 4, 0, 0, 16, 0, 0, 0, 0, 0, 0, 5, 0, 23, 0, 0, 0, 0, 27, 0, 14, 0, 14, 16, 0, 0, 0, 0, 0, 30, 0, 26, 0, 13, 0, 2, 0, 0, 19, 0, 0, 0, 0, 25, 0, 2, 0, 0, 20, 0, 0, 5, 16, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 8, 0, 0, 0, 0, 0, 18, 0, 0, 0, 18, 8, 0, 0, 23, 0, 0, 0, 0, 11, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 27, 0, 0, 0, 8, 10, 26, 15, 8, 0, 27, 18, 0, 0, 21, 26, 1, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 26, 17, 0, 0, 25, 0, 0, 30, 0, 23, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0 };
		ArrayList<Integer> A = UtilityClass.getList(a);
		
		JumpArray jumpArray = new JumpArray();
		System.out.println("Result="+jumpArray.canJumpIter(A));
		
	}
	
	//TODO remember this approach
	public int canJumpCopied(ArrayList<Integer> a) {
	    
	    int steps=a.get(0); 
	    for(int i=1;i<a.size();i++) {
	        steps--; //At every iteration, we have consumed one step. So coming from 0 to 1 consumed 1 step. So decrement steps by 1
	        
	        if(steps<0) {
	          return 0; //If at any point of time, the steps become less than 0, then there is no solution
	        }
	       
	        if(a.get(i)>steps) {
	         steps=a.get(i);    //At each step, we go maximum either our earlier steps or the current steps whichever are maximum.
	        }
	    }
	    return 1;
	}

}

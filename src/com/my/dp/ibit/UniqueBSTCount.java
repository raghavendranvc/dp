package com.my.dp.ibit;

public class UniqueBSTCount {

	/*
	 * 		1 is root 	2 is root here 		n is root here 
	 * f(n) = f(0)f(n-1) + f(1)f(n-2) .... + f(n-1)f(0)
	 * 
	 * This is similar to Chords in a Cirlce
	 * 
	 */
	//TODO remeMber the base cases. 
	
	public int numTrees(int A) {
		if(A == 0) {
			return 1; // With zero nodes only 1 BST possible
		}
		if(A == 1) {
			return 1; // With one nodes only 1 BST possible
		}
		
		int[] value = new int[A + 1];
		value[0] = 1; //
		value[1] = 1; // With just one node 1
		/*
		 * 		
		 * f(3)=f(0)f(2)+f(1)*f(1)+f(2)*f(0);
		 */
		
		for(int i=2;i<=A;i++) {
			for(int j=0;j<i;j++) {
				value[i] += value[j]*value[i-j-1];
			}
		}
		return value[A];
	}

	/*
	 * BST count = (2n)!/(n+1)!n! BT count = n! * BST count => (2n)!/(n+1)!
	 */

	/*
	 * (1,2) (1,0), 1 (2,2) (1,1), 2 (3,2)
	 * 
	 */

	public static void main(String[] args) {
		UniqueBSTCount uniqueBinaryTrees = new UniqueBSTCount();
		System.out.println("value=" + uniqueBinaryTrees.numTrees(3));

	}

}

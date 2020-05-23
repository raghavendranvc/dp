package com.my.dp;

public class SubSetSum {
	
	
	public boolean isSubSetHasSum(int[] a,int sum){
		return isSubSetHasSum(a, sum, a.length);
	}
	
	public boolean isSubSetHasSum(int[] a,int sum,int n){
		if(sum == 0){
			return true;
		}
		
		if(sum != 0  && n==0){
			return false;
		}
		
		/*
		 *  if(sum < a[n-1]){
		 *    return (isSubSetHasSum(a, sum,n-1);
		 *  }
		 */
		
		return ((isSubSetHasSum(a, sum,n-1)) || (isSubSetHasSum(a, sum-a[n-1], n-1)));
		
	}
	
	public boolean isSubSetHasSumIter(int[] a,int sum){
		int n = a.length;
		/*
		 * Rows are sum : 1, 2, 3 ..... sum
		 * Columns are values : a[0] a[1] a[2]
		 */
		boolean[][] table = new boolean[sum+1][n+1];
		
		/*
		 * For first row - Sum is '0'. so first row has all true values 
		 */
		
		for(int i=0;i<n;i++){
			table[0][i] = true;
		}
		
		/*
		 * When sum is not 0 and n is 0 => first column
		 *  then all values are false;
		 */
		
		for(int i=1;i<=sum;i++){
			table[i][0] = false;
		}
		
		for(int i=1;i<=sum;i++){
			for(int j=1;j<=n;j++){
				/*
				 * When we discard the element 'j', then the sum remains the same as 'j-1'
				 */
				table[i][j] = table[i][j-1];
				/*
				 * If current sum "i" is greater than or equal to a[j-1]
				 * Then check if by including and by excluding it
				 * Excluding is simply table[i][j]
				 * Including means from the previous column check by adding a[j-1] you can reach
				 * [i] meaning table[i-a[j-1]][j-1]
				 * 
				 * from the previous column see if by adding a[j-1] 
				 * we can reach i
				 * 
				 */
				if(i >= a[j-1]){
					table[i][j] = table[i][j] || table[i-a[j-1]][j-1];
				}
			}
		}
		
		return table[sum][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2, 3, 34, 4, 12, 5};
//		int sum = 18;
//		int sum = 8;
		int sum = 20;
		
		SubSetSum ss = new SubSetSum();
		boolean val1 = ss.isSubSetHasSum(a, sum);
		System.out.println("val1="+val1);

	}
	
	// Call isSubSetRecurPractice(A,A.size()-1,sum)
	public boolean iSubSetRecurPractice(int[] A, int n, int sum) {
		if(sum == 0) {
			return true;
		}
		
		if(sum !=0 && n ==0) {
			return false;
		}
		
		if(A[n-1] > sum) { 
			// We should only ignore
			return iSubSetRecurPractice(A,n-1,sum);
		}
		
		//ignore A[n]
		//include A[n]
		
		return (iSubSetRecurPractice(A,n-1,sum) || iSubSetRecurPractice(A,n-1,sum-A[n-1]));
		
		
	}
	

}

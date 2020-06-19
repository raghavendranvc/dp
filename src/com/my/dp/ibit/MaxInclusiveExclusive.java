package com.my.dp.ibit;



public class MaxInclusiveExclusive {
	
	/*
	 * TODO , we need to check this logic carefully
	 * {5,  5, 10, 40, 50, 35}
	 * 
	 * inc -> Max Sum including the previous element
	 * 		  max sum including the current element will be exc + current element
	 * 
	 * exc -> Max Sum excluding the previous element
	 * 		  Max sum excluding the current element will be max(inc, exc) 
	 * 
	 * i = 0(5)
	 * inc = 5
	 * exc = 0
	 * 
	 * i=1 (5)
	 * 
	 * inc = exc + A[i]
	 * exc = Max (ealrier inc, earlier exc) 
	 * 
	 * Given		5,  	5, 		10, 	40, 		50, 		35
	 * Inc			5	   0+5		5+10	45			60			80
	 * Exc			0	   (0,5)5	(5,5)5  (15,10)15	(40,45)45	60 (60,45)
	 */
	
	
	int FindMaxSum(int a[]) {
		int n = a.length;
		
		int inclusive = a[0];
		int exclusive = 0;
		
		for(int i=1;i<n;i++) {
							   //the exclusion here is previous exclusive
			int newInclusive = exclusive+a[i];
			
			// here exclusive is previous exclusive
			// here inclusive is also previous inclusive
			// we are preparing the new exclusive
			exclusive = Math.max(exclusive, inclusive);
			
			inclusive = newInclusive;//we now assign the new inclusive to inclusive
			// We shouldn't be affecting exclusive computation 
			// and so we stored it in a separate varaible
			
		}
				
		return Math.max(inclusive, exclusive);
		
    }

}

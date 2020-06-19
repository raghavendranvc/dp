package com.my.dp;

public class LargestSumSubArrayInTable {
	
	static class Rectangle{
		int left;
		int top;
		int right;
		int bottom;
		int max;
		
		public String toString(){
			return "left="+left +"  top="+top+"  right="+right+"  bottom="+bottom;
		}
	}
	
	static class SubArray{
		int val;
		int left;
		int right;
		public String toString(){
			return "left="+left+"  right="+right+"  val="+val;
		}
	}
	
	SubArray getMaxSumSubArray(int[] a){
		
		SubArray sb = new SubArray();
		sb.left = 0;
		sb.right = 0;
		sb.val = a[0];
		
		int newStart = 0;
		int consecSum = a[0];
		
		for(int i=1;i<a.length;i++){
			
			if(consecSum + a[i] > consecSum) {
				consecSum = consecSum + a[i];
			} else {
				consecSum = a[i];
				newStart = i;
			}
			
			if(consecSum > sb.val ) {
				sb.left = newStart;
				sb.right = i;
				sb.val = consecSum;
			}
		}
		return sb;
		
	}
	
	public void getMaxSum2DSubArray(int[][] m,Rectangle rect){
		int rows = m.length;
		int columns = m[0].length;
		
		rect.left = 0;
		rect.top = 0;
		rect.right = 0;
		rect.bottom = 0;
		rect.max = m[0][0];
			
		/*
		 * We are evaluating like  
		 * [0,0]
		 * [1,0]
		 * [2,0]
		 * [3,0]
		 * 
		 * and then
		 * 
		 * [0,1]
		 * [1,1]
		 * [2,1]
		 * [3,1]
		 * 
		 * ...
		 * 
		 * [0,2]
		 * [1,2]
		 * [2,2]
		 * [3,2]
		 *  
		 * 
		 */
		for(int left=0;left<columns;left++){
			
			int[] rowArray = new int[rows];
			
			for(int right=left;right<columns;right++){ 
				//For left = 0 (0,n), (1,n), (2,n) ....(n,n)
				//For left = 1 (1,n), (2,n), (3,n) ....(n,n) //discarding 1st column
 				
				
				/*
				 * rowArray 
				 * For each row i, what is the sum from left to right
				 * It is calculated cumulatively as previous value is stored and the 
				 * value at the new column 'right' is added 
				 */
				
				for(int i=0;i<rows;i++){
					rowArray[i] += m[i][right]; //vertical sum from 'right' to 'left'
				}
				
				SubArray sa = getMaxSumSubArray(rowArray);
				
				if(rect.max < sa.val){
					rect.max = sa.val;
					rect.left = left;    //In rowArray top to bottom row values are stored from left to right 
					rect.top = sa.left;  	//sa.left has the top row  
					rect.right = right;  
					rect.bottom = sa.right; //sa.right has the bottom row
				}
			}
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int[] a = {-2, -3, 14, -1, -2, -1, 5, -3};*/
		LargestSumSubArrayInTable lssat = new LargestSumSubArrayInTable();
/*		SubArray sa = new SubArray();
		lssat.getMaxSumSubArray(a, sa);
		System.out.println("subarray="+sa);*/
		
		int[][] m = {
				{ 1,  2,  -1, -4, -20  },
                {-8, -3,   4,  2,   1  },
                { 3,  8, -10,  1,  33  },
                {-4, -1,   1, -7,  -6  }
		};
		
		Rectangle rect = new Rectangle();
		lssat.getMaxSum2DSubArray(m, rect);
		System.out.println("Rect="+rect);
		
	}

}

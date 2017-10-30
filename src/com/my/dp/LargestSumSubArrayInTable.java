package com.my.dp;

public class LargestSumSubArrayInTable {
	
	static class Rectangle{
		int left;
		int top;
		int right;
		int bottom;
		
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
	
	public void getMaxSumSubArray(int[] a,SubArray sb){
		int maxSum = a[0];
		int consecSum = a[0];
		sb.left = 0;
		sb.right = 0;
		sb.val = maxSum;
		
		for(int i=1;i<a.length;i++){
			
			int newSum = consecSum+a[i];
			if(a[i] > newSum){
				sb.left = i;
				sb.right = i;
				sb.val = maxSum;
				consecSum = a[i];
			} else if(consecSum < newSum){
				consecSum = consecSum + a[i];
			}
			
			if(consecSum > maxSum){
				maxSum = consecSum;
				sb.right = i;
				sb.val = maxSum;
			}
		}
		
		
	}
	
	public void getMaxSum2DSubArray(int[][] m,Rectangle rect){
		int rows = m.length;
		int columns = m[0].length;
		
		int max = m[0][0];
		
		rect.left = 0;
		rect.top = 0;
		rect.right = 0;
		rect.bottom = 0;
			
		
		for(int left=0;left<columns;left++){
			
			int[] rowArray = new int[rows];
			
			for(int right=left;right<columns;right++){
				
				
				/*
				 * rowArray 
				 * For each row i, what is the sum from left to right
				 * It is calculated cumulatively as previous value is stored and the 
				 * value at the new column 'right' is added 
				 */
				
				for(int i=0;i<rows;i++){
					rowArray[i] += m[i][right]; 
				}
				
				SubArray sa = new SubArray();
				getMaxSumSubArray(rowArray,sa);
				
				if(max < sa.val){
					max = sa.val;
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

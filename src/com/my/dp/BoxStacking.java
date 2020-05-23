package com.my.dp;

import java.util.Arrays;
import java.util.Comparator;

import com.my.common.UtilityClass;

public class BoxStacking {

	//TODO - Read
	
	static class Box{
		int h;
		int w;
		int d;
		Box(int h,int w,int d){
			this.h = h;
			this.w = w;
			this.d = d;
		}
		
		public String toString(){
			return "H="+h+" W="+w+" D="+d;
		}
	}
	
	/*
	 * We need decreasing order of Boxes
	 * b2,b1  if(b2>b1)
	 */
	class BoxComparator implements Comparator<Box>{

		public int compare(Box b1, Box b2) {
			return (-1*(b1.d*b1.w - b2.d*b2.w));  // -1 is for decreasing order
		}
		
	}
	
	public int maxHeight(Box[] a){
		int numberOfBoxes = a.length;
		int tmpHeight = 3*numberOfBoxes;
		
		Box[] r = new Box[tmpHeight];
		
		/*
		 * For each box, we will add 3 choices
		 *  A[i].h as height (it doesn't matter the other two)
		 *  A[i].d as height (we will use the maximum one as depth from the rest 2 (ht,wdith)
		 * 	A[i].w as height (here too. We will use the maximum one as depth for the rest 2(ht, dep)
		 */
		/*
		 * Depth >= Width
		 */
		for(int i=0,k=0;i<numberOfBoxes;i++){
			r[k++] = a[i];
			r[k++] = new Box(a[i].d,Math.min(a[i].w,a[i].h),Math.max(a[i].w,a[i].h));
			r[k++] = new Box(a[i].w,Math.min(a[i].h,a[i].d),Math.max(a[i].h,a[i].d));
		}
		
		BoxComparator bc = new BoxComparator();
		Arrays.sort(r, bc); 
		//We now sort based on base area. We want to have the one with max are as bottom
		printBox(r);
		
		
		int[] maxHeight = new int[tmpHeight];
		
		for(int i=0;i<tmpHeight;i++){
			maxHeight[i] = r[i].h; // is initialized to the maximum of all the box heights
		}
		
		for(int i=1;i<tmpHeight;i++){ //LCS like algorithm
			for(int j=0;j<i;j++){
				System.out.print(i+"="+r[i]+" j="+r[j]);   // "i" is going to be higher than "j"
				if(r[i].d < r[j].d  &&  r[i].w < r[j].w){  // If "i" has less d and w compared with "j"
					maxHeight[i] = Math.max(maxHeight[i], maxHeight[j]+r[i].h);
					System.out.print("New maxHeight["+i+"]="+maxHeight[i]);
				}
				System.out.println();
			}
		}
		
		UtilityClass.print(maxHeight);
		
		int retHeight = maxHeight[0];
		for(int i=1;i<tmpHeight;i++){
			retHeight = Math.max(retHeight,maxHeight[i]);
		}
		
		return retHeight;
		
	}
	
	private void printBox(Box[] b){
		for(int i=0;i<b.length;i++){
			System.out.println(i+" = "+b[i]);
		}
	}

	/**
	 * @param args
	 * Assume each box follows rule: depth>=width
	 */
	public static void main(String[] args) {
		Box[] b = {
				new Box(4, 6, 7),
				new Box(1, 2, 3),
				new Box(4, 5, 6), 
				new Box(10, 12, 32)
		};
		
		BoxStacking bs = new BoxStacking();
		int val1 = bs.maxHeight(b);
		System.out.println("val1="+val1);

	}

}

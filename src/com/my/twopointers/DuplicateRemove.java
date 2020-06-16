package com.my.twopointers;

import java.util.ArrayList;

import com.my.common.UtilityClass;

public class DuplicateRemove {

    
    
    public static int removeDuplicates(int[] a) {
    	
    	// 1 1 1 2 2 2 3 3 4
    	// i
    	//     j
    	int i=0;
    	int n=a.length;
    	
    	for(int j=1;j<n;j++) {
    		if(a[j-1] != a[j]) {
    			i++;
    			a[i] = a[j];
    		}
    	}
    	
    	return i+1;
    }

    public static void main(String[] args){
        //int[] a = new int[] {5000, 5000, 5000};
    	int[] a = new int[] {1,1,1,2,2,3,3,3,4,4,5,5,6,7};
    	int length=removeDuplicates(a);
        System.out.println("Result="+removeDuplicates(a));
        UtilityClass.print(a,0,length-1);


        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a){
            intListA.add(i);
        }

    }
}

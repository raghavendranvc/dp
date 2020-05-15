package com.my.twopointers;

import java.util.ArrayList;

import com.my.common.UtilityClass;

public class DuplicateRemove {

    public int removeDuplicatesOriginal(ArrayList<Integer> a) {

        for(int i=a.size()-1;i>0;i--){
            if(a.get(i-1).equals(a.get(i))){
                a.remove(i);
            }
        }

        return a.size();
    }

    private void copyArray(ArrayList<Integer> a, int startIndex){
        for(int i=startIndex;i<a.size()-1;i++){
            a.set(i,a.get(i+1));
        }
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        for(int i=a.size()-1;i>1;i--){
            if(a.get(i-1).equals(a.get(i)) && a.get(i-1).equals(a.get(i-2))){
                a.remove(i);
            }
        }
        return a.size();
    }
    
    public static int removeDuplicates(int[] a) {
    	
    	// 1 1 1 2 2 2 3 3 4
    	// i
    	//     j
    	int i=0;
    	int n=a.length;
    	
    	for(int j=1;j<n;j++) {
    		if(a[j-1] != a[j]) {
    			a[++i] = a[j];
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

        System.out.println("a="+intListA);
        DuplicateRemove duplicateRemove = new DuplicateRemove();
        duplicateRemove.removeDuplicates(intListA);
        System.out.println("end="+intListA);

    }
}

package com.my.twopointers;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingTriangles {

    public boolean canFormTriangle(int a, int b, int c){
        if(a+b <= c || a+c <= b || b+c <= a){
            return false;
        }
        return true;
    }

    public int nTriang(ArrayList<Integer> A) {
        if(A.size() < 3){
            return 0;
        }

        Collections.sort(A);

        int numberOfTriangles =0 ;
        for(int i=0;i<A.size()-2;i++){
            if(A.get(i) <= 0 ){
                continue;
            }
            for(int j=i+1, k=j+1; j<A.size()-1 && A.get(j) >0; ){
                while(k<A.size() && A.get(k) >0 && (A.get(i) + A.get(j) > A.get(k))){
                    k++;  // meaning all these are able to form triangles
                }
                // The loop is broken and so traingles cannot be formed with i,j,k
                // k started from j+1 . So number of traingles formed = k - (j+1)
                numberOfTriangles += k - j - 1;
                numberOfTriangles %= 1000000007;
                j++; // Now increment j
            }
        }

        return numberOfTriangles;

    }


    public int nTriangCopied(ArrayList<Integer> a) {

        int n=a.size();
        if(n<3){
            return 0;
        }
        Collections.sort(a);

        int ans=0;
        for(int i=0;i<n-2;i++){
            if(a.get(i)!=0){
                int j=i+1;
                int k=i+2;
                while(j<n-1 && a.get(j)!=0){
                    while(k<n && a.get(k)!=0 && a.get(i)+a.get(j)>a.get(k)){
                        k++;
                    }
                    ans+=(k-j-1);
                    ans=ans%1000000007;
                    j++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] a = new int[]{1, 1, 1, 2, 2};
        int B = 0;
        ArrayList<Integer> intListA = new ArrayList<>(a.length);
        for (int i : a){
            intListA.add(i);
        }
        System.out.println("initlist="+intListA);
        CountingTriangles countingTriangles = new CountingTriangles();
        countingTriangles.nTriang(intListA);
    }
}

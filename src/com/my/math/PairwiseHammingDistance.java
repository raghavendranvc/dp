package com.my.math;

import com.my.common.UtilityClass;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

public class PairwiseHammingDistance {

    /*public int hammingDistance(final List<Integer> A) {

        ArrayList<ArrayList> aList = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            aList.add(A.get(i));
        }

        for(int i=0;i<A.size();i++){
            aList.add(A.get(i));
        }


    }*/

    //TODO - Just compiled. Still need to check
    public int hammingDistance(final List<Integer> A) {
        int n = A.size();
        int dist = 0;
        for(int i = 0; i < 31; i++) {
            int oneCount = 0;
            for(int j = 0; j < n; j++) {
                int num = A.get(j);
                oneCount += (num & 1 << i) != 0? 1 : 0;
            }
            int zeroCount = n - oneCount;
            dist += (2L * oneCount * zeroCount) % 1000000007;
            dist = dist % 1000000007;
        }
        return dist;
    }

    public void computePermutation(String str, String suffix) {
        if(str.length() == 0){
            System.out.println(suffix);
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String restOfTheString = str.substring(0,i) + str.substring(i+1);
            computePermutation(restOfTheString, suffix+ch);
        }

    }

    public void computePermutationDistinct(String str, String suffix) {
        boolean[] exists = new boolean[26];
        computePermutationDistinct(str, suffix,exists);
    }

    public void computePermutationDistinct(String str, String suffix, boolean[] exists) {
        if(str.length() == 0){
            System.out.println(suffix);
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String restOfTheString = str.substring(0,i) + str.substring(i+1);

            //UtilityClass.print(exists);
            if(!exists[ch-'a']) { //Only for distinct chars do permutation
                computePermutationDistinct(restOfTheString, suffix + ch);
            }
            exists[ch-'a'] = true;
        }
    }

    public static void main(String[] args) {
        String s = "abdd";
        PairwiseHammingDistance pairwiseHammingDistance = new PairwiseHammingDistance();
        //pairwiseHammingDistance.computePermutation(s, "");
        pairwiseHammingDistance.computePermutationDistinct(s, "");
    }


}

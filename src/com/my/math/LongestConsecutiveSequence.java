package com.my.math;

import com.my.common.UtilityClass;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutiveNonNegative(final List<Integer> A) {
        int maxElement = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            maxElement = Math.max(maxElement,A.get(i));
        }

        System.out.println("maxElement="+maxElement);

        boolean[] map = new boolean[maxElement+1];
        for(int i=0;i<A.size();i++){
            map[A.get(i)] = true;
        }

        UtilityClass.print(map);

        int maxCount = 1;
        int currentCount = 1;

        for(int i=1;i<=maxElement;i++){
            //System.out.println("map[i]="+map[i] +" map[i-1]="+map[i-1]+ " Oveall= "+(map[i] && map[i-1]));
            if(map[i] && map[i-1]){
                currentCount++;
                maxCount = Math.max(maxCount,currentCount);
                System.out.println("new maxCount="+maxCount);
            } else {
                currentCount=1;
            }
        }

        return maxCount;

    }

    public int longestConsecutive(final List<Integer> A) {

        int minElement = A.get(0);
        int maxElement = A.get(0);
        Set<Integer> map = new HashSet<>();
        map.add(A.get(0));
        for(int i=1;i<A.size();i++){
            minElement = Math.min(minElement,A.get(i));
            maxElement = Math.max(maxElement,A.get(i));
            map.add(A.get(i));
        }


        int maxCount = 1;
        int currentCount = 1;
        System.out.println("minElement="+minElement+" maxElement="+maxElement+" map="+map);

        while(minElement <= maxElement){
            if(map.contains(minElement) && map.contains(minElement+1)){
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
                System.out.println("currentCount="+currentCount+" maxCount="+maxCount);
            } else {
                currentCount = 1;
            }

            minElement++;
        }

        return maxCount;
    }

    public static void main(String[] args){
        int[] a = {6, 4, 5, 2, 3 };
        List<Integer> A = new ArrayList<>();
        for(int i : a){
            A.add(i);
        }
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println("Result="+longestConsecutiveSequence.longestConsecutive(A));
    }

}

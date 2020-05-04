package com.my.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(final List<Integer> A) {
        int maxCount = Integer.MIN_VALUE;
        int majorityElement = -1;

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int val : A){
           int currentCount = countMap.getOrDefault(val,0);
           currentCount++;
           countMap.put(val,currentCount);
           if(maxCount < currentCount){
               maxCount = currentCount;
               majorityElement = val;
           }
        }

        if(maxCount > A.size()/2){
            return majorityElement;
        }

        return -1;
    }

    //TODO go thorugh this alo again
    public int majorityElementNonHash(final List<Integer> A) {

        int currentCount = 1;
        int majorityElement = A.get(0); //Assume the first one as the majority element

        for(int i=1;i<A.size();i++){
            if(majorityElement == A.get(i)) {
                currentCount++; //Increment the count for the majority element
            } else {
                currentCount--; //Decrement in the case of mismatch
            }

            // if the count becomes zero, then we will restart this process with this element as the new majority element.
            // make sure the count is set to 1
            if(currentCount == 0){
                majorityElement = A.get(i);
                currentCount = 1;
            }
        }
        // We might have found a probable candidate, we still need to confirm that.

        int count = 0;
        for(int val : A){
            if(majorityElement == val){
                count++;
            }
        }

        if(count > A.size()/2) {
            return majorityElement;
        } else {
            return -1;
        }
    }

}

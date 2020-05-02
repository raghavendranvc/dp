package com.my.heaps;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> resultList = new ArrayList<>();

        if(B > A.size()){
            return resultList;
        }

        Map<Integer,Integer> countMap = new HashMap<>();
        int i=0;
        for(i=0;i<B;i++){
            countMap.put(A.get(i),countMap.getOrDefault(A.get(i),0)+1);
        }
        System.out.println("countMap="+countMap);
        resultList.add(countMap.size());

        for(;i<A.size();i++){
            int purgeValue = countMap.get(A.get(i-B));
            if(purgeValue>1) {
                countMap.put(A.get(i - B), purgeValue - 1);
            } else {
                countMap.remove(A.get(i - B));
            }
            countMap.put(A.get(i),countMap.getOrDefault(A.get(i),0)+1);
            System.out.println("Removed="+countMap.get(A.get(i-B))+" Added="+A.get(i)+" countMap="+countMap);
            resultList.add(countMap.size());
        }
        return resultList;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 1, 3, 4, 3};
        ArrayList<Integer> A = UtilityClass.getList(a);
        DistinctNumbersInWindow distinctNumbersInWindow = new DistinctNumbersInWindow();
        System.out.println("Result="+distinctNumbersInWindow.dNums(A,3));
    }

}

package com.my.twopointers;

import java.util.ArrayList;

public class RemoveInstances {
    public int removeElement(ArrayList<Integer> a, int b) {

        for(int i=a.size()-1;i>=0;i--){
            if(a.get(i).intValue() == b){
                a.remove(i);
            }
        }

        ArrayList<Integer> solution = new ArrayList<>();
        for(int i =0;i<a.size();i++){
            if(a.get(i).intValue() != b){
                solution.add(a.get(i));
            }
        }

        a.clear();
        a.addAll(solution);

        return a.size();


    }
}

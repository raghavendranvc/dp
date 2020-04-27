package com.my.hashing;

import java.util.*;

public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String,ArrayList<Integer>> lookup = new HashMap<>();

        for(int i=0; i<A.size();i++){
            char[] c = A.get(i).toCharArray();
            Arrays.sort(c);
            String sortedString = new String(c);
            if(lookup.containsKey(sortedString)){
                lookup.get(sortedString).add(i+1);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i+1);
                lookup.put(sortedString,newList);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Map.Entry<String,ArrayList<Integer>> entry : lookup.entrySet()){
            result.add(entry.getValue());

        }
        return  result;
    }

}

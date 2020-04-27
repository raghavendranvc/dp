package com.my.hashing;

import com.my.linkedlists.Substract;

import java.util.*;

public class SubstringConcat {

    public ArrayList<Integer> findSubstring(String A, final List<String> B) {

        //Set<String> subStrings = new HashSet<>(B);
        ArrayList<Integer> result = new ArrayList<>();
        if(B.size() == 0){
            return result;
        }

        if(A.length() < B.get(0).length()){
            return result;
        }

        int l = B.get(0).length();
        HashMap<String,Integer> subStringCountMap = getSubStringMap(B);
        System.out.println("subStringCountMap="+subStringCountMap);

        for(int i=0;i<A.length();i++){
            HashMap<String,Integer> tempSubStringCountMap = (HashMap) subStringCountMap.clone();
            System.out.println("clonedMap="+tempSubStringCountMap);
            int numberOfSubStrings = B.size();
            int j = i;
            while(j+l <= A.length() && numberOfSubStrings>0){

                String checkSubStr = A.substring(j,j+l);
                if(tempSubStringCountMap.containsKey(checkSubStr) && tempSubStringCountMap.get(checkSubStr)>0){
                    tempSubStringCountMap.put(checkSubStr, tempSubStringCountMap.get(checkSubStr)-1);
                    numberOfSubStrings--;
                    System.out.println("matched happened for "+checkSubStr);
                } else {
                    break;
                }
                j = j+l;
            }
            if(numberOfSubStrings == 0){
                result.add(i);
            }
        }
        return result;
    }

    private HashMap<String,Integer> getSubStringMap(final List<String> B){
        HashMap<String,Integer> subStringCountMap = new HashMap<>();
        for(String s : B){
            int count = subStringCountMap.getOrDefault(s,0);
            subStringCountMap.put(s, count+1);
        }
        return subStringCountMap;
    }

    public static void main(String[] args){
        String A = "";
        String[] b = {};
        ArrayList<String> B = new ArrayList<>();
        for(String s : b){
            B.add(s);
        }
        SubstringConcat substringConcat = new SubstringConcat();
        System.out.println("Result="+substringConcat.findSubstring(A,B));


    }

}

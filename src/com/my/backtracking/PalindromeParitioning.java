package com.my.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeParitioning {

    private boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(a == null || a.isEmpty()){
            return result;
        }
        partition( a,  result, 0,  a.length(), new LinkedList<>());
        return result;
    }

    public void  partition(String a, ArrayList<ArrayList<String>> result, int startIndex, int endIndex, Deque<String> tempString) {
        if(startIndex >= endIndex){
            result.add(new ArrayList<>(tempString));
            return;
        }

        for(int i=startIndex;i<endIndex;i++){ //For each string starting with startIndex and ending with "i"
            if(isPalindrome(a.substring(startIndex,i+1))){
                tempString.addLast(a.substring(startIndex,i+1));
                partition( a,  result, i+1, endIndex, tempString); // Now the startIndex is end of the earlier palindrome string
                tempString.removeLast();
            }
        }
    }

}

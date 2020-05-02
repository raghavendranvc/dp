package com.my.backtracking;

import java.util.ArrayList;

public class LetterPhone {

    String[] phoneArray = {"0", "1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();
        if(A == null || A.isEmpty()){
            return result;
        }
        letterCombinations(A.toCharArray(),phoneArray,result,0,"");
        return result;
    }

    public void letterCombinations(char[] A, String[] phoneArray, ArrayList<String> result, int startIndex, String prefix){
        if(startIndex == A.length){
            System.out.println("One Answer="+prefix);
            result.add(prefix);
            return;
        }
        for(char ch : phoneArray[A[startIndex]-'0'].toCharArray()){
            prefix = prefix+ch;
            letterCombinations(A, phoneArray, result, startIndex+1, prefix);
            System.out.println("Beefore Removing char="+prefix+" prefix length="+prefix.length());
            prefix = prefix.substring(0,prefix.length()-1);
            System.out.println("After Removing char="+prefix+" prefix length="+prefix.length());
        }
    }

    public static void main(String[] args){
        String A = "23";
        LetterPhone letterPhone = new LetterPhone();
        System.out.println("Result="+letterPhone.letterCombinations(A));
    }
}

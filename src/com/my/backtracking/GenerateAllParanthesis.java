package com.my.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateAllParanthesis {

    //TODO practice again. Creation of 2 variable to track left and right is very important
    //-------------------

    public ArrayList<String> generateParenthesisTry(int A) {
        ArrayList<String> result = new ArrayList<>();
        generateParenthesisTry(result, "", A, A);
        return result;
    }

    public void generateParenthesisTry(ArrayList<String> result, String prefix, int leftP, int rightP){
        if(leftP == 0 && rightP==0){
            result.add(prefix);
            return;
        }

        if(leftP > 0){
            generateParenthesisTry(  result,  prefix +"(",  leftP-1,  rightP);
        }

        if(leftP < rightP ){
            generateParenthesisTry(  result,  prefix +")",  leftP,  rightP-1);
        }
    }
    //-------------------

    public static void main(String[] args){
        GenerateAllParanthesis generateAllParanthesis = new GenerateAllParanthesis();
        //System.out.println("Result="+generateAllParanthesis.generateParenthesis(3));
    }

    public ArrayList<String> generateParenthesisCopied(int a) {
        ArrayList<String> list = new ArrayList<String>();
        helperGenerateParenthesis("", a, a, list);
        Collections.sort(list);
        return list;
    }

    private void helperGenerateParenthesis(String str, int openBracket, int closedBracket, List<String> list) {

        if (openBracket == 0 && closedBracket == 0) {
            list.add(str);
        }

        if (openBracket > 0) {
            helperGenerateParenthesis(str + "(", openBracket - 1, closedBracket, list);
        }

        if (openBracket < closedBracket) {
            helperGenerateParenthesis(str + ")", openBracket, closedBracket - 1, list);
        }
    }

    ArrayList<String> answer = new ArrayList<String>();
    public ArrayList<String> generateParenthesisCopied2(int a) {

        char[] arr= new char[2*a];
        recurse(arr,0,0,a);
        return answer;
    }

    public void recurse(char[] arr,int nLeft,int nRight,int n) {

        int pos = nLeft + nRight;
        if(pos == 2*n) {
            String s = new String(arr);
            answer.add(s);
        }

        if(nLeft < n) {
            arr[pos] = '(' ;
            recurse(arr,nLeft+1,nRight,n);
        }
        if(nRight < nLeft) {
            arr[pos] = ')';
            recurse(arr,nLeft,nRight+1,n);
        }
    }

}

package com.my.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreyCode {

    public ArrayList<Integer> grayCodeMine(int a) {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = grayCodeString(a);
        System.out.println("strList="+strList);
        for(String s : strList) {
            intList.add(getValue(s));
        }
        return intList;
    }
    /*
    0
    1
    10

     */

    private Integer getValue(String s) {
        int number = 0;
        for(int i=s.length()-1;i>=0;i--) {
            number = number + (s.charAt(i)-'0') * (int) Math.pow(2,(s.length()-1)-i);
        }
        return number;
    }

    public ArrayList<String> grayCodeString(int a) {
        ArrayList<String> returnList = new ArrayList<>();
        List<String> zero = new ArrayList<>();
        zero.add("0");

        if( a == 1){
            returnList.addAll(zero);
        }

        List<String> one = new ArrayList<>();
        one.add("1");

        if( a == 2){
            returnList.addAll(one);
        }

        if(a>2){
            List<String> list1 = new ArrayList<>(returnList);
            List<String> list2 = new ArrayList<>(returnList);
            Collections.reverse(list2);

            prefixList( list1,"0");
            prefixList( list2,"1");

            returnList = new ArrayList<>();
            returnList.addAll(list1);
            returnList.addAll(list2);

        }
        return returnList;
    }

    void prefixList(List<String> list, String prefix){
        for(int i=0;i<list.size();i++) {
            list.set(i,prefix+list.get(i));
        }
    }

    public static void main(String[] str){
        GreyCode greyCode = new GreyCode();
        System.out.println("Result="+greyCode.grayCode(2));

    }




    /**



        0
        ==
        0
        1
        ===
        00
        01

        11
        10
        ===
     00
     01

     11
     10

     10
     11





     */

    /**
     * Copied
     *
     */
    //TODO practice again

    private static int workingNumber = 0;



    public void nextGreyCodeNumberCopied(ArrayList<Integer> greyCodes, int n){
        if( n == 0 ){
            greyCodes.add(workingNumber);
            return;
        }

        nextGreyCodeNumberCopied(greyCodes,n-1);

        workingNumber = workingNumber ^ (1 << (n-1));  //We are supposed to invert the numbers

        nextGreyCodeNumberCopied(greyCodes,n-1);

    }

    public ArrayList<Integer> grayCodeCopied(int n){
        ArrayList<Integer> greyCodes = new ArrayList<>();
        workingNumber = 0;
        nextGreyCodeNumberCopied(greyCodes, n);
        return greyCodes;
    }

    /***
     * Newly worked out
     * @param greyCodes
     * @param n
     * @param workingNumber
     * @return
     */

    public int nextGreyCodeNumber(ArrayList<Integer> greyCodes, int n, int workingNumber){
        if( n == 0 ){
            greyCodes.add(workingNumber);
            return workingNumber;
        }

        workingNumber = nextGreyCodeNumber(greyCodes,n-1, workingNumber);

        workingNumber = workingNumber ^ (1 << (n-1));  //We are supposed to invert the numbers

        return nextGreyCodeNumber(greyCodes,n-1, workingNumber);

    }

    public ArrayList<Integer> grayCode(int n){
        ArrayList<Integer> greyCodes = new ArrayList<>();
        nextGreyCodeNumber(greyCodes, n, 0);
        return greyCodes;
    }
}

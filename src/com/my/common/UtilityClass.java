package com.my.common;

import java.util.ArrayList;

public class UtilityClass {

    public static void print(boolean[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    public static void print(boolean[] a, int s, int e){
        for(int i=s;i<=e;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void print(char[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void print(String[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void print(Integer[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void print(Long[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> getList(int[] a){
        ArrayList<Integer> returnList = new ArrayList<>();
        for(int i : a){
            returnList.add(i);
        }
        return returnList;
    }

    public static ArrayList<String> getList(String[] a){
        ArrayList<String> returnList = new ArrayList<>();
        for(String i : a){
            returnList.add(i);
        }
        return returnList;
    }


    public static void print(int[] a, int num){

    }
}

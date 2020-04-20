package com.my.common;

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


    public static void print(int[] a, int num){

    }
}

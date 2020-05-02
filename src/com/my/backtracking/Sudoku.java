package com.my.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudokuRecur( a);
    }

    public boolean solveSudokuRecur(ArrayList<ArrayList<Character>> a) {

        boolean allAssigned = true;

        int startRow = -1;
        int startCol = -1;

        for(int i=0;i<a.size() && allAssigned;i++){
            for(int j=0;j<a.size() && allAssigned;j++){
                if(a.get(i).get(j).equals('.')){
                    startRow = i;
                    startCol = j;
                    allAssigned = false;
                }
            }
        }

        if(allAssigned) {
            return true;
        }

        for(int i=1;i<=a.size();i++){
            if(isValid(a,startRow,startCol,String.valueOf(i).charAt(0))){
                a.get(startRow).set(startCol,String.valueOf(i).charAt(0));
                if(solveSudokuRecur(a)){
                    return true;
                }
                a.get(startRow).set(startCol,'.');
            }
        }
        return false;
    }

    public boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col, char ch){

        for(int i=0;i<9;i++){
            if (!a.get(row).get(i).equals('.') && a.get(row).get(i).equals(ch)){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if (!a.get(i).get(col).equals('.') && a.get(i).get(col).equals(ch)){
                return false;
            }
        }

        int size = (int) Math.sqrt(a.size());
        int rowNum = row-row%3;
        int colNum = col-col%3;

        for(int i = rowNum; i< rowNum+size; i++){
            for(int j = colNum; j < colNum + size; j++){
                if (!a.get(i).get(j).equals('.') && a.get(i).get(j).equals(ch)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        /*

        "5  3   .   .   7   .   .   .   .",
        "6  .   .   1   9   5   .   .   .",
        ".  9   8   .   .   .   .   6   .",
        "8  .   .   .   6   .   .   .   3",
        "4  .   .   8   .   3   .   .   1",
        "7  .   .   .   2   .   .   .   6",
        ".  6   .   .   .   .   28  .   ",
        ".  .   .   4   1   9   .   .   5",
        ".  .   .   .   8   .   .   7   9"
         */

        String[] strings = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79" };
        ArrayList<ArrayList<Character>> a = new ArrayList<>();

        for(int i=0;i<strings.length;i++){
            ArrayList<Character> arrayList = new ArrayList<>();
            for(Character ch : strings[i].toCharArray()){
                arrayList.add(ch);
            }
            a.add(arrayList);
        }
        Sudoku sudoku = new Sudoku();
        sudoku.solveSudoku(a);
        System.out.println("Result="+a);
    }
}

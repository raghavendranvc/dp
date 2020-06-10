package com.my.backtracking;

import java.util.ArrayList;

public class NQueens {

/*
==================================Geeks==============
 */

    void printSolution(int a, boolean board[][]) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    /* A recursive utility function to solve N
       Queen problem */
    boolean solveNQUtil(int a, boolean board[][], int col)
    {
        /* base case: If all queens are placed
           then return true */
        if (col >= a)
            return true;

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < a; i++) {
            /* Check if the queen can be placed on
               board[i][col] */
            if (isSafe(a, board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = true;

                /* recur to place rest of the queens */
                if (solveNQUtil(a, board, col + 1) == true)
                    return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = false; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in
           this colum col, then return false */
        return false;
    }


    boolean solveNQ(int a)
    {
        boolean board[][] = new boolean[a][a];

        if (!solveNQUtil(a, board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(a, board);
        return true;
    }
    //TODO practice well
    
    //This validity is very important
    // Understanding that queens are placed as Col is also very crucial
    // We choose col (rather than row) for better understanding. 
    // To pleace queen of col, we should have successfully placed queens < col.

    boolean isSafe(int a, boolean board[][], int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i])
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j])
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < a; i++, j--)
            if (board[i][j])
                return false;

        return true;
    }

/*
==================================Mine==============
 */

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        boolean[][] nQueens = new boolean[a][a];
        solveNQueen(a,0,nQueens, result);
        return result;
    }

    //queenNumber is column
    public void solveNQueen(int a, int queenNumber, boolean[][] nQueens, ArrayList<ArrayList<String>> result){
        if(queenNumber >= a){
            result.add(getRequiredSolution(a,nQueens));
            return;
        }

        for(int row=0;row < a;row ++){
            if(isValid(a,nQueens,row,queenNumber)){
                nQueens[row][queenNumber] = true;
                solveNQueen(a,queenNumber+1, nQueens, result);
                nQueens[row][queenNumber] = false;
            }
        }
    }
    
    private ArrayList<String> getRequiredSolution(int a,boolean[][] nQueens){
    	ArrayList<String> rowString = new ArrayList<>();
        for(int i=0;i<a;i++){
            StringBuilder StringBuilder = new StringBuilder();
            for(int j=0;j<a;j++){
                StringBuilder.append(nQueens[i][j]? "Q":".");
            }
            rowString.add(StringBuilder.toString());
        }
        return rowString;
    }


    private boolean isValid(int a, boolean[][] nQueens, int row, int col) {
        // We will check which column this queenNumber should go.
        // queenNumber represents the row. So we know for a given queen 'i', it will be placed in row 'i'
        for(int i=0;i<a;i++){
            if(nQueens[row][i]){
                return false;
            }
        }

        /***

         d  0   0   0   0   0   0   0
         0  d   0   0   0   0   0   0
         0  0   d   0   0   0   0   0
         c  c   c   Q   c   c   c   c
         0  0   d   0   0   0   0   0
         0  d   0   0   0   0   0   0
         d  0   0   0   0   0   0   0
         0  0   0   0   0   0   0   0




         */

        // check diagonal
        // row and column decreases together (or increase together)
        for(int i=row, j=col; i>=0 && j>=0 ; i--,j--){
            if(nQueens[i][j]){
                return false;
            }
        }
        // check reverse-diagonal
        // row increases, column decreases

        for(int i=row, j=col; i<a && j>=0 ; i++,j--){
            if(nQueens[i][j]){
                return false;
            }
        }
        return true;
    }

/*
===============================From IB Print All NQueens=====================================================
 */
    StringBuilder str = new StringBuilder("");
    public boolean isSafe(ArrayList<String> board, int row, int col)
    {
        int i,j;
        for( i = 0 ; i<board.get(0).length(); i++)
        {
            if(board.get(row).charAt(i) == 'Q')
                return false;
        }
        
        //Upper left diagonal. Rows decreasing, column decreasing.
        i = row;
        j = col;
        for (; i>=0 && j>=0; i--, j--)
            if (board.get(i).charAt(j) == 'Q')
                return false;
        
        //Lower Left diagonal. Rows increasing, columns decreased
        i = row;
        j = col;
        for (; j>=0 && i<board.get(0).length(); i++, j--)
            if (board.get(i).charAt(j) == 'Q')
                return false;
        return true;
    }
    public void generate(ArrayList<ArrayList<String>> result, ArrayList<String> board, int col,int n)
    {
        if(col >= n)
        {
            ArrayList<String> temp = new ArrayList<String>(board);
            result.add(temp);
            return;
        }
        for(int i =0; i<board.get(0).length(); i++)
        {
            if(isSafe(board,i,col))
            {
                StringBuilder str1 = new StringBuilder(board.get(i));
                str1.setCharAt(col,'Q');
                board.set(i,str1.toString());
                generate(result,board,col+1,n);
                board.set(i,str.toString());
            }
        }
    }
    public ArrayList<ArrayList<String>> solveNQueensCopied(int a)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> board = new ArrayList<String>();
        for(int i = 0 ; i<a; i++)
            str.append(".");
        for(int i = 0 ; i<a; i++)
            board.add(str.toString());


        generate(result,board,0,a);
        return result;
    }

    public static void main(String[] args){
        NQueens nQueens = new NQueens();
        System.out.println("Result="+nQueens.solveNQueens(8));
    }
    /*
    [Q, ., ., ., ., ., ., .],
    [., ., ., ., ., ., Q, .],
    [., ., ., ., Q, ., ., .],
    [., ., ., ., ., ., ., Q],
    [., Q, ., ., ., ., ., .],
    [., ., ., Q, ., ., ., .],
    [., ., ., ., ., Q, ., .],
    [., ., Q, ., ., ., ., .]
     */
    //---------------------------One Solution-------------------------------------
    /*
     * We are trying to place the queen in a row called "row"
     * Since we are going serial, we don't need to check beyond "row" rows
     */
    
    private boolean isValidToStore(int N, int currentQueen, int[] columnsPoitionOfEachQueen) {
    	for(int i=0;i< currentQueen ;i++) {
    		int diff = Math.abs(columnsPoitionOfEachQueen[i] - columnsPoitionOfEachQueen[currentQueen]);
    		if(diff == 0 || diff == currentQueen-i) {
    			return false;
    		}	
    	}
    	return true;
    }
    
    
    private void printOneNQueen(int N, int currentQueen, int[] columnsPoitionOfEachQueen) {
    	if(currentQueen == N) {
    		return; //we have place every queen
    	}
    	
    	// Here i represents columns
    	for(int i=0;i<N;i++) {
    		// place queen in the first possible position
    		columnsPoitionOfEachQueen[currentQueen] = i;
    		if(isValidToStore(N,currentQueen, columnsPoitionOfEachQueen)) {
    			printOneNQueen(N, currentQueen+1, columnsPoitionOfEachQueen);
    		}
    	}
    	
    }
    

}

package com.my.greedy;

public class Seats {
	
	/*
	 * 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
	 * . . . . x . . x x . . . x . .
	 * 			
	 * Total = 4
	 * 
	 * count=0
	 * 0 0 0 0 1 - - 2 3 - - - 4 0 0      (count again from left)
	 * 4 4 4 4 3 3 3 2 1 1 1 1 0          (Total--)
	 * 		     1 1     1 1 1 T          (moves = min(totalRemaining,leftCount))
	 * 		   	
	 * 
	 */


    //TODO practice this again and remember this approach

    private static final char OCCUPIED='x';
    private static final long MODULO = 10000003;

    public int seats(String A) {

        int numberOfOccupied = 0;

        for(char c: A.toCharArray()){
            if (c == OCCUPIED){
                numberOfOccupied++;
            }
        }

        long movesNeeded = 0;
        int leftMoves = 0;

        for(char c : A.toCharArray()){
            if(numberOfOccupied == 0){
                break;
            } else if (c == OCCUPIED){
                /*
                    When leftMoves == numberOfOccupied then, it is the median, and this is the right place
                    all lefts and rights moves towards this position.
                 */
                leftMoves++;
                numberOfOccupied--;     //
            } else {
                movesNeeded += Math.min(leftMoves, numberOfOccupied); 
                // min means either people on left or people on right move towards median.
            }
        }
        return (int) (movesNeeded % MODULO);
    }
}

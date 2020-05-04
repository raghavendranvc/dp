package com.my.greedy;

public class Seats {


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
            }
        }
        return (int) (movesNeeded % MODULO);
    }
}

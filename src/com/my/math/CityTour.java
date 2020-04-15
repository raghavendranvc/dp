package com.my.math;

import java.util.ArrayList;

public class CityTour {

    //TODO NOT DONE
    /*
    A = 5
    B = [2,5]
    ToVisit = 1,3,4
    B = [1]
    ToVisit = 2,3,4,5
    B=[3,5]
    ToVisit = 1,2,4
     */


    public int solve(int A, ArrayList<Integer> B) {

        int numberOfCitiesNotVisited = A-B.size();

        int fact[] = new int[numberOfCitiesNotVisited+1];

        fact[0] = fact[1] = 1;
        for(int i=2;i<=numberOfCitiesNotVisited;i++){
            fact[i] = i* fact[i-1];
        }

        return fact[numberOfCitiesNotVisited+1];

    }



}

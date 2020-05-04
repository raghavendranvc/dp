package com.my.greedy;

import java.util.List;

public class GasStation {

    public int canCompleteCircuitNotOptimal(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int[] diff =  new int[n];

        for(int i=0;i<n;i++){
            diff[i] = A.get(i) - B.get(i);
        }

        for(int startStation=0;startStation<n;startStation++){
            if(diff[startStation] < 0){
                continue;
            }

            int gas = diff[startStation];
            int j=1;
            boolean foundStation = true;
            while(j < n) {
                gas += diff[(startStation+j)%n];
                if(gas < 0){
                    foundStation = false;
                }
                j++;
            }

            if(foundStation){
                return startStation;
            }
        }

        return -1;
    }

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int[] diff =  new int[n];

        int possible = 0;
        for(int i=0;i<n;i++){
            diff[i] = A.get(i) - B.get(i);
            possible += diff[i];
        }

        /*
        If at the end, gas is not remaining, then there is no solution.
        We can also check this condition at the beginning.
         */
        if(possible < 0){
            return -1;
        }

        /*
            We now will try to find the right gas station.

         */

        int currentGas = 0;
        int minGasStation = 0;
        for(int i=0;i<n;i++){


            if(currentGas >=0){
                currentGas += diff[i];
            } else {
                currentGas = diff[i];
                minGasStation = i;
            }
        }
        return minGasStation;
    }


    public int canCompleteCircuitCopied(final List<Integer> gas, final List<Integer> cost) {
        int currentFuel = 0;
        int remaining = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.size(); i++){
            remaining = gas.get(i) - cost.get(i);
            if(currentFuel >= 0)
                currentFuel += remaining;
            else{
                currentFuel = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }

}

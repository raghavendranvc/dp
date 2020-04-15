package com.my.math;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {


    public ArrayList<Integer> primeSum(int A) {

        ArrayList<Integer> primes = new ArrayList<>(A);
        primes.add(2);
        for(int i=3;i<A;i+=2){
            boolean isPrime = true;
            for(int j=0;j<primes.size();j++){
                if(i%primes.get(j) == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(i);
            }
        }

        System.out.println("primes="+primes);

        Integer[] check = primes.toArray(new Integer[primes.size()]);
        UtilityClass.print(check);

        ArrayList<Integer> print = new ArrayList<>();
        for(int i=0;i<primes.size();i++){
            int found = Arrays.binarySearch(check, A-check[i]);
            System.out.println("number="+(A-check[i])+" found at "+found);
            if( found >= 0){
                print.add(check[i]);
                print.add(A-check[i]);
                break;
            }
        }
        return print;
    }

    public static void main(String[] args){
        PrimeSum p = new PrimeSum();
        System.out.println(p.primeSum(1048574));
    }
}

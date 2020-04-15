package com.my.math;

public class PowerOfIntegers {

    /*
    1 is true
    0 is false
     */
    public int isPower1(int A) {

        if( A == 2){
            return 0;
        }

        int i = 2;

        boolean isOdd = false;
        if( A % 2 != 0){
            isOdd = true;
            i = 3;
        }

        while (i*i < A){
            int power = i;
            while (power < A ){
                power = power * i;
            }
            if(power == A){
                return 1;
            }
            i++;
            if(isOdd) {
                i++;
            }
        }

        if( i*i == A){
            return 1;
        }

        return 0;
    }


    public boolean isPowerBkp(int a) {
        if(a==1) {
            return true;
        }

        for (int i = 2; i*i <= a; i++) {
            int power = a;
            while(power%i == 0){
                power/=i;
            }
            if(power == 1) {
                return true;
            }
        }
        return false;

    }

    public boolean isPower(int a) {
        if( a== 1) {
            return true;
        }

        for (int i = 2; i*i <= a; i++) {
            int power = a;
            while( power%i == 0){
                power = power/i;
            }
            if(power == 1) {
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args){
        PowerOfIntegers powerOfIntegers = new PowerOfIntegers();
        System.out.println(powerOfIntegers.isPower(1024000000));
    }
}

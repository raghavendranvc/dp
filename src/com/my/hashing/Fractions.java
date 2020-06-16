package com.my.hashing;

import java.util.*;

public class Fractions {

    public String fractionToDecimal(int A, int B) {
        if(A%B == 0){
            return String.valueOf(A/B);
        }

        StringBuilder sb = new StringBuilder();

        if( (A > 0 && B < 0) || (A < 0 && B > 0)) {
            sb.append("-");
        }
        A = Math.abs(A);
        B = Math.abs(B);
        sb.append(A/B).append(".");

        A = (A%B)*10;

        Map<Integer,Integer> fraction = new LinkedHashMap<>();
        while(fraction.containsKey(A)){
            fraction.put(A, sb.length()); //Record the length of the result string. So that we know where to keep "("
            sb.append(A/B);
            A = (A%B)*10;
            if(A == 0){ //Fraction is divisible exactly
                return sb.toString();
            }
        }

        // we are here, means there is a repeated pattern/digit
        sb.insert(fraction.get(A),"(");
        sb.append(")");
        return sb.toString();

    }

    public String fractionToDecimalCopied(int numerator, int denominator) {
        long a=numerator,b=denominator;
        if(a%b==0) return String.valueOf(a/b);



        StringBuilder res=new StringBuilder();

        if( (a>0 && b<0)||(a<0 && b>0)) {
            res.append("-");
        }
        a=Math.abs(a);
        b=Math.abs(b);
        res.append(a/b+".");


        a=(a%b)*10;

        Map<Long,Integer> map=new HashMap<>();
        while(!map.containsKey(a)){
            map.put(a,res.length());
            res.append(a/b);
            a=(a%b)*10;
            if(a==0) {
                return res.toString();
            }
        }
        return res.insert(map.get(a),"(").append(")").toString();
    }

}

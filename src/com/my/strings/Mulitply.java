package com.my.strings;

import java.util.Arrays;

public class Mulitply {

    /**
     *      2468 * 141
     *      ==========
     *      2 4 6 8
     *    9 8 7 2 0
     *  2 4 6 8 0 0
     *
     * @param A
     * @param B
     * @return
     */

    public String multiply(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        long totalValue = 0;
        for(int i=0;i<b.length;i++){
            long value = 0;
            for(int j=0;j<a.length;j++){
                value = (long) (value + ((a[a.length-1-j]-'0') * (b[b.length-1-i]-'0'))*(Math.pow(10,j)));
                System.out.println("computing at i="+value +" a="+a[a.length-1-j]+" b="+b[b.length-1-i]);
            }
            totalValue = (long) (totalValue + value * (Math.pow(10,i)));
            System.out.println("computing at j="+value + " totalValue="+totalValue);
        }

        return totalValue+"";

    }

    public String multiplyCopied(String num1, String num2) {

        if(num1.length()==0||num2.length()==0)
            return "";

        if(num1.equals("0")||num2.equals("0"))
            return "0";

        char[] c1=new StringBuilder(num1).reverse().toString().toCharArray();
        char[] c2=new StringBuilder(num2).reverse().toString().toCharArray();
        char[] c=new char[c1.length+c2.length+1];

        Arrays.fill(c,'0');

        for(int i=0;i<c2.length;i++){
            int dig2=c2[i]-'0';
            int carry=0;
            for(int j=0;j<c1.length;j++){
                int dig1=c1[j]-'0';
                int temp=c[i+j]-'0';
                int cur=dig1*dig2+temp+carry;
                c[i+j]=(char) (cur%10+'0');
                carry=cur/10;
            }
            c[i+c1.length]=(char) (carry+'0');
        }
        String ret=new StringBuilder(new String(c)).reverse().toString();
        int pos=0;
        while(ret.charAt(pos)=='0'&&pos<ret.length()) pos++;
        return ret.substring(pos);
    }

    /*
        2   4   6   8   X 4
                    32
                   240
                  1600
                  8000


     */

    public String multiply(char[] a, char m){
        int digit = m - '0';
        if(digit == 0){
            return "0";
        }

        int value = 0;
        for(int i=0;i<a.length;i++){
            value = (int) (value + ((a[a.length-1-i]-'0') * digit)*(Math.pow(10,i)));
            System.out.println("computing at i="+value);
        }

        return value+"";
    }

    public static void main(String[] args){
        String str = "2468";
        String str1 = "141";
        char ch = '4';

        Mulitply mulitply = new Mulitply();
        System.out.println("value="+mulitply.multiply(str,str1));

    }

}

package com.my.strings;

import com.my.common.UtilityClass;

public class AddBinaryStrings {

    public String addBinary(String A, String B) {

        int resultMaxLenght = Math.max(A.length(), B.length())+1;
        char[] ch = new char[resultMaxLenght];

        int i = A.length()-1;
        int j = B.length()-1;
        int k = resultMaxLenght-1;

        int carry = 0;
        /*
        0 0 0 = 0
        0 0 1 = 1
        0 1 1 = 0   Carry = 1
        1 1 1 = 1   Carry = 1
         */
        while(i>=0 && j>=0){
            int bin1 = A.charAt(i--) - '0';
            int bin2 = B.charAt(j--) - '0';
            ch[k--] = (char) ((carry + bin1 + bin2)%2 + '0');
            carry = (carry + bin1 + bin2)/2;
        }

        System.out.println("sum so far");
        UtilityClass.print(ch);


        if(i>=0){
            while(i>=0){
                int bin1 = A.charAt(i--) - '0';
                ch[k--] = (char) ((carry + bin1)%2 + '0');
                carry = (carry + bin1)/2;
            }
            System.out.println("Copying remaing A");
        } else {
            while(j>=0){
                int bin2 = B.charAt(j--) - '0';
                ch[k--] = (char) ((carry + bin2)%2 + '0');
                carry = (carry + bin2)/2;
            }
            System.out.println("Copying remaing B");
        }

        UtilityClass.print(ch);
        if(carry == 1){
            ch[k] = '1';
        }

        return new String(ch).trim();
    }

    public static void main(String[] args){
        String b1 = "1111111";
        String b2 = "11";

        AddBinaryStrings addBinaryStrings = new AddBinaryStrings();
        System.out.println("sum="+addBinaryStrings.addBinary(b1,b2));
    }

}

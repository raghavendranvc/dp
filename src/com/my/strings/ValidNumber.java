package com.my.strings;

import java.util.ArrayList;

public class ValidNumber {
    public int isNumber(final String A) {
        return (A.matches("[-+]?[0-9]*"))? 1 : 0;

        /*

        5   \\s*
        4   [\\-\\+]?
        2   ([0-9]*\\.?)?
        1   [0-9]+
        3   (e[\\-\\+]?[0-9]+)?
        6   \\s*

         */

    }

    /*

    \\s*
    [\\-\\+]?
    ([0-9]*\\.?)?
    [0-9]+
    (e[\\-\\+]?[0-9]+)?
    \\s*

     */

    public int isNumberCopied(final String a) {
        return (a.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
    }


    /*public ArrayList<String> restoreIpAddresses(String A) {
        if(A.length() > 12 && A.length()<4){
            return new ArrayList<>();
        }

        int minLengthPossible = A.length()/4;
        for(int i=minLengthPossible;i<=3;i++){
            String str1 = A.substring(0,i);

            for(int j=minLengthPossible;j<=3;j++){
                String str2 = A.substring(i,i+j);

                for(int k=minLengthPossible;k<=3;k++){
                    String str3 = A.substring(i+j,i+j+k);
                    String str4 = A.substring(i+j+k);

                }
            }
        }


        int maxLengthPossible = Math.max(minLengthPossible + A.length()%3, 3);

    }

    private boolean isValidIPClass(String str){

        if(str.equals("0")) {
            return true;
        }

        if(str.startsWith("0")){
            return false;
        }

        if(str.matches("\d(\d(\d))+")){

        }

    }*/

}

package com.my.strings;

public class IntegerToRomanMapping {

    /**
     * 1345
     *
     * MCCCXLV
     *
     */

    public String intToRoman(int A) {
        String singles[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hundreds[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thousands[]={"","M","MM","MMM"};

        return thousands[A/1000]    +
                hundreds[(A%1000)/100]+
                tens[(A%100)/10]+
                singles[A%10];
    }

}

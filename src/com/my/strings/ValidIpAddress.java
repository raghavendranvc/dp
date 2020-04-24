package com.my.strings;

import java.util.ArrayList;

public class ValidIpAddress {

    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> result = new ArrayList<>();
        restoreIpAddresses(A, 4, "", result);
        return result;
    }

    public void restoreIpAddresses(String givenString, int remaining, String preparedIpAddress, ArrayList<String> resultIps){
        if(givenString.isEmpty() && remaining == 0){ //Entire String is completed in this iteration. So add it to result
            resultIps.add(preparedIpAddress);
            return;
        }

        for(int i=1;i<=3;i++){ //For each possible block length which are 1,2 & 3
            if(givenString.length() < i){
                continue; // It means we cannot have a prefix of length i here as the remaining string is less than 'i' length.
            }


            String block = givenString.substring(0,i);
            int value = Integer.parseInt(block);
            // Validity. Integer length should be equal to i. Else it means that there are leading 0's
            // If "0" alone is the value, then the condition still matches.
            if(value >=0 && value <=255  && String.valueOf(value).length() == i ) {
                String newIpPrefix = preparedIpAddress.isEmpty()? block : preparedIpAddress +"."+block;
                restoreIpAddresses(givenString.substring(i), remaining-1, newIpPrefix, resultIps);
            }
        }
    }
}

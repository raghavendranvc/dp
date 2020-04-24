package com.my.strings;

public class LengthOfLastWord {

    /*
    0   1   2   3   4   5   6   7   8   9   10
    H   e   l   l   o       W   o   r   l   d



     */
    public int lengthOfLastWord(final String A) {
        String tempStr = A.trim();
        for(int i=tempStr.length()-1;i>=0;i--){
            if(tempStr.charAt(i) == ' '){
                return tempStr.length()-1-i;
            }
        }
        return tempStr.length();
    }

}

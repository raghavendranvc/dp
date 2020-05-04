package com.my.dp.ibit;

public class EncodingNumbers {


    /*

    345

    5 - 1

    45
    ==
    4, 45 - 1

    345
    ===
    3 - 1
    34


     */

    public int numDecodingsCopied(String str) {
        int n=str.length();

        if(str==null||n==0)
            return 0;

        int dp[]=new int[n+1];

        dp[0]=1;

        if(str.charAt(0)!='0')
            dp[1]=1;

        for(int i=2;i<=n;i++) {
            int first=Integer.parseInt(str.substring(i-1,i));
            int second=Integer.parseInt(str.substring(i-2,i));
            if(first>=1&&first<=9)
                dp[i]+=dp[i-1];
            if(second>=10&&second<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }


    public int numDecodings(String A){

        if(A == null || A.length()==0){
            return 0;
        }

        if(A.charAt(0) == '0'){
            return 0;
        }

        int n = A.length();

        int[] decodings = new int[n+1];
        //decoding array contains all the ways for strings ending at [i-1]

        decodings[0] = 1; // Why? For length=0, number of decodings possible is 0
        decodings[1] = 1;


        for(int endIndex=2;endIndex<=n;endIndex++){

            int singleNumber = Integer.parseInt(A.substring(endIndex-1,endIndex)); // [1,2)
            int doubleNumber = Integer.parseInt(A.substring(endIndex-2,endIndex)); // [0,2)

            if(singleNumber >= 1 && singleNumber <= 9){
                decodings[endIndex] += decodings[endIndex-1];
            }

            if(doubleNumber >=10 && doubleNumber <=26) {
                decodings[endIndex] += decodings[endIndex-2];
            }

        }

        return decodings[n];


    }





    public int numDecodingsBadNotWorking(String A) {

        int n = A.length();
        int result[] = new int[n];

        if(A.charAt(n-1) != '0') {
            result[n - 1] = 1;
        }


        for(int i=n-2;i>=0;i--){

            int currentPossible = 0;
            int value = Integer.parseInt(A.substring(i,i+2));// (i,i-1) i+2 is excluded
            if(value == 10 || value == 20){
                currentPossible ++;
            } else if(A.charAt(i) != '0') {
                currentPossible ++;
                if(value < 1 || value > 26){
                    currentPossible ++;
                }
            }

            if(currentPossible == 0){
                return 0;
            }

            result[i] = Math.max(currentPossible,result[i+1]);
        }

        return result[0];
    }

}

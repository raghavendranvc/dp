package com.my.arrays;

import java.util.ArrayList;

public class Flip {

    /*public ArrayList<Integer> flip(String A) {

        int firstZero = 0;
        int lastZero = A.length()-1;

        while(A.charAt(firstZero) == '1'){
            firstZero++;
        }

        if(firstZero > A.length()){
            return new ArrayList<>();
        }

        while(A.charAt(lastZero) == '1'){
            lastZero--;
        }

        int numberOfOnes = 0;
        for(int i=firstZero; i<=lastZero; i++){
            if(A.charAt(i) == '1'){
                numberOfOnes++;
            }
        }

        if(numberOfOnes == lastZero-firstZero){

        }

    }*/


    /*public ArrayList<Integer> flip0(String A) {

        int sum = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) == '1'){
                sum = sum -1;
            }
        }


        int firstZero = 0;
        int lastZero = A.length()-1;

        while(A.charAt(firstZero) == '1'){
            firstZero++;
        }

        if(firstZero > A.length()){
            return new ArrayList<>();
        }

        while(A.charAt(lastZero) == '1'){
            lastZero--;
        }

        int numberOfOnes = 0;
        for(int i=firstZero; i<=lastZero; i++){
            if(A.charAt(i) == '1'){
                numberOfOnes++;
            }
        }

        if(numberOfOnes == lastZero-firstZero){

        }

    }*/

    //TODO revist

    public ArrayList<Integer> flip1(String A) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);


        int start = -1; //Simple init
        int count = -1; //Simple init

        boolean all1 = true;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<A.length();i++)
        {
            if(count<0)
            {
                count = 0; //Reset the counter to start again the next subArray
                start = i+1;
            }
            char c = A.charAt(i);
            if(c=='0')
            {
                count++;
                all1 = false;
            }
            else
                count--;

            if(count>max)
            {
                max = count;
                result.set(0,start); //overwrites
                result.set(1,i+1); // overwrites
            }
        }
        if(all1)
            return new ArrayList<Integer>();

        return result;
    }


    public ArrayList<Integer> flip11(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);

        int start = -1;
        int count = -1;

        boolean all1s = true;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<A.length();i++){

            if(count < 0){
                count = 0; //reset the counter from here
                start = i+1; //From next element onwards start the subArray
            }

            if(A.charAt(i) == '0'){
                count++;
                all1s = false;

            } else {
                count--;
            }

            if(count > max){
                max = count;
                result.add(0, start);
                result.add (1, i+1);
            }
        }

        if(all1s) {
            return new ArrayList<>();
        }

        return result;
    }


    public static ArrayList<Integer> flip2(String A) {
        char[] array = A.toCharArray();
        int[] zeroToOne = new int[A.length()];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<array.length;i++){
            if(array[i]=='0'){
                zeroToOne[i]=1; //make all 0's as 1
            }else{
                zeroToOne[i]=-1; //make all 1's as -1
            }
        }

        int cumulative=0, left=0, max_sum=0;

        int left_ans=0,right_ans=0;

        for(int i=0;i<A.length();i++){

            cumulative+=zeroToOne[i];

            if(cumulative<0){
                left=i+1;  // This becomes start of the indexArray
                cumulative=0; //Reset
            }else{
                if(cumulative>max_sum){
                    max_sum=cumulative;
                    left_ans=left;
                    right_ans=i;
                }
            }
        }

        if(max_sum<=0){
            return ans;
        }else{
            ans.add(left_ans+1);
            ans.add(right_ans+1);
        }
        return ans;
    }

    public ArrayList<Integer> flip3(String A) {
        int globalSum = 0, left = -1, right = -1, localSum = 0, localLeft = -1, localRight = -1;

        for(int i = 0; i < A.length(); i++) {

            if (A.charAt(i) == '0') {
                localSum += 1; //for every 0 increase the count by 1

                if (localLeft == -1) //if localLeft is not present, then this the start of the subArray
                    localLeft = i;

                localRight = i;

                if (localSum > globalSum) { //if we got a new sum greater than the global then set it as global
                    globalSum = localSum;
                    left = localLeft;
                    right = localRight;
                }
            } else {
                localSum -= 1; //for every 1 reduce the count by 1
                if (localSum < 0)  // the local sum became negative. So reset everything
                {
                    localSum = 0;
                    localLeft = -1;
                    localRight = -1;
                }
            }
        }

        if(globalSum == 0 || left == -1 || right == -1)
            return new ArrayList<Integer>();
        else
        {
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(left+1);
            res.add(right+1);
            return res;
        }



    }

    public ArrayList<Integer> flip(String A) {

        int max = 0;

        int cumulativeSum = 0;
        int left = -1;
        int right = -1;

        int tempLeft = -1;
        int tempRight = -1;

        for(int i=0;i <A.length();i++) {

            if(A.charAt(i) == '0') {
                cumulativeSum++;

                if(tempLeft == -1) {
                    tempLeft = i;
                }

                tempRight = i;

                if(cumulativeSum > max) {
                    max = cumulativeSum;
                    left = tempLeft;
                    right = tempRight;
                }

            } else {
                cumulativeSum--;
                if(cumulativeSum < 0) {
                    cumulativeSum = 0;
                    tempLeft = -1;
                    tempRight = -1;
                }

            }
        }

        if(max == 0 || left == -1 || right == -1){
            return new ArrayList<>();
        } else {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(left+1);
            result.add(right+1);
            return result;
        }
    }


    public static void main(String[] args){



    }
}

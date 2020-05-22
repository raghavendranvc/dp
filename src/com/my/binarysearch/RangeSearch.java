package com.my.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class RangeSearch {


    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        returnList.add(findIndex(A,B,true));
        returnList.add(findIndex(A,B,false));
        return returnList;
    }
    
    //TODO this logic is very crucial

    public int findIndex(final List<Integer> A, int key, boolean lower){

        int l = 0;
        int h = A.size()-1;

        int returnIndex = -1;
        while (l <=h ){
            int mid = (l+h)/2;

            if(A.get(mid) == key) {
                returnIndex = mid;
            }

            if(key > A.get(mid)){
                l = mid + 1;
            } else if (key < A.get(mid)){
                h = mid - 1;
            } else { //if key == A.get(mid)
                if(lower) { //Lower Index
                    h = mid - 1;  // To find lower Index, we have to move search in the left side. So new high = mid -1
                } else {
                    l = mid + 1;   // To find higher Index, we need to search in the right side. So new low = mid +1
                }
            }
        }

        return returnIndex;
    }

    public ArrayList<Integer> searchRangeElegant(final List<Integer> A, int B) {

        int count = A.size();
        int low = 0;

        ArrayList<Integer> returnList = new ArrayList<>();

        if(count == 0 || (A.get(0) > B || A.get(count-1) < B)) {
            returnList.add(-1);
            returnList.add(-1);
            return returnList;
        }

        int l = low;
        int r = count-1;

        //Finding the first smaller element
        // 0    1   2   3   4   5   6   7   8   9   10  11  12  13
        // l                        m                           r
        // 5    9   9  10   10  10  10  11  11  11  15  18  22  25
        // B = 10
        // B = 11
        // B = 9

        int firstSmaller = l;
        while (l <= r) {
            int mid = (l+r)/2;

//            System.out.println("SE:Starting :: A.get("+l+")="+A.get(l)+" A.get("+mid+")="+A.get(mid)+" A.get("+r+")="+A.get(r));

            if(A.get(mid) >= B){
                r = mid - 1;
//                System.out.println("SE:new right :: A.get("+l+")="+A.get(l)+" A.get("+mid+")="+A.get(mid)+" A.get("+r+")="+A.get(r));
            } else {
                firstSmaller = mid;
                l = mid + 1;
 //               System.out.println("SE:new left :: A.get("+l+")="+A.get(l)+" A.get("+mid+")="+A.get(mid)+" A.get("+r+")="+A.get(r));
            }
            /*if(A.get(mid) < B){
                l = mid;
            }

            if(A.get(mid) > B){
                r = mid;
            } */
        }

        /**
         * We should increase by 1 for all except when the search is for first element
         * for first element low = firstSmaller
         */

        if(A.get(firstSmaller) == B){
            returnList.add(firstSmaller);
        } else if(A.get(firstSmaller+1) == B){
            returnList.add(firstSmaller+1);
        } else {
            returnList.add(-1);
            returnList.add(-1);
            return returnList;
        }


        //System.out.println();

        l = low;
        r = count-1;

        //Finding the first greater element

        int firstGreater = r;
        while (l <= r) {
            int mid = l + (r-l)/2;
            // mid = (2l+r-l)/2 = (l+r)/2

//            System.out.println("GE:Starting :: A.get("+l+")="+A.get(l)+" A.get("+mid+")="+A.get(mid)+" A.get("+r+")="+A.get(r));

            if(A.get(mid) > B){
                firstGreater = mid;
                r = mid - 1;
//                System.out.println("GE:new right :: A.get("+l+")="+A.get(l)+" A.get("+mid+")="+A.get(mid)+" A.get("+r+")="+A.get(r));
            } else {
                l = mid + 1;
//                System.out.println("GE:new left :: A.get("+l+")="+A.get(l)+" A.get("+mid+")="+A.get(mid)+" A.get("+r+")="+A.get(r));
            }
        }

        /**
         * We should decrease by 1 for all except when the search is for last element
         * for last element high = firstGreater
         */

        if(A.get(firstGreater) == B){
            returnList.add(firstGreater);
        } else if(A.get(firstGreater-1) == B){
            returnList.add(firstGreater-1);
        } else {
            returnList.add(-1);
            returnList.add(-1);
            return returnList;
        }



        return returnList;

    }

    public static void main(String[] args){
        int[] A =  new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        int B = 1;

        ArrayList<Integer> intList = new ArrayList<>(A.length);
        for (int i : A){
            intList.add(i);
        }
        System.out.println("Initial Array="+intList);

        RangeSearch rangeSearch = new RangeSearch();
        System.out.println("Answer="+rangeSearch.searchRange(intList,B));

    }

    public ArrayList<Integer> searchRangeCopied(final List<Integer> a, int b) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(getIndex(a, b, 0));
        ans.add(getIndex(a, b, 1));
        return ans;
    }
    public int getIndex(List<Integer> a, int b, int i) {
        int low = 0, high = a.size() - 1, mid = 0;
        int ans = -1;
        while(low <= high){

            mid = low + (high - low) / 2;

            if((int)a.get(mid) == b) {
                ans = mid;
            }

            if(i == 0) { //Lower Index
                if ((int) a.get(mid) < b)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else if(i == 1) { //Higher Index
                if ((int) a.get(mid) <= b)
                    low = mid + 1;
                else
                    high = mid - 1;
            }


        }
        return ans;
    }

}

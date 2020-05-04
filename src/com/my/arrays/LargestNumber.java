package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.*;

public class LargestNumber {

    public String largestNumber(final List<Integer> A) {
        List<String> aStr = new ArrayList<>(A.size());
        for(int i=0; i<A.size();i++){
            aStr.add(A.get(i).toString());
        }
        Collections.sort(aStr, new StringComparator());
        System.out.println(aStr);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(;i<aStr.size();i++){
            if(!aStr.get(i).equals("0")){
                break;
            }
        }

        for(;i<aStr.size();i++){
            sb.append(aStr.get(i));
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public class StringComparator implements Comparator<String>{


        public int compare1(String a, String b){
            return (b+a).compareTo(a+b);
        }

        @Override
        public int compare(String o1, String o2) {
            int i=0;
            for(; i<o1.length() && i<o2.length();i++){
                if(o1.charAt(i)>o2.charAt(i)){
                    return -1;
                } else if(o1.charAt(i)<o2.charAt(i)){
                    return 1;
                }
            }

            if( i == o1.length() && i < o2.length()) {
                return compare(o1,o2.substring(i,o2.length()));
            }

            if( i == o2.length() && i < o1.length()) {
                return compare(o1.substring(i,o1.length()),o2);
            }

            return 1;
        }
    }

    public static void main(String[] args){
        //int[] a = new int[] {721, 500, 304, 829, 380, 795, 318, 264, 190, 713, 683, 643, 967, 2, 519, 55, 698, 893, 416, 638, 733, 625, 808, 291, 63, 299, 653, 790, 77, 967, 837, 129, 307, 179, 668, 919, 584, 673, 550, 238, 792, 406, 959, 512, 250, 8, 433, 580, 327, 419, 266, 717, 354, 252, 769, 364, 784, 557, 22, 120, 313, 38, 434, 935, 891, 429, 82, 344, 946, 82, 519, 41, 22, 95, 160, 632, 19, 255, 895, 351, 897, 19, 836, 450, 943, 938, 663, 893, 742  };
        //int[] a = new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};
        int[] a = new int[] {12, 121};
        UtilityClass.print(a);

        ArrayList<Integer> intList = new ArrayList<Integer>(a.length);
        for (int i : a)
        {
            intList.add(i);
        }
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(intList));
    }
}

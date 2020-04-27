package com.my.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        Collections.sort(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<Math.pow(2,A.size()); i++){

            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int j=0;j<A.size();j++){
                if( (i & (1 << j)) != 0){ // "j"th bit in "i'
                    arrayList.add(A.get(j));
                }
            }
            result.add(arrayList);
        }
        return result;


        /*for(int startIndex=0;startIndex<A.size();startIndex++){
            for(int length=1;length<=A.size()-startIndex;length++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = startIndex; i < startIndex + length; i++) {
                    arrayList.add(A.get(i));
                }
                result.add(arrayList);
            }
        }
        return result;*/
    }

    public ArrayList<ArrayList<Integer>> subsetsCopied(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if (a.size() == 0) {
            return output;
        }
        Collections.sort(a);
        generate(a, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
    {
        for (int i = index; i < a.size(); i++) {
            temp.add(a.get(i));
            output.add(new ArrayList<Integer>(temp));
            generate(a, output, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }





}

package com.my.hashing;

import java.util.*;

public class FourSum {

    //TODO still some duplicates are there

    static class Pair {
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "("+x+","+y+")";
        }

        @Override
        public int hashCode(){
            return x*y;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }

            Pair op = (Pair) obj;
            return (this.x == op.x && this.y == op.y) || (this.x == op.y && this.y == op.x);
        }
    }

    public class FourComparator implements Comparator<List<Integer>> {

        public int compare(List<Integer> o1, List<Integer> o2) {
            for(int i=0;i<4;i++){
                if(o1.get(i) > o2.get(i)){
                    return 1;
                } else if(o1.get(i) < o2.get(i)){
                    return -1;
                }
            }
            return 0;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSumNeedsToBeRefined(ArrayList<Integer> A, int B) {

        Collections.sort(A);

        Map<Integer, Set<Pair>> doubleSet = new LinkedHashMap<>();
        for(int i=0;i<A.size();i++){ // i is the first index of the pair
            for(int j=i+1;j<A.size();j++){ // j is the second index of the pair
                int value = A.get(i) + A.get(j);
                Pair p = new Pair(A.get(i),A.get(j));
                if(doubleSet.containsKey(new Integer(value))){
                    doubleSet.get(value).add(p);
                } else {
                    Set<Pair> lp = new HashSet<>();
                    lp.add(p);
                    doubleSet.put(value,lp);
                }
            }
        }

        System.out.println(doubleSet);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Set<Integer> processedValues = new LinkedHashSet<>();

        for (Map.Entry<Integer, Set<Pair>> entry : doubleSet.entrySet() ){
            if(processedValues.contains(entry.getKey())){
                continue;
            }
            if(entry.getKey() ==  (B-entry.getKey())){
                //Unique case where this has value Target/2. So we just need to take different mappings between them
                List<Pair> pairs = new ArrayList(entry.getValue());
                for(int i=0;i<pairs.size()-1;i++){
                    for(int j=i+1;j<pairs.size();j++){
                        addToList(pairs.get(i),pairs.get(j),result);
                    }
                }
            } else if(doubleSet.containsKey(B-entry.getKey())){
                List<Pair> l1 = new ArrayList(entry.getValue());
                List<Pair> l2 = new ArrayList(doubleSet.get(B-entry.getKey()));

                for(int i=0;i<l1.size();i++){
                    for(int j=0;j<l2.size();j++){
                        addToList(l1.get(i),l2.get(j),result);
                    }
                }
            }
            processedValues.add(entry.getKey());
            processedValues.add(B-entry.getKey());

        }

        Collections.sort(result,new FourComparator());
        return result;

    }

    public void addToList(Pair p1, Pair p2, ArrayList<ArrayList<Integer>> result){
        ArrayList<Integer> tList = new ArrayList<>();
        tList.add(p1.x);
        tList.add(p1.y);
        tList.add(p2.x);
        tList.add(p2.y);
        result.add(tList);

    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = A.size();
        Set<ArrayList<Integer>> tempMap = new HashSet<>();

        for(int i=0;i<A.size()-1;i++){
            for(int j=i+1;j<A.size();j++){
                int k = j+1;
                int l = n-1;
                int currentTarget = B - A.get(i) + A.get(j);

                while (k < l){
                    int sum = A.get(k) + A.get(j);
                    if(sum > currentTarget){
                        l--;
                    } else if(sum < currentTarget){
                        k++;
                    } else {
                        ArrayList<Integer> tempList = new ArrayList<>();
                        tempList.add(A.get(i));
                        tempList.add(A.get(j));
                        tempList.add(A.get(k));
                        tempList.add(A.get(l));
                        if(!tempMap.contains(tempList)){
                            tempMap.add(tempList);
                            result.add(tempList);
                        }
                    }

                }
            }
        }
        return result;
    }






    public ArrayList<ArrayList<Integer>> fourSumCopied(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }
}

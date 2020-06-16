package com.my.hashing;

import java.util.*;

public class EqualKey {

    //TODO practice it

    static class Pair{
        int a;
        int b;
        Pair (int a , int b){
            this.a = a;
            this.b = b;
        }

        public boolean equals(Object obj){
            if(this == obj) {
                return true;
            }

            Pair otherP = (Pair) obj;
            return ( (this.a == otherP.a && this.b == otherP.b) || (this.a == otherP.b && this.b == otherP.a));
        }

    }

    /*
    n-1
    n-2
    n-3
    n-4

    3
    2
     1

     0,1
     0,2 1,2
     0,3 1,3 2,3
     0,4 1,4 2,4 3,4



     */

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Pair> map = new LinkedHashMap<>();

        for(int i=1;i<9;i++){
            for(int j=0;j<i;j++){
                int sum = A.get(j)+A.get(i);
                if(map.containsKey(sum)){
                    Pair p = map.get(sum) ;
                    result.add(p.a);
                    result.add(p.b);
                    result.add(j);
                    result.add(i);
                    return result;
                } else {
                    map.put(sum,new Pair(j,i));
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> equalCopied(ArrayList<Integer> A) {
        int sum=0;
        ArrayList<Integer>ans=null;
        Hashtable<Integer,ArrayList<Integer>>ht=new Hashtable<Integer,ArrayList<Integer>>();

        for(int i=0;i<A.size();i++) {
            for(int j=i+1;j<A.size();j++) {
            	
                sum=A.get(i)+A.get(j);
                
                if(ht.containsKey(sum)) {
                    ArrayList<Integer>a=ht.get(sum);
                    if(a.get(0)!=i && a.get(1)!=j && a.get(0)!=j && a.get(1)!=i) {
                    	
                        ArrayList<Integer>tmp=new ArrayList<Integer>();
                        tmp.add(a.get(0));
                        tmp.add(a.get(1));
                        tmp.add(i);
                        tmp.add(j);
                        
                        if(ans==null) {
                            ans = tmp;
                        }  else  {
                        	//This is to get lex smallest
                            for(int k=0;k<4;k++) {
                                if(ans.get(k)<tmp.get(k)) {
                                    break;
                                } else if(ans.get(k)>tmp.get(k)) {
                                    ans=tmp;
                                    break;
                                }
                            }
                        }
                    }
                }
                else
                {
                    ArrayList<Integer>l=new ArrayList<Integer>();
                    l.add(i);
                    l.add(j);
                    ht.put(sum,l);
                }
            }
        }
        return ans;
    }


    public ArrayList<Integer> equalButDistorted(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Pair>> map = new LinkedHashMap<>();

        for(int i=0;i<A.size()-1;i++){
            for(int j=i+1;j<A.size();j++){
                int sum = A.get(i)+A.get(j);
                if(map.containsKey(sum)){
                    ArrayList<Pair> aList = map.get(sum);
                    Pair newPair = new Pair(i,j);
                    if(!aList.equals(newPair)){
                        result.add(newPair.a);
                        result.add(newPair.b);
                        result.add(i);
                        result.add(j);
                        return result;
                    }
                } else {
                    //map.put(sum,new Pair(i,j));
                }
            }
        }
        return result;
    }

}

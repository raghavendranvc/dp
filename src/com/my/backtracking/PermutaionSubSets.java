package com.my.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutaionSubSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<String>> inputList=new ArrayList<List<String>>();
        
		List<String> arrayList=null;
        
		arrayList=new ArrayList<String>();
        arrayList.add("a1");
        arrayList.add("a2");
        arrayList.add("a3");
        inputList.add(arrayList);
        
        arrayList=new ArrayList<String>();
        arrayList.add("b1");
        arrayList.add("b2");
        arrayList.add("b3");
        arrayList.add("b4");
        inputList.add(arrayList);
        
        arrayList=new ArrayList<String>();
        arrayList.add("c1");
        arrayList.add("c2");
        arrayList.add("c3");
        inputList.add(arrayList);
        
        PermutaionSubSets p = new PermutaionSubSets();
        p.getAllPermutations(inputList);

	}
	
	public void getAllPermutations(List<List<String>> lists){
		
		List<List<String>> retSet = new ArrayList<List<String>>();
		
		/*
		 * Initialize with first Set.
		 * This Solution set is when number of lists is 1;
		 */
		for(int i=0;i<lists.get(0).size();i++){ 
			List<String> innerSet = new ArrayList<String>();
			innerSet.add(lists.get(0).get(i));
			retSet.add(innerSet);  
		}
		
		if(lists.size() > 0){
			/*
			 * For further permutations - pass this permutation and next List which returns a 
			 * complete permutation of that.
			 * 
			 */
			
			for(int i=1;i<lists.size();i++){ 
				retSet = getAllPerumationsForEachCouple(lists.get(i),retSet);
			}
		}
		
		for(int i=0;i<retSet.size();i++){
			System.out.println(i+" "+retSet.get(i));
		}
	}
	
	/*
	 * [c1,c2]  X {  {a1,b1},{a1,b2},{a2,b1},{a2,b2} }
	 * {{a1,b1,c1},{a1,b1,c2},{a1,b2,c1},{a1,b2,c2},{a2,b1,c1},{a2,b1,c2},{a2,b2,c1},{a1,b2,c2}}
	 */
	
	public List<List<String>> getAllPerumationsForEachCouple(List<String> list,List<List<String>> subSet){
		List<List<String>> retSet = new ArrayList<List<String>>();
		for(int i=0;i<list.size();i++){ 
			for(int j=0;j<subSet.size();j++){ 
				List<String> innerSet = new ArrayList<String>(subSet.get(j));
				innerSet.add(list.get(i));
				retSet.add(innerSet);  
			}
		}
		return retSet;
	}
}

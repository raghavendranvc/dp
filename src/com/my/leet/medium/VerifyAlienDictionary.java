package com.my.leet.medium;

import java.util.HashMap;
import java.util.Map;

public class VerifyAlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		Map<Character,Integer> orderMap = new HashMap<>();
		for(int i=0;i<order.length();i++) {
			orderMap.put(order.charAt(i), i);
		}
		
		for(int i=1;i<words.length;i++) {
			if(compare(words[i-1], words[i], orderMap) > 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	private int compare(String a, String b, Map<Character,Integer> orderMap) {
		int m = a.length();
		int n = b.length();
		
		int diff = 0;
		for(int i=0,j=0;i<m && j < n;i++,j++) {
			diff = orderMap.get(a.charAt(i)) - orderMap.get(b.charAt(j));
			if(diff != 0 ) {
				break;
			}
		}
		
		if(diff == 0) {
			return m-n;
		}
		
		return diff;
	}
	
}

package com.my.leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNSASequences {
	// https://leetcode.com/problems/repeated-dna-sequences/
	// https://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/
	public List<String> findRepeatedDnaSequences(String s) {
		return null;
	}
	
	//TODO Copied. Not done

	/**
	 * The key to solve this problem is that each of the 4 nucleotides can be stored
	 * in 2 bits. So the 10-letter-long sequence can be converted to 20-bits-long
	 * integer. The following is a Java solution. You may use an example to manually
	 * execute the program and see how it works.
	 * 
	 * @param s
	 * @return
	 */

	public List<String> findRepeatedDnaSequencesCopied(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 10) {
			return result;
		}

		HashMap<Character, Integer> dict = new HashMap<>();
		dict.put('A', 0);
		dict.put('C', 1);
		dict.put('G', 2);
		dict.put('T', 3);

		int hash = 0;
		int mask = (1 << 20) - 1;

		HashSet<Integer> added = new HashSet<>();
		HashSet<Integer> temp = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			hash = (hash << 2) + dict.get(s.charAt(i));

			if (i >= 9) {
				hash &= mask;
				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash);
				}

				temp.add(hash);
			}
		}

		return result;
	}

}

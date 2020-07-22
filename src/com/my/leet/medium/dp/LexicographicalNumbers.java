package com.my.leet.medium.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {

	public void solve(int curr, int n, List<Integer> ret) {
		if (curr > n) {// curr is the number
			return;
		}
		ret.add(curr);
		for (int i = 0; i < 10; i++) {// append 0-9 to the end of curr

			if (curr * 10 + i <= n) {// recurse as long as its less than n
				solve(curr * 10 + i, n, ret);
			} else {
				break;
			}
		}
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {// fix first digit
			solve(i, n, ret);
		}
		return ret;
	}
	
	//-----------------------------------

	public List<Integer> lexicalOrderSimpleSort(int n) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(String.valueOf(i));
		}

		Collections.sort(list, new Comparator<String>() {
			public int compare(String a, String b) {
				int i = 0;
				while (i < a.length() && i < b.length()) {
					if (a.charAt(i) != b.charAt(i)) {
						return a.charAt(i) - b.charAt(i);
					}
					i++;
				}

				if (i >= a.length()) {
					return -1;
				}

				return 1;
			}
		});

		List<Integer> result = new ArrayList<>();
		for (String s : list) {
			result.add(Integer.parseInt(s));
		}

		return result;
	}

}

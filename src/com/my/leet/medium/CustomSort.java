package com.my.leet.medium;

public class CustomSort {
	
	//S is the pattern
	//T is the string to be sorted
	public String customSortStringLinear(String S, String T) {
        // Step 1: count the freq of each char in T
        //
        int[] freq = new int[26];
         
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            freq[c - 'a']++;
        }
         
        // step 2: scan the string S and print the number of chars in T
        //
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
             
            while (freq[c - 'a'] > 0) {
                sb.append(c);
                freq[c - 'a']--;
            }
        }
         
        // step 3: scan the freq again and append anything not zero
        // these are not alphabets within the pattern. So we need to append them
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }
         
        return sb.toString();
    }
	
	//------------------Below is based that every aplhatbet is ranked-----------------

	int MAX_CHAR = 26;

	// not in place
	void sortByPattern(char[] str, char[] pat) {
		// Create a count array stor
		// count of characters in str.
		int frequencyMap[] = new int[MAX_CHAR];

		// Count number of occurrences of
		// each character in str.
		for (int i = 0; i < str.length; i++) {
			frequencyMap[str[i] - 'a']++;
		}

		// Traverse the pattern and print every characters
		// same number of times as it appears in str. This
		// loop takes O(m + n) time where m is length of
		// pattern and n is length of str.
		int index = 0;
		for (int i = 0; i < pat.length; i++) {
			for (int j = 0; j < frequencyMap[pat[i] - 'a']; j++) {
				str[index++] = pat[i];
			}
		}
	}
	
	//-----------------MergeSortWay-------------------------------

	public String customSortString(String S, String T) {
		int[] dict = new int[26];

		for (int i = 0; i < dict.length; i++) {
			dict[i] = Integer.MAX_VALUE;
		}

		// Step 1: note the position of each char in S
		//
		for (int i = 0; i < S.length(); i++) {
			dict[S.charAt(i) - 'a'] = i;
		}

		// Step 2: merge sort
		//
		char[] Aux = new char[T.length()];
		char[] A = T.toCharArray();
		customMergeSort(dict, A, Aux, 0, A.length - 1);

		return String.copyValueOf(A);
	}

	private void customMergeSort(int[] dict, char[] A, char[] Aux, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int mid = lo + (hi - lo) / 2;

		customMergeSort(dict, A, Aux, lo, mid);
		customMergeSort(dict, A, Aux, mid + 1, hi);

		customMerge(dict, A, Aux, lo, mid, hi);
	}

	private void customMerge(int[] dict, char[] A, char[] Aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			Aux[i] = A[i];
		}

		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				A[k] = Aux[j++];
			} else if (j > hi) {
				A[k] = Aux[i++];
			} else if (dict[Aux[i] - 'a'] < dict[Aux[j] - 'a']) {
				A[k] = Aux[i++];
				;
			} else if (dict[Aux[i] - 'a'] >= dict[Aux[j] - 'a']) {
				A[k] = Aux[j++];
			}
		}
	}

}

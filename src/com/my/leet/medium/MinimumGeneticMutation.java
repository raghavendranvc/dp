package com.my.leet.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

	// https://leetcode.com/problems/minimum-genetic-mutation/
	// https://zhaonanli.gitbooks.io/leetcode/433minimum-genetic-mutation.html

	// BFS, Queue, Map

	public int minMutation(String start, String end, String[] bank) {

		if (start == null || end == null || start.length() < 8 || end.length() < 8) {
			return 0;
		}

		Map<String, Integer> distance = new HashMap<>();
		distance.put(start, 0);

		Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

		char[] geneChars = { 'A', 'C', 'G', 'T' };

		Queue<String> bfsQ = new LinkedList<String>();
		bfsQ.add(start);

		while (!bfsQ.isEmpty()) {
			String currentString = bfsQ.remove();

			if (currentString.equals(end)) {
				return distance.get(currentString);
			}

			for (int i = 0; i < currentString.length(); i++) {

				char[] currentStrChar = currentString.toCharArray();

				for (int j = 0; j < geneChars.length; j++) {
					if (currentStrChar[i] == geneChars[j]) {
						continue;
					}
					currentStrChar[i] = geneChars[j];
					String newGeneStr = String.valueOf(currentStrChar);
					if (!bankSet.contains(newGeneStr) || distance.containsKey(newGeneStr)) {
						continue;
					}

					distance.put(newGeneStr, distance.get(currentString) + 1);
					bfsQ.add(newGeneStr);
				}

			}

		}

		return -1;
	}

	public int minMutationCopied(String start, String end, String[] bank) {
		// check input
		if (start == null || start.length() < 8 || end == null || end.length() < 8) {
			throw new IllegalArgumentException("the input is invalid");
		}

		char[] candidates = new char[] { 'A', 'C', 'G', 'T' };

		Set<String> genes = new HashSet<>(Arrays.asList(bank));

		// BFS
		Map<String, Integer> distanceMap = new HashMap<>();
		distanceMap.put(start, 0);

		Queue<String> queue = new LinkedList<>();
		queue.add(start);

		while (queue.size() > 0) {
			String curr = queue.remove();
			int distance = distanceMap.get(curr);

			if (curr.equals(end)) {
				return distance;
			}

			char[] chars = curr.toCharArray();
			for (int i = 0; i < 8; i++) {
				char originalChar = chars[i];

				for (int j = 0; j < candidates.length; j++) {
					if (candidates[j] == originalChar) {
						continue;
					}
					chars[i] = candidates[j];
					String newStr = String.valueOf(chars);
					if (!genes.contains(newStr) || distanceMap.containsKey(newStr)) {
						continue;
					}

					distanceMap.put(newStr, distance + 1);
					queue.add(newStr);
				}

				chars[i] = originalChar;
			}
		}

		return -1;
	}

}

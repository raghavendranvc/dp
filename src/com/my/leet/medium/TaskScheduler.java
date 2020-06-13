package com.my.leet.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	// https://massivealgorithms.blogspot.com/2017/06/leetcode-621-task-scheduler.html
	// https://leetcode.com/problems/task-scheduler/

	public int leastInterval1(char[] tasks, int n) {
		int[] counter = new int[26];
		
		int max = 0;
		int maxCount = 0;
		
		for (char task : tasks) {
			counter[task - 'A']++;
			if (max == counter[task - 'A']) {
				maxCount++;
			} else if (max < counter[task - 'A']) {
				max = counter[task - 'A'];
				maxCount = 1;
			}
		}

		int partCount = max - 1;
		int partLength = n - (maxCount - 1);
		int emptySlots = partCount * partLength;
		int availableTasks = tasks.length - max * maxCount;
		int idles = Math.max(0, emptySlots - availableTasks);

		return tasks.length + idles;
	}

	public int leastIntervalUsingIdleSlots(char[] tasks, int n) {

		int[] map = new int[26];
		for (char c : tasks)
			map[c - 'A']++;

		Arrays.sort(map);

		int max_val = map[25] - 1, idle_slots = max_val * n;

		for (int i = 24; i >= 0 && map[i] > 0; i--) {
			idle_slots -= Math.min(map[i], max_val);
		}
		return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
	}

	public int leastIntervalWithSortings(char[] tasks, int n) {
		int[] map = new int[26];

		for (char c : tasks) {
			map[c - 'A']++;
		}

		Arrays.sort(map);

		int time = 0;
		while (map[25] > 0) {
			int i = 0;

			while (i <= n) {
				if (map[25] == 0)
					break;

				if (i < 26 && map[25 - i] > 0)
					map[25 - i]--;

				time++;
				i++;
			}
			Arrays.sort(map);
		}
		return time;
	}

	public int leastInterval(char[] tasks, int n) {
		if (n == 0)
			return tasks.length;

		Map<Character, Integer> taskToCount = new HashMap<>();
		for (char c : tasks) {
			taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
		}

		Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1); // reverseOrder

		for (char c : taskToCount.keySet()) // maxHeap
			queue.offer(taskToCount.get(c));

		Map<Integer, Integer> coolDown = new HashMap<>();

		int currTime = 0;
		while (!queue.isEmpty() || !coolDown.isEmpty()) {
			if (coolDown.containsKey(currTime - n - 1)) {
				queue.offer(coolDown.remove(currTime - n - 1));
			}

			if (!queue.isEmpty()) {
				int left = queue.poll() - 1;
				if (left != 0)
					coolDown.put(currTime, left);
			}
			currTime++;
		}

		return currTime;
	}
}

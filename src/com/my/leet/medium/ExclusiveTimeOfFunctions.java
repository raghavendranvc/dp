package com.my.leet.medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

	class LogEntry {
		int processId;
		int timeStamp;
		boolean start;

		LogEntry(String log) {
			String[] values = log.split(log);
			processId = Integer.parseInt(values[0]);
			start = "start".equals(values[1]);
			timeStamp = Integer.parseInt(values[1]);
		}
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		Stack<Integer> processes = new Stack<>();
		int[] result = new int[n];

		int pStartTime = 0;
		for (int i = 0; i < logs.size(); i++) {
			LogEntry lEntry = new LogEntry(logs.get(i));

			if (!processes.isEmpty()) {
				result[processes.peek()] += lEntry.timeStamp - pStartTime;
			}

			if (lEntry.start) {
				processes.push(lEntry.processId);
			} else {
				// We should also count the current timeStamp as part of the process
				// as it ended at this step
				result[processes.pop()]++;
				// next process, shall execute from the next timestamp
				pStartTime = lEntry.timeStamp + 1;
			}

		}
		return result;
	}

}

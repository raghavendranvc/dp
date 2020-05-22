package com.my.fb;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreams {

	int[] findMedian(int[] arr) {
		// Write your code here
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		int[] output = new int[arr.length];
		output[0] = arr[0];

		if (arr.length == 1) {
			return output;
		}

		if (arr.length >= 2) {
			output[1] = (arr[0] + arr[1]) / 2;

			if (arr[0] <= arr[1]) {
				maxHeap.add(arr[0]);
				minHeap.add(arr[1]);
			} else {
				maxHeap.add(arr[1]);
				minHeap.add(arr[0]);
			}
		}

		for (int i = 2; i < arr.length; i++) {

			int left = maxHeap.peek();
			int right = minHeap.peek();

			if (maxHeap.size() == minHeap.size()) {

				if (arr[i] <= left) {
					maxHeap.add(arr[i]);
				} else if (arr[i] >= right) {
					minHeap.add(right);
				} else { // arr[i] is between left and right
					maxHeap.add(arr[i]);
				}

				if (maxHeap.size() > minHeap.size()) {
					output[i] = maxHeap.peek();
				} else {
					output[i] = minHeap.peek();
				}

			} else if (maxHeap.size() > minHeap.size()) {

				if (arr[i] < left) { // if smaller we need to readjust
					maxHeap.poll();// left
					minHeap.add(left);
					maxHeap.add(arr[i]);
				} else { // equal or greater simply move to minHeap
					minHeap.add(arr[i]);
				}
				output[i] = (minHeap.peek() + maxHeap.peek()) / 2;

			} else if (maxHeap.size() < minHeap.size()) {

				if (arr[i] > right) {
					minHeap.poll();// right
					maxHeap.add(right);
					minHeap.add(arr[i]);
				} else {
					maxHeap.add(arr[i]);
				}

				output[i] = (minHeap.peek() + maxHeap.peek()) / 2;
			}

		}
		return output;

	}

}

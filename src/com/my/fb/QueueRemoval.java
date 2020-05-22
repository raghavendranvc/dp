package com.my.fb;

import java.util.LinkedList;
import java.util.Queue;

import com.my.common.UtilityClass;

public class QueueRemoval {

	class Pair {
		int index;
		int value;

		Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}

		public String toString() {
			return "index=" + index + " value=" + value;
		}
	}

	int[] findPositions(int[] arr, int x) {
		// Write your code here
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			queue.add(new Pair(i, arr[i]));
		}
		
		System.out.println("Initial queue="+queue);

		int[] returnList = new int[x];

		for (int i = 0; i < x; i++) {

			int maxElement = -1;
			Queue<Pair> tQueue = new LinkedList<>();
				
			for (int j = 0; j < x && !queue.isEmpty(); j++) {
				Pair element = queue.remove();
				if (maxElement < element.value) {
					maxElement = element.value;
				}
				tQueue.add(element);
			}

			System.out.println("TempQueue=" + tQueue + " maxElement=" + maxElement);

			boolean maxRemoved = false;

			while(!tQueue.isEmpty()) {

				Pair element = tQueue.remove();
				System.out.println("Pair  Processing="+element);
				if (!maxRemoved && maxElement == element.value) {
					System.out.println("maxElement="+element);
					maxRemoved = true;
					returnList[i] = element.index + 1;
				} else {
					if (element.value > 0) {
						queue.add(new Pair(element.index, element.value - 1));
					} else {
						queue.add(element);
					}

				}
			}
			System.out.println("After "+i+" Queue=" + queue);
			UtilityClass.print(returnList);
		}
		return returnList;
	}

	public static void main(String[] args) {
		QueueRemoval queueRemoval = new QueueRemoval();
		int[] arr = { 1, 2, 2, 3, 4, 5 };
		int x = 5;
		queueRemoval.findPositions(arr, x);
	}

}

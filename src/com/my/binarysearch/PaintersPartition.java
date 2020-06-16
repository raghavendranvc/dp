package com.my.binarysearch;

import com.my.common.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PaintersPartition {

	/*
	 * A is number of painters
	 */
	public boolean isPossible(int A, ArrayList<Integer> C, int T) {
		int painterAssinged = 0;
		int onePainterWork = 0;

		while (!C.isEmpty()) {
			painterAssinged++;
			System.out.println("C=" + C + " painterAssinged=" + painterAssinged);
			onePainterWork = 0;

			for (int i = 0; i < C.size(); i++) {
				if (onePainterWork + C.get(i) <= T) {
					onePainterWork += C.get(i);
					C.remove(i);
					i--;
					System.out.println(" proceesed one=" + C);
				}
			}

			if (painterAssinged > A) {
				System.out.println("painterAssinged exceeded=" + painterAssinged);
				return false;
			}

		}

		System.out.println("painterAssinged sufficient=" + painterAssinged);
		return true;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 640, 435, 647, 352, 8, 90, 960, 329, 859 };
		// 8 90 329 352 435 640 647 859 960
		int A = 3;
		int B = 10;
		/*
		 * int[] a = new int[] { 1, 10 }; int A = 2; int B = 5;
		 */
		UtilityClass.print(a);

		ArrayList<Integer> intList = new ArrayList<>(a.length);
		for (int i : a) {
			intList.add(i);
		}

		PaintersPartition p = new PaintersPartition();

		System.out.println("Result=" + p.paint(A, B, intList));

	}

	// Copied
	public int paintCopied(int A, int B, ArrayList<Integer> C) {
		long total = 0, max = Long.MIN_VALUE;
		for (Integer c : C) {
			total += c;
			max = Math.max(max, c);
		}

		long l = max, h = total;

		while (l < h) { //understand why '=' is not present
			long mid = (l + (h - l) / 2);
			long reqPainters = getRequiredPainters(C, mid);
			if (reqPainters <= A)
				h = mid; //it is not mid-1 due to the equals sign
			else
				l = mid + 1;
		} // l will be the answer
		long ans = ((l % 10000003) * (B % 10000003)) % 10000003;
		return (int) ans;
	}

	public long getRequiredPainters(ArrayList<Integer> A, long k) {
		long painterEffort = 0, reqPainters = 1;
		for (Integer a : A) {
			painterEffort += a;
			if (painterEffort > k) {
				painterEffort = a;
				reqPainters++;
			}
		}
		return reqPainters;
	}

	public int paint(int A, int B, ArrayList<Integer> C) {

		Integer[] sortedC = C.toArray(new Integer[C.size()]);
		Arrays.sort(sortedC);
		ArrayList<Integer> sortedList = new ArrayList<>(C.size());
		for (int i = sortedC.length - 1; i >= 0; i--) {
			sortedList.add(sortedC[i]);
		}

		int max = sortedList.get(sortedList.size() - 1);
		int total = sortedList.get(0);
		for (int i = 1; i < C.size(); i++) {
			total += C.get(i);
		}

		int low = max;
		int high = total;

		while (low < high) {
			int mid = low + (high - low) / 2;
			System.out.println("--mid::" + mid + " low=" + low + " high=" + high);
			if (paintersSufficient((ArrayList<Integer>) sortedList.clone(), mid, A)) {
				System.out.println("==sufficent mid::" + mid + " low=" + low + " high=" + high);
				high = mid;
			} else {
				System.out.println("**NOT mid::" + mid + " low=" + low + " high=" + high);
				low = mid + 1;

			}
		}

		long returnVal = 1L * low * B;
		return (int) returnVal;

	}

	public boolean paintersSufficient(ArrayList<Integer> C, int sum, int paintersLimit) {
		int painters = 0;
		int painterSum = 0;
		while (!C.isEmpty()) {
			painters++;
			painterSum = 0;
			System.out.println("C=" + C + " painters=" + painters);
			for (int i = 0; i < C.size(); i++) {
				if (painterSum + C.get(i) <= sum) {
					painterSum += C.get(i);
					C.remove(i);
					i--;
					System.out.println(" proceesed one=" + C);
				}
			}
			if (painters > paintersLimit) {
				System.out.println("painterAssinged exceeded=" + painters);
				return false;
			}
		}
		return true;
	}

}

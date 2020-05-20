package com.my.arrays;

import com.my.common.UtilityClass;

import java.awt.print.Book;
import java.util.*;

public class BookingsPossible {

	public boolean hotelCopied(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		Collections.sort(arrive);
		Collections.sort(depart);
		int roomsRequired = 0, i = 0, j = 0;
		while (i < arrive.size() && j < arrive.size() && roomsRequired <= K) {
			if (arrive.get(i) < depart.get(j)) {
				i++;
				roomsRequired++;
			} else {
				j++;
				roomsRequired--;
			}
		}
		if (roomsRequired <= K) {
			return true;
		} else {
			return false;
		}
	}

	public class Booking implements Comparable<Booking> {

		Integer startDay;
		Integer departDay;

		public Booking(int startDay, int departDay) {
			this.startDay = startDay;
			this.departDay = departDay;
		}

		@Override
		public int compareTo(Booking o) {
			return this.startDay.compareTo(o.startDay);
		}

		public String toString() {
			return "startDay=" + startDay + " departDay=" + departDay;
		}
	}

	// 2 3 4 6 9 15
	// 4 6 10 11 14 18

	// 2 1 +
	// 3 2 +
	// 4 3 +
	// 4 2 -
	// 6 3 +
	// 6 2 -
	// 9 3 +
	// 10 2 -
	// 11 1 -
	// 14 0 -
	// 15 1 +
	// 16 0 -

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

		int size = arrive.size();

		Integer[] sortedArrivals = arrive.toArray(new Integer[size]);
		Arrays.sort(sortedArrivals);
		Integer[] sortedDepartures = depart.toArray(new Integer[size]);
		Arrays.sort(sortedDepartures);

		int ai = 0;
		int di = 0;

		int numberOfRooms = 0;
		while (ai < size) {
			System.out.println("a=" + sortedArrivals[ai] + " d=" + sortedDepartures[di]);
			if (sortedArrivals[ai] < sortedDepartures[di]) {
				numberOfRooms++;
				ai++;
			} else if (sortedArrivals[ai] > sortedDepartures[di]) {
				numberOfRooms--;
				di++;
			} else {
				ai++;
				di++;
			}

			System.out.println("ai=" + ai + " di=" + di + " numberOfRooms=" + numberOfRooms);
			if (numberOfRooms > K) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int[] a = new int[] { 13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49,
				12, 7, 8 };
		int[] b = new int[] { 28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67,
				22, 51, 53 };

		ArrayList<Integer> a1 = new ArrayList<Integer>(a.length);
		for (int i : a) {
			a1.add(i);
		}

		ArrayList<Integer> b1 = new ArrayList<Integer>(a.length);
		for (int i : b) {
			b1.add(i);
		}

		BookingsPossible bp = new BookingsPossible();
		System.out.println(bp.hotel(a1, b1, 23));

	}
}

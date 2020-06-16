package com.my.strings;

import com.my.common.UtilityClass;

public class CompareVersionNumbers {

	//https://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/
	public int compareVersion(String A, String B) {
		if (A.equals(B)) {
			return 0;
		}

		while (A.endsWith(".0")) {
			A = A.substring(0, A.length() - 2);
		}

		while (B.endsWith(".0")) {
			B = B.substring(0, B.length() - 2);
		}

		String[] versionsA = A.split("\\.");
		String[] versionsB = B.split("\\.");

		UtilityClass.print(versionsA);
		UtilityClass.print(versionsB);

		int i = 0;
		for (; i < versionsA.length && i < versionsB.length; i++) {
			/*
			 * long va = Long.valueOf(versionsA[i]) ; long vb = Long.valueOf(versionsB[i]) ;
			 * System.out.println("i="+i+" va="+va+" vb="+vb); if(va>vb){ return 1; } else
			 * if (va < vb) { return -1; }
			 */

			int value = compare(versionsA[i], versionsB[i]);
			if (value == 0) {
				continue;
			}

			return value;

		}
		System.out
				.println("i=" + i + " versionsA.length=" + versionsA.length + " versionsB.length=" + versionsB.length);
		if (versionsA.length == i && versionsB.length == i) {
			return 0;
		} else if (versionsA.length == i) {
			return -1;
		} else {
			return 1;
		}

	}

	public int compare(String number1, String number2) {
		number1 = getTrimmedZeroString(number1);
		number2 = getTrimmedZeroString(number2);

		System.out.println("Trimmed number1=" + number1 + " number2=" + number2);

		if (number1.equals(number2)) {
			return 0;
		}

		if (number1.length() > number2.length()) {
			return 1;
		} else if (number1.length() < number2.length()) {
			return -1;
		} else {
			for (int i = 0; i < number1.length(); i++) {
				if (number1.charAt(i) > number2.charAt(i)) {
					return 1;
				} else if (number1.charAt(i) < number2.charAt(i)) {
					return -1;
				}
			}
		}

		return 0;
	}

	private String getTrimmedZeroString(String number) {
		int nonZeroDigit = 0;
		for (int i = 0; i < number.length(); i++) {
			System.out.println("number.charAt(" + i + ")=" + number.charAt(i));
			if (number.charAt(i) != '0') {
				nonZeroDigit = i;
				break;
			}
		}
		return number.substring(nonZeroDigit);
	}

	public static void main(String[] args) {
		String A = "0013.0";
		String B = "0013.1";

		CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
		System.out.println("Result=" + compareVersionNumbers.compareVersion(A, B));

	}
	
	/*****************Another solution*********************/

	public int compareVersionCopied(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int i = 0;
		while (i < arr1.length || i < arr2.length) {
			
			if (i < arr1.length && i < arr2.length) {
				if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
					return -1;
				} else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
					return 1;
				}
			} else if (i < arr1.length) {// 3.4.1 > 3.4
				if (Integer.parseInt(arr1[i]) != 0) {
					return 1;
				}
			} else if (i < arr2.length) {
				if (Integer.parseInt(arr2[i]) != 0) {
					return -1;
				}
			}

			i++;
		}

		return 0;
	}

}

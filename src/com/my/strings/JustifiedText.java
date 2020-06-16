package com.my.strings;

import java.util.ArrayList;

public class JustifiedText {

	public ArrayList<String> fullJustifyCopied(ArrayList<String> A, int B) {
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0, w; i < A.size(); i = w) {
			int l = -1;
			
			for (w = i; w < A.size() && A.get(w).length() + 1 + l <= B; w++)
				l += A.get(w).length() + 1;
			
			StringBuilder sb = new StringBuilder(A.get(i));
			
			int spaces = 1, extra = 0;
			if (w != i + 1 && w != A.size()) {
				spaces = (B - l) / (w - i - 1) + 1;
				extra = (B - l) % (w - i - 1);
			}
			
			for (int j = i + 1; j < w; j++) {
				for (int s = 0; s < spaces; s++)
					sb.append(' ');
				if (extra-- > 0)
					sb.append(' ');
				sb.append(A.get(j));
			}
			int remaining = B - sb.length();
			
			while (remaining-- > 0)
				sb.append(' ');
			list.add(sb.toString());
		}
		return list;
	}

	public ArrayList<String> fullJustify(ArrayList<String> A, int B) {

		ArrayList<String> result = new ArrayList<>();

		int count = 0;
		int startIndex = 0;

		for (int i = 0; i < A.size(); i++) {
			System.out.println("count=" + count + " A[i] len=" + A.get(i).length() + " A.get(i)=" + A.get(i) + " i=" + i
					+ " startIndex=" + startIndex + " total=" + (count + A.get(i).length() + (i - startIndex)));

			// We add i-startIndex as the number of spaces
			// If we add 1 space for each word then we end up adding extra space at the end
			// which will imbalance the format. So we need to do this way
			if (B >= count + A.get(i).length() + (i - startIndex)) {
				count += A.get(i).length();
				System.out.println("count=" + count);
			} else {
				System.out.println("startIndex=" + startIndex + " endIndex=" + (i - 1));
				result.add(justifyLine(A, startIndex, i - 1, B));
				count = A.get(i).length();
				startIndex = i;
			}
		}
		if (startIndex < A.size()) {
			result.add(justifyLine(A, startIndex, A.size() - 1, B));
		}

		return result;
	}

	public String justifyLine(ArrayList<String> A, int startWord, int endWord, int length) {
		if (endWord == A.size() - 1) {

			StringBuilder sb = new StringBuilder();
			for (int i = startWord; i < endWord; i++) {
				sb.append(A.get(i));
				sb.append(' ');
			}
			sb.append(A.get(endWord));
			while (sb.toString().length() < length) {
				sb.append(' ');
			}
			return sb.toString();
		}

		int spacesAvailabe = length;
		for (int i = startWord; i <= endWord; i++) {
			spacesAvailabe -= A.get(i).length();
		}

		int miniSpaceBetweenWords = (endWord == startWord) ? 0 : spacesAvailabe / (endWord - startWord);
		int extraSpace = (endWord == startWord) ? 0 : spacesAvailabe % (endWord - startWord);
		System.out.println("spacesAvailabe=" + spacesAvailabe + " miniSpaceBetweenWords=" + miniSpaceBetweenWords
				+ " extraSpace=" + extraSpace);
		StringBuilder sb = new StringBuilder();
		for (int i = startWord; i < endWord; i++) {
			sb.append(A.get(i));
			System.out.println("Appending String=" + A.get(i));
			for (int j = 0; j < miniSpaceBetweenWords; j++) {
				sb.append(' ');
			}
			if (extraSpace > 0) {
				sb.append(' ');
				extraSpace--;
			}
		}
		sb.append(A.get(endWord));
		while (sb.toString().length() < length) { // single length words reach ths
			sb.append(' ');
		}
		System.out.println("prepared string=" + sb.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = { "am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm",
				"ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq",
				"lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy" };
		ArrayList<String> list = new ArrayList<>();
		for (String s : words) {
			list.add(s);
		}
		int b = 14;
		JustifiedText justifiedText = new JustifiedText();
		System.out.println("Result=" + justifiedText.fullJustify(list, b));

	}
	// 9
	// 4 (4) 2 (3) 2

}

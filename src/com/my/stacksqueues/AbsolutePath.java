package com.my.stacksqueues;

import com.my.common.UtilityClass;

import java.util.Stack;

public class AbsolutePath {

	public String simplifyPath(String A) {
		String[] fileNames = A.split("\\/");
		UtilityClass.print(fileNames);
		Stack<String> workspace = new Stack<>();
		for (String fName : fileNames) {
			switch (fName) {
			case ".":
				break;
			case "..":
				if (!workspace.isEmpty())
					workspace.pop();
				break;
			default:
				if (!fName.isEmpty())
					workspace.push(fName);
				break;
			}
			System.out.println("workspace=" + workspace);
		}
		System.out.println("workspace=" + workspace);
		if (workspace.isEmpty()) {
			return "/";
		}

		String str = new String();
		while (!workspace.isEmpty()) {
			str = "/" + workspace.pop() + str;
			System.out.println("srt=" + str);
		}
		return str;
	}

	public static void main(String[] args) {
		String str = "/.";
		AbsolutePath absolutePath = new AbsolutePath();
		System.out.println("absPath=" + absolutePath.simplifyPath(str));
	}
}

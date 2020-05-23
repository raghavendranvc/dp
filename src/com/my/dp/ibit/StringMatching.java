package com.my.dp.ibit;

public class StringMatching {
	
	//******************************BELOW is for RegX Matching==================================
	
	/*
	 * Here we say false for the below
	 * s = aabbaa
	 * p = c*a*a  (meaning * is equal to '0' or more of any chars including space)
	 */
	
	//TODO, logic needs to be understood well
	public boolean isGeneralRegMatchPractice(String s, String p) {
		
		//result[i][j] if true of string of length 'i' and pattern of length 'j' matches
		
		boolean[][] result = new boolean[s.length()+1][p.length()+1];
		
		for(int i=0;i<=s.length();i++) {
			for(int j=0;j<=p.length();j++) {
				if(i == 0 && j ==0) { // both pattern and string are null
					result[i][j] = true;
				} else if (j==0) { //pattern is null and so any not empty string is null
					result[i][j] = false;// TODO This condition is very important
				} else if (j> 0 && p.charAt(j-1) == '*') {
					/*
					 * This is the case when we ignore either the text or ignore the pattern. 
					 * Since we are ignoring, the value will be a consequence of the earlier length
					 */
					result[i][j] = (i>0 && result[i-1][j]) || result[i][j-1];
				} else if (j>0 && i>0 && (p.charAt(j-1) == '?' || (p.charAt(j-1) == s.charAt(i-1)))) {
					/*
					 * This is the case where we skip one character that matches
					 * When ? too we just skip one char
					 */
					result[i][j] = result[i-1][j-1];
				} else {
					/*
					 * Previous steps didn't match. So we now ignore
					 */
					result[i][j] = false;
				}	
			}
		}
		
		return result[s.length()][p.length()];
	}
	
	public boolean isGeneralRegMatchAnathorWayPractice(String s, String p) {
		
		//result[i][j] if true of string of length 'i' an pattern of length 'j' matches
		
		boolean[][] result = new boolean[s.length()+1][p.length()+1];
		
		result[0][0]=true;
		
		/* Text ended. But the last character in pattern is '*' 
		 * It means the previous values remains as it is.
		 */
		for(int i=1;i<=p.length();i++) {
			if(p.charAt(i-1) == '*') {
				result[0][i] = result[0][i-1];
			}
		}
		
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=p.length();j++) {
				if(p.charAt(j-1) == '*') {
					result[i][j] = result[i-1][j] || result[i][j-1];
				} else if (p.charAt(i-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
					result[i][j] = result[i-1][j-1];
				} else {
					result[i][j] = false;
				}
			}
		}
		return result[s.length()][p.length()];
	}
	
	public int isMatchExpr1(String s, String p) {
		if(isGeneralRegMatchPractice(s,p)) {
			return 1;
		}
		return 0;
	}
	
	

	private boolean match(char c1, char c2) {
		return c2 == '?' || c1 == c2;
	}

	public int isMatchCopied(final String A, final String B) {
		
		boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
		
		for (int i = 0; i <= A.length(); i++) {
			
			for (int j = 0; j <= B.length(); j++) {
				
				if (i == 0 && j == 0) {
					// Empty strings are always matching
					dp[i][j] = true;
				} else if (j > 0 && B.charAt(j - 1) == '*') {
					// B ends with *, ignore it or match it with last character of A
					dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
					
				} else if (i > 0 && j > 0 && match(A.charAt(i - 1), B.charAt(j - 1))) {
					// Matching last characters
					dp[i][j] = dp[i - 1][j - 1];
					
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[A.length()][B.length()] ? 1 : 0;
	}

}

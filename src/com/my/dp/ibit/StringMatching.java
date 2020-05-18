package com.my.dp.ibit;

public class StringMatching {

	//******************************BELOW is for WildChar Pattern Matching==========================
	public int isMatch(String s, String p) {
		if(isWildCharPatternMatchPractice(s,p)) {
			return 1;
		}
		return 0;
	}
	/*
	 * Here we say true
	 * s = aabbaa
	 * p = c*a*a  (meaning c* is equal to '0' or more of c)
	 */
	//TODO, logic needs to be understood well
	public boolean isWildCharPatternMatchPractice(String s, String p) {
		boolean[][] result = new boolean[s.length()+1][p.length()+1];
		
		result[0][0]=true;
		
		/**
		 * We need to fix strings that could become empty like
		 * a*b* or .* etc
		 */
		
		for(int j=1;j<=p.length();j++) {
			if(p.charAt(j-1) == '*') {
				if(j>1) { // first char won't be *. but we still set this condition
					result[0][j] = result[0][j-2];
				}
			}
		}
		
		
		//(i,j) stores if string(0,i+1) & pattern(0,j+1) matches
		// i and j are lengths of string and pattern
		
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=p.length();j++) {
				
				if (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) {
					result[i][j] = result[i-1][j-1];
				} else if (p.charAt(j-1) == '*') {
					// we need to match with the preceding char to *
					result[i][j] = result[i][j-2]; //First get the earlier value
					if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2)=='.') {
						result[i][j] = result[i][j] || result[i-1][j]; 
					}
					
				} else {
					result[i][j] = false;
				}
			}
		}
		return result[s.length()][p.length()];
	}
	
	
	public int isMatchCopiedWildChar(final String s, final String p) {
	    int m=s.length();
	    int n=p.length();
	    boolean[][] t=new boolean [m+1][n+1];
	    
	    t[0][0]=true;
	    // pattern of type a*b* can match to empty string;
	    
	    for(int j=1 ; j<t[0].length;j++){
	        if(p.charAt(j-1)=='*'){
	            t[0][j]=t[0][j-2];
	        }
	    }
	    
	    for(int i=1 ;i<=m; i++){
	        for(int j=1 ;j<=n; j++){
	            if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
	                t[i][j]=t[i-1][j-1];
	            }
	            else if(p.charAt(j-1)=='*'){
	                t[i][j]=t[i][j-2];
	                if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
	                    t[i][j]=t[i][j] || t[i-1][j];
	                }
	            }
	            else{
	                t[i][j]=false;
	            }
	        }
	    }
	    
	    return (t[m][n]) ? 1 :0; 
	}
	
	//******************************BELOW is for RegX Matching==================================
	
	/*
	 * Here we say false for the below
	 * s = aabbaa
	 * p = c*a*a  (meaning * is equal to '0' or more of any chars including space)
	 */
	
	//TODO, logic needs to be understood well
	public boolean isGeneralRegMatchPractice(String s, String p) {
		
		//result[i][j] if true of string of length 'i' an pattern of length 'j' matches
		
		boolean[][] result = new boolean[s.length()+1][p.length()+1];
		
		for(int i=0;i<=s.length();i++) {
			for(int j=0;j<=p.length();j++) {
				if(i == 0 && j ==0) { // both pattern and string are null
					result[i][j] = true;
				} else if (j==0) { //pattern is null and so any not empty string is null
					result[i][j] = false;
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
	
	public boolean isMatchCrudeDoesNotWork(String s, String p) {

		int i = 0;
		int j = 0;

		while (i < s.length() && j < p.length()) {

			if (p.charAt(j) == '.') {
				i++;
				j++;
				continue;
			}

			if (p.charAt(j) == '*') {
				if (j + 1 == p.length()) {
					j++;
					break;
				}
				while (i < s.length() && p.charAt(j + 1) != s.charAt(i)) {
					i++;
				}
				j++;
				continue;
			}

			if (p.charAt(j) != s.charAt(i)) {

				if (j + 1 < p.length()) {
					if (p.charAt(j + 1) == '*') {
						j++;
						continue;
					} else {
						return false;
					}
				}
				return false;
			}

			i++;
			j++;
		}

		if (j == p.length()) {
			if (p.charAt(j - 1) == '*') {
				return true;
			}

			if (i == s.length()) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		String s = "mississippi";
		String p = "mis*is*ip*.";

		StringMatching sm = new StringMatching();
		System.out.println("Result=" + sm.isMatch(s, p));

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

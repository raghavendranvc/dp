package com.my.dp.ibit;

public class WildCharMatching {

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
		
		result[0][0]=true; //When nothing is given
		
		/**
		 * We need to fix strings that could become empty like
		 * a*b* or .* etc
		 */
		//This works on first row when row length is 0 and pattern alone is present
		
		
		for(int i=1;i<=p.length();i++) {
			if(p.charAt(i-1) == '*') {
				if(i>1) { // first char won't be *. but we still set this condition
					result[0][i] = result[0][i-2];
				}
			}
		}
		
		
		//(i,j) stores if string(0,i+1) & pattern(0,j+1) matches
		// i and j are lengths of string and pattern
		
		//For each length from 1 to s.length(), we try to match the whole pattern
		
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=p.length();j++) {
				
				if (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) {
					result[i][j] = result[i-1][j-1];
				} else if (p.charAt(j-1) == '*') {
					// we need to match with the preceding char to *
					//result[i][j] = result[i][j-2]; //First get the earlier value
					if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2)=='.') {
						result[i][j] = result[i][j-2] || result[i-1][j]; 
					}
					
				} else {
					result[i][j] = false;
				}
			}
		}
		return result[s.length()][p.length()];
	}
	
	/***************************One sol***********************************/
	
	
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
	
	public static void main(String[] args) {

		String s = "mississippi";
		String p = "mis*is*ip*.";

		WildCharMatching sm = new WildCharMatching();
		System.out.println("Result=" + sm.isMatch(s, p));

	}
}

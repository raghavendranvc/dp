package com.my.dp;

public class LongestCommonSubsquence {
	
	public String getLongestCommonSubSequenceStringRecur(char[] a,char[] b,int i,int j){
		if(i<0 || j<0){
			return "";
		}
		
		if(a[i] == b[j]){
			return  getLongestCommonSubSequenceStringRecur(a, b, i-1, j-1) + a[i];
		} else {
			String str1 = getLongestCommonSubSequenceStringRecur(a,b,i-1,j);
			String str2 = getLongestCommonSubSequenceStringRecur(a,b,i,j-1);
			return ((str1.length()>=str2.length())? str1:str2);
		}
		
	}
	
	
	public int getLongestCommonSubSequenceRecur(char[] a,char[] b,int i,int j){
		if(i<0 || j<0){
			return 0;
		}
		
		if(a[i] == b[j]){
			return 1 + getLongestCommonSubSequenceRecur(a, b, i-1, j-1);
		} else {
			return Math.max(getLongestCommonSubSequenceRecur(a,b,i-1,j), getLongestCommonSubSequenceRecur(a,b,i,j-1));
		}
		
	}
	
	public int getLongestCommonSubSequenceIter(char[] a,char[] b){
		
		int m = a.length;
		int n = b.length;
		int c[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			c[i][0]=0;
		}
		
		for(int i=0;i<=n;i++){
			c[0][i]=0;
		}

		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(a[i-1] == b[j-1]){
					c[i][j] = c[i-1][j-1]+1;
				} else {
					c[i][j] = Math.max(c[i-1][j],c[i][j-1]);
				}
			}
		}
		
		return c[m][n];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str1 = "ABCDABBA";
		String str2 = "AAABBCABA";

		/*String str1 = "AAAAA";
		String str2 = "BBBBBBBB";*/
		
		/*String str1 = "BAABAABA";
		String str2 = "BBBAABAAAA";*/
		
		LongestCommonSubsquence lcs = new LongestCommonSubsquence();
		
		int lcsLength1 = lcs.getLongestCommonSubSequenceRecur(str1.toCharArray(),str2.toCharArray(),str1.length()-1,str2.length()-1);
		int lcsLength2 = lcs.getLongestCommonSubSequenceIter(str1.toCharArray(),str2.toCharArray());
		
		System.out.println("LCSLength1="+lcsLength1+"   LCSLength2="+lcsLength2);
		// TODO Auto-generated method stub
		
		String lcsString = lcs.getLongestCommonSubSequenceStringRecur(str1.toCharArray(),str2.toCharArray(),str1.length()-1,str2.length()-1);
		System.out.println("LCSString="+lcsString);

	}

}

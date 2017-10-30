package com.my.dp;

public class BinomialCoefficient {

	// (n,0)/(n,n) = 1
	// (n,r) = (n-1,r-1) + (n-1,r)
	public int BinomialCoeffiecntRecur(int n,int r){
		if(n==r || r==0){
			return 1;
		}
		return BinomialCoeffiecntRecur(n-1, r-1) + BinomialCoeffiecntRecur(n-1, r);
	}
	
	public int BinomialCoefficentIter(int n,int r){
		int C[][] = new int[n+1][r+1];
		for(int i=0;i<=n;i++){
			C[i][0] = 1;
		}
		
		for(int j=0;j<=r;j++){
			C[j][j]=1;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=Math.min(i, r);j++){
				C[i][j] = C[i-1][j-1]+C[i-1][j];
			}
		}
		
		return C[n][r];
	}
	
	public static void main(String[] args) {
		int n = 15, r = 6;
		BinomialCoefficient bc = new BinomialCoefficient();
		int val1 = bc.BinomialCoeffiecntRecur(n, r);
		System.out.println("val1="+val1);
		int val2 = bc.BinomialCoefficentIter(n, r);
		System.out.println("val2="+val2);
	}

}

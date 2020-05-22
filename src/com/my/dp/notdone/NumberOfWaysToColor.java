package com.my.dp.notdone;

public class NumberOfWaysToColor {

	private static int MOD = 1000000007;

	private static int COLORS = 4;
	
	//TODO NOTDONE fully. Recheck again

	private int getCombination(int n, int r) {
		//ncr = n!/(n-r)!r! = n-r+1/r *(n-1)c(r))
		int value = 1;
		for(int i=n;i>r;i--) {
			value = value*(i)/(i-r);
		}
		System.out.println("ncr ("+n+","+r+")="+value);
		return value;
	}

	public int solve(int A) {

		int numOfWays = 0;

		for (int i = 2; i <= COLORS; i++) {
			numOfWays = numOfWays + getCombination(COLORS,i) * getNumberOfWaysToColor(A, i);
			System.out.println("With max " + i + " Colors, number of ways=" + numOfWays);
		}

		return numOfWays;
	}

	int getNumberOfWaysToColor(int A, int availableColors) {

		boolean[][] visited = new boolean[3][A];

		long numOfWays = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < A; j++) {

				int unVistedNeighbours = availableColors;
				if (i + 1 < 3 && visited[i + 1][j]) {
					unVistedNeighbours--;
				}
				if (i - 1 >= 0 && visited[i - 1][j]) {
					unVistedNeighbours--;
				}

				if (j + 1 < A && visited[i][j + 1]) {
					unVistedNeighbours--;
				}

				if (j - 1 >= 0 && visited[i][j - 1]) {
					unVistedNeighbours--;
				}
				System.out
						.println("For [" + i + "," + j + "]=" + " Number of unVistedNeighbours=" + unVistedNeighbours);
				numOfWays = (numOfWays * unVistedNeighbours) % MOD;
				visited[i][j] = true;
			}
		}

		return (int) (numOfWays % MOD);
	}

	/*
	 * T(4) T(3) T(3) T(2) T(3) T(2)
	 */

	public static void main(String[] args) {
		NumberOfWaysToColor numberOfWaysToColor = new NumberOfWaysToColor();
		System.out.println("Result=" + numberOfWaysToColor.solve(2));
	}

}

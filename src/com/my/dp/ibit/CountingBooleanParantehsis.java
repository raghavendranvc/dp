package com.my.dp.ibit;

public class CountingBooleanParantehsis {
	
	/****************************** another way ***************************/

	/*
	 * Expression = operand1 op1 operand2 op2 operand3 op3 operand4
	 */

	// TODO - Read

	public int GetNumberOfBooleanParanthesis(boolean[] operands, String[] operators) {
		int n = operands.length;
		int[][] TrueValues = new int[n][n];
		int[][] FalseValues = new int[n][n];

		for (int i = 0; i < n; i++) {

			/*
			 * true & true = 1 true or true = 1 true ^ true = 0
			 * 
			 * false & false = 0 false or false = 0 false ^ false = 0
			 */

			TrueValues[i][i] = 2;
			FalseValues[i][i] = 4;
		}

		for (int length = 2; length < n; length++) {
			for (int i = 0, j = length - 1; j < n; i++, j++) {
				for (int k = i; k < j; k++) { // i to ...k and k+1....j
					TrueValues[i][j] = /* AND */ TrueValues[i][k] * TrueValues[k + 1][j] +
					/* OR */ (TrueValues[i][k] + FalseValues[i][k]) * (TrueValues[k + 1][j] + FalseValues[k + 1][j])
							- FalseValues[i][k] * FalseValues[k + 1][j] +
							/* XOR */ TrueValues[i][k] * FalseValues[k + 1][j]
							+ FalseValues[i][k] * TrueValues[k + 1][j];

					FalseValues[i][j] = /* AND */ (TrueValues[i][k] + FalseValues[i][k])
							* (TrueValues[k + 1][j] + FalseValues[k + 1][j]) - TrueValues[i][k] * TrueValues[k + 1][j] +
					/* OR */ FalseValues[i][k] * FalseValues[k + 1][j] +
					/* XOR */ TrueValues[i][k] * TrueValues[k + 1][j] + FalseValues[i][k] * FalseValues[k + 1][j];
				}
			}
		}

		return TrueValues[0][n - 1];
	}

	/****************************** another way ***************************/
	public int cnttrue(String A) {
		
		//First thing is seperate out operators and operands
		// operators are 3 kinds of values
		// operands are 2 types either T or F

		/*
		 * T ^ T = F T | T = T * T & T = T *
		 * 
		 * F ^ F = F F | F = F F & F = F
		 * 
		 * T ^ F = T * T | F = T * T & T = F
		 * 
		 * 
		 * T | T = T | F = F | T = T (3 ways) (L,R) F ^ F = T ^ T = T (2 ways) T & T = T
		 * (1 way)
		 * 
		 * 
		 */

		if (A == null || A.length() < 3) {
			return 0;
		}

		StringBuilder operands = new StringBuilder();
		StringBuilder operators = new StringBuilder();

		for (char c : A.toCharArray()) {
			if (c == 'T' || c == 'F') {
				operands.append(c);
			} else {
				operators.append(c);
			}
		}

		return getNumberOfTrueValues(operators.toString().toCharArray(), operands.toString().toCharArray());
	}

	public int getNumberOfTrueValues(char[] operators, char[] operands) {

		int n = operands.length;

		/*
		 * (i,j) represents number of ways truth can be derived between the operands
		 * between i and j (including j) & the operators between i and j (excluding j)
		 * operand(i) + operator(i) + ......operand(j-1) + operator(j-1) + operand(j)
		 */

		int[][] T = new int[n][n];
		int[][] F = new int[n][n];

		/**
		 * Number of ways when length is 1 (i,i) depends on the operand itself if
		 * operand is T, then T(i,i) is 1 else F(i,i) is 1
		 */

		for (int i = 0; i < n; i++) {
			if (operands[i] == 'T') {
				T[i][i] = 1;
			} else {
				F[i][i] = 0;
			}
		}

		for (int length = 2; length <= n; length++) // length will be between 2 to n {

			for (int i = 0, j = length - 1; j < n; i++, j++) {
				// calculating True and False values between i and j

				// We will jump from one operator to another operator between i and j
				// operators will range between i and j-1
				// For each selected operator, we calculate its left and right
				for (int k = i; k < j; k++) {

					//T[i,k] is the value of operands from i to k using k-1 operators
					//T[k+1,j] is the value of operators from k+1 to j using the rest of the operands from k+1 to j-1
					switch (operators[k]) {
					case '&':
						T[i][j] += T[i][k] * T[k + 1][j];
						F[i][j] += F[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
						break;
					case '|':
						T[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
						F[i][j] += F[i][k] * F[k + 1][j];
						break;
					case '^':
						T[i][j] += T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j];
						F[i][j] += F[i][k] * F[k + 1][j] + T[i][k] * T[k + 1][j];
						break;
					}

				}

			}

		return T[0][n - 1];//upper half of diagonal
	}
	
	/****************************** another way ***************************/

	int MOD = 1003;

	public int cnttrueCopied(String A) {

		StringBuilder symbols = new StringBuilder();
		StringBuilder operators = new StringBuilder();

		for (int i = 0; i < A.length(); ++i) {
			char cur = A.charAt(i);
			if (cur == 'T' || cur == 'F') {
				symbols.append(cur);
			} else {
				operators.append(cur);
			}
		}

		return cnt(symbols.toString().toCharArray(), operators.toString().toCharArray()) % MOD;
	}

	private int cnt(char exp[], char op[]) {

		int n = exp.length;

		int t[][] = new int[n][n];
		int f[][] = new int[n][n];

		for (int i = 0; i < n; ++i) {
			if (exp[i] == 'T') {
				t[i][i] = 1;
			} else {
				f[i][i] = 1;
			}
		}

		for (int length = 1; length < n; length++) {

			for (int i = 0, j = length; j < n; i++, j++) {

				for (int g = 0; g < length; g++) { // operator movement from i to j

					int k = i + g; // Find the right operator at position

					switch (op[k]) {

					case '&':
						t[i][j] += t[i][k] * t[k + 1][j];
						f[i][j] += t[i][k] * f[k + 1][j] + f[i][k] * t[k + 1][j] + f[i][k] * f[k + 1][j];
						break;
					case '|':
						t[i][j] += t[i][k] * t[k + 1][j] + t[i][k] * f[k + 1][j] + f[i][k] * t[k + 1][j];
						f[i][j] += f[i][k] * f[k + 1][j];
						break;
					case '^':
						t[i][j] += t[i][k] * f[k + 1][j] + f[i][k] * t[k + 1][j];
						f[i][j] += t[i][k] * t[k + 1][j] + f[i][k] * f[k + 1][j];
						break;
					}

					t[i][j] %= MOD;
					f[i][j] %= MOD;
				}
			}
		}

		return t[0][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

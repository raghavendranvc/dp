package com.my.dp;

import java.util.Arrays;

public class AllPairsShortestPathFlyodWarshall {

	public int[][] getAllPairsShortestPath(int[][] a) {

		int numberOfNodes = a.length;

		int[][] pathMatrix = new int[numberOfNodes][numberOfNodes];
		Arrays.fill(pathMatrix, Integer.MAX_VALUE);

		for (int i = 0; i < numberOfNodes; i++) {
			for (int j = 0; j < numberOfNodes; j++) {
				if (a[i][j] >= 0) {
					pathMatrix[i][j] = a[i][j];
				}
			}
		}

		// k = intermediateNode i = sourceNode j = destinationNode

		for (int k = 0; k < numberOfNodes; k++) {
			for (int i = 0; i < numberOfNodes; i++) {
				for (int j = 0; j < numberOfNodes; j++) {
					pathMatrix[i][j] = Math.min(pathMatrix[i][j], pathMatrix[i][k] + pathMatrix[k][j]);
				}
			}

		}

		return pathMatrix;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

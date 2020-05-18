package com.my.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

	static int[][] snakes1 = { { 32, 62 }, { 42, 68 }, { 12, 98 } };
	static int[][] ladders1 = { { 95, 13 }, { 97, 25 }, { 93, 37 }, { 79, 27 }, { 75, 19 }, { 49, 47 }, { 67, 17 } };

	static int[][] snakes2 = { { 8, 52 }, { 6, 80 }, { 26, 42 }, { 2, 72 } };
	static int[][] ladders2 = { { 51, 19 }, { 39, 11 }, { 37, 29 }, { 81, 3 }, { 59, 5 }, { 79, 23 }, { 53, 7 }, { 43, 33 },
			{ 77, 21 } };

	public int game(int size, int maxDice, int[][] snakes, int[][] ladders) {
		int[] board = new int[size + 1];
		for (int i = 0; i < snakes.length; i++) {
			board[snakes[i][0]] = snakes[i][1];
		}

		for (int i = 0; i < ladders.length; i++) {
			board[ladders[i][0]] = ladders[i][1];
		}
		return getMinDiceBFS(board, maxDice, size);
	}

	class BNode {
		int x;
		int depth;

		BNode(int x, int depth) {
			this.x = x;
			this.depth = depth;
		}
	}

	int getMinDiceBFS(int[] board, int maxDice, int size) {
		boolean[] visited = new boolean[size + 1];
		Queue<BNode> bQueue = new LinkedList<BNode>();

		BNode bNode = new BNode(0, 0);
		bQueue.add(bNode);
		visited[0] = true;

		while (!bQueue.isEmpty()) {
			bNode = bQueue.remove();
			int currentPosition = bNode.x;

			if (currentPosition == size) {
				break;
			}

			for (int i = currentPosition + 1; i <= currentPosition + maxDice && i <= size; i++) {

				if (visited[i]) {
					continue;
				}

				visited[i] = true;
				
				/*
				 * For ladder if we are the head, we don't need to bother
				 * For snake if we are at the tail, we don't need to bother
				 * 
				 * For ladder, if we are the tail, we should mark the current 
				 * 	as visited and add the head. We may or may not mark it as visited.
				 *  In the current we are not bothered, because we mark it when we start processing it
				 *  
				 * 
				 * For snake, if we are at the head, we should mark the head as visited. 
				 * We would have already marked snake tail already as it comes first.
				 */
				
				BNode t = null;
				if (board[i] == 0) {
					t = new BNode(i, bNode.depth + 1);
				} else {
					if(visited[board[i]]) {
						continue;
					}
					visited[board[i]] = true;
					t = new BNode(board[i], bNode.depth + 1);
				}
				bQueue.add(t);
			}
		}
		return bNode.depth;
	}
	
	public static void main(String[] args) {
		
		SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
		int size=100;
		int maxDice=6;
		int minDices = snakesAndLadders.game(size, maxDice, snakes2, ladders2);
		System.out.println("Result="+minDices);
		
	}
}

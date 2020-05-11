package com.my.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ChessKnightDest {

	class Pair {
		int x;
		int y;
		int value;

		Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.value = val;
		}

		
		public String toString() {
			return "(x="+x+" y="+y+")";
		}

	}
	
	private boolean validPoint(int A, int B, int x, int y) {
		if (x < 1 || y < 1 || x > A || y > B) {
			return false;
		}
		return true;
	}

	public int knight(int A, int B, int C, int D, int E, int F) {
		Pair s = new Pair(C, D, 0);
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(s);
		boolean[][] visisted = new boolean[A+1][B+1];
		
		visisted[s.x][s.y] = true;
		
		int[] xDiff = {-2, -1, 1, 2, -2, -1, 1, 2};
		int[] yDiff = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			if(p.x==E && p.y==F) {
				return p.value;
			}	
			for(int i=0;i<xDiff.length;i++) {
				
				int newX = p.x+xDiff[i];
				int newY = p.y+yDiff[i];
				
				if(!validPoint(A,B,newX,newY)) {
					continue;
				}
				
				if(visisted[newX][newY]) {
					continue;
				}
				
				visisted[newX][newY] = true;
				queue.add(new Pair(newX,newY,p.value+1));
			}	
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		ChessKnightDest chessKnightDest = new ChessKnightDest();
		System.out.println("value="+chessKnightDest.knight(8, 8, 1, 1, 8, 8));
	}

}

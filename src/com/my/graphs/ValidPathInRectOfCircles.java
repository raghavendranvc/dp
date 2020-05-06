package com.my.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ValidPathInRectOfCircles {
	
	public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
		
		int solution[][] = new int[A+1][B+1];
		for(int i=0;i<=A;i++) {
			solution[i] = new int[B+1];
			Arrays.fill(solution[i], 0);
		}
		
		
		//(A,B) is the opposite end of Rectangle of (0,0)
		for(int i=0;i<=A;i++) { 
			for(int j=0;j<=B;j++) {
				
				//C is the number of circles
				for(int k=0;k<C;k++) {
					//R is the radius of each circle
					// (E,F) is the center of each circle
					// We need to check the distance between the point(i,j) and center of circle (E,F)
					// If <=R, then the point (i,j) shouldn't be touched
					// squareRoot(x^2+y^2) <=r
					
					int distance = (int) Math.ceil(Math.sqrt(Math.pow((i-E.get(k)),2) + Math.pow((j-F.get(k)), 2)));
					if(distance <= D) {
						solution[i][j] = -1;
					}
					
				}	
			}
		}
		
		if(solution[0][0]==-1 || solution[A][B]==-1) {
			return "NO"; // no solution
		}
		
		LinkedList<Integer> xQueue = new LinkedList<Integer>();
		xQueue.add(0);
		
		LinkedList<Integer> yQueue = new LinkedList<Integer>();
		yQueue.add(0);
		
		while(!xQueue.isEmpty()) {
			int cpX = xQueue.removeFirst();
			int cpY = yQueue.removeFirst();
			
			
			
			// -1, -1
			// -1, 0
			// 0, -1
			// 0, 0
			// 0 , 1
			// 1, 0
			// 1, 1
			// 1 , -1
			// 
			
			// Queue up all unmarked ones and unvisited ones
			// 
			
			//top left
			if(cpX>0 && cpY>0 && solution[cpX-1][cpY-1] == 0) { 
				xQueue.add(cpX-1);
				yQueue.add(cpY-1);
				
				solution[cpX-1][cpY-1] = 1;
			}
			
			//top
			if(cpX>0 && solution[cpX-1][cpY] == 0) { 
				xQueue.add(cpX-1);
				yQueue.add(cpY);
				
				solution[cpX-1][cpY] = 1;
			}
			
			//top right
			if(cpX>0 && cpY<B && solution[cpX-1][cpY+1] == 0) { 
				xQueue.add(cpX-1);
				yQueue.add(cpY+1);
				
				solution[cpX-1][cpY+1] = 1;
			}
			
			//right
			if(cpY<B && solution[cpX][cpY+1] == 0) { 
				xQueue.add(cpX);
				yQueue.add(cpY+1);
				
				solution[cpX][cpY+1] = 1;
			}
			
			//right bottom
			if(cpX<A && cpY<B && solution[cpX+1][cpY+1] == 0) { 
				xQueue.add(cpX+1);
				yQueue.add(cpY+1);
				
				solution[cpX+1][cpY+1] = 1;
			}
			
			// bottom
			if(cpX<A && solution[cpX+1][cpY] == 0) { 
				xQueue.add(cpX+1);
				yQueue.add(cpY);
				solution[cpX+1][cpY] = 1;
			}
			
			//bottom-left
			if(cpX<A && cpY>0 && solution[cpX+1][cpY-1] == 0) { 
				xQueue.add(cpX+1);
				yQueue.add(cpY-1);
				solution[cpX+1][cpY-1] = 1;
			}
			
			//left
			if(cpY>0 && solution[cpX][cpY-1] == 0) { 
				xQueue.add(cpX);
				yQueue.add(cpY-1);
				solution[cpX][cpY-1] = 1;
			}
			
		}
		
		if(solution[A][B] == 1) {
			return "YES";
		} else {
			return "NO";
		}
		
    }
	
}

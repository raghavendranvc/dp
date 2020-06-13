package com.my.leet.hard.notdone;

import java.util.HashSet;
import java.util.Set;

public class RobotCleaner {

	/*
	 * Given a robot cleaner in a room modeled as a grid.
	 * 
	 * Each cell in the grid can be empty or blocked.
	 * 
	 * The robot cleaner with 4 given APIs can move forward, turn left or turn
	 * right. Each turn it made is 90 degrees.
	 * 
	 * When it tries to move into a blocked cell, its bumper sensor detects the
	 * obstacle and it stays on the current cell.
	 * 
	 * Design an algorithm to clean the entire room using only the 4 given APIs
	 * shown below.
	 */

	interface Robot {
		// returns true if next cell is open and robot moves into the cell.
		// returns false if next cell is obstacle and robot stays on the current cell.
		boolean move();

		// Robot will stay on the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		void turnLeft();

		void turnRight();

		// Clean the current cell.
		void clean();
	}

	// https://linlaw0229.github.io/2019/03/02/489-Robot-Room-Cleaner/

	public void cleanRoom(Robot robot) {
		Set<String> visited = new HashSet<>(); // String is a pair of (x,y)
		backtracking(robot, visited, 0, 0, 0);
	}

	int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow) {

		String path = x + "-" + y;

		if (visited.contains(path))
			return;

		visited.add(path);
		robot.clean();

		for (int i = 0; i < 4; i++) {
			if (robot.move()) {
				// go all the way till cannot move, then back one step
				int nx = x + dir[arrow][0];
				int ny = y + dir[arrow][1];

				backtracking(robot, visited, nx, ny, arrow);
				// trace back
				// //go back to original place, because dfs is our helper function
				// function return does not make the robot move back
				
				robot.turnLeft();
				robot.turnLeft();
				robot.move();
				//redirect to curDir
				robot.turnLeft();
				robot.turnLeft();
			
			}
			robot.turnLeft();// or turnRight();
			arrow = (arrow + 1) % 4;
		}
	}

}

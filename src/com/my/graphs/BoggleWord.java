package com.my.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BoggleWord {
	//https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
	//TODO pending
	
	public List<String> findWords(char boggle[][], Set<String> dict) {
		int m = boggle.length;
		int n = boggle[0].length;
		boolean[][] visited = new boolean[m][n];
		
		List<String> result = new ArrayList<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				findWordsRecur(m,n,boggle, dict, visited, i, j, "", result);
			}
		}
		
		return result;
	}
	
	void findWordsRecur(int m, int n, char boggle[][], Set<String> dict, boolean[][] visited, int r, int c, String word, List<String> result ) {
		visited[r][c] = true;
		
		word = word + boggle[r][c];
		
		if(dict.contains(word)) {
			result.add(word);
		}
		
		//-1,0,1 all 9 cells will be checked. [r,c] is visited, so it will be ignored.
		for(int i=r-1;i<=r+1 && i < m;i++) {
			for(int j=c-1;j<=c+1 && j < n;j++) {
				if(i >=0 && j >=0 && !visited[i][j]) {
					findWordsRecur(m, n,boggle, dict, visited,i,j,word, result);
				}
			}
		}
		visited[r][c] = false;//backtracking
		word = word.substring(0, word.length()-1); //backtracking
	}

}

package com.my.dp.ibit;

import java.util.ArrayList;
import java.util.Collections;

import com.my.common.UtilityClass;

public class BirthdayKicks {
	
	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		solveRecur(A, B, 0, result);
		Collections.reverse(result);
		return result;
    }
	
	
	public boolean solveRecur(int A, ArrayList<Integer> B, int currentIndex, ArrayList<Integer> result){
		if(A == 0) {
			return true;
		}
		
		if(currentIndex == B.size()) {
			return false;
		}
		
		if(A < 0) {
			return false;
		}
		
		for(int i=currentIndex; i<B.size();i++) {
			int repeats = A/B.get(i);
			
			for(int j=repeats;j>=0;j--) {
				System.out.println("currentInde="+i+" repeats="+j+" Sum="+A);
				if(solveRecur(A-j*B.get(i), B, currentIndex+1, result)) {
					System.out.println("Completed");
					populateResultArray(result, i, j);
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	private void populateResultArray(ArrayList<Integer> result, int index, int repeats) {
		for(int i=0;i<repeats;i++) {
			result.add(index);
		}
	}
	
	public static void main(String[] args) {
		int A = 12;
		int[] b = { 8, 8, 6, 5, 4 };
		ArrayList<Integer> B = UtilityClass.getList(b);
		
		BirthdayKicks birthdayKicks = new BirthdayKicks();
		ArrayList<Integer> result = birthdayKicks.solve(A, B);
		System.out.println("Result="+result);
	}
	
	
	public ArrayList<Integer> solveCopied(int A, ArrayList<Integer> B) {
        ArrayList<Integer> resp = new ArrayList<>();
        int min = Collections.min(B);
        int available = A % min;

        int i = 0;
        while (resp.size() < A / min) {
            if (B.get(i) - min <= available) {
                available -= B.get(i) - min;
                resp.add(i);
            } else {
                i++;
            }
        }
        return resp;
    }
	
	

}

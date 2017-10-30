package com.my.dp;



public class TelephonicWords {
	
	
	public void printAllTelephonicWords(int number){
		String[] alphbhets = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		int[] d = getNumberOfDigits(number);
		
		printAllTelehonicWordsRecur(alphbhets,d,d.length,new char[d.length]);
	}
	
	
	private void printAllTelehonicWordsRecur(String[] alphbhets,int[] digits,int currLength,char[] word){
		if(currLength == 0){
			System.out.println(new String(word));
			return;
		}
		int digit = digits[digits.length - currLength];
		String digitChars = alphbhets[digit];
		
		for(int i=0;i<digitChars.length();i++){
			word[digits.length - currLength] = digitChars.charAt(i);
			printAllTelehonicWordsRecur(alphbhets, digits, currLength-1, word);
		}
		
	}
	
	public int[] getNumberOfDigits(int number){
		int tmp = number;
		int count=0;
		while(tmp>0){
			count++;
			tmp = tmp/10;
		}
		int[] digits = new int[count];
		
		/*count--;
		while(count>-1){
			digits[count] = (int)(number/Math.pow(10, count));
			count--;
		}*/
		
		count--;
		int i=0;
		while(i<=count){
			digits[count-i] = number % 10;
			number=number/10;
			i++;
		}
		
//		UtilityClass.print(digits);
		 
		return digits;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TelephonicWords tw = new TelephonicWords();
		tw.printAllTelephonicWords(92400);

	}

}
